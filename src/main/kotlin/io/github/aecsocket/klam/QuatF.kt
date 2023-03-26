@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

import kotlin.math.cos
import kotlin.math.sin

data class FQuat(@JvmField var x: Float, @JvmField var y: Float, @JvmField var z: Float, @JvmField var w: Float) {
    companion object {
        fun identity() = FQuat(0.0f, 0.0f, 0.0f, 1.0f)

        fun ofAxisAngle(axis: FVec3, angle: Float): FQuat {
            val xyz = axis * sin(angle * 0.5f)
            return FQuat(xyz.x, xyz.y, xyz.z, cos(angle * 0.5f))
        }
    }

    constructor(q: FQuat) : this(q.x, q.y, q.z, q.w)
    constructor(v: FVec4) : this(v.x, v.y, v.z, v.w)

    fun from(x: Float, y: Float, z: Float, w: Float) { this.x = x; this.y = y; this.z = z; this.w = w }
    fun from(q: FQuat) = from(q.x, q.y, q.z, q.w)

    operator fun get(idx: Index) = when (idx) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException(idx)
    }

    operator fun set(idx: Index, s: Float) = when (idx) {
        0 -> x = s
        1 -> y = s
        2 -> z = s
        3 -> w = s
        else -> throw IndexOutOfBoundsException(idx)
    }

    fun compareTo(q: FQuat) = IVec4(x.compareTo(q.x), y.compareTo(q.y), z.compareTo(q.z), w.compareTo(q.w))
    fun equalTo(q: FQuat) = x.compareTo(q.x) == 0 && y.compareTo(q.y) == 0 && z.compareTo(q.z) == 0 && w.compareTo(q.w) == 0
    fun toArray() = floatArrayOf(x, y, z, w)

    fun asString(fmt: String) = "(${fmt} + ${fmt}i + ${fmt}j + ${fmt}k)".format(w, x, y, z)
    override fun toString() = asString("%f")
}

inline fun FQuat.map(block: (Float) -> Float) = FQuat(block(x), block(y), block(z), block(w))

inline operator fun FQuat.plus(s: Float)  = FQuat(x + s, y + s, z + s, w + s)
inline operator fun FQuat.minus(s: Float) = FQuat(x - s, y - s, z - s, w - s)
inline operator fun FQuat.times(s: Float) = FQuat(x * s, y * s, z * s, w * s)
inline operator fun FQuat.div(s: Float)   = FQuat(x / s, y / s, z / s, w / s)

inline operator fun FQuat.plusAssign(s: Float)  { x += s; y += s; z += s; w += s }
inline operator fun FQuat.minusAssign(s: Float) { x -= s; y -= s; z -= s; w -= s }
inline operator fun FQuat.timesAssign(s: Float) { x *= s; y *= s; z *= s; w *= s }
inline operator fun FQuat.divAssign(s: Float)   { x /= s; y /= s; z /= s; w /= s }

inline operator fun FQuat.times(q: FQuat) = FQuat(this).apply { this *= q }

inline operator fun FQuat.timesAssign(q: FQuat) {
    from(
        w*q.x + x*q.w + y*q.z - z*q.y,
        w*q.y - x*q.z + y*q.w + z*q.x,
        w*q.z + x*q.y - y*q.x + z*q.w,
        w*q.w - x*q.x - y*q.y - z*q.z,
    )
}

inline operator fun FQuat.times(v: FVec3): FVec3 {
    val u = xyz
    val s = w
    return (u * 2.0f * dot(u, v)) +
            (v * (s*s - dot(u, u))) +
            (cross(u, v) * 2.0f * s)
}

inline operator fun FQuat.times(v: DVec3): DVec3 {
    val u = DVec3(xyz)
    val s = w.toDouble()
    return (u * 2.0 * dot(u, v)) +
            (v * (s*s - dot(u, u))) +
            (cross(u, v) * 2.0 * s)
}

//region Alternate accessors
inline var FQuat.xyz get() = FVec3(x, y, z); set(value) { x = value.x; y = value.y; z = value.z }
//endregion
