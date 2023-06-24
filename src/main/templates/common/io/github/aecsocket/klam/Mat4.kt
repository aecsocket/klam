@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Mat4(
    @JvmField val x: {{ T }}Vec4,
    @JvmField val y: {{ T }}Vec4,
    @JvmField val z: {{ T }}Vec4,
    @JvmField val w: {{ T }}Vec4,
) {
    companion object {
        val {{ Zero }} get() = {{ T }}Mat4(
            {{ T }}Vec4.{{ Zero }},
            {{ T }}Vec4.{{ Zero }},
            {{ T }}Vec4.{{ Zero }},
            {{ T }}Vec4.{{ Zero }},
        )

        val {{ One }} get() = {{ T }}Mat4(
            {{ T }}Vec4.{{ One }},
            {{ T }}Vec4.{{ One }},
            {{ T }}Vec4.{{ One }},
            {{ T }}Vec4.{{ One }},
        )

        val Identity get() = {{ T }}Mat4(
            {{ one }}, {{ zero }}, {{ zero }}, {{ zero }},
            {{ zero }}, {{ one }}, {{ zero }}, {{ zero }},
            {{ zero }}, {{ zero }}, {{ one }}, {{ zero }},
            {{ zero }}, {{ zero }}, {{ zero }}, {{ one }},
        )
    }

    constructor(
        xx: {{ Type }}, xy: {{ Type }}, xz: {{ Type }}, xw: {{ Type }},
        yx: {{ Type }}, yy: {{ Type }}, yz: {{ Type }}, yw: {{ Type }},
        zx: {{ Type }}, zy: {{ Type }}, zz: {{ Type }}, zw: {{ Type }},
        wx: {{ Type }}, wy: {{ Type }}, wz: {{ Type }}, ww: {{ Type }},
    ) : this(
        {{ T }}Vec4(xx, yx, zx, wx),
        {{ T }}Vec4(xy, yy, zy, wy),
        {{ T }}Vec4(xz, yz, zz, wz),
        {{ T }}Vec4(xw, yw, zw, ww),
    )

    constructor(s: {{ Type }}) : this(
        s, s, s, s,
        s, s, s, s,
        s, s, s, s,
        s, s, s, s,
    )

    operator fun get(col: Int) = when (col) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Int, row: Int) = get(col)[row]

    fun compareTo(m: {{ T }}Mat4) = IMat4(x.compareTo(m.x), y.compareTo(m.y), z.compareTo(m.z), w.compareTo(m.w))
    fun toArray() = {{ arrayOf }}(
        x.x, x.y, x.z, x.w,
        y.x, y.y, y.z, y.w,
        z.x, z.y, z.z, z.w,
        w.x, w.y, w.z, w.w,
    )

    fun asString(fmt: String) = """
        [
          $fmt $fmt $fmt
          $fmt $fmt $fmt
          $fmt $fmt $fmt
        ]
    """.trimIndent().format(
        x.x, y.x, z.x, w.x,
        x.y, y.y, z.y, w.y,
        x.z, y.z, z.z, w.z,
        x.w, y.w, z.w, w.w,
    )
    override fun toString() = asString("{{ toStringFormat }}")

    inline fun mapVector(block: ({{ T }}Vec4) -> {{ T }}Vec4) = {{ T }}Mat4(block(x), block(y), block(z), block(w))
    inline fun mapScalar(block: ({{ Type }}) -> {{ Type }}) = {{ T }}Mat4(x.map(block), y.map(block), z.map(block), w.map(block))

{% for cast in numberCasts %}
    inline fun mapVector{{ cast.Type }}(block: ({{ T }}Vec4) -> {{ cast.T }}Vec4) = {{ cast.T }}Mat4(block(x), block(y), block(z), block(w))
    inline fun mapScalar{{ cast.Type }}(block: ({{ Type }}) -> {{ cast.Type }}) = {{ cast.T }}Mat4(x.map{{ cast.Type }}(block), y.map{{ cast.Type }}(block), z.map{{ cast.Type }}(block), w.map{{ cast.Type }}(block))
    fun {{ cast.fn }} = {{ cast.T }}Mat4(x.{{ cast.fn }}, y.{{ cast.fn }}, z.{{ cast.fn }}, w.{{ cast.fn }})

{% endfor %}
{% if isNumber %}
    inline operator fun unaryMinus() = {{ T }}Mat4(-x, -y, -z, -w)

    @JvmName("add")
    inline operator fun plus (s: {{ Type }}) = {{ T }}Mat4(x + s, y + s, z + s, w + s)
    @JvmName("sub")
    inline operator fun minus(s: {{ Type }}) = {{ T }}Mat4(x - s, y - s, z - s, w - s)
    @JvmName("mul")
    inline operator fun times(s: {{ Type }}) = {{ T }}Mat4(x * s, y * s, z * s, w * s)

    @JvmName("add")
    inline operator fun plus (m: {{ T }}Mat4) = {{ T }}Mat4(x + m.x, y + m.y, z + m.z, w + m.w)
    @JvmName("sub")
    inline operator fun minus(m: {{ T }}Mat4) = {{ T }}Mat4(x - m.x, y - m.y, z - m.z, w - m.w)

    @JvmName("mul")
    inline operator fun times(m: {{ T }}Mat4) = {{ T }}Mat4(
        x.x * m.x.x + y.x * m.x.y + z.x * m.x.z + w.x * m.x.w,  x.y * m.x.x + y.y * m.x.y + z.y * m.x.z + w.y * m.x.w,  x.z * m.x.x + y.z * m.x.y + z.z * m.x.z + w.z * m.x.w,  x.w * m.x.x + y.w * m.x.y + z.w * m.x.z + w.w * m.x.w,
        x.x * m.y.x + y.x * m.y.y + z.x * m.y.z + w.x * m.y.w,  x.y * m.y.x + y.y * m.y.y + z.y * m.y.z + w.y * m.y.w,  x.z * m.y.x + y.z * m.y.y + z.z * m.y.z + w.z * m.y.w,  x.w * m.y.x + y.w * m.y.y + z.w * m.y.z + w.w * m.y.w,
        x.x * m.z.x + y.x * m.z.y + z.x * m.z.z + w.x * m.z.w,  x.y * m.z.x + y.y * m.z.y + z.y * m.z.z + w.y * m.z.w,  x.z * m.z.x + y.z * m.z.y + z.z * m.z.z + w.z * m.z.w,  x.w * m.z.x + y.w * m.z.y + z.w * m.z.z + w.w * m.z.w,
        x.x * m.w.x + y.x * m.w.y + z.x * m.w.z + w.x * m.w.w,  x.y * m.w.x + y.y * m.w.y + z.y * m.w.z + w.y * m.w.w,  x.z * m.w.x + y.z * m.w.y + z.z * m.w.z + w.z * m.w.w,  x.w * m.w.x + y.w * m.w.y + z.w * m.w.z + w.w * m.w.w,
    )
{% endif %}
}

{% if isNumber %}
@JvmName("add")
inline operator fun {{ Type }}.plus (m: {{ T }}Mat4) = {{ T }}Mat4(this + m.x, this + m.y, this + m.z, this + m.w)
@JvmName("sub")
inline operator fun {{ Type }}.minus(m: {{ T }}Mat4) = {{ T }}Mat4(this - m.x, this - m.y, this - m.z, this - m.w)
@JvmName("mul")
inline operator fun {{ Type }}.times(m: {{ T }}Mat4) = {{ T }}Mat4(this * m.x, this * m.y, this * m.z, this * m.w)
{% endif %}

inline fun transpose(m: {{ T }}Mat4) = {{ T }}Mat4(
    m[0, 0], m[0, 1], m[0, 2], m[0, 3],
    m[1, 0], m[1, 1], m[1, 2], m[1, 3],
    m[2, 0], m[2, 1], m[2, 2], m[2, 3],
    m[3, 0], m[3, 1], m[3, 2], m[3, 3],
)

{% if isNumber %}
inline fun determinant(m: {{ T }}Mat4): {{ Type }} {
    val f00 = m[2, 2] * m[3, 3] - m[3, 2] * m[2, 3]
    val f01 = m[2, 1] * m[3, 3] - m[3, 1] * m[2, 3]
    val f02 = m[2, 1] * m[3, 2] - m[3, 1] * m[2, 2]
    val f03 = m[2, 0] * m[3, 3] - m[3, 0] * m[2, 3]
    val f04 = m[2, 0] * m[3, 2] - m[3, 0] * m[2, 2]
    val f05 = m[2, 0] * m[3, 1] - m[3, 0] * m[2, 1]

    val detCof = {{ T }}Vec4(
        + (m[1, 1] * f00 - m[1, 2] * f01 + m[1, 3] * f02),
        - (m[1, 0] * f00 - m[1, 2] * f03 + m[1, 3] * f04),
        + (m[1, 0] * f01 - m[1, 1] * f03 + m[1, 3] * f05),
        - (m[1, 0] * f02 - m[1, 1] * f04 + m[1, 2] * f05),
    )

    return m[0, 0] * detCof[0] + m[0, 1] * detCof[1] +
           m[0, 2] * detCof[2] + m[0, 3] * detCof[3]
}

{% if isDecimal %}
inline fun inverse(m: {{ T }}Mat4): {{ T }}Mat4 {
    val c00 = m[2, 2] * m[3, 3] - m[3, 2] * m[2, 3]
    val c02 = m[1, 2] * m[3, 3] - m[3, 2] * m[1, 3]
    val c03 = m[1, 2] * m[2, 3] - m[2, 2] * m[1, 3]

    val c04 = m[2, 1] * m[3, 3] - m[3, 1] * m[2, 3]
    val c06 = m[1, 1] * m[3, 3] - m[3, 1] * m[1, 3]
    val c07 = m[1, 1] * m[2, 3] - m[2, 1] * m[1, 3]

    val c08 = m[2, 1] * m[3, 2] - m[3, 1] * m[2, 2]
    val c10 = m[1, 1] * m[3, 2] - m[3, 1] * m[1, 2]
    val c11 = m[1, 1] * m[2, 2] - m[2, 1] * m[1, 2]

    val c12 = m[2, 0] * m[3, 3] - m[3, 0] * m[2, 3]
    val c14 = m[1, 0] * m[3, 3] - m[3, 0] * m[1, 3]
    val c15 = m[1, 0] * m[2, 3] - m[2, 0] * m[1, 3]

    val c16 = m[2, 0] * m[3, 2] - m[3, 0] * m[2, 2]
    val c18 = m[1, 0] * m[3, 2] - m[3, 0] * m[1, 2]
    val c19 = m[1, 0] * m[2, 2] - m[2, 0] * m[1, 2]

    val c20 = m[2, 0] * m[3, 1] - m[3, 0] * m[2, 1]
    val c22 = m[1, 0] * m[3, 1] - m[3, 0] * m[1, 1]
    val c23 = m[1, 0] * m[2, 1] - m[2, 0] * m[1, 1]

    val fac0 = {{ T }}Vec4(c00, c00, c02, c03)
    val fac1 = {{ T }}Vec4(c04, c04, c06, c07)
    val fac2 = {{ T }}Vec4(c08, c08, c10, c11)
    val fac3 = {{ T }}Vec4(c12, c12, c14, c15)
    val fac4 = {{ T }}Vec4(c16, c16, c18, c19)
    val fac5 = {{ T }}Vec4(c20, c20, c22, c23)

    val vec0 = {{ T }}Vec4(m[1, 0], m[0, 0], m[0, 0], m[0, 0])
    val vec1 = {{ T }}Vec4(m[1, 1], m[0, 1], m[0, 1], m[0, 1])
    val vec2 = {{ T }}Vec4(m[1, 2], m[0, 2], m[0, 2], m[0, 2])
    val vec3 = {{ T }}Vec4(m[1, 3], m[0, 3], m[0, 3], m[0, 3])

    val inv0 = vec1 * fac0 - vec2 * fac1 + vec3 * fac2
    val inv1 = vec0 * fac0 - vec2 * fac3 + vec3 * fac4
    val inv2 = vec0 * fac1 - vec1 * fac3 + vec3 * fac5
    val inv3 = vec0 * fac2 - vec1 * fac4 + vec2 * fac5

    val signA = {{ T }}Vec4( {{ one }}, -{{ one }},  {{ one }}, -{{ one }})
    val signB = {{ T }}Vec4(-{{ one }},  {{ one }}, -{{ one }},  {{ one }})
    val inverse = {{ T }}Mat4(inv0 * signA, inv1 * signB, inv2 * signA, inv3 * signB)

    val row0 = {{ T }}Vec4(inverse[0, 0], inverse[1, 0], inverse[2, 0], inverse[3, 0])

    val dot0 = m[0] * row0
    val dot1 = (dot0.x + dot0.y) + (dot0.z + dot0.w)

    return inverse * ({{ one }} / dot1)
}
{% endif %}
{% endif %}
