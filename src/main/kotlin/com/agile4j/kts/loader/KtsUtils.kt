package com.agile4j.kts.loader

import java.nio.file.Files.readAllBytes
import java.nio.file.NoSuchFileException
import java.nio.file.Paths

/**
 * @author liurenpeng
 * Created on 2020-11-12
 */

/**
 * @throws NoSuchFileException
 * @throws KtsLoadException
 */
fun eval(ktsPath: String) = KtsLoader().justRun(getScriptContent(ktsPath))

/**
 * @throws NoSuchFileException
 * @throws KtsLoadException
 */
inline fun <reified T> load(ktsPath: String): T = KtsLoader().load(getScriptContent(ktsPath))

fun getScriptContent(ktsPath: String): String = String(readAllBytes(Paths.get(ktsPath)))