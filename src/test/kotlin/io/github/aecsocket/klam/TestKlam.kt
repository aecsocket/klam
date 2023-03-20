package io.github.aecsocket.klam

import kotlin.test.Test

class TestKlam {
    @Test
    fun test() {
        val a = FVec3(0.0f, 1.0f, 0.0f)
        val b = FVec3(0.0f, 2.0f, 0.0f)

        println(a + b)
    }
}
