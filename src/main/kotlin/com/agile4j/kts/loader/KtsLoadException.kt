package com.agile4j.kts.loader

class KtsLoadException(
    message: String? = null,
    cause: Throwable? = null
) : RuntimeException(message, cause)