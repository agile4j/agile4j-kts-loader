package com.agile4j.kts.loader

import java.nio.file.Files
import java.nio.file.Paths

/**
 * @author liurenpeng
 * Created on 2020-11-12
 */
fun eval(ktsPath: String) {
    val scriptContent = Files.readAllBytes(Paths.get(ktsPath))?.let { String(it) }
    scriptContent?.let { KtsLoader().justRun(it) }
}