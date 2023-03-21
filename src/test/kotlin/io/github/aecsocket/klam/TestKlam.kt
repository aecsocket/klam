package io.github.aecsocket.klam

import kotlin.test.Test

class TestKlam {
    @Test
    fun test() {
        val vec = FVec3(0.0f)
        val add = DVec3(0.5, 1.0, 1.5)

        repeat(100) {
            vec += FVec3(add)
        }

        println(vec)
    }
}
