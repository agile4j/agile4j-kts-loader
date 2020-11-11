package com.agile4j.kts.loader

import java.io.InputStream
import java.io.Reader
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

/**
 * This class is not thread-safe, don't use it for parallel executions and create new instances instead.
 */
class KtsLoader(classLoader: ClassLoader? = Thread.currentThread().contextClassLoader) {

    val engine: ScriptEngine = ScriptEngineManager(classLoader).getEngineByExtension("kts")
        ?: throw KtsLoadException("ScriptEngine is null")

    inline fun <R> safeEval(evaluation: () -> R?) = try {
        evaluation()
    } catch (e: Exception) {
        throw KtsLoadException("Cannot load script", e)
    }

    inline fun <reified T> Any?.castOrError() = takeIf { it is T }?.let { it as T }
        ?: throw KtsLoadException("Cannot cast $this to expected type ${T::class}")

    inline fun <reified T> load(script: String): T = safeEval { engine.eval(script) }.castOrError()

    inline fun <reified T> load(reader: Reader): T = safeEval { engine.eval(reader) }.castOrError()

    inline fun <reified T> load(inputStream: InputStream): T = load(inputStream.reader())

    inline fun <reified T> loadAll(vararg inputStream: InputStream): List<T> = inputStream.map(::load)

    fun justRun(script: String) {
        safeEval { engine.eval(script) }
    }
}

