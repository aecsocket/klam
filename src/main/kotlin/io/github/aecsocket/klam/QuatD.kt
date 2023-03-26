@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

import kotlin.math.cos
import kotlin.math.sin

data class DQuat(@JvmField var x: Double, @JvmField var y: Double, @JvmField var z: Double, @JvmField var w: Double) {
    companion object {
        fun identity() = DQuat(0.0, 0.0, 0.0, 1.0)

        fun ofAxisAngle(axis: DVec3, angle: Double): DQuat {
            val xyz = axis * sin(angle * 0.5)
            return DQuat(xyz.x, xyz.y, xyz.z, cos(angle * 0.5))
        }
    }

    constructor(q: DQuat) : this(q.x, q.y, q.z, q.w)
    constructor(v: DVec4) : this(v.x, v.y, v.z, v.w)

    fun from(x: Double, y: Double, z: Double, w: Double) { this.x = x; this.y = y; this.z = z; this.w = w }
    fun from(q: DQuat) = from(q.x, q.y, q.z, q.w)

    operator fun get(idx: Index) = when (idx) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException(idx)
    }

    operator fun set(idx: Index, s: Double) = when (idx) {
        0 -> x = s
        1 -> y = s
        2 -> z = s
        3 -> w = s
        else -> throw IndexOutOfBoundsException(idx)
    }

    fun compareTo(q: DQuat) = IVec4(x.compareTo(q.x), y.compareTo(q.y), z.compareTo(q.z), w.compareTo(q.w))
    fun equalTo(q: DQuat) = x.compareTo(q.x) == 0 && y.compareTo(q.y) == 0 && z.compareTo(q.z) == 0 && w.compareTo(q.w) == 0
    fun toArray() = doubleArrayOf(x, y, z, w)

    fun asString(fmt: String = "%f") = "(${fmt} + ${fmt}i + ${fmt}j + ${fmt}k)".format(w, x, y, z)
    override fun toString() = asString("%.3f")
}

inline fun DQuat.map(block: (Double) -> Double) = DQuat(block(x), block(y), block(z), block(w))

inline operator fun DQuat.plus(s: Double)  = DQuat(x + s, y + s, z + s, w + s)
inline operator fun DQuat.minus(s: Double) = DQuat(x - s, y - s, z - s, w - s)
inline operator fun DQuat.times(s: Double) = DQuat(x * s, y * s, z * s, w * s)
inline operator fun DQuat.div(s: Double)   = DQuat(x / s, y / s, z / s, w / s)

inline operator fun DQuat.plusAssign(s: Double)  { x += s; y += s; z += s; w += s }
inline operator fun DQuat.minusAssign(s: Double) { x -= s; y -= s; z -= s; w -= s }
inline operator fun DQuat.timesAssign(s: Double) { x *= s; y *= s; z *= s; w *= s }
inline operator fun DQuat.divAssign(s: Double)   { x /= s; y /= s; z /= s; w /= s }

inline operator fun DQuat.times(q: DQuat) = DQuat(this).apply { this *= q }

inline operator fun DQuat.timesAssign(q: DQuat) {
    from(
        w*q.x + x*q.w + y*q.z - z*q.y,
        w*q.y - x*q.z + y*q.w + z*q.x,
        w*q.z + x*q.y - y*q.x + z*q.w,
        w*q.w - x*q.x - y*q.y - z*q.z,
    )
}

inline operator fun DQuat.times(v: DVec3): DVec3 {
    val u = xyz
    val s = w
    return (u * 2.0 * dot(u, v)) +
            (v * (s*s - dot(u, u))) +
            (cross(u, v) * 2.0 * s)
}

//region Alternate accessors
inline var DQuat.xyz get() = DVec3(x, y, z); set(value) { x = value.x; y = value.y; z = value.z }
//endregion
