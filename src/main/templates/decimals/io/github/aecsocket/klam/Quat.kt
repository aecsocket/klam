@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

import kotlin.math.cos
import kotlin.math.sin

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
            return DQuat(xyz.x, xyz.y, xyz.z, cos(angle * 0.5))
        }
    }

    constructor(v: {{ T }}Vec4) : this(v.x, v.y, v.z, v.w)

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

    fun compareTo(q: {{ T }}Quat) = IVec4(x.compareTo(q.x), y.compareTo(q.y), z.compareTo(q.z), w.compareTo(q.w))
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

    inline infix fun eq(q: {{ T }}Quat) = BVec4(x.compareTo(v.x) == 0, q.compareTo(q.y) == 0, z.compareTo(q.z), w.compareTo(q.w))
    inline infix fun ne(q: {{ T }}Quat) = BVec4(x.compareTo(v.x) != 0, q.compareTo(q.y) != 0, z.compareTo(q.z), w.compareTo(q.w))

    inline infix fun lt(q: {{ T }}Quat) = BVec4(x  < q.x, y  < q.y, z  < q.z, w  < q.w)
    inline infix fun le(q: {{ T }}Quat) = BVec4(x <= q.x, y <= q.y, z <= q.z, w <= q.w)
    inline infix fun gt(q: {{ T }}Quat) = BVec4(x  > q.x, y  > q.y, z  > q.z, w  > q.w)
    inline infix fun ge(q: {{ T }}Quat) = BVec4(x >= q.x, y >= q.y, z >= q.z, w >= q.w)
}

{% if isNumber %}
inline operator fun {{ Type }}.plus (q: {{ T }}Quat) = {{ T }}Quat(this + q.x, this + q.y, this + q.z, this + q.w)
inline operator fun {{ Type }}.minus(q: {{ T }}Quat) = {{ T }}Quat(this - q.x, this - q.y, this - q.z, this - q.w)
inline operator fun {{ Type }}.times(q: {{ T }}Quat) = {{ T }}Quat(this * q.x, this * q.y, this * q.z, this * q.w)
inline operator fun {{ Type }}.div  (q: {{ T }}Quat) = {{ T }}Quat(this / q.x, this / q.y, this / q.z, this / q.w)
{% endif %}
