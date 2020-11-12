package com.agile4j.kts.loader

import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import java.nio.file.NoSuchFileException

class Test {

    @get:Rule
    val thrown: ExpectedException = ExpectedException.none()

    @Test
    fun testNoSuchFile() {
        thrown.expect(NoSuchFileException::class.java)
        eval("src/test/resources/not-exist-script.kts")
    }

    @Test
    fun testEval() {
        Assert.assertEquals(CountHolder.count, 0)
        eval("src/test/resources/test-eval-script.kts")
        Assert.assertEquals(CountHolder.count, 10)
    }

    @Test
    fun testLoadInt() {
        val i = load<Int>("src/test/resources/test-load-int-script.kts")
        Assert.assertEquals(i, 2)
    }

    @Test
    fun testLoadModel() {
        val model = load<Model>("src/test/resources/test-load-model-script.kts")
        Assert.assertEquals(model.id, 1)
    }
}
