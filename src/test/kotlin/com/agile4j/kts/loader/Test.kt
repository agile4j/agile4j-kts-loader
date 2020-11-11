package com.agile4j.kts.loader

import org.junit.Assert
import org.junit.Test

class Test {
    @Test
    fun test() {
        Assert.assertEquals(CountHolder.count, 0)
        eval("src/test/resources/test-script.kts")
        Assert.assertEquals(CountHolder.count, 10)
    }
}
