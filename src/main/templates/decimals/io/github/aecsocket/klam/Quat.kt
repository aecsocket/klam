@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

data class {{ T }}Quat(
    @JvmField val x: {{ Type }},
    @JvmField val y: {{ Type }},
    @JvmField val z: {{ Type }},
    @JvmField val w: {{ Type }},
) {
    companion object {
        val Zero get() = {{ T }}Quat({{ zero }}, {{ zero }}, {{ zero }}, {{ zero }})
        val Identity get() = {{ T }}Quat({{ zero }}, {{ zero }}, {{ zero }}, {{ one }})

        fun ofAxisAngle(axis: {{ T }}Vec3, angle: {{ Type }}): {{ T }}Quat {
            val xyz = axis * sin(angle * {{ half }})
            return {{ T }}Quat(xyz.x, xyz.y, xyz.z, cos(angle * {{ half }}))
        }
    }

    constructor(v: {{ T }}Vec4) : this(v.x, v.y, v.z, v.w)

    constructor(q: {{ S }}Quat) : this(q.x.{{ sToT }}, q.y.{{ sToT }}, q.z.{{ sToT }}, q.w.{{ sToT }})

    operator fun get(index: Int) = when (index) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException(index)
    }

    fun x(x: {{ Type }}) = {{ T }}Quat(x, y, z, w)
    fun y(y: {{ Type }}) = {{ T }}Quat(x, y, z, w)
    fun z(z: {{ Type }}) = {{ T }}Quat(x, y, z, w)
    fun w(w: {{ Type }}) = {{ T }}Quat(x, y, z, w)

    fun toArray() = {{ arrayOf }}(x, y, z, w)

    fun asString(fmt: String) = "(${fmt} + ${fmt}i + ${fmt}j + ${fmt}k)".format(w, x, y, z)
    override fun toString() = asString("{{ toStringFormat }}")

    inline fun map(block: ({{ Type }}) -> {{ Type }}) = {{ T }}Quat(block(x), block(y), block(z), block(w))

    @JvmName("add")
    inline operator fun plus (s: {{ Type }}) = {{ T }}Quat(x + s, y + s, z + s, w + s)
    @JvmName("sub")
    inline operator fun minus(s: {{ Type }}) = {{ T }}Quat(x - s, y - s, z - s, w - s)
    @JvmName("mul")
    inline operator fun times(s: {{ Type }}) = {{ T }}Quat(x * s, y * s, z * s, w * s)
    @JvmName("div")
    inline operator fun div  (s: {{ Type }}) = {{ T }}Quat(x / s, y / s, z / s, w / s)

    @JvmName("mul")
    inline operator fun times(q: {{ T }}Quat) = {{ T }}Quat(
            w * q.x + x * q.w + y * q.z - z * q.y,
            w * q.y - x * q.z + y * q.w + z * q.x,
            w * q.z + x * q.y - y * q.x + z * q.w,
            w * q.w - x * q.x - y * q.y - z * q.z,
    )

    @JvmName("transform")
    inline operator fun times(v: {{ T }}Vec3): {{ T }}Vec3 {
        val u = xyz
        val s = w
        return (u * {{ two }} * dot(u, v)) +
                (v * (s*s - dot(u, u))) +
                (cross(u, v) * {{ two }} * s)
    }

    fun compareTo(q: {{ T }}Quat) = IVec4(x.compareTo(q.x), y.compareTo(q.y), z.compareTo(q.z), w.compareTo(q.w))

    inline infix fun eq(q: {{ T }}Quat) = BVec4(x.compareTo(q.x) == 0, y.compareTo(q.y) == 0, z.compareTo(q.z) == 0, w.compareTo(q.w) == 0)
    inline infix fun ne(q: {{ T }}Quat) = BVec4(x.compareTo(q.x) != 0, y.compareTo(q.y) != 0, z.compareTo(q.z) != 0, w.compareTo(q.w) != 0)

    inline infix fun lt(q: {{ T }}Quat) = BVec4(x  < q.x, y  < q.y, z  < q.z, w  < q.w)
    inline infix fun le(q: {{ T }}Quat) = BVec4(x <= q.x, y <= q.y, z <= q.z, w <= q.w)
    inline infix fun gt(q: {{ T }}Quat) = BVec4(x  > q.x, y  > q.y, z  > q.z, w  > q.w)
    inline infix fun ge(q: {{ T }}Quat) = BVec4(x >= q.x, y >= q.y, z >= q.z, w >= q.w)
}

inline operator fun {{ Type }}.plus (q: {{ T }}Quat) = {{ T }}Quat(this + q.x, this + q.y, this + q.z, this + q.w)
inline operator fun {{ Type }}.minus(q: {{ T }}Quat) = {{ T }}Quat(this - q.x, this - q.y, this - q.z, this - q.w)
inline operator fun {{ Type }}.times(q: {{ T }}Quat) = {{ T }}Quat(this * q.x, this * q.y, this * q.z, this * q.w)
inline operator fun {{ Type }}.div  (q: {{ T }}Quat) = {{ T }}Quat(this / q.x, this / q.y, this / q.z, this / q.w)

inline fun lengthSq(q: {{ T }}Quat) = sqr(q.x) + sqr(q.y) + sqr(q.z) + sqr(q.w)

inline fun length(q: {{ T }}Quat) = sqrt(lengthSq(q))

inline fun normalize(q: {{ T }}Quat): {{ T }}Quat {
    val l = {{ one }} / length(q)
    return {{ T }}Quat(q.x * l, q.y * l, q.z * l, q.w * l)
}

inline fun inverse(q: {{ T }}Quat) = {{ T }}Quat(-q.x, -q.y, -q.z, q.w)

//region Alternate accessors
inline val {{ T }}Quat.xyz get() = {{ T }}Vec3(x, y, z)
//endregion
