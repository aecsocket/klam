package io.github.aecsocket.klam

import kotlin.test.Test
import kotlin.test.assertEquals

class TestFVec {
    @Test
    fun testFVec2Map() {
        val vec = FVec2(1.0f, 2.0f)
        assertEquals(FVec2(6.0f, 7.0f), vec.map { i -> i + 5.0f })
        assertEquals(FVec2(-4.0f, -3.0f), vec.map { i -> i - 5.0f })
        assertEquals(FVec2(5.0f, 10.0f), vec.map { i -> i * 5.0f })
        assertEquals(FVec2(0.5f, 1.0f), vec.map { i -> i / 2.0f })
    }

    @Test
    fun testFVec2Set() {
        val vec = FVec2(1.0f, 2.0f)
        vec.x = 2.0f
        assertEquals(FVec2(2.0f, 2.0f), vec)
        vec.y = 1.0f
        assertEquals(FVec2(2.0f, 1.0f), vec)
    }

    @Test
    fun testFVec2Components() {
        val vec = FVec2(1.0f, 2.0f)
        assertEquals(1.0f, vec.x)
        assertEquals(2.0f, vec.y)
    }

    @Test
    fun testFVec2Plus() {
        val vec = FVec2(1.0f, 2.0f)
        assertEquals(FVec2(2.0f, 4.0f), vec + FVec2(1.0f, 2.0f))
        assertEquals(FVec2(3.0f, 4.0f), vec + 2.0f)
        assertEquals(FVec2(3.0f, 4.0f), 2.0f + vec)

        vec += FVec2(1.0f, 2.0f)
        assertEquals(FVec2(2.0f, 4.0f), vec)
        vec += 2.0f
        assertEquals(FVec2(4.0f, 6.0f), vec)
    }

    @Test
    fun testFVec2Minus() {
        val vec = FVec2(4.0f, 6.0f)
        assertEquals(FVec2(3.0f, 4.0f), vec - FVec2(1.0f, 2.0f))
        assertEquals(FVec2(2.0f, 4.0f), vec - 2.0f)
        assertEquals(FVec2(-2.0f, -4.0f), 2.0f - vec)

        vec -= FVec2(1.0f, 2.0f)
        assertEquals(FVec2(3.0f, 4.0f), vec)
        vec -= 2.0f
        assertEquals(FVec2(1.0f, 2.0f), vec)
    }

    @Test
    fun testFVec2Times() {
        assertEquals(FVec2(0.0f, 0.0f), 0.0f * FVec2(4.0f, 6.0f))
        assertEquals(FVec2(0.0f, 0.0f), FVec2(4.0f, 6.0f) * 0.0f)
        assertEquals(FVec2(0.0f, 2.0f), FVec2(0.0f, 1.0f) * FVec2(4.0f, 2.0f))
        assertEquals(FVec2(4.0f, 0.0f), FVec2(1.0f, 0.0f) * FVec2(4.0f, 2.0f))
        assertEquals(FVec2(4.0f, 2.0f), FVec2(1.0f, 1.0f) * FVec2(4.0f, 2.0f))

        val vec = FVec2(4.0f, 6.0f)
        vec *= 1.0f
        assertEquals(FVec2(4.0f, 6.0f), vec)
        vec *= 2.0f
        assertEquals(FVec2(8.0f, 12.0f), vec)
        vec *= 0.0f
        assertEquals(FVec2(0.0f, 0.0f), vec)
    }

    @Test
    fun testFVec2Divide() {
        assertEquals(FVec2(0.0f, 0.0f), 0.0f / FVec2(4.0f, 6.0f))
        assertEquals(FVec2(4.0f, 2.0f), FVec2(4.0f, 2.0f) / FVec2(1.0f, 1.0f))
        assertEquals(FVec2(2.0f, 1.0f), FVec2(4.0f, 2.0f) / FVec2(2.0f, 2.0f))

        val vec = FVec2(4.0f, 6.0f)
        vec /= 1.0f
        assertEquals(FVec2(4.0f, 6.0f), vec)
        vec /= 2.0f
        assertEquals(FVec2(2.0f, 3.0f), vec)
        vec /= FVec2(2.0f, 1.0f)
        assertEquals(FVec2(1.0f, 3.0f), vec)
    }

    @Test
    fun testFVec2Inc() {
        var vec = FVec2(4.0f, 6.0f)
        assertEquals(FVec2(5.0f, 7.0f), ++vec)
    }
    @Test
    fun testFVec2Dec() {
        var vec = FVec2(4.0f, 6.0f)
        assertEquals(FVec2(3.0f, 5.0f), --vec)
    }

    @Test
    fun testFVec2Negate() {
        val vec = FVec2(4.0f, 6.0f)
        assertEquals(FVec2(-4.0f, -6.0f), -vec)
        val vec2 = FVec2(-4.0f, 6.0f)
        assertEquals(FVec2(4.0f, -6.0f), -vec2)
        assertEquals(vec, -(-vec))
        assertEquals(vec2, -(-vec2))
    }

    @Test
    fun testFVec2Equals() {
        val vec = FVec2(4.0f, 6.0f)
        @Suppress("KotlinConstantConditions")
        assertEquals(true, vec == vec)
        assertEquals(true, FVec2(0.0f, 0.0f) == FVec2(0.0f,0.0f))
        assertEquals(true, FVec2(4.0f, 6.0f) == FVec2(4.0f, 6.0f))
        assertEquals(false, FVec2(5.0f, 6.0f) == FVec2(4.0f, 6.0f))
        assertEquals(false, FVec2(4.0f, 7.0f) == FVec2(4.0f, 6.0f))
    }

    @Test
    fun testFVec2Diff() {
        val vec = FVec2(4.0f, 6.0f)
        @Suppress("KotlinConstantConditions")
        assertEquals(false, vec != vec)
        assertEquals(false, FVec2(0.0f, 0.0f) != FVec2(0.0f,0.0f))
        assertEquals(false, FVec2(4.0f, 6.0f) != FVec2(4.0f, 6.0f))
        assertEquals(true, FVec2(5.0f, 6.0f) != FVec2(4.0f, 6.0f))
        assertEquals(true, FVec2(4.0f, 7.0f) != FVec2(4.0f, 6.0f))
    }

    @Test
    fun testFVec2LessThan() {
        val vec = FVec2(4.0f, 6.0f)
        assertEquals(BVec2(false, false), vec lt vec)
        assertEquals(BVec2(false, false), FVec2(0.0f, 0.0f) lt FVec2(0.0f, 0.0f))
        assertEquals(BVec2(true, false), FVec2(0.0f, 0.0f) lt FVec2(1.0f,0.0f))
        assertEquals(BVec2(false, true), FVec2(4.0f, 0.0f) lt FVec2(4.0f, 6.0f))
        assertEquals(BVec2(false, false), FVec2(5.0f, 6.0f) lt FVec2(4.0f, 6.0f))
        assertEquals(BVec2(true, true), FVec2(1.0f, 3.0f) lt FVec2(4.0f, 6.0f))
    }

    @Test
    fun testFVec2LessThanEquals() {
        val vec = FVec2(4.0f, 6.0f)
        assertEquals(BVec2(true, true), vec le vec)
        assertEquals(BVec2(true, true), FVec2(0.0f, 0.0f) le FVec2(0.0f, 0.0f))
        assertEquals(BVec2(true, true), FVec2(0.0f, 0.0f) le FVec2(1.0f,0.0f))
        assertEquals(BVec2(true, true), FVec2(4.0f, 0.0f) le FVec2(4.0f, 6.0f))
        assertEquals(BVec2(false, false), FVec2(5.0f, 6.0f) le FVec2(4.0f, 5.0f))
        assertEquals(BVec2(false, true), FVec2(5.0f, 6.0f) le FVec2(4.0f, 6.0f))
        assertEquals(BVec2(true, true), FVec2(1.0f, 3.0f) le FVec2(4.0f, 6.0f))
    }

    @Test
    fun testFVec2GreaterThan() {
        val vec = FVec2(4.0f, 6.0f)
        assertEquals(BVec2(false, false), vec gt vec)
        assertEquals(BVec2(false, false), FVec2(0.0f, 0.0f) gt FVec2(0.0f, 0.0f))
        assertEquals(BVec2(true, false),  FVec2(1.0f,0.0f) gt FVec2(0.0f, 0.0f))
        assertEquals(BVec2(false, true), FVec2(4.0f, 6.0f) gt FVec2(4.0f, 0.0f))
        assertEquals(BVec2(false, false), FVec2(4.0f, 6.0f) gt FVec2(5.0f, 6.0f))
        assertEquals(BVec2(true, true), FVec2(4.0f, 6.0f) gt FVec2(1.0f, 3.0f))
    }

    @Test
    fun testFVec2GreaterThanEquals() {
        val vec = FVec2(4.0f, 6.0f)
        assertEquals(BVec2(true, true), vec ge vec)
        assertEquals(BVec2(true, true), FVec2(0.0f, 0.0f) ge FVec2(0.0f, 0.0f))
        assertEquals(BVec2(true, true),  FVec2(1.0f,0.0f) ge FVec2(0.0f, 0.0f))
        assertEquals(BVec2(true, true), FVec2(4.0f, 6.0f) ge FVec2(4.0f, 0.0f))
        assertEquals(BVec2(false, false), FVec2(4.0f, 5.0f) ge FVec2(5.0f, 6.0f))
        assertEquals(BVec2(false, true), FVec2(4.0f, 6.0f) ge FVec2(5.0f, 6.0f))
        assertEquals(BVec2(true, true), FVec2(4.0f, 6.0f) ge FVec2(1.0f, 3.0f))
    }

    // FVec3

    @Test
    fun testFVec3Map() {
        val vec = FVec3(1.0f, 2.0f, 3.0f)
        assertEquals(FVec3(6.0f, 7.0f, 8.0f), vec.map { i -> i + 5.0f })
        assertEquals(FVec3(-4.0f, -3.0f, -2.0f), vec.map { i -> i - 5.0f })
        assertEquals(FVec3(5.0f, 10.0f, 15.0f), vec.map { i -> i * 5.0f })
        assertEquals(FVec3(0.5f, 1.0f, 1.5f), vec.map { i -> i / 2.0f })
    }

    @Test
    fun testFVec3Set() {
        val vec = FVec3(1.0f, 2.0f, 3.0f)
        vec.x = 2.0f
        assertEquals(FVec3(2.0f, 2.0f, 3.0f), vec)
        vec.y = 1.0f
        assertEquals(FVec3(2.0f, 1.0f, 3.0f), vec)
        vec.z = 2.0f
        assertEquals(FVec3(2.0f, 1.0f, 2.0f), vec)
    }

    @Test
    fun testFVec3Components() {
        val vec = FVec3(1.0f, 2.0f, 3.0f)
        assertEquals(1.0f, vec.x)
        assertEquals(2.0f, vec.y)
        assertEquals(3.0f, vec.z)
    }

    @Test
    fun testFVec3Plus() {
        val vec = FVec3(1.0f, 2.0f, 3.0f)
        assertEquals(FVec3(2.0f, 4.0f, 6.0f), vec + FVec3(1.0f, 2.0f, 3.0f))
        assertEquals(FVec3(3.0f, 4.0f, 5.0f), vec + 2.0f)
        assertEquals(FVec3(3.0f, 4.0f, 5.0f), 2.0f + vec)

        vec += FVec3(1.0f, 2.0f, 3.0f)
        assertEquals(FVec3(2.0f, 4.0f, 6.0f), vec)
        vec += 2.0f
        assertEquals(FVec3(4.0f, 6.0f, 8.0f), vec)
    }

    @Test
    fun testFVec3Minus() {
        val vec = FVec3(4.0f, 6.0f, 9.0f)
        assertEquals(FVec3(3.0f, 4.0f, 6.0f), vec - FVec3(1.0f, 2.0f, 3.0f))
        assertEquals(FVec3(2.0f, 4.0f, 7.0f), vec - 2.0f)
        assertEquals(FVec3(-2.0f, -4.0f, -7.0f), 2.0f - vec)

        vec -= FVec3(1.0f, 2.0f, 3.0f)
        assertEquals(FVec3(3.0f, 4.0f, 6.0f), vec)
        vec -= 2.0f
        assertEquals(FVec3(1.0f, 2.0f, 4.0f), vec)
    }

    @Test
    fun testFVec3Times() {
        assertEquals(FVec3(0.0f, 0.0f, 0.0f), 0.0f * FVec3(4.0f, 6.0f, 9.0f))
        assertEquals(FVec3(0.0f, 0.0f, 0.0f), FVec3(4.0f, 6.0f, 9.0f) * 0.0f)
        assertEquals(FVec3(0.0f, 2.0f, 4.0f), FVec3(0.0f, 1.0f, 2.0f) * FVec3(4.0f, 2.0f, 2.0f))
        assertEquals(FVec3(4.0f, 0.0f, 6.0f), FVec3(1.0f, 0.0f, 2.0f) * FVec3(4.0f, 2.0f, 3.0f))
        assertEquals(FVec3(4.0f, 2.0f, 5.0f), FVec3(1.0f, 1.0f, 1.0f) * FVec3(4.0f, 2.0f, 5.0f))

        val vec = FVec3(4.0f, 6.0f, 9.0f)
        vec *= 1.0f
        assertEquals(FVec3(4.0f, 6.0f, 9.0f), vec)
        vec *= 2.0f
        assertEquals(FVec3(8.0f, 12.0f, 18.0f), vec)
        vec *= 0.0f
        assertEquals(FVec3(0.0f, 0.0f, 0.0f), vec)
    }

    @Test
    fun testFVec3Divide() {
        assertEquals(FVec3(0.0f, 0.0f, 0.0f), 0.0f / FVec3(4.0f, 6.0f, 9.0f))
        assertEquals(FVec3(4.0f, 2.0f, 6.0f), FVec3(4.0f, 2.0f, 6.0f) / FVec3(1.0f, 1.0f, 1.0f))
        assertEquals(FVec3(2.0f, 1.0f, 3.0f), FVec3(4.0f, 2.0f, 6.0f) / FVec3(2.0f, 2.0f, 2.0f))

        val vec = FVec3(4.0f, 6.0f, 9.0f)
        vec /= 1.0f
        assertEquals(FVec3(4.0f, 6.0f, 9.0f), vec)
        vec /= 2.0f
        assertEquals(FVec3(2.0f, 3.0f, 4.5f), vec)
        vec /= FVec3(2.0f, 1.0f, 3.0f)
        assertEquals(FVec3(1.0f, 3.0f, 1.5f), vec)
    }

    @Test
    fun testFVec3Inc() {
        var vec = FVec3(4.0f, 6.0f, 8.0f)
        assertEquals(FVec3(5.0f, 7.0f, 9.0f), ++vec)
    }
    @Test
    fun testFVec3Dec() {
        var vec = FVec3(4.0f, 6.0f, 8.0f)
        assertEquals(FVec3(3.0f, 5.0f, 7.0f), --vec)
    }

    @Test
    fun testFVec3Negate() {
        val vec = FVec3(4.0f, 6.0f, 8.0f)
        assertEquals(FVec3(-4.0f, -6.0f, -8.0f), -vec)
        val vec2 = FVec3(-4.0f, 6.0f, 8.0f)
        assertEquals(FVec3(4.0f, -6.0f, -8.0f), -vec2)
        assertEquals(vec, -(-vec))
        assertEquals(vec2, -(-vec2))
    }

    @Test
    fun testFVec3Equals() {
        val vec = FVec3(4.0f, 6.0f, 8.0f)
        @Suppress("KotlinConstantConditions")
        assertEquals(true, vec == vec)
        assertEquals(true, FVec3(0.0f, 0.0f, 0.0f) == FVec3(0.0f,0.0f, 0.0f))
        assertEquals(true, FVec3(4.0f, 6.0f, 8.0f) == FVec3(4.0f, 6.0f, 8.0f))
        assertEquals(false, FVec3(5.0f, 6.0f, 2.0f) == FVec3(4.0f, 6.0f, 5.0f))
        assertEquals(false, FVec3(4.0f, 7.0f, 2.0f) == FVec3(4.0f, 6.0f, 2.0f))
    }

    @Test
    fun testFVec3Diff() {
        val vec = FVec3(4.0f, 6.0f, 8.0f)
        @Suppress("KotlinConstantConditions")
        assertEquals(false, vec != vec)
        assertEquals(false, FVec3(0.0f, 0.0f, 0.0f) != FVec3(0.0f,0.0f, 0.0f))
        assertEquals(false, FVec3(4.0f, 6.0f, 8.0f) != FVec3(4.0f, 6.0f, 8.0f))
        assertEquals(true, FVec3(5.0f, 6.0f, 2.0f) != FVec3(4.0f, 6.0f, 5.0f))
        assertEquals(true, FVec3(4.0f, 7.0f, 2.0f) != FVec3(4.0f, 6.0f, 2.0f))
    }

    @Test
    fun testFVec3LessThan() {
        val vec = FVec3(4.0f, 6.0f, 8.0f)
        assertEquals(BVec3(false, false, false), vec lt vec)
        assertEquals(BVec3(false, false, false), FVec3(0.0f, 0.0f, 0.0f) lt FVec3(0.0f, 0.0f, 0.0f))
        assertEquals(BVec3(true, false, false), FVec3(0.0f, 0.0f, 0.0f) lt FVec3(1.0f,0.0f, 0.0f))
        assertEquals(BVec3(false, true, false), FVec3(4.0f, 0.0f, 0.0f) lt FVec3(4.0f, 6.0f, 0.0f))
        assertEquals(BVec3(false, false, true), FVec3(5.0f, 6.0f, 1.0f) lt FVec3(4.0f, 6.0f, 5.0f))
        assertEquals(BVec3(true, true, true), FVec3(1.0f, 3.0f, 2.0f) lt FVec3(4.0f, 6.0f, 5.0f))
    }

    @Test
    fun testFVec3LessThanEquals() {
        val vec = FVec3(4.0f, 6.0f, 8.0f)
        assertEquals(BVec3(true, true, true), vec le vec)
        assertEquals(BVec3(true, true, true), FVec3(0.0f, 0.0f, 0.0f) le FVec3(0.0f, 0.0f, 0.0f))
        assertEquals(BVec3(true, true, true), FVec3(0.0f, 0.0f, 0.0f) le FVec3(1.0f,0.0f, 0.0f))
        assertEquals(BVec3(true, true, false), FVec3(4.0f, 0.0f, 5.0f) le FVec3(4.0f, 6.0f, 0.0f))
        assertEquals(BVec3(false, false, true), FVec3(5.0f, 6.0f, 5.0f) le FVec3(4.0f, 5.0f, 5.0f))
        assertEquals(BVec3(false, true, false), FVec3(5.0f, 6.0f, 2.0f) le FVec3(4.0f, 6.0f, 1.0f))
        assertEquals(BVec3(true, true, true), FVec3(1.0f, 3.0f, 2.0f) le FVec3(4.0f, 6.0f, 3.0f))
    }

    @Test
    fun testFVec3GreaterThan() {
        val vec = FVec3(4.0f, 6.0f, 8.0f)
        assertEquals(BVec3(false, false, false), vec gt vec)
        assertEquals(BVec3(false, false, false), FVec3(0.0f, 0.0f, 0.0f) gt FVec3(0.0f, 0.0f, 0.0f))
        assertEquals(BVec3(true, false, false),  FVec3(1.0f,0.0f, 0.0f) gt FVec3(0.0f, 0.0f, 0.0f))
        assertEquals(BVec3(false, true, false), FVec3(4.0f, 6.0f, 2.0f) gt FVec3(4.0f, 0.0f, 4.0f))
        assertEquals(BVec3(false, false, true), FVec3(4.0f, 6.0f, 5.0f) gt FVec3(5.0f, 6.0f, 2.0f))
        assertEquals(BVec3(true, true, true), FVec3(4.0f, 6.0f, 5.0f) gt FVec3(1.0f, 3.0f, 2.0f))
    }

    @Test
    fun testFVec3GreaterThanEquals() {
        val vec = FVec3(4.0f, 6.0f, 8.0f)
        assertEquals(BVec3(true, true, true), vec ge vec)
        assertEquals(BVec3(true, true, true), FVec3(0.0f, 0.0f, 0.0f) ge FVec3(0.0f, 0.0f, 0.0f))
        assertEquals(BVec3(true, true, true),  FVec3(1.0f,0.0f, 0.0f) ge FVec3(0.0f, 0.0f, 0.0f))
        assertEquals(BVec3(true, true, true), FVec3(4.0f, 6.0f, 5.0f) ge FVec3(4.0f, 0.0f, 2.0f))
        assertEquals(BVec3(false, false, false), FVec3(4.0f, 5.0f, 1.0f) ge FVec3(5.0f, 6.0f, 2.0f))
        assertEquals(BVec3(false, true, false), FVec3(4.0f, 6.0f, 2.0f) ge FVec3(5.0f, 6.0f, 3.0f))
        assertEquals(BVec3(true, true, true), FVec3(4.0f, 6.0f, 5.0f) ge FVec3(1.0f, 3.0f, 5.0f))
    }

    // FVec4

    @Test
    fun testFVec4Map() {
        val vec = FVec4(1.0f, 2.0f, 3.0f, 4.0f)
        assertEquals(FVec4(6.0f, 7.0f, 8.0f, 9.0f), vec.map { i -> i + 5.0f })
        assertEquals(FVec4(-4.0f, -3.0f, -2.0f, -1.0f), vec.map { i -> i - 5.0f })
        assertEquals(FVec4(5.0f, 10.0f, 15.0f, 20.0f), vec.map { i -> i * 5.0f })
        assertEquals(FVec4(0.5f, 1.0f, 1.5f, 2.0f), vec.map { i -> i / 2.0f })
    }

    @Test
    fun testFVec4Set() {
        val vec = FVec4(1.0f, 2.0f, 3.0f, 4.0f)
        vec.x = 2.0f
        assertEquals(FVec4(2.0f, 2.0f, 3.0f, 4.0f), vec)
        vec.y = 1.0f
        assertEquals(FVec4(2.0f, 1.0f, 3.0f, 4.0f), vec)
        vec.z = 2.0f
        assertEquals(FVec4(2.0f, 1.0f, 2.0f, 4.0f), vec)
        vec.w = 5.0f
        assertEquals(FVec4(2.0f, 1.0f, 2.0f, 5.0f), vec)
    }

    @Test
    fun testFVec4Components() {
        val vec = FVec4(1.0f, 2.0f, 3.0f, 4.0f)
        assertEquals(1.0f, vec.x)
        assertEquals(2.0f, vec.y)
        assertEquals(3.0f, vec.z)
        assertEquals(4.0f, vec.w)
    }

    @Test
    fun testFVec4Plus() {
        val vec = FVec4(1.0f, 2.0f, 3.0f, 4.0f)
        assertEquals(FVec4(2.0f, 4.0f, 6.0f, 8.0f), vec + FVec4(1.0f, 2.0f, 3.0f, 4.0f))
        assertEquals(FVec4(3.0f, 4.0f, 5.0f, 6.0f), vec + 2.0f)
        assertEquals(FVec4(3.0f, 4.0f, 5.0f, 6.0f), 2.0f + vec)

        vec += FVec4(1.0f, 2.0f, 3.0f, 4.0f)
        assertEquals(FVec4(2.0f, 4.0f, 6.0f, 8.0f), vec)
        vec += 2.0f
        assertEquals(FVec4(4.0f, 6.0f, 8.0f, 10.0f), vec)
    }

    @Test
    fun testFVec4Minus() {
        val vec = FVec4(4.0f, 6.0f, 9.0f, 12.0f)
        assertEquals(FVec4(3.0f, 4.0f, 6.0f, 8.0f), vec - FVec4(1.0f, 2.0f, 3.0f, 4.0f))
        assertEquals(FVec4(2.0f, 4.0f, 7.0f, 10.0f), vec - 2.0f)
        assertEquals(FVec4(-2.0f, -4.0f, -7.0f, -10.0f), 2.0f - vec)

        vec -= FVec4(1.0f, 2.0f, 3.0f, 4.0f)
        assertEquals(FVec4(3.0f, 4.0f, 6.0f, 8.0f), vec)
        vec -= 2.0f
        assertEquals(FVec4(1.0f, 2.0f, 4.0f, 6.0f), vec)
    }

    @Test
    fun testFVec4Times() {
        assertEquals(FVec4(0.0f, 0.0f, 0.0f, 0.0f), 0.0f * FVec4(4.0f, 6.0f, 9.0f, 12.0f))
        assertEquals(FVec4(0.0f, 0.0f, 0.0f, 0.0f), FVec4(4.0f, 6.0f, 9.0f, 12.0f) * 0.0f)
        assertEquals(FVec4(0.0f, 2.0f, 4.0f, 6.0f), FVec4(0.0f, 1.0f, 2.0f, 3.0f) * FVec4(4.0f, 2.0f, 2.0f, 2.0f))
        assertEquals(FVec4(4.0f, 0.0f, 6.0f, 2.0f), FVec4(1.0f, 0.0f, 2.0f, 1.0f) * FVec4(4.0f, 2.0f, 3.0f, 2.0f))
        assertEquals(FVec4(4.0f, 2.0f, 5.0f, 6.0f), FVec4(1.0f, 1.0f, 1.0f, 1.0f) * FVec4(4.0f, 2.0f, 5.0f, 6.0f))

        val vec = FVec4(4.0f, 6.0f, 9.0f, 12.0f)
        vec *= 1.0f
        assertEquals(FVec4(4.0f, 6.0f, 9.0f, 12.0f), vec)
        vec *= 2.0f
        assertEquals(FVec4(8.0f, 12.0f, 18.0f, 24.0f), vec)
        vec *= 0.0f
        assertEquals(FVec4(0.0f, 0.0f, 0.0f, 0.0f), vec)
    }

    @Test
    fun testFVec4Divide() {
        assertEquals(FVec4(0.0f, 0.0f, 0.0f, 0.0f), 0.0f / FVec4(4.0f, 6.0f, 9.0f, 12.0f))
        assertEquals(FVec4(4.0f, 2.0f, 6.0f, 9.0f), FVec4(4.0f, 2.0f, 6.0f, 9.0f) / FVec4(1.0f, 1.0f, 1.0f, 1.0f))
        assertEquals(FVec4(2.0f, 1.0f, 3.0f, 4.0f), FVec4(4.0f, 2.0f, 6.0f, 8.0f) / FVec4(2.0f, 2.0f, 2.0f, 2.0f))

        val vec = FVec4(4.0f, 6.0f, 9.0f, 12.0f)
        vec /= 1.0f
        assertEquals(FVec4(4.0f, 6.0f, 9.0f, 12.0f), vec)
        vec /= 2.0f
        assertEquals(FVec4(2.0f, 3.0f, 4.5f, 6.0f), vec)
        vec /= FVec4(2.0f, 1.0f, 3.0f, 6.0f)
        assertEquals(FVec4(1.0f, 3.0f, 1.5f, 1.0f), vec)
    }

    @Test
    fun testFVec4Inc() {
        var vec = FVec4(4.0f, 6.0f, 8.0f, 10.0f)
        assertEquals(FVec4(5.0f, 7.0f, 9.0f, 11.0f), ++vec)
    }
    @Test
    fun testFVec4Dec() {
        var vec = FVec4(4.0f, 6.0f, 8.0f, 10.0f)
        assertEquals(FVec4(3.0f, 5.0f, 7.0f, 9.0f), --vec)
    }

    @Test
    fun testFVec4Negate() {
        val vec = FVec4(4.0f, 6.0f, 8.0f, 10.0f)
        assertEquals(FVec4(-4.0f, -6.0f, -8.0f, -10.0f), -vec)
        val vec2 = FVec4(-4.0f, 6.0f, 8.0f, -10.0f)
        assertEquals(FVec4(4.0f, -6.0f, -8.0f, 10.0f), -vec2)
        assertEquals(vec, -(-vec))
        assertEquals(vec2, -(-vec2))
    }

    @Test
    fun testFVec4Equals() {
        val vec = FVec4(4.0f, 6.0f, 8.0f, 10.0f)
        @Suppress("KotlinConstantConditions")
        assertEquals(true, vec == vec)
        assertEquals(true, FVec4(0.0f, 0.0f, 0.0f, 0.0f) == FVec4(0.0f,0.0f, 0.0f, 0.0f))
        assertEquals(true, FVec4(4.0f, 6.0f, 8.0f, 10.0f) == FVec4(4.0f, 6.0f, 8.0f, 10.0f))
        assertEquals(false, FVec4(5.0f, 6.0f, 2.0f, 7.0f) == FVec4(4.0f, 6.0f, 5.0f, 7.0f))
        assertEquals(false, FVec4(4.0f, 7.0f, 2.0f, 7.0f) == FVec4(4.0f, 6.0f, 2.0f, 5.0f))
    }

    @Test
    fun testFVec4Diff() {
        val vec = FVec4(4.0f, 6.0f, 8.0f, 10.0f)
        @Suppress("KotlinConstantConditions")
        assertEquals(false, vec != vec)
        assertEquals(false, FVec4(0.0f, 0.0f, 0.0f, 0.0f) != FVec4(0.0f,0.0f, 0.0f, 0.0f))
        assertEquals(false, FVec4(4.0f, 6.0f, 8.0f, 10.0f) != FVec4(4.0f, 6.0f, 8.0f, 10.0f))
        assertEquals(true, FVec4(5.0f, 6.0f, 2.0f, 4.0f) != FVec4(4.0f, 6.0f, 5.0f, 5.0f))
        assertEquals(true, FVec4(4.0f, 7.0f, 2.0f, 4.0f) != FVec4(4.0f, 6.0f, 2.0f, 4.0f))
    }

    @Test
    fun testFVec4LessThan() {
        val vec = FVec4(4.0f, 6.0f, 8.0f, 10.0f)
        assertEquals(BVec4(false, false, false, false), vec lt vec)
        assertEquals(BVec4(false, false, false, false), FVec4(0.0f, 0.0f, 0.0f, 0.0f) lt FVec4(0.0f, 0.0f, 0.0f, 0.0f))
        assertEquals(BVec4(true, false, false, false), FVec4(0.0f, 0.0f, 0.0f, 0.0f) lt FVec4(1.0f,0.0f, 0.0f, 0.0f))
        assertEquals(BVec4(false, true, false, true), FVec4(4.0f, 0.0f, 0.0f, 1.0f) lt FVec4(4.0f, 6.0f, 0.0f, 5.0f))
        assertEquals(BVec4(false, false, true, false), FVec4(5.0f, 6.0f, 1.0f, 4.0f) lt FVec4(4.0f, 6.0f, 5.0f, 2.0f))
        assertEquals(BVec4(true, true, true, true), FVec4(1.0f, 3.0f, 2.0f, 2.0f) lt FVec4(4.0f, 6.0f, 5.0f, 4.0f))
    }

    @Test
    fun testFVec4LessThanEquals() {
        val vec = FVec4(4.0f, 6.0f, 8.0f, 10.0f)
        assertEquals(BVec4(true, true, true, true), vec le vec)
        assertEquals(BVec4(true, true, true, true), FVec4(0.0f, 0.0f, 0.0f, 0.0f) le FVec4(0.0f, 0.0f, 0.0f, 0.0f))
        assertEquals(BVec4(true, true, true, true), FVec4(0.0f, 0.0f, 0.0f, 0.0f) le FVec4(1.0f,0.0f, 0.0f, 0.0f))
        assertEquals(BVec4(true, true, false, true), FVec4(4.0f, 0.0f, 5.0f, 4.0f) le FVec4(4.0f, 6.0f, 0.0f, 7.0f))
        assertEquals(BVec4(false, false, true, false), FVec4(5.0f, 6.0f, 5.0f, 5.0f) le FVec4(4.0f, 5.0f, 5.0f, 2.0f))
        assertEquals(BVec4(false, true, false, false), FVec4(5.0f, 6.0f, 2.0f, 5.0f) le FVec4(4.0f, 6.0f, 1.0f, 2.0f))
        assertEquals(BVec4(true, true, true, true), FVec4(1.0f, 3.0f, 2.0f, 4.0f) le FVec4(4.0f, 6.0f, 3.0f, 4.0f))
    }

    @Test
    fun testFVec4GreaterThan() {
        val vec = FVec4(4.0f, 6.0f, 8.0f, 10.0f)
        assertEquals(BVec4(false, false, false, false), vec gt vec)
        assertEquals(BVec4(false, false, false, false), FVec4(0.0f, 0.0f, 0.0f, 0.0f) gt FVec4(0.0f, 0.0f, 0.0f, 0.0f))
        assertEquals(BVec4(true, false, false, false),  FVec4(1.0f,0.0f, 0.0f, 0.0f) gt FVec4(0.0f, 0.0f, 0.0f, 0.0f))
        assertEquals(BVec4(false, true, false, true), FVec4(4.0f, 6.0f, 2.0f, 5.0f) gt FVec4(4.0f, 0.0f, 4.0f, 2.0f))
        assertEquals(BVec4(false, false, true, false), FVec4(4.0f, 6.0f, 5.0f, 2.0f) gt FVec4(5.0f, 6.0f, 2.0f, 5.0f))
        assertEquals(BVec4(true, true, true, true), FVec4(4.0f, 6.0f, 5.0f, 4.0f) gt FVec4(1.0f, 3.0f, 2.0f, 2.0f))
    }

    @Test
    fun testFVec4GreaterThanEquals() {
        val vec = FVec4(4.0f, 6.0f, 8.0f, 10.0f)
        assertEquals(BVec4(true, true, true, true), vec ge vec)
        assertEquals(BVec4(true, true, true, true), FVec4(0.0f, 0.0f, 0.0f, 0.0f) ge FVec4(0.0f, 0.0f, 0.0f, 0.0f))
        assertEquals(BVec4(true, true, true, true),  FVec4(1.0f,0.0f, 0.0f, 0.0f) ge FVec4(0.0f, 0.0f, 0.0f, 0.0f))
        assertEquals(BVec4(true, true, true, true), FVec4(4.0f, 6.0f, 5.0f, 5.0f) ge FVec4(4.0f, 0.0f, 2.0f, 3.0f))
        assertEquals(BVec4(false, false, false, false), FVec4(4.0f, 5.0f, 1.0f, 2.0f) ge FVec4(5.0f, 6.0f, 2.0f, 5.0f))
        assertEquals(BVec4(false, true, false, true), FVec4(4.0f, 6.0f, 2.0f, 4.0f) ge FVec4(5.0f, 6.0f, 3.0f, 4.0f))
        assertEquals(BVec4(true, true, true, true), FVec4(4.0f, 6.0f, 5.0f, 7.0f) ge FVec4(1.0f, 3.0f, 5.0f, 7.0f))
    }
}
