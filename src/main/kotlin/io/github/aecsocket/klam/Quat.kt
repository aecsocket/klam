@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

import kotlin.math.cos
import kotlin.math.sin

data class Quat(@JvmField var x: Float, @JvmField var y: Float, @JvmField var z: Float, @JvmField var w: Float) {
    companion object {
        fun identity() = Quat(0.0f, 0.0f, 0.0f, 1.0f)

        fun ofAxisAngle(axis: FVec3, angle: Float): Quat {
            val xyz = axis * sin(angle * 0.5f)
            return Quat(xyz.x, xyz.y, xyz.z, cos(angle * 0.5f))
        }
    }

    constructor(q: Quat) : this(q.x, q.y, q.z, q.w)
    constructor(v: FVec4) : this(v.x, v.y, v.z, v.w)

    fun from(x: Float, y: Float, z: Float, w: Float) { this.x = x; this.y = y; this.z = z; this.w = w }
    fun from(q: Quat) = from(q.x, q.y, q.z, q.w)

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

    inline operator fun times(v: FVec3): FVec3 {
        val u = xyz
        return (u * 2f * dot(u, v)) +
                (v * (w*w - dot(u, u))) +
                (cross(u, v) * 2f * w)
    }

    inline fun compareTo(q: Quat) = IVec4(x.compareTo(q.x), y.compareTo(q.y), z.compareTo(q.z), w.compareTo(q.w))
    inline fun equalTo(q: Quat) = x.compareTo(q.x) == 0 && y.compareTo(q.y) == 0 && z.compareTo(q.z) == 0 && w.compareTo(q.w) == 0
    fun toArray() = floatArrayOf(x, y, z, w)

    fun asString(fmt: String = "%f") = "(${fmt} + ${fmt}i + ${fmt}j + ${fmt}k)".format(w, x, y, z)
    override fun toString() = asString("%.3f")
}

inline fun Quat.map(block: (Float) -> Float) = Quat(block(x), block(y), block(z), block(w))

inline operator fun Quat.plus(s: Float)  = Quat(x + s, y + s, z + s, w + s)
inline operator fun Quat.minus(s: Float) = Quat(x - s, y - s, z - s, w - s)
inline operator fun Quat.times(s: Float) = Quat(x * s, y * s, z * s, w * s)
inline operator fun Quat.div(s: Float)   = Quat(x / s, y / s, z / s, w / s)

inline operator fun Quat.plusAssign(s: Float)  { x += s; y += s; z += s; w += s }
inline operator fun Quat.minusAssign(s: Float) { x -= s; y -= s; z -= s; w -= s }
inline operator fun Quat.timesAssign(s: Float) { x *= s; y *= s; z *= s; w *= s }
inline operator fun Quat.divAssign(s: Float)   { x /= s; y /= s; z /= s; w /= s }

inline operator fun Quat.times(q: Quat) = Quat(this).apply { this *= q }

inline operator fun Quat.timesAssign(q: Quat) {
    from(
        w*q.x + x*q.w + y*q.z - z*q.y,
        w*q.y - x*q.z + y*q.w + z*q.x,
        w*q.z + x*q.y - y*q.x + z*q.w,
        w*q.w - x*q.x - y*q.y - z*q.z,
    )
}

//region Alternate accessors
inline var Quat.xyz get() = FVec3(x, y, z); set(value) { x = value.x; y = value.y; z = value.z }
inline var Quat.r get() = w; set(value) { w = value }
//endregion
