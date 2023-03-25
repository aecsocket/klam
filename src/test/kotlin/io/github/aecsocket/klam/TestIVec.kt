package io.github.aecsocket.klam

import kotlin.test.Test
import kotlin.test.assertEquals

class TestIVec {
    @Test
    fun testIVec2Map() {
        val vec = IVec2(1, 2)
        assertEquals(IVec2(6, 7), vec.map { i -> i + 5 })
        assertEquals(IVec2(-4, -3), vec.map { i -> i - 5 })
        assertEquals(IVec2(5, 10), vec.map { i -> i * 5 })
        assertEquals(IVec2(0, 1), vec.map { i -> i / 2 })
    }

    @Test
    fun testIVec2Set() {
        val vec = IVec2(1, 2)
        vec.x = 2
        assertEquals(IVec2(2, 2), vec)
        vec.y = 1
        assertEquals(IVec2(2, 1), vec)
    }

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

    @Test
    fun testIVec2Minus() {
        val vec = IVec2(4, 6)
        assertEquals(IVec2(3, 4), vec - IVec2(1, 2))
        assertEquals(IVec2(2, 4), vec - 2)
        assertEquals(IVec2(-2, -4), 2 - vec)

        vec -= IVec2(1, 2)
        assertEquals(IVec2(3, 4), vec)
        vec -= 2
        assertEquals(IVec2(1, 2), vec)
    }

    @Test
    fun testIVec2Times() {
        assertEquals(IVec2(0, 0), 0 * IVec2(4, 6))
        assertEquals(IVec2(0, 0), IVec2(4, 6) * 0)
        assertEquals(IVec2(0, 2), IVec2(0, 1) * IVec2(4, 2))
        assertEquals(IVec2(4, 0), IVec2(1, 0) * IVec2(4, 2))
        assertEquals(IVec2(4, 2), IVec2(1, 1) * IVec2(4, 2))

        val vec = IVec2(4, 6)
        vec *= 1
        assertEquals(IVec2(4, 6), vec)
        vec *= 2
        assertEquals(IVec2(8, 12), vec)
        vec *= 0
        assertEquals(IVec2(0, 0), vec)
    }

    @Test
    fun testIVec2Divide() {
        assertEquals(IVec2(0, 0), 0 / IVec2(4, 6))
        assertEquals(IVec2(4, 2), IVec2(4, 2) / IVec2(1, 1))
        assertEquals(IVec2(2, 1), IVec2(4, 2) / IVec2(2, 2))

        val vec = IVec2(4, 6)
        vec /= 1
        assertEquals(IVec2(4, 6), vec)
        vec /= 2
        assertEquals(IVec2(2, 3), vec)
        vec /= IVec2(2, 1)
        assertEquals(IVec2(1, 3), vec)
    }

    @Test
    fun testIVec2Inc() {
        var vec = IVec2(4, 6)
        assertEquals(IVec2(5, 7), ++vec)
    }
    @Test
    fun testIVec2Dec() {
        var vec = IVec2(4, 6)
        assertEquals(IVec2(3, 5), --vec)
    }

    @Test
    fun testIVec2Negate() {
        val vec = IVec2(4, 6)
        assertEquals(IVec2(-4, -6), -vec)
        val vec2 = IVec2(-4, 6)
        assertEquals(IVec2(4, -6), -vec2)
        assertEquals(vec, -(-vec))
        assertEquals(vec2, -(-vec2))
    }

    @Test
    fun testIVec2Equals() {
        val vec = IVec2(4, 6)
        @Suppress("KotlinConstantConditions")
        assertEquals(true, vec == vec)
        assertEquals(true, IVec2(0, 0) == IVec2(0,0))
        assertEquals(true, IVec2(4, 6) == IVec2(4, 6))
        assertEquals(false, IVec2(5, 6) == IVec2(4, 6))
        assertEquals(false, IVec2(4, 7) == IVec2(4, 6))
    }

    @Test
    fun testIVec2Diff() {
        val vec = IVec2(4, 6)
        @Suppress("KotlinConstantConditions")
        assertEquals(false, vec != vec)
        assertEquals(false, IVec2(0, 0) != IVec2(0,0))
        assertEquals(false, IVec2(4, 6) != IVec2(4, 6))
        assertEquals(true, IVec2(5, 6) != IVec2(4, 6))
        assertEquals(true, IVec2(4, 7) != IVec2(4, 6))
    }

    @Test
    fun testIVec2LessThan() {
        val vec = IVec2(4, 6)
        assertEquals(BVec2(false, false), vec lt vec)
        assertEquals(BVec2(false, false), IVec2(0, 0) lt IVec2(0, 0))
        assertEquals(BVec2(true, false), IVec2(0, 0) lt IVec2(1,0))
        assertEquals(BVec2(false, true), IVec2(4, 0) lt IVec2(4, 6))
        assertEquals(BVec2(false, false), IVec2(5, 6) lt IVec2(4, 6))
        assertEquals(BVec2(true, true), IVec2(1, 3) lt IVec2(4, 6))
    }

    @Test
    fun testIVec2LessThanEquals() {
        val vec = IVec2(4, 6)
        assertEquals(BVec2(true, true), vec le vec)
        assertEquals(BVec2(true, true), IVec2(0, 0) le IVec2(0, 0))
        assertEquals(BVec2(true, true), IVec2(0, 0) le IVec2(1,0))
        assertEquals(BVec2(true, true), IVec2(4, 0) le IVec2(4, 6))
        assertEquals(BVec2(false, false), IVec2(5, 6) le IVec2(4, 5))
        assertEquals(BVec2(false, true), IVec2(5, 6) le IVec2(4, 6))
        assertEquals(BVec2(true, true), IVec2(1, 3) le IVec2(4, 6))
    }

    @Test
    fun testIVec2GreaterThan() {
        val vec = IVec2(4, 6)
        assertEquals(BVec2(false, false), vec gt vec)
        assertEquals(BVec2(false, false), IVec2(0, 0) gt IVec2(0, 0))
        assertEquals(BVec2(true, false),  IVec2(1,0) gt IVec2(0, 0))
        assertEquals(BVec2(false, true), IVec2(4, 6) gt IVec2(4, 0))
        assertEquals(BVec2(false, false), IVec2(4, 6) gt IVec2(5, 6))
        assertEquals(BVec2(true, true), IVec2(4, 6) gt IVec2(1, 3))
    }

    @Test
    fun testIVec2GreaterThanEquals() {
        val vec = IVec2(4, 6)
        assertEquals(BVec2(true, true), vec ge vec)
        assertEquals(BVec2(true, true), IVec2(0, 0) ge IVec2(0, 0))
        assertEquals(BVec2(true, true),  IVec2(1,0) ge IVec2(0, 0))
        assertEquals(BVec2(true, true), IVec2(4, 6) ge IVec2(4, 0))
        assertEquals(BVec2(false, false), IVec2(4, 5) ge IVec2(5, 6))
        assertEquals(BVec2(false, true), IVec2(4, 6) ge IVec2(5, 6))
        assertEquals(BVec2(true, true), IVec2(4, 6) ge IVec2(1, 3))
    }

    // IVec3

    @Test
    fun testIVec3Map() {
        val vec = IVec3(1, 2, 3)
        assertEquals(IVec3(6, 7, 8), vec.map { i -> i + 5 })
        assertEquals(IVec3(-4, -3, -2), vec.map { i -> i - 5 })
        assertEquals(IVec3(5, 10, 15), vec.map { i -> i * 5 })
        assertEquals(IVec3(0, 1, 1), vec.map { i -> i / 2 })
    }

    @Test
    fun testIVec3Set() {
        val vec = IVec3(1, 2, 3)
        vec.x = 2
        assertEquals(IVec3(2, 2, 3), vec)
        vec.y = 1
        assertEquals(IVec3(2, 1, 3), vec)
        vec.z = 2
        assertEquals(IVec3(2, 1, 2), vec)
    }

    @Test
    fun testIVec3Components() {
        val vec = IVec3(1, 2, 3)
        assertEquals(1, vec.x)
        assertEquals(2, vec.y)
        assertEquals(3, vec.z)
    }

    @Test
    fun testIVec3Plus() {
        val vec = IVec3(1, 2, 3)
        assertEquals(IVec3(2, 4, 6), vec + IVec3(1, 2, 3))
        assertEquals(IVec3(3, 4, 5), vec + 2)
        assertEquals(IVec3(3, 4, 5), 2 + vec)

        vec += IVec3(1, 2, 3)
        assertEquals(IVec3(2, 4, 6), vec)
        vec += 2
        assertEquals(IVec3(4, 6, 8), vec)
    }

    @Test
    fun testIVec3Minus() {
        val vec = IVec3(4, 6, 9)
        assertEquals(IVec3(3, 4, 6), vec - IVec3(1, 2, 3))
        assertEquals(IVec3(2, 4, 7), vec - 2)
        assertEquals(IVec3(-2, -4, -7), 2 - vec)

        vec -= IVec3(1, 2, 3)
        assertEquals(IVec3(3, 4, 6), vec)
        vec -= 2
        assertEquals(IVec3(1, 2, 4), vec)
    }

    @Test
    fun testIVec3Times() {
        assertEquals(IVec3(0, 0, 0), 0 * IVec3(4, 6, 9))
        assertEquals(IVec3(0, 0, 0), IVec3(4, 6, 9) * 0)
        assertEquals(IVec3(0, 2, 4), IVec3(0, 1, 2) * IVec3(4, 2, 2))
        assertEquals(IVec3(4, 0, 6), IVec3(1, 0, 2) * IVec3(4, 2, 3))
        assertEquals(IVec3(4, 2, 5), IVec3(1, 1, 1) * IVec3(4, 2, 5))

        val vec = IVec3(4, 6, 9)
        vec *= 1
        assertEquals(IVec3(4, 6, 9), vec)
        vec *= 2
        assertEquals(IVec3(8, 12, 18), vec)
        vec *= 0
        assertEquals(IVec3(0, 0, 0), vec)
    }

    @Test
    fun testIVec3Divide() {
        assertEquals(IVec3(0, 0, 0), 0 / IVec3(4, 6, 9))
        assertEquals(IVec3(4, 2, 6), IVec3(4, 2, 6) / IVec3(1, 1, 1))
        assertEquals(IVec3(2, 1, 3), IVec3(4, 2, 6) / IVec3(2, 2, 2))

        val vec = IVec3(4, 6, 9)
        vec /= 1
        assertEquals(IVec3(4, 6, 9), vec)
        vec /= 2
        assertEquals(IVec3(2, 3, 4), vec)
        vec /= IVec3(2, 1, 3)
        assertEquals(IVec3(1, 3, 1), vec)
    }

    @Test
    fun testIVec3Inc() {
        var vec = IVec3(4, 6, 8)
        assertEquals(IVec3(5, 7, 9), ++vec)
    }
    @Test
    fun testIVec3Dec() {
        var vec = IVec3(4, 6, 8)
        assertEquals(IVec3(3, 5, 7), --vec)
    }

    @Test
    fun testIVec3Negate() {
        val vec = IVec3(4, 6, 8)
        assertEquals(IVec3(-4, -6, -8), -vec)
        val vec2 = IVec3(-4, 6, 8)
        assertEquals(IVec3(4, -6, -8), -vec2)
        assertEquals(vec, -(-vec))
        assertEquals(vec2, -(-vec2))
    }

    @Test
    fun testIVec3Equals() {
        val vec = IVec3(4, 6, 8)
        @Suppress("KotlinConstantConditions")
        assertEquals(true, vec == vec)
        assertEquals(true, IVec3(0, 0, 0) == IVec3(0,0, 0))
        assertEquals(true, IVec3(4, 6, 8) == IVec3(4, 6, 8))
        assertEquals(false, IVec3(5, 6, 2) == IVec3(4, 6, 5))
        assertEquals(false, IVec3(4, 7, 2) == IVec3(4, 6, 2))
    }

    @Test
    fun testIVec3Diff() {
        val vec = IVec3(4, 6, 8)
        @Suppress("KotlinConstantConditions")
        assertEquals(false, vec != vec)
        assertEquals(false, IVec3(0, 0, 0) != IVec3(0,0, 0))
        assertEquals(false, IVec3(4, 6, 8) != IVec3(4, 6, 8))
        assertEquals(true, IVec3(5, 6, 2) != IVec3(4, 6, 5))
        assertEquals(true, IVec3(4, 7, 2) != IVec3(4, 6, 2))
    }

    @Test
    fun testIVec3LessThan() {
        val vec = IVec3(4, 6, 8)
        assertEquals(BVec3(false, false, false), vec lt vec)
        assertEquals(BVec3(false, false, false), IVec3(0, 0, 0) lt IVec3(0, 0, 0))
        assertEquals(BVec3(true, false, false), IVec3(0, 0, 0) lt IVec3(1,0, 0))
        assertEquals(BVec3(false, true, false), IVec3(4, 0, 0) lt IVec3(4, 6, 0))
        assertEquals(BVec3(false, false, true), IVec3(5, 6, 1) lt IVec3(4, 6, 5))
        assertEquals(BVec3(true, true, true), IVec3(1, 3, 2) lt IVec3(4, 6, 5))
    }

    @Test
    fun testIVec3LessThanEquals() {
        val vec = IVec3(4, 6, 8)
        assertEquals(BVec3(true, true, true), vec le vec)
        assertEquals(BVec3(true, true, true), IVec3(0, 0, 0) le IVec3(0, 0, 0))
        assertEquals(BVec3(true, true, true), IVec3(0, 0, 0) le IVec3(1,0, 0))
        assertEquals(BVec3(true, true, false), IVec3(4, 0, 5) le IVec3(4, 6, 0))
        assertEquals(BVec3(false, false, true), IVec3(5, 6, 5) le IVec3(4, 5, 5))
        assertEquals(BVec3(false, true, false), IVec3(5, 6, 2) le IVec3(4, 6, 1))
        assertEquals(BVec3(true, true, true), IVec3(1, 3, 2) le IVec3(4, 6, 3))
    }

    @Test
    fun testIVec3GreaterThan() {
        val vec = IVec3(4, 6, 8)
        assertEquals(BVec3(false, false, false), vec gt vec)
        assertEquals(BVec3(false, false, false), IVec3(0, 0, 0) gt IVec3(0, 0, 0))
        assertEquals(BVec3(true, false, false),  IVec3(1,0, 0) gt IVec3(0, 0, 0))
        assertEquals(BVec3(false, true, false), IVec3(4, 6, 2) gt IVec3(4, 0, 4))
        assertEquals(BVec3(false, false, true), IVec3(4, 6, 5) gt IVec3(5, 6, 2))
        assertEquals(BVec3(true, true, true), IVec3(4, 6, 5) gt IVec3(1, 3, 2))
    }

    @Test
    fun testIVec3GreaterThanEquals() {
        val vec = IVec3(4, 6, 8)
        assertEquals(BVec3(true, true, true), vec ge vec)
        assertEquals(BVec3(true, true, true), IVec3(0, 0, 0) ge IVec3(0, 0, 0))
        assertEquals(BVec3(true, true, true),  IVec3(1,0, 0) ge IVec3(0, 0, 0))
        assertEquals(BVec3(true, true, true), IVec3(4, 6, 5) ge IVec3(4, 0, 2))
        assertEquals(BVec3(false, false, false), IVec3(4, 5, 1) ge IVec3(5, 6, 2))
        assertEquals(BVec3(false, true, false), IVec3(4, 6, 2) ge IVec3(5, 6, 3))
        assertEquals(BVec3(true, true, true), IVec3(4, 6, 5) ge IVec3(1, 3, 5))
    }

    // IVec4

    @Test
    fun testIVec4Map() {
        val vec = IVec4(1, 2, 3, 4)
        assertEquals(IVec4(6, 7, 8, 9), vec.map { i -> i + 5 })
        assertEquals(IVec4(-4, -3, -2, -1), vec.map { i -> i - 5 })
        assertEquals(IVec4(5, 10, 15, 20), vec.map { i -> i * 5 })
        assertEquals(IVec4(0, 1, 1, 2), vec.map { i -> i / 2 })
    }

    @Test
    fun testIVec4Set() {
        val vec = IVec4(1, 2, 3, 4)
        vec.x = 2
        assertEquals(IVec4(2, 2, 3, 4), vec)
        vec.y = 1
        assertEquals(IVec4(2, 1, 3, 4), vec)
        vec.z = 2
        assertEquals(IVec4(2, 1, 2, 4), vec)
        vec.w = 5
        assertEquals(IVec4(2, 1, 2, 5), vec)
    }

    @Test
    fun testIVec4Components() {
        val vec = IVec4(1, 2, 3, 4)
        assertEquals(1, vec.x)
        assertEquals(2, vec.y)
        assertEquals(3, vec.z)
        assertEquals(4, vec.w)
    }

    @Test
    fun testIVec4Plus() {
        val vec = IVec4(1, 2, 3, 4)
        assertEquals(IVec4(2, 4, 6, 8), vec + IVec4(1, 2, 3, 4))
        assertEquals(IVec4(3, 4, 5, 6), vec + 2)
        assertEquals(IVec4(3, 4, 5, 6), 2 + vec)

        vec += IVec4(1, 2, 3, 4)
        assertEquals(IVec4(2, 4, 6, 8), vec)
        vec += 2
        assertEquals(IVec4(4, 6, 8, 10), vec)
    }

    @Test
    fun testIVec4Minus() {
        val vec = IVec4(4, 6, 9, 12)
        assertEquals(IVec4(3, 4, 6, 8), vec - IVec4(1, 2, 3, 4))
        assertEquals(IVec4(2, 4, 7, 10), vec - 2)
        assertEquals(IVec4(-2, -4, -7, -10), 2 - vec)

        vec -= IVec4(1, 2, 3, 4)
        assertEquals(IVec4(3, 4, 6, 8), vec)
        vec -= 2
        assertEquals(IVec4(1, 2, 4, 6), vec)
    }

    @Test
    fun testIVec4Times() {
        assertEquals(IVec4(0, 0, 0, 0), 0 * IVec4(4, 6, 9, 12))
        assertEquals(IVec4(0, 0, 0, 0), IVec4(4, 6, 9, 12) * 0)
        assertEquals(IVec4(0, 2, 4, 6), IVec4(0, 1, 2, 3) * IVec4(4, 2, 2, 2))
        assertEquals(IVec4(4, 0, 6, 2), IVec4(1, 0, 2, 1) * IVec4(4, 2, 3, 2))
        assertEquals(IVec4(4, 2, 5, 6), IVec4(1, 1, 1, 1) * IVec4(4, 2, 5, 6))

        val vec = IVec4(4, 6, 9, 12)
        vec *= 1
        assertEquals(IVec4(4, 6, 9, 12), vec)
        vec *= 2
        assertEquals(IVec4(8, 12, 18, 24), vec)
        vec *= 0
        assertEquals(IVec4(0, 0, 0, 0), vec)
    }

    @Test
    fun testIVec4Divide() {
        assertEquals(IVec4(0, 0, 0, 0), 0 / IVec4(4, 6, 9, 12))
        assertEquals(IVec4(4, 2, 6, 9), IVec4(4, 2, 6, 9) / IVec4(1, 1, 1, 1))
        assertEquals(IVec4(2, 1, 3, 4), IVec4(4, 2, 6, 8) / IVec4(2, 2, 2, 2))

        val vec = IVec4(4, 6, 9, 12)
        vec /= 1
        assertEquals(IVec4(4, 6, 9, 12), vec)
        vec /= 2
        assertEquals(IVec4(2, 3, 4, 6), vec)
        vec /= IVec4(2, 1, 3, 6)
        assertEquals(IVec4(1, 3, 1, 1), vec)
    }

    @Test
    fun testIVec4Inc() {
        var vec = IVec4(4, 6, 8, 10)
        assertEquals(IVec4(5, 7, 9, 11), ++vec)
    }
    @Test
    fun testIVec4Dec() {
        var vec = IVec4(4, 6, 8, 10)
        assertEquals(IVec4(3, 5, 7, 9), --vec)
    }

    @Test
    fun testIVec4Negate() {
        val vec = IVec4(4, 6, 8, 10)
        assertEquals(IVec4(-4, -6, -8, -10), -vec)
        val vec2 = IVec4(-4, 6, 8, -10)
        assertEquals(IVec4(4, -6, -8, 10), -vec2)
        assertEquals(vec, -(-vec))
        assertEquals(vec2, -(-vec2))
    }

    @Test
    fun testIVec4Equals() {
        val vec = IVec4(4, 6, 8, 10)
        @Suppress("KotlinConstantConditions")
        assertEquals(true, vec == vec)
        assertEquals(true, IVec4(0, 0, 0, 0) == IVec4(0,0, 0, 0))
        assertEquals(true, IVec4(4, 6, 8, 10) == IVec4(4, 6, 8, 10))
        assertEquals(false, IVec4(5, 6, 2, 7) == IVec4(4, 6, 5, 7))
        assertEquals(false, IVec4(4, 7, 2, 7) == IVec4(4, 6, 2, 5))
    }

    @Test
    fun testIVec4Diff() {
        val vec = IVec4(4, 6, 8, 10)
        @Suppress("KotlinConstantConditions")
        assertEquals(false, vec != vec)
        assertEquals(false, IVec4(0, 0, 0, 0) != IVec4(0,0, 0, 0))
        assertEquals(false, IVec4(4, 6, 8, 10) != IVec4(4, 6, 8, 10))
        assertEquals(true, IVec4(5, 6, 2, 4) != IVec4(4, 6, 5, 5))
        assertEquals(true, IVec4(4, 7, 2, 4) != IVec4(4, 6, 2, 4))
    }

    @Test
    fun testIVec4LessThan() {
        val vec = IVec4(4, 6, 8, 10)
        assertEquals(BVec4(false, false, false, false), vec lt vec)
        assertEquals(BVec4(false, false, false, false), IVec4(0, 0, 0, 0) lt IVec4(0, 0, 0, 0))
        assertEquals(BVec4(true, false, false, false), IVec4(0, 0, 0, 0) lt IVec4(1,0, 0, 0))
        assertEquals(BVec4(false, true, false, true), IVec4(4, 0, 0, 1) lt IVec4(4, 6, 0, 5))
        assertEquals(BVec4(false, false, true, false), IVec4(5, 6, 1, 4) lt IVec4(4, 6, 5, 2))
        assertEquals(BVec4(true, true, true, true), IVec4(1, 3, 2, 2) lt IVec4(4, 6, 5, 4))
    }

    @Test
    fun testIVec4LessThanEquals() {
        val vec = IVec4(4, 6, 8, 10)
        assertEquals(BVec4(true, true, true, true), vec le vec)
        assertEquals(BVec4(true, true, true, true), IVec4(0, 0, 0, 0) le IVec4(0, 0, 0, 0))
        assertEquals(BVec4(true, true, true, true), IVec4(0, 0, 0, 0) le IVec4(1,0, 0, 0))
        assertEquals(BVec4(true, true, false, true), IVec4(4, 0, 5, 4) le IVec4(4, 6, 0, 7))
        assertEquals(BVec4(false, false, true, false), IVec4(5, 6, 5, 5) le IVec4(4, 5, 5, 2))
        assertEquals(BVec4(false, true, false, false), IVec4(5, 6, 2, 5) le IVec4(4, 6, 1, 2))
        assertEquals(BVec4(true, true, true, true), IVec4(1, 3, 2, 4) le IVec4(4, 6, 3, 4))
    }

    @Test
    fun testIVec4GreaterThan() {
        val vec = IVec4(4, 6, 8, 10)
        assertEquals(BVec4(false, false, false, false), vec gt vec)
        assertEquals(BVec4(false, false, false, false), IVec4(0, 0, 0, 0) gt IVec4(0, 0, 0, 0))
        assertEquals(BVec4(true, false, false, false),  IVec4(1,0, 0, 0) gt IVec4(0, 0, 0, 0))
        assertEquals(BVec4(false, true, false, true), IVec4(4, 6, 2, 5) gt IVec4(4, 0, 4, 2))
        assertEquals(BVec4(false, false, true, false), IVec4(4, 6, 5, 2) gt IVec4(5, 6, 2, 5))
        assertEquals(BVec4(true, true, true, true), IVec4(4, 6, 5, 4) gt IVec4(1, 3, 2, 2))
    }

    @Test
    fun testIVec4GreaterThanEquals() {
        val vec = IVec4(4, 6, 8, 10)
        assertEquals(BVec4(true, true, true, true), vec ge vec)
        assertEquals(BVec4(true, true, true, true), IVec4(0, 0, 0, 0) ge IVec4(0, 0, 0, 0))
        assertEquals(BVec4(true, true, true, true),  IVec4(1,0, 0, 0) ge IVec4(0, 0, 0, 0))
        assertEquals(BVec4(true, true, true, true), IVec4(4, 6, 5, 5) ge IVec4(4, 0, 2, 3))
        assertEquals(BVec4(false, false, false, false), IVec4(4, 5, 1, 2) ge IVec4(5, 6, 2, 5))
        assertEquals(BVec4(false, true, false, true), IVec4(4, 6, 2, 4) ge IVec4(5, 6, 3, 4))
        assertEquals(BVec4(true, true, true, true), IVec4(4, 6, 5, 7) ge IVec4(1, 3, 5, 7))
    }
}
