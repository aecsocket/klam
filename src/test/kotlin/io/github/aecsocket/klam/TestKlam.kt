package io.github.aecsocket.klam

import kotlin.test.Test

class TestKlam {
    @Test
    fun test() {
        val a = FMat2(
            1.4f, 1.4f,
            1.4f, 1.4f,
        )
        println(a == (FMat2(1.3f, 1.3f, 1.3f, 1.3f) + FMat2(0.1f)))
    }
}
