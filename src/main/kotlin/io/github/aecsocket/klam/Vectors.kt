@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

import kotlin.math.abs
import kotlin.math.min
import kotlin.math.max
import kotlin.math.sqrt

// operators
inline operator fun BVec2.not() = BVec2(!x, !y)
inline operator fun BVec3.not() = BVec3(!x, !y, !z)
inline operator fun BVec4.not() = BVec4(!x, !y, !z, !w)

inline operator fun IVec2.plusAssign(v: IVec2)  { x += v.x; y += v.y }
inline operator fun IVec2.minusAssign(v: IVec2) { x -= v.x; y -= v.y }
inline operator fun IVec2.timesAssign(v: IVec2) { x *= v.x; y *= v.y }
inline operator fun IVec2.divAssign(v: IVec2)   { x /= v.x; y /= v.y }

inline operator fun IVec2.plus(v: IVec2)  = IVec2(x + v.x, y + v.y)
inline operator fun IVec2.minus(v: IVec2) = IVec2(x - v.x, y - v.y)
inline operator fun IVec2.times(v: IVec2) = IVec2(x * v.x, y * v.y)
inline operator fun IVec2.div(v: IVec2)   = IVec2(x / v.x, y / v.y)

inline operator fun IVec3.plusAssign(v: IVec3)  { x += v.x; y += v.y; z += v.z }
inline operator fun IVec3.minusAssign(v: IVec3) { x -= v.x; y -= v.y; z += v.z }
inline operator fun IVec3.timesAssign(v: IVec3) { x *= v.x; y *= v.y; z *= v.z }
inline operator fun IVec3.divAssign(v: IVec3)   { x /= v.x; y /= v.y; z /= v.z }

inline operator fun IVec3.plus(v: IVec3)  = IVec3(x + v.x, y + v.y, z + v.z)
inline operator fun IVec3.minus(v: IVec3) = IVec3(x - v.x, y - v.y, z - v.z)
inline operator fun IVec3.times(v: IVec3) = IVec3(x * v.x, y * v.y, z * v.z)
inline operator fun IVec3.div(v: IVec3)   = IVec3(x / v.x, y / v.y, z / v.z)

// comparators
inline infix fun IVec2.eq(v: IVec2) = BVec2(x.compareTo(v.x) == 0, y.compareTo(v.y) == 0)
inline infix fun IVec3.eq(v: IVec3) = BVec3(x.compareTo(v.x) == 0, y.compareTo(v.y) == 0, z.compareTo(v.z) == 0)
inline infix fun IVec4.eq(v: IVec4) = BVec4(x.compareTo(v.x) == 0, y.compareTo(v.y) == 0, z.compareTo(v.z) == 0, w.compareTo(v.w) == 0)
inline infix fun FVec2.eq(v: FVec2) = BVec2(x.compareTo(v.x) == 0, y.compareTo(v.y) == 0)
inline infix fun FVec3.eq(v: FVec3) = BVec3(x.compareTo(v.x) == 0, y.compareTo(v.y) == 0, z.compareTo(v.z) == 0)
inline infix fun FVec4.eq(v: FVec4) = BVec4(x.compareTo(v.x) == 0, y.compareTo(v.y) == 0, z.compareTo(v.z) == 0, w.compareTo(v.w) == 0)
inline infix fun DVec2.eq(v: DVec2) = BVec2(x.compareTo(v.x) == 0, y.compareTo(v.y) == 0)
inline infix fun DVec3.eq(v: DVec3) = BVec3(x.compareTo(v.x) == 0, y.compareTo(v.y) == 0, z.compareTo(v.z) == 0)
inline infix fun DVec4.eq(v: DVec4) = BVec4(x.compareTo(v.x) == 0, y.compareTo(v.y) == 0, z.compareTo(v.z) == 0, w.compareTo(v.w) == 0)

inline infix fun IVec2.ne(v: IVec2) = BVec2(x.compareTo(v.x) != 0, y.compareTo(v.y) != 0)
inline infix fun IVec3.ne(v: IVec3) = BVec3(x.compareTo(v.x) != 0, y.compareTo(v.y) != 0, z.compareTo(v.z) != 0)
inline infix fun IVec4.ne(v: IVec4) = BVec4(x.compareTo(v.x) != 0, y.compareTo(v.y) != 0, z.compareTo(v.z) != 0, w.compareTo(v.w) != 0)
inline infix fun FVec2.ne(v: FVec2) = BVec2(x.compareTo(v.x) != 0, y.compareTo(v.y) != 0)
inline infix fun FVec3.ne(v: FVec3) = BVec3(x.compareTo(v.x) != 0, y.compareTo(v.y) != 0, z.compareTo(v.z) != 0)
inline infix fun FVec4.ne(v: FVec4) = BVec4(x.compareTo(v.x) != 0, y.compareTo(v.y) != 0, z.compareTo(v.z) != 0, w.compareTo(v.w) != 0)
inline infix fun DVec2.ne(v: DVec2) = BVec2(x.compareTo(v.x) != 0, y.compareTo(v.y) != 0)
inline infix fun DVec3.ne(v: DVec3) = BVec3(x.compareTo(v.x) != 0, y.compareTo(v.y) != 0, z.compareTo(v.z) != 0)
inline infix fun DVec4.ne(v: DVec4) = BVec4(x.compareTo(v.x) != 0, y.compareTo(v.y) != 0, z.compareTo(v.z) != 0, w.compareTo(v.w) != 0)

inline infix fun IVec2.lt(v: IVec2) = BVec2(x < v.x, y < v.y)
inline infix fun IVec3.lt(v: IVec3) = BVec3(x < v.x, y < v.y, z < v.z)
inline infix fun IVec4.lt(v: IVec4) = BVec4(x < v.x, y < v.y, z < v.z, w < v.w)
inline infix fun FVec2.lt(v: FVec2) = BVec2(x < v.x, y < v.y)
inline infix fun FVec3.lt(v: FVec3) = BVec3(x < v.x, y < v.y, z < v.z)
inline infix fun FVec4.lt(v: FVec4) = BVec4(x < v.x, y < v.y, z < v.z, w < v.w)
inline infix fun DVec2.lt(v: DVec2) = BVec2(x < v.x, y < v.y)
inline infix fun DVec3.lt(v: DVec3) = BVec3(x < v.x, y < v.y, z < v.z)
inline infix fun DVec4.lt(v: DVec4) = BVec4(x < v.x, y < v.y, z < v.z, w < v.w)

inline infix fun IVec2.lt(s: Int)    = BVec2(x < s, y < s)
inline infix fun IVec3.lt(s: Int)    = BVec3(x < s, y < s, z < s)
inline infix fun IVec4.lt(s: Int)    = BVec4(x < s, y < s, z < s, w < s)
inline infix fun FVec2.lt(s: Float)  = BVec2(x < s, y < s)
inline infix fun FVec3.lt(s: Float)  = BVec3(x < s, y < s, z < s)
inline infix fun FVec4.lt(s: Float)  = BVec4(x < s, y < s, z < s, w < s)
inline infix fun DVec2.lt(s: Double) = BVec2(x < s, y < s)
inline infix fun DVec3.lt(s: Double) = BVec3(x < s, y < s, z < s)
inline infix fun DVec4.lt(s: Double) = BVec4(x < s, y < s, z < s, w < s)

inline infix fun IVec2.le(v: IVec2) = BVec2(x <= v.x, y <= v.y)
inline infix fun IVec3.le(v: IVec3) = BVec3(x <= v.x, y <= v.y, z <= v.z)
inline infix fun IVec4.le(v: IVec4) = BVec4(x <= v.x, y <= v.y, z <= v.z, w <= v.w)
inline infix fun FVec2.le(v: FVec2) = BVec2(x <= v.x, y <= v.y)
inline infix fun FVec3.le(v: FVec3) = BVec3(x <= v.x, y <= v.y, z <= v.z)
inline infix fun FVec4.le(v: FVec4) = BVec4(x <= v.x, y <= v.y, z <= v.z, w <= v.w)
inline infix fun DVec2.le(v: DVec2) = BVec2(x <= v.x, y <= v.y)
inline infix fun DVec3.le(v: DVec3) = BVec3(x <= v.x, y <= v.y, z <= v.z)
inline infix fun DVec4.le(v: DVec4) = BVec4(x <= v.x, y <= v.y, z <= v.z, w <= v.w)

inline infix fun IVec2.le(s: Int)    = BVec2(x <= s, y <= s)
inline infix fun IVec3.le(s: Int)    = BVec3(x <= s, y <= s, z <= s)
inline infix fun IVec4.le(s: Int)    = BVec4(x <= s, y <= s, z <= s, w <= s)
inline infix fun FVec2.le(s: Float)  = BVec2(x <= s, y <= s)
inline infix fun FVec3.le(s: Float)  = BVec3(x <= s, y <= s, z <= s)
inline infix fun FVec4.le(s: Float)  = BVec4(x <= s, y <= s, z <= s, w <= s)
inline infix fun DVec2.le(s: Double) = BVec2(x <= s, y <= s)
inline infix fun DVec3.le(s: Double) = BVec3(x <= s, y <= s, z <= s)
inline infix fun DVec4.le(s: Double) = BVec4(x <= s, y <= s, z <= s, w <= s)

inline infix fun IVec2.gt(v: IVec2) = BVec2(x > v.x, y > v.y)
inline infix fun IVec3.gt(v: IVec3) = BVec3(x > v.x, y > v.y, z > v.z)
inline infix fun IVec4.gt(v: IVec4) = BVec4(x > v.x, y > v.y, z > v.z, w > v.w)
inline infix fun FVec2.gt(v: FVec2) = BVec2(x > v.x, y > v.y)
inline infix fun FVec3.gt(v: FVec3) = BVec3(x > v.x, y > v.y, z > v.z)
inline infix fun FVec4.gt(v: FVec4) = BVec4(x > v.x, y > v.y, z > v.z, w > v.w)
inline infix fun DVec2.gt(v: DVec2) = BVec2(x > v.x, y > v.y)
inline infix fun DVec3.gt(v: DVec3) = BVec3(x > v.x, y > v.y, z > v.z)
inline infix fun DVec4.gt(v: DVec4) = BVec4(x > v.x, y > v.y, z > v.z, w > v.w)

inline infix fun IVec2.ge(v: IVec2) = BVec2(x >= v.x, y >= v.y)
inline infix fun IVec3.ge(v: IVec3) = BVec3(x >= v.x, y >= v.y, z >= v.z)
inline infix fun IVec4.ge(v: IVec4) = BVec4(x >= v.x, y >= v.y, z >= v.z, w >= v.w)
inline infix fun FVec2.ge(v: FVec2) = BVec2(x >= v.x, y >= v.y)
inline infix fun FVec3.ge(v: FVec3) = BVec3(x >= v.x, y >= v.y, z >= v.z)
inline infix fun FVec4.ge(v: FVec4) = BVec4(x >= v.x, y >= v.y, z >= v.z, w >= v.w)
inline infix fun DVec2.ge(v: DVec2) = BVec2(x >= v.x, y >= v.y)
inline infix fun DVec3.ge(v: DVec3) = BVec3(x >= v.x, y >= v.y, z >= v.z)
inline infix fun DVec4.ge(v: DVec4) = BVec4(x >= v.x, y >= v.y, z >= v.z, w >= v.w)

// common
inline fun BVec2.map(block: (Boolean) -> Boolean) = BVec2(block(x), block(y))
inline fun BVec3.map(block: (Boolean) -> Boolean) = BVec3(block(x), block(y), block(z))
inline fun BVec4.map(block: (Boolean) -> Boolean) = BVec4(block(x), block(y), block(z), block(w))

inline fun IVec2.map(block: (Int) -> Int) = IVec2(block(x), block(y))
inline fun IVec3.map(block: (Int) -> Int) = IVec3(block(x), block(y), block(z))
inline fun IVec4.map(block: (Int) -> Int) = IVec4(block(x), block(y), block(z), block(w))

inline fun FVec2.map(block: (Float) -> Float) = FVec2(block(x), block(y))
inline fun FVec3.map(block: (Float) -> Float) = FVec3(block(x), block(y), block(z))
inline fun FVec4.map(block: (Float) -> Float) = FVec4(block(x), block(y), block(z), block(w))

inline fun DVec2.map(block: (Double) -> Double) = DVec2(block(x), block(y))
inline fun DVec3.map(block: (Double) -> Double) = DVec3(block(x), block(y), block(z))
inline fun DVec4.map(block: (Double) -> Double) = DVec4(block(x), block(y), block(z), block(w))

inline fun min(a: IVec2, b: IVec2) = IVec2(min(a.x, b.x), min(a.y, b.y))
inline fun min(a: IVec3, b: IVec3) = IVec3(min(a.x, b.x), min(a.y, b.y), min(a.z, b.z))
inline fun min(a: IVec4, b: IVec4) = IVec4(min(a.x, b.x), min(a.y, b.y), min(a.z, b.z), min(a.w, b.w))

inline fun max(a: IVec2, b: IVec2) = IVec2(max(a.x, b.x), max(a.y, b.y))
inline fun max(a: IVec3, b: IVec3) = IVec3(max(a.x, b.x), max(a.y, b.y), max(a.z, b.z))
inline fun max(a: IVec4, b: IVec4) = IVec4(max(a.x, b.x), max(a.y, b.y), max(a.z, b.z), max(a.w, b.w))

inline fun clamp(v: IVec2, min: IVec2, max: IVec2) = IVec2(clamp(v.x, min.x, max.x), clamp(v.y, min.y, max.y))
inline fun clamp(v: IVec2, min: Int, max: Int)     = IVec2(clamp(v.x, min, max), clamp(v.y, min, max))
inline fun clamp(v: IVec3, min: IVec3, max: IVec3) = IVec3(clamp(v.x, min.x, max.x), clamp(v.y, min.y, max.y), clamp(v.z, min.z, max.z))
inline fun clamp(v: IVec3, min: Int, max: Int)     = IVec3(clamp(v.x, min, max), clamp(v.y, min, max), clamp(v.z, min, max))
inline fun clamp(v: IVec4, min: IVec4, max: IVec4) = IVec4(clamp(v.x, min.x, max.x), clamp(v.y, min.y, max.y), clamp(v.z, min.z, max.z), clamp(v.w, min.w, max.w))
inline fun clamp(v: IVec4, min: Int, max: Int)     = IVec4(clamp(v.x, min, max), clamp(v.y, min, max), clamp(v.z, min, max), clamp(v.w, min, max))

inline fun clamp(v: FVec2, min: FVec2, max: FVec2) = FVec2(clamp(v.x, min.x, max.x), clamp(v.y, min.y, max.y))
inline fun clamp(v: FVec2, min: Float, max: Float) = FVec2(clamp(v.x, min, max), clamp(v.y, min, max))
inline fun clamp(v: FVec3, min: FVec3, max: FVec3) = FVec3(clamp(v.x, min.x, max.x), clamp(v.y, min.y, max.y), clamp(v.z, min.z, max.z))
inline fun clamp(v: FVec3, min: Float, max: Float) = FVec3(clamp(v.x, min, max), clamp(v.y, min, max), clamp(v.z, min, max))
inline fun clamp(v: FVec4, min: FVec4, max: FVec4) = FVec4(clamp(v.x, min.x, max.x), clamp(v.y, min.y, max.y), clamp(v.z, min.z, max.z), clamp(v.w, min.w, max.w))
inline fun clamp(v: FVec4, min: Float, max: Float) = FVec4(clamp(v.x, min, max), clamp(v.y, min, max), clamp(v.z, min, max), clamp(v.w, min, max))

inline fun clamp(v: DVec2, min: DVec2, max: DVec2)   = DVec2(clamp(v.x, min.x, max.x), clamp(v.y, min.y, max.y))
inline fun clamp(v: DVec2, min: Double, max: Double) = DVec2(clamp(v.x, min, max), clamp(v.y, min, max))
inline fun clamp(v: DVec3, min: DVec3, max: DVec3)   = DVec3(clamp(v.x, min.x, max.x), clamp(v.y, min.y, max.y), clamp(v.z, min.z, max.z))
inline fun clamp(v: DVec3, min: Double, max: Double) = DVec3(clamp(v.x, min, max), clamp(v.y, min, max), clamp(v.z, min, max))
inline fun clamp(v: DVec4, min: DVec4, max: DVec4)   = DVec4(clamp(v.x, min.x, max.x), clamp(v.y, min.y, max.y), clamp(v.z, min.z, max.z), clamp(v.w, min.w, max.w))
inline fun clamp(v: DVec4, min: Double, max: Double) = DVec4(clamp(v.x, min, max), clamp(v.y, min, max), clamp(v.z, min, max), clamp(v.w, min, max))

// boolean
inline fun any(v: BVec2) = v.x || v.y
inline fun any(v: BVec3) = v.x || v.y || v.z
inline fun any(v: BVec4) = v.x || v.y || v.z || v.w

inline fun all(v: BVec2) = v.x && v.y
inline fun all(v: BVec3) = v.x && v.y && v.z
inline fun all(v: BVec4) = v.x && v.y && v.z && v.w

// casts
inline fun IVec2(v: FVec2) = IVec2(v.x.toInt(), v.y.toInt())
inline fun IVec2(v: DVec2) = IVec2(v.x.toInt(), v.y.toInt())
inline fun IVec3(v: FVec3) = IVec3(v.x.toInt(), v.y.toInt(), v.z.toInt())
inline fun IVec3(v: DVec3) = IVec3(v.x.toInt(), v.y.toInt(), v.z.toInt())
inline fun IVec4(v: FVec4) = IVec4(v.x.toInt(), v.y.toInt(), v.z.toInt(), v.w.toInt())
inline fun IVec4(v: DVec4) = IVec4(v.x.toInt(), v.y.toInt(), v.z.toInt(), v.w.toInt())

inline fun DVec2(v: IVec2) = DVec2(v.x.toDouble(), v.y.toDouble())
inline fun DVec2(v: FVec2) = DVec2(v.x.toDouble(), v.y.toDouble())
inline fun DVec3(v: IVec3) = DVec3(v.x.toDouble(), v.y.toDouble(), v.z.toDouble())
inline fun DVec3(v: FVec3) = DVec3(v.x.toDouble(), v.y.toDouble(), v.z.toDouble())
inline fun DVec4(v: IVec4) = DVec4(v.x.toDouble(), v.y.toDouble(), v.z.toDouble(), v.w.toDouble())
inline fun DVec4(v: FVec4) = DVec4(v.x.toDouble(), v.y.toDouble(), v.z.toDouble(), v.w.toDouble())

inline fun FVec2(v: IVec2) = FVec2(v.x.toFloat(), v.y.toFloat())
inline fun FVec2(v: DVec2) = FVec2(v.x.toFloat(), v.y.toFloat())
inline fun FVec3(v: IVec3) = FVec3(v.x.toFloat(), v.y.toFloat(), v.z.toFloat())
inline fun FVec3(v: DVec3) = FVec3(v.x.toFloat(), v.y.toFloat(), v.z.toFloat())
inline fun FVec4(v: IVec4) = FVec4(v.x.toFloat(), v.y.toFloat(), v.z.toFloat(), v.w.toFloat())
inline fun FVec4(v: DVec4) = FVec4(v.x.toFloat(), v.y.toFloat(), v.z.toFloat(), v.w.toFloat())

// floats
inline fun abs(v: IVec2) = IVec2(abs(v.x), abs(v.y))
inline fun abs(v: IVec3) = IVec3(abs(v.x), abs(v.y), abs(v.z))
inline fun abs(v: IVec4) = IVec4(abs(v.x), abs(v.y), abs(v.z), abs(v.w))
inline fun abs(v: FVec2) = FVec2(abs(v.x), abs(v.y))
inline fun abs(v: FVec3) = FVec3(abs(v.y), abs(v.y), abs(v.z))
inline fun abs(v: FVec4) = FVec4(abs(v.y), abs(v.y), abs(v.z), abs(v.z))
inline fun abs(v: DVec2) = DVec2(abs(v.x), abs(v.y))
inline fun abs(v: DVec3) = DVec3(abs(v.y), abs(v.y), abs(v.z))
inline fun abs(v: DVec4) = DVec4(abs(v.y), abs(v.y), abs(v.z), abs(v.z))

inline fun lengthSq(v: FVec2) = sqr(v.x) + sqr(v.y)
inline fun lengthSq(v: FVec3) = sqr(v.x) + sqr(v.y) + sqr(v.z)
inline fun lengthSq(v: FVec4) = sqr(v.x) + sqr(v.y) + sqr(v.z) + sqr(v.w)
inline fun lengthSq(v: DVec2) = sqr(v.x) + sqr(v.y)
inline fun lengthSq(v: DVec3) = sqr(v.x) + sqr(v.y) + sqr(v.z)
inline fun lengthSq(v: DVec4) = sqr(v.x) + sqr(v.y) + sqr(v.z) + sqr(v.w)

inline fun length(v: FVec2) = sqrt(lengthSq(v))
inline fun length(v: FVec3) = sqrt(lengthSq(v))
inline fun length(v: FVec4) = sqrt(lengthSq(v))
inline fun length(v: DVec2) = sqrt(lengthSq(v))
inline fun length(v: DVec3) = sqrt(lengthSq(v))
inline fun length(v: DVec4) = sqrt(lengthSq(v))

inline fun normalize(v: FVec2): FVec2 {
    val l = length(v)
    return FVec2(v.x / l, v.y / l)
}
inline fun normalize(v: FVec3): FVec3 {
    val l = length(v)
    return FVec3(v.x / l, v.y / l, v.z / l)
}
inline fun normalize(v: FVec4): FVec4 {
    val l = length(v)
    return FVec4(v.x / l, v.y / l, v.z / l, v.w / l)
}

inline fun distance(a: FVec2, b: FVec2) = length(b - a)
inline fun distance(a: FVec3, b: FVec3) = length(b - a)
inline fun distance(a: FVec4, b: FVec4) = length(b - a)
inline fun distance(a: DVec2, b: DVec2) = length(b - a)
inline fun distance(a: DVec3, b: DVec3) = length(b - a)
inline fun distance(a: DVec4, b: DVec4) = length(b - a)

inline fun mix(a: FVec2, b: FVec2, f: Float) = FVec2(mix(a.x, b.x, f), mix(a.y, b.y, f))
inline fun mix(a: FVec3, b: FVec3, f: Float) = FVec3(mix(a.x, b.x, f), mix(a.y, b.y, f), mix(a.z, b.z, f))
inline fun mix(a: FVec4, b: FVec4, f: Float) = FVec4(mix(a.x, b.x, f), mix(a.y, b.y, f), mix(a.z, b.z, f), mix(a.w, b.w, f))
inline fun mix(a: DVec2, b: DVec2, f: Double) = DVec2(mix(a.x, b.x, f), mix(a.y, b.y, f))
inline fun mix(a: DVec3, b: DVec3, f: Double) = DVec3(mix(a.x, b.x, f), mix(a.y, b.y, f), mix(a.z, b.z, f))
inline fun mix(a: DVec4, b: DVec4, f: Double) = DVec4(mix(a.x, b.x, f), mix(a.y, b.y, f), mix(a.z, b.z, f), mix(a.w, b.w, f))

inline fun dot(a: FVec2, b: FVec2) = a.x*b.x + a.y*b.y
inline fun dot(a: FVec3, b: FVec3) = a.x*b.x + a.y*b.y + a.z*b.z
inline fun dot(a: FVec4, b: FVec4) = a.x*b.x + a.y*b.y + a.z*b.z + a.w*b.w
inline fun dot(a: DVec2, b: DVec2) = a.x*b.x + a.y*b.y
inline fun dot(a: DVec3, b: DVec3) = a.x*b.x + a.y*b.y + a.z*b.z
inline fun dot(a: DVec4, b: DVec4) = a.x*b.x + a.y*b.y + a.z*b.z + a.w*b.w

inline fun cross(a: FVec3, b: FVec3) = FVec3(
    a.y*b.z - a.z*b.y,
    a.z*b.x - a.x*b.z,
    a.x*b.y - a.y*b.x,
)
inline fun cross(a: DVec3, b: DVec3) = DVec3(
    a.y*b.z - a.z*b.y,
    a.z*b.x - a.x*b.z,
    a.x*b.y - a.y*b.x,
)
