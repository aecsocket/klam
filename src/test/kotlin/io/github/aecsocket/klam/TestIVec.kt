package io.github.aecsocket.klam

import kotlin.test.Test
import kotlin.test.assertEquals

class TestIVec {
    @Test
    fun testIVec2Components() {
        val vec = IVec2(1, 2)
        assertEquals(1, vec.x)
        assertEquals(2, vec.y)
    }

    @Test
    fun testIVec2Plus() {
        val vec = IVec2(1, 2)
        assertEquals(IVec2(2, 4), vec + IVec2(1, 2))
        assertEquals(IVec2(3, 4), vec + 2)
        assertEquals(IVec2(3, 4), 2 + vec)

        vec += IVec2(1, 2)
        assertEquals(IVec2(2, 4), vec)
        vec += 2
        assertEquals(IVec2(4, 6), vec)
    }
}
