@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

import kotlin.math.abs
import kotlin.math.min
import kotlin.math.max
import kotlin.math.sqrt

// common
inline fun min(a: IVec2, b: IVec2) = IVec2(min(a.x, b.x), min(a.y, b.y))
inline fun min(a: IVec3, b: IVec3) = IVec3(min(a.x, b.x), min(a.y, b.y), min(a.z, b.z))
inline fun min(a: IVec4, b: IVec4) = IVec4(min(a.x, b.x), min(a.y, b.y), min(a.z, b.z), min(a.w, b.w))

inline fun min(a: FVec2, b: FVec2) = FVec2(min(a.x, b.x), min(a.y, b.y))
inline fun min(a: FVec3, b: FVec3) = FVec3(min(a.x, b.x), min(a.y, b.y), min(a.z, b.z))
inline fun min(a: FVec4, b: FVec4) = FVec4(min(a.x, b.x), min(a.y, b.y), min(a.z, b.z), min(a.w, b.w))

inline fun min(a: DVec2, b: DVec2) = DVec2(min(a.x, b.x), min(a.y, b.y))
inline fun min(a: DVec3, b: DVec3) = DVec3(min(a.x, b.x), min(a.y, b.y), min(a.z, b.z))
inline fun min(a: DVec4, b: DVec4) = DVec4(min(a.x, b.x), min(a.y, b.y), min(a.z, b.z), min(a.w, b.w))

inline fun max(a: IVec2, b: IVec2) = IVec2(max(a.x, b.x), max(a.y, b.y))
inline fun max(a: IVec3, b: IVec3) = IVec3(max(a.x, b.x), max(a.y, b.y), max(a.z, b.z))
inline fun max(a: IVec4, b: IVec4) = IVec4(max(a.x, b.x), max(a.y, b.y), max(a.z, b.z), max(a.w, b.w))

inline fun max(a: FVec2, b: FVec2) = FVec2(max(a.x, b.x), max(a.y, b.y))
inline fun max(a: FVec3, b: FVec3) = FVec3(max(a.x, b.x), max(a.y, b.y), max(a.z, b.z))
inline fun max(a: FVec4, b: FVec4) = FVec4(max(a.x, b.x), max(a.y, b.y), max(a.z, b.z), max(a.w, b.w))

inline fun max(a: DVec2, b: DVec2) = DVec2(max(a.x, b.x), max(a.y, b.y))
inline fun max(a: DVec3, b: DVec3) = DVec3(max(a.x, b.x), max(a.y, b.y), max(a.z, b.z))
inline fun max(a: DVec4, b: DVec4) = DVec4(max(a.x, b.x), max(a.y, b.y), max(a.z, b.z), max(a.w, b.w))

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

// decimals
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
    val l = 1.0f / length(v)
    return FVec2(v.x * l, v.y * l)
}
inline fun normalize(v: FVec3): FVec3 {
    val l = 1.0f / length(v)
    return FVec3(v.x * l, v.y * l, v.z * l)
}
inline fun normalize(v: FVec4): FVec4 {
    val l = 1.0f / length(v)
    return FVec4(v.x * l, v.y * l, v.z * l, v.w * l)
}
inline fun normalize(v: DVec2): DVec2 {
    val l = 1.0 / length(v)
    return DVec2(v.x * l, v.y * l)
}
inline fun normalize(v: DVec3): DVec3 {
    val l = 1.0 / length(v)
    return DVec3(v.x * l, v.y * l, v.z * l)
}
inline fun normalize(v: DVec4): DVec4 {
    val l = 1.0 / length(v)
    return DVec4(v.x * l, v.y * l, v.z * l, v.w * l)
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
