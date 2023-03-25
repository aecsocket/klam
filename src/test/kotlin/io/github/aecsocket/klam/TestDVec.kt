package io.github.aecsocket.klam

import kotlin.test.Test
import kotlin.test.assertEquals

class TestDVec {
    @Test
    fun testDVec2Map() {
        val vec = DVec2(1.0, 2.0)
        assertEquals(DVec2(6.0, 7.0), vec.map { i -> i + 5.0 })
        assertEquals(DVec2(-4.0, -3.0), vec.map { i -> i - 5.0 })
        assertEquals(DVec2(5.0, 10.0), vec.map { i -> i * 5.0 })
        assertEquals(DVec2(0.5, 1.0), vec.map { i -> i / 2.0 })
    }

    @Test
    fun testDVec2Set() {
        val vec = DVec2(1.0, 2.0)
        vec.x = 2.0
        assertEquals(DVec2(2.0, 2.0), vec)
        vec.y = 1.0
        assertEquals(DVec2(2.0, 1.0), vec)
    }

    @Test
    fun testDVec2Components() {
        val vec = DVec2(1.0, 2.0)
        assertEquals(1.0, vec.x)
        assertEquals(2.0, vec.y)
    }

    @Test
    fun testDVec2Plus() {
        val vec = DVec2(1.0, 2.0)
        assertEquals(DVec2(2.0, 4.0), vec + DVec2(1.0, 2.0))
        assertEquals(DVec2(3.0, 4.0), vec + 2.0)
        assertEquals(DVec2(3.0, 4.0), 2.0 + vec)

        vec += DVec2(1.0, 2.0)
        assertEquals(DVec2(2.0, 4.0), vec)
        vec += 2.0
        assertEquals(DVec2(4.0, 6.0), vec)
    }

    @Test
    fun testDVec2Minus() {
        val vec = DVec2(4.0, 6.0)
        assertEquals(DVec2(3.0, 4.0), vec - DVec2(1.0, 2.0))
        assertEquals(DVec2(2.0, 4.0), vec - 2.0)
        assertEquals(DVec2(-2.0, -4.0), 2.0 - vec)

        vec -= DVec2(1.0, 2.0)
        assertEquals(DVec2(3.0, 4.0), vec)
        vec -= 2.0
        assertEquals(DVec2(1.0, 2.0), vec)
    }

    @Test
    fun testDVec2Times() {
        assertEquals(DVec2(0.0, 0.0), 0.0 * DVec2(4.0, 6.0))
        assertEquals(DVec2(0.0, 0.0), DVec2(4.0, 6.0) * 0.0)
        assertEquals(DVec2(0.0, 2.0), DVec2(0.0, 1.0) * DVec2(4.0, 2.0))
        assertEquals(DVec2(4.0, 0.0), DVec2(1.0, 0.0) * DVec2(4.0, 2.0))
        assertEquals(DVec2(4.0, 2.0), DVec2(1.0, 1.0) * DVec2(4.0, 2.0))

        val vec = DVec2(4.0, 6.0)
        vec *= 1.0
        assertEquals(DVec2(4.0, 6.0), vec)
        vec *= 2.0
        assertEquals(DVec2(8.0, 12.0), vec)
        vec *= 0.0
        assertEquals(DVec2(0.0, 0.0), vec)
    }

    @Test
    fun testDVec2Divide() {
        assertEquals(DVec2(0.0, 0.0), 0.0 / DVec2(4.0, 6.0))
        assertEquals(DVec2(4.0, 2.0), DVec2(4.0, 2.0) / DVec2(1.0, 1.0))
        assertEquals(DVec2(2.0, 1.0), DVec2(4.0, 2.0) / DVec2(2.0, 2.0))

        val vec = DVec2(4.0, 6.0)
        vec /= 1.0
        assertEquals(DVec2(4.0, 6.0), vec)
        vec /= 2.0
        assertEquals(DVec2(2.0, 3.0), vec)
        vec /= DVec2(2.0, 1.0)
        assertEquals(DVec2(1.0, 3.0), vec)
    }

    @Test
    fun testDVec2Inc() {
        var vec = DVec2(4.0, 6.0)
        assertEquals(DVec2(5.0, 7.0), ++vec)
    }
    @Test
    fun testDVec2Dec() {
        var vec = DVec2(4.0, 6.0)
        assertEquals(DVec2(3.0, 5.0), --vec)
    }

    @Test
    fun testDVec2Negate() {
        val vec = DVec2(4.0, 6.0)
        assertEquals(DVec2(-4.0, -6.0), -vec)
        val vec2 = DVec2(-4.0, 6.0)
        assertEquals(DVec2(4.0, -6.0), -vec2)
        assertEquals(vec, -(-vec))
        assertEquals(vec2, -(-vec2))
    }

    @Test
    fun testDVec2Equals() {
        val vec = DVec2(4.0, 6.0)
        @Suppress("KotlinConstantConditions")
        assertEquals(true, vec == vec)
        assertEquals(true, DVec2(0.0, 0.0) == DVec2(0.0,0.0))
        assertEquals(true, DVec2(4.0, 6.0) == DVec2(4.0, 6.0))
        assertEquals(false, DVec2(5.0, 6.0) == DVec2(4.0, 6.0))
        assertEquals(false, DVec2(4.0, 7.0) == DVec2(4.0, 6.0))
    }

    @Test
    fun testDVec2Diff() {
        val vec = DVec2(4.0, 6.0)
        @Suppress("KotlinConstantConditions")
        assertEquals(false, vec != vec)
        assertEquals(false, DVec2(0.0, 0.0) != DVec2(0.0,0.0))
        assertEquals(false, DVec2(4.0, 6.0) != DVec2(4.0, 6.0))
        assertEquals(true, DVec2(5.0, 6.0) != DVec2(4.0, 6.0))
        assertEquals(true, DVec2(4.0, 7.0) != DVec2(4.0, 6.0))
    }

    @Test
    fun testDVec2LessThan() {
        val vec = DVec2(4.0, 6.0)
        assertEquals(BVec2(false, false), vec lt vec)
        assertEquals(BVec2(false, false), DVec2(0.0, 0.0) lt DVec2(0.0, 0.0))
        assertEquals(BVec2(true, false), DVec2(0.0, 0.0) lt DVec2(1.0,0.0))
        assertEquals(BVec2(false, true), DVec2(4.0, 0.0) lt DVec2(4.0, 6.0))
        assertEquals(BVec2(false, false), DVec2(5.0, 6.0) lt DVec2(4.0, 6.0))
        assertEquals(BVec2(true, true), DVec2(1.0, 3.0) lt DVec2(4.0, 6.0))
    }

    @Test
    fun testDVec2LessThanEquals() {
        val vec = DVec2(4.0, 6.0)
        assertEquals(BVec2(true, true), vec le vec)
        assertEquals(BVec2(true, true), DVec2(0.0, 0.0) le DVec2(0.0, 0.0))
        assertEquals(BVec2(true, true), DVec2(0.0, 0.0) le DVec2(1.0,0.0))
        assertEquals(BVec2(true, true), DVec2(4.0, 0.0) le DVec2(4.0, 6.0))
        assertEquals(BVec2(false, false), DVec2(5.0, 6.0) le DVec2(4.0, 5.0))
        assertEquals(BVec2(false, true), DVec2(5.0, 6.0) le DVec2(4.0, 6.0))
        assertEquals(BVec2(true, true), DVec2(1.0, 3.0) le DVec2(4.0, 6.0))
    }

    @Test
    fun testDVec2GreaterThan() {
        val vec = DVec2(4.0, 6.0)
        assertEquals(BVec2(false, false), vec gt vec)
        assertEquals(BVec2(false, false), DVec2(0.0, 0.0) gt DVec2(0.0, 0.0))
        assertEquals(BVec2(true, false),  DVec2(1.0,0.0) gt DVec2(0.0, 0.0))
        assertEquals(BVec2(false, true), DVec2(4.0, 6.0) gt DVec2(4.0, 0.0))
        assertEquals(BVec2(false, false), DVec2(4.0, 6.0) gt DVec2(5.0, 6.0))
        assertEquals(BVec2(true, true), DVec2(4.0, 6.0) gt DVec2(1.0, 3.0))
    }

    @Test
    fun testDVec2GreaterThanEquals() {
        val vec = DVec2(4.0, 6.0)
        assertEquals(BVec2(true, true), vec ge vec)
        assertEquals(BVec2(true, true), DVec2(0.0, 0.0) ge DVec2(0.0, 0.0))
        assertEquals(BVec2(true, true),  DVec2(1.0,0.0) ge DVec2(0.0, 0.0))
        assertEquals(BVec2(true, true), DVec2(4.0, 6.0) ge DVec2(4.0, 0.0))
        assertEquals(BVec2(false, false), DVec2(4.0, 5.0) ge DVec2(5.0, 6.0))
        assertEquals(BVec2(false, true), DVec2(4.0, 6.0) ge DVec2(5.0, 6.0))
        assertEquals(BVec2(true, true), DVec2(4.0, 6.0) ge DVec2(1.0, 3.0))
    }

    // DVec3

    @Test
    fun testDVec3Map() {
        val vec = DVec3(1.0, 2.0, 3.0)
        assertEquals(DVec3(6.0, 7.0, 8.0), vec.map { i -> i + 5.0 })
        assertEquals(DVec3(-4.0, -3.0, -2.0), vec.map { i -> i - 5.0 })
        assertEquals(DVec3(5.0, 10.0, 15.0), vec.map { i -> i * 5.0 })
        assertEquals(DVec3(0.5, 1.0, 1.5), vec.map { i -> i / 2.0 })
    }

    @Test
    fun testDVec3Set() {
        val vec = DVec3(1.0, 2.0, 3.0)
        vec.x = 2.0
        assertEquals(DVec3(2.0, 2.0, 3.0), vec)
        vec.y = 1.0
        assertEquals(DVec3(2.0, 1.0, 3.0), vec)
        vec.z = 2.0
        assertEquals(DVec3(2.0, 1.0, 2.0), vec)
    }

    @Test
    fun testDVec3Components() {
        val vec = DVec3(1.0, 2.0, 3.0)
        assertEquals(1.0, vec.x)
        assertEquals(2.0, vec.y)
        assertEquals(3.0, vec.z)
    }

    @Test
    fun testDVec3Plus() {
        val vec = DVec3(1.0, 2.0, 3.0)
        assertEquals(DVec3(2.0, 4.0, 6.0), vec + DVec3(1.0, 2.0, 3.0))
        assertEquals(DVec3(3.0, 4.0, 5.0), vec + 2.0)
        assertEquals(DVec3(3.0, 4.0, 5.0), 2.0 + vec)

        vec += DVec3(1.0, 2.0, 3.0)
        assertEquals(DVec3(2.0, 4.0, 6.0), vec)
        vec += 2.0
        assertEquals(DVec3(4.0, 6.0, 8.0), vec)
    }

    @Test
    fun testDVec3Minus() {
        val vec = DVec3(4.0, 6.0, 9.0)
        assertEquals(DVec3(3.0, 4.0, 6.0), vec - DVec3(1.0, 2.0, 3.0))
        assertEquals(DVec3(2.0, 4.0, 7.0), vec - 2.0)
        assertEquals(DVec3(-2.0, -4.0, -7.0), 2.0 - vec)

        vec -= DVec3(1.0, 2.0, 3.0)
        assertEquals(DVec3(3.0, 4.0, 6.0), vec)
        vec -= 2.0
        assertEquals(DVec3(1.0, 2.0, 4.0), vec)
    }

    @Test
    fun testDVec3Times() {
        assertEquals(DVec3(0.0, 0.0, 0.0), 0.0 * DVec3(4.0, 6.0, 9.0))
        assertEquals(DVec3(0.0, 0.0, 0.0), DVec3(4.0, 6.0, 9.0) * 0.0)
        assertEquals(DVec3(0.0, 2.0, 4.0), DVec3(0.0, 1.0, 2.0) * DVec3(4.0, 2.0, 2.0))
        assertEquals(DVec3(4.0, 0.0, 6.0), DVec3(1.0, 0.0, 2.0) * DVec3(4.0, 2.0, 3.0))
        assertEquals(DVec3(4.0, 2.0, 5.0), DVec3(1.0, 1.0, 1.0) * DVec3(4.0, 2.0, 5.0))

        val vec = DVec3(4.0, 6.0, 9.0)
        vec *= 1.0
        assertEquals(DVec3(4.0, 6.0, 9.0), vec)
        vec *= 2.0
        assertEquals(DVec3(8.0, 12.0, 18.0), vec)
        vec *= 0.0
        assertEquals(DVec3(0.0, 0.0, 0.0), vec)
    }

    @Test
    fun testDVec3Divide() {
        assertEquals(DVec3(0.0, 0.0, 0.0), 0.0 / DVec3(4.0, 6.0, 9.0))
        assertEquals(DVec3(4.0, 2.0, 6.0), DVec3(4.0, 2.0, 6.0) / DVec3(1.0, 1.0, 1.0))
        assertEquals(DVec3(2.0, 1.0, 3.0), DVec3(4.0, 2.0, 6.0) / DVec3(2.0, 2.0, 2.0))

        val vec = DVec3(4.0, 6.0, 9.0)
        vec /= 1.0
        assertEquals(DVec3(4.0, 6.0, 9.0), vec)
        vec /= 2.0
        assertEquals(DVec3(2.0, 3.0, 4.5), vec)
        vec /= DVec3(2.0, 1.0, 3.0)
        assertEquals(DVec3(1.0, 3.0, 1.5), vec)
    }

    @Test
    fun testDVec3Inc() {
        var vec = DVec3(4.0, 6.0, 8.0)
        assertEquals(DVec3(5.0, 7.0, 9.0), ++vec)
    }
    @Test
    fun testDVec3Dec() {
        var vec = DVec3(4.0, 6.0, 8.0)
        assertEquals(DVec3(3.0, 5.0, 7.0), --vec)
    }

    @Test
    fun testDVec3Negate() {
        val vec = DVec3(4.0, 6.0, 8.0)
        assertEquals(DVec3(-4.0, -6.0, -8.0), -vec)
        val vec2 = DVec3(-4.0, 6.0, 8.0)
        assertEquals(DVec3(4.0, -6.0, -8.0), -vec2)
        assertEquals(vec, -(-vec))
        assertEquals(vec2, -(-vec2))
    }

    @Test
    fun testDVec3Equals() {
        val vec = DVec3(4.0, 6.0, 8.0)
        @Suppress("KotlinConstantConditions")
        assertEquals(true, vec == vec)
        assertEquals(true, DVec3(0.0, 0.0, 0.0) == DVec3(0.0,0.0, 0.0))
        assertEquals(true, DVec3(4.0, 6.0, 8.0) == DVec3(4.0, 6.0, 8.0))
        assertEquals(false, DVec3(5.0, 6.0, 2.0) == DVec3(4.0, 6.0, 5.0))
        assertEquals(false, DVec3(4.0, 7.0, 2.0) == DVec3(4.0, 6.0, 2.0))
    }

    @Test
    fun testDVec3Diff() {
        val vec = DVec3(4.0, 6.0, 8.0)
        @Suppress("KotlinConstantConditions")
        assertEquals(false, vec != vec)
        assertEquals(false, DVec3(0.0, 0.0, 0.0) != DVec3(0.0,0.0, 0.0))
        assertEquals(false, DVec3(4.0, 6.0, 8.0) != DVec3(4.0, 6.0, 8.0))
        assertEquals(true, DVec3(5.0, 6.0, 2.0) != DVec3(4.0, 6.0, 5.0))
        assertEquals(true, DVec3(4.0, 7.0, 2.0) != DVec3(4.0, 6.0, 2.0))
    }

    @Test
    fun testDVec3LessThan() {
        val vec = DVec3(4.0, 6.0, 8.0)
        assertEquals(BVec3(false, false, false), vec lt vec)
        assertEquals(BVec3(false, false, false), DVec3(0.0, 0.0, 0.0) lt DVec3(0.0, 0.0, 0.0))
        assertEquals(BVec3(true, false, false), DVec3(0.0, 0.0, 0.0) lt DVec3(1.0,0.0, 0.0))
        assertEquals(BVec3(false, true, false), DVec3(4.0, 0.0, 0.0) lt DVec3(4.0, 6.0, 0.0))
        assertEquals(BVec3(false, false, true), DVec3(5.0, 6.0, 1.0) lt DVec3(4.0, 6.0, 5.0))
        assertEquals(BVec3(true, true, true), DVec3(1.0, 3.0, 2.0) lt DVec3(4.0, 6.0, 5.0))
    }

    @Test
    fun testDVec3LessThanEquals() {
        val vec = DVec3(4.0, 6.0, 8.0)
        assertEquals(BVec3(true, true, true), vec le vec)
        assertEquals(BVec3(true, true, true), DVec3(0.0, 0.0, 0.0) le DVec3(0.0, 0.0, 0.0))
        assertEquals(BVec3(true, true, true), DVec3(0.0, 0.0, 0.0) le DVec3(1.0,0.0, 0.0))
        assertEquals(BVec3(true, true, false), DVec3(4.0, 0.0, 5.0) le DVec3(4.0, 6.0, 0.0))
        assertEquals(BVec3(false, false, true), DVec3(5.0, 6.0, 5.0) le DVec3(4.0, 5.0, 5.0))
        assertEquals(BVec3(false, true, false), DVec3(5.0, 6.0, 2.0) le DVec3(4.0, 6.0, 1.0))
        assertEquals(BVec3(true, true, true), DVec3(1.0, 3.0, 2.0) le DVec3(4.0, 6.0, 3.0))
    }

    @Test
    fun testDVec3GreaterThan() {
        val vec = DVec3(4.0, 6.0, 8.0)
        assertEquals(BVec3(false, false, false), vec gt vec)
        assertEquals(BVec3(false, false, false), DVec3(0.0, 0.0, 0.0) gt DVec3(0.0, 0.0, 0.0))
        assertEquals(BVec3(true, false, false),  DVec3(1.0,0.0, 0.0) gt DVec3(0.0, 0.0, 0.0))
        assertEquals(BVec3(false, true, false), DVec3(4.0, 6.0, 2.0) gt DVec3(4.0, 0.0, 4.0))
        assertEquals(BVec3(false, false, true), DVec3(4.0, 6.0, 5.0) gt DVec3(5.0, 6.0, 2.0))
        assertEquals(BVec3(true, true, true), DVec3(4.0, 6.0, 5.0) gt DVec3(1.0, 3.0, 2.0))
    }

    @Test
    fun testDVec3GreaterThanEquals() {
        val vec = DVec3(4.0, 6.0, 8.0)
        assertEquals(BVec3(true, true, true), vec ge vec)
        assertEquals(BVec3(true, true, true), DVec3(0.0, 0.0, 0.0) ge DVec3(0.0, 0.0, 0.0))
        assertEquals(BVec3(true, true, true),  DVec3(1.0,0.0, 0.0) ge DVec3(0.0, 0.0, 0.0))
        assertEquals(BVec3(true, true, true), DVec3(4.0, 6.0, 5.0) ge DVec3(4.0, 0.0, 2.0))
        assertEquals(BVec3(false, false, false), DVec3(4.0, 5.0, 1.0) ge DVec3(5.0, 6.0, 2.0))
        assertEquals(BVec3(false, true, false), DVec3(4.0, 6.0, 2.0) ge DVec3(5.0, 6.0, 3.0))
        assertEquals(BVec3(true, true, true), DVec3(4.0, 6.0, 5.0) ge DVec3(1.0, 3.0, 5.0))
    }

    // DVec4

    @Test
    fun testDVec4Map() {
        val vec = DVec4(1.0, 2.0, 3.0, 4.0)
        assertEquals(DVec4(6.0, 7.0, 8.0, 9.0), vec.map { i -> i + 5.0 })
        assertEquals(DVec4(-4.0, -3.0, -2.0, -1.0), vec.map { i -> i - 5.0 })
        assertEquals(DVec4(5.0, 10.0, 15.0, 20.0), vec.map { i -> i * 5.0 })
        assertEquals(DVec4(0.5, 1.0, 1.5, 2.0), vec.map { i -> i / 2.0 })
    }

    @Test
    fun testDVec4Set() {
        val vec = DVec4(1.0, 2.0, 3.0, 4.0)
        vec.x = 2.0
        assertEquals(DVec4(2.0, 2.0, 3.0, 4.0), vec)
        vec.y = 1.0
        assertEquals(DVec4(2.0, 1.0, 3.0, 4.0), vec)
        vec.z = 2.0
        assertEquals(DVec4(2.0, 1.0, 2.0, 4.0), vec)
        vec.w = 5.0
        assertEquals(DVec4(2.0, 1.0, 2.0, 5.0), vec)
    }

    @Test
    fun testDVec4Components() {
        val vec = DVec4(1.0, 2.0, 3.0, 4.0)
        assertEquals(1.0, vec.x)
        assertEquals(2.0, vec.y)
        assertEquals(3.0, vec.z)
        assertEquals(4.0, vec.w)
    }

    @Test
    fun testDVec4Plus() {
        val vec = DVec4(1.0, 2.0, 3.0, 4.0)
        assertEquals(DVec4(2.0, 4.0, 6.0, 8.0), vec + DVec4(1.0, 2.0, 3.0, 4.0))
        assertEquals(DVec4(3.0, 4.0, 5.0, 6.0), vec + 2.0)
        assertEquals(DVec4(3.0, 4.0, 5.0, 6.0), 2.0 + vec)

        vec += DVec4(1.0, 2.0, 3.0, 4.0)
        assertEquals(DVec4(2.0, 4.0, 6.0, 8.0), vec)
        vec += 2.0
        assertEquals(DVec4(4.0, 6.0, 8.0, 10.0), vec)
    }

    @Test
    fun testDVec4Minus() {
        val vec = DVec4(4.0, 6.0, 9.0, 12.0)
        assertEquals(DVec4(3.0, 4.0, 6.0, 8.0), vec - DVec4(1.0, 2.0, 3.0, 4.0))
        assertEquals(DVec4(2.0, 4.0, 7.0, 10.0), vec - 2.0)
        assertEquals(DVec4(-2.0, -4.0, -7.0, -10.0), 2.0 - vec)

        vec -= DVec4(1.0, 2.0, 3.0, 4.0)
        assertEquals(DVec4(3.0, 4.0, 6.0, 8.0), vec)
        vec -= 2.0
        assertEquals(DVec4(1.0, 2.0, 4.0, 6.0), vec)
    }

    @Test
    fun testDVec4Times() {
        assertEquals(DVec4(0.0, 0.0, 0.0, 0.0), 0.0 * DVec4(4.0, 6.0, 9.0, 12.0))
        assertEquals(DVec4(0.0, 0.0, 0.0, 0.0), DVec4(4.0, 6.0, 9.0, 12.0) * 0.0)
        assertEquals(DVec4(0.0, 2.0, 4.0, 6.0), DVec4(0.0, 1.0, 2.0, 3.0) * DVec4(4.0, 2.0, 2.0, 2.0))
        assertEquals(DVec4(4.0, 0.0, 6.0, 2.0), DVec4(1.0, 0.0, 2.0, 1.0) * DVec4(4.0, 2.0, 3.0, 2.0))
        assertEquals(DVec4(4.0, 2.0, 5.0, 6.0), DVec4(1.0, 1.0, 1.0, 1.0) * DVec4(4.0, 2.0, 5.0, 6.0))

        val vec = DVec4(4.0, 6.0, 9.0, 12.0)
        vec *= 1.0
        assertEquals(DVec4(4.0, 6.0, 9.0, 12.0), vec)
        vec *= 2.0
        assertEquals(DVec4(8.0, 12.0, 18.0, 24.0), vec)
        vec *= 0.0
        assertEquals(DVec4(0.0, 0.0, 0.0, 0.0), vec)
    }

    @Test
    fun testDVec4Divide() {
        assertEquals(DVec4(0.0, 0.0, 0.0, 0.0), 0.0 / DVec4(4.0, 6.0, 9.0, 12.0))
        assertEquals(DVec4(4.0, 2.0, 6.0, 9.0), DVec4(4.0, 2.0, 6.0, 9.0) / DVec4(1.0, 1.0, 1.0, 1.0))
        assertEquals(DVec4(2.0, 1.0, 3.0, 4.0), DVec4(4.0, 2.0, 6.0, 8.0) / DVec4(2.0, 2.0, 2.0, 2.0))

        val vec = DVec4(4.0, 6.0, 9.0, 12.0)
        vec /= 1.0
        assertEquals(DVec4(4.0, 6.0, 9.0, 12.0), vec)
        vec /= 2.0
        assertEquals(DVec4(2.0, 3.0, 4.5, 6.0), vec)
        vec /= DVec4(2.0, 1.0, 3.0, 6.0)
        assertEquals(DVec4(1.0, 3.0, 1.5, 1.0), vec)
    }

    @Test
    fun testDVec4Inc() {
        var vec = DVec4(4.0, 6.0, 8.0, 10.0)
        assertEquals(DVec4(5.0, 7.0, 9.0, 11.0), ++vec)
    }
    @Test
    fun testDVec4Dec() {
        var vec = DVec4(4.0, 6.0, 8.0, 10.0)
        assertEquals(DVec4(3.0, 5.0, 7.0, 9.0), --vec)
    }

    @Test
    fun testDVec4Negate() {
        val vec = DVec4(4.0, 6.0, 8.0, 10.0)
        assertEquals(DVec4(-4.0, -6.0, -8.0, -10.0), -vec)
        val vec2 = DVec4(-4.0, 6.0, 8.0, -10.0)
        assertEquals(DVec4(4.0, -6.0, -8.0, 10.0), -vec2)
        assertEquals(vec, -(-vec))
        assertEquals(vec2, -(-vec2))
    }

    @Test
    fun testDVec4Equals() {
        val vec = DVec4(4.0, 6.0, 8.0, 10.0)
        @Suppress("KotlinConstantConditions")
        assertEquals(true, vec == vec)
        assertEquals(true, DVec4(0.0, 0.0, 0.0, 0.0) == DVec4(0.0,0.0, 0.0, 0.0))
        assertEquals(true, DVec4(4.0, 6.0, 8.0, 10.0) == DVec4(4.0, 6.0, 8.0, 10.0))
        assertEquals(false, DVec4(5.0, 6.0, 2.0, 7.0) == DVec4(4.0, 6.0, 5.0, 7.0))
        assertEquals(false, DVec4(4.0, 7.0, 2.0, 7.0) == DVec4(4.0, 6.0, 2.0, 5.0))
    }

    @Test
    fun testDVec4Diff() {
        val vec = DVec4(4.0, 6.0, 8.0, 10.0)
        @Suppress("KotlinConstantConditions")
        assertEquals(false, vec != vec)
        assertEquals(false, DVec4(0.0, 0.0, 0.0, 0.0) != DVec4(0.0,0.0, 0.0, 0.0))
        assertEquals(false, DVec4(4.0, 6.0, 8.0, 10.0) != DVec4(4.0, 6.0, 8.0, 10.0))
        assertEquals(true, DVec4(5.0, 6.0, 2.0, 4.0) != DVec4(4.0, 6.0, 5.0, 5.0))
        assertEquals(true, DVec4(4.0, 7.0, 2.0, 4.0) != DVec4(4.0, 6.0, 2.0, 4.0))
    }

    @Test
    fun testDVec4LessThan() {
        val vec = DVec4(4.0, 6.0, 8.0, 10.0)
        assertEquals(BVec4(false, false, false, false), vec lt vec)
        assertEquals(BVec4(false, false, false, false), DVec4(0.0, 0.0, 0.0, 0.0) lt DVec4(0.0, 0.0, 0.0, 0.0))
        assertEquals(BVec4(true, false, false, false), DVec4(0.0, 0.0, 0.0, 0.0) lt DVec4(1.0,0.0, 0.0, 0.0))
        assertEquals(BVec4(false, true, false, true), DVec4(4.0, 0.0, 0.0, 1.0) lt DVec4(4.0, 6.0, 0.0, 5.0))
        assertEquals(BVec4(false, false, true, false), DVec4(5.0, 6.0, 1.0, 4.0) lt DVec4(4.0, 6.0, 5.0, 2.0))
        assertEquals(BVec4(true, true, true, true), DVec4(1.0, 3.0, 2.0, 2.0) lt DVec4(4.0, 6.0, 5.0, 4.0))
    }

    @Test
    fun testDVec4LessThanEquals() {
        val vec = DVec4(4.0, 6.0, 8.0, 10.0)
        assertEquals(BVec4(true, true, true, true), vec le vec)
        assertEquals(BVec4(true, true, true, true), DVec4(0.0, 0.0, 0.0, 0.0) le DVec4(0.0, 0.0, 0.0, 0.0))
        assertEquals(BVec4(true, true, true, true), DVec4(0.0, 0.0, 0.0, 0.0) le DVec4(1.0,0.0, 0.0, 0.0))
        assertEquals(BVec4(true, true, false, true), DVec4(4.0, 0.0, 5.0, 4.0) le DVec4(4.0, 6.0, 0.0, 7.0))
        assertEquals(BVec4(false, false, true, false), DVec4(5.0, 6.0, 5.0, 5.0) le DVec4(4.0, 5.0, 5.0, 2.0))
        assertEquals(BVec4(false, true, false, false), DVec4(5.0, 6.0, 2.0, 5.0) le DVec4(4.0, 6.0, 1.0, 2.0))
        assertEquals(BVec4(true, true, true, true), DVec4(1.0, 3.0, 2.0, 4.0) le DVec4(4.0, 6.0, 3.0, 4.0))
    }

    @Test
    fun testDVec4GreaterThan() {
        val vec = DVec4(4.0, 6.0, 8.0, 10.0)
        assertEquals(BVec4(false, false, false, false), vec gt vec)
        assertEquals(BVec4(false, false, false, false), DVec4(0.0, 0.0, 0.0, 0.0) gt DVec4(0.0, 0.0, 0.0, 0.0))
        assertEquals(BVec4(true, false, false, false),  DVec4(1.0,0.0, 0.0, 0.0) gt DVec4(0.0, 0.0, 0.0, 0.0))
        assertEquals(BVec4(false, true, false, true), DVec4(4.0, 6.0, 2.0, 5.0) gt DVec4(4.0, 0.0, 4.0, 2.0))
        assertEquals(BVec4(false, false, true, false), DVec4(4.0, 6.0, 5.0, 2.0) gt DVec4(5.0, 6.0, 2.0, 5.0))
        assertEquals(BVec4(true, true, true, true), DVec4(4.0, 6.0, 5.0, 4.0) gt DVec4(1.0, 3.0, 2.0, 2.0))
    }

    @Test
    fun testDVec4GreaterThanEquals() {
        val vec = DVec4(4.0, 6.0, 8.0, 10.0)
        assertEquals(BVec4(true, true, true, true), vec ge vec)
        assertEquals(BVec4(true, true, true, true), DVec4(0.0, 0.0, 0.0, 0.0) ge DVec4(0.0, 0.0, 0.0, 0.0))
        assertEquals(BVec4(true, true, true, true),  DVec4(1.0,0.0, 0.0, 0.0) ge DVec4(0.0, 0.0, 0.0, 0.0))
        assertEquals(BVec4(true, true, true, true), DVec4(4.0, 6.0, 5.0, 5.0) ge DVec4(4.0, 0.0, 2.0, 3.0))
        assertEquals(BVec4(false, false, false, false), DVec4(4.0, 5.0, 1.0, 2.0) ge DVec4(5.0, 6.0, 2.0, 5.0))
        assertEquals(BVec4(false, true, false, true), DVec4(4.0, 6.0, 2.0, 4.0) ge DVec4(5.0, 6.0, 3.0, 4.0))
        assertEquals(BVec4(true, true, true, true), DVec4(4.0, 6.0, 5.0, 7.0) ge DVec4(1.0, 3.0, 5.0, 7.0))
    }
}
