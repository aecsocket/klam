@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Mat3(
    @JvmField val x: {{ T }}Vec3,
    @JvmField val y: {{ T }}Vec3,
    @JvmField val z: {{ T }}Vec3,
) {
    companion object {
        val {{ Zero }} get() = {{ T }}Mat3(
            {{ T }}Vec3.{{ Zero }},
            {{ T }}Vec3.{{ Zero }},
            {{ T }}Vec3.{{ Zero }},
        )

        val {{ One }} get() = {{ T }}Mat3(
            {{ T }}Vec3.{{ One }},
            {{ T }}Vec3.{{ One }},
            {{ T }}Vec3.{{ One }},
        )

        val Identity get() = {{ T }}Mat3(
            {{ one }}, {{ zero }}, {{ zero }},
            {{ zero }}, {{ one }}, {{ zero }},
            {{ zero }}, {{ zero }}, {{ one }},
        )
    }

    constructor(
        xx: {{ Type }}, xy: {{ Type }}, xz: {{ Type }},
        yx: {{ Type }}, yy: {{ Type }}, yz: {{ Type }},
        zx: {{ Type }}, zy: {{ Type }}, zz: {{ Type }},
    ) : this(
        {{ T }}Vec3(xx, yx, zx),
        {{ T }}Vec3(xy, yy, zy),
        {{ T }}Vec3(xz, yz, zz),
    )

    constructor(s: {{ Type }}) : this(
        s, s, s,
        s, s, s,
        s, s, s,
    )

    operator fun get(col: Int) = when (col) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Int, row: Int) = get(col)[row]

    fun compareTo(m: {{ T }}Mat3) = IMat3(x.compareTo(m.x), y.compareTo(m.y), z.compareTo(m.z))
    fun toArray() = {{ arrayOf }}(
        x.x, x.y, x.z,
        y.x, y.y, y.z,
        z.x, z.y, z.z,
    )

    fun asString(fmt: String) = """
        [
          $fmt $fmt $fmt
          $fmt $fmt $fmt
          $fmt $fmt $fmt
        ]
    """.trimIndent().format(
        x.x, y.x, z.x,
        x.y, y.y, z.y,
        x.z, y.z, z.z,
    )
    override fun toString() = asString("{{ toStringFormat }}")

    inline fun mapVector(block: ({{ T }}Vec3) -> {{ T }}Vec3) = {{ T }}Mat3(block(x), block(y), block(z))
    inline fun mapScalar(block: ({{ Type }}) -> {{ Type }}) = {{ T }}Mat3(x.map(block), y.map(block), z.map(block))

{% if isNumber %}
    inline operator fun unaryMinus() = {{ T }}Mat3(-x, -y, -z)

    @JvmName("add")
    inline operator fun plus (s: {{ Type }}) = {{ T }}Mat3(x + s, y + s, z + s)
    @JvmName("sub")
    inline operator fun minus(s: {{ Type }}) = {{ T }}Mat3(x - s, y - s, z - s)
    @JvmName("mul")
    inline operator fun times(s: {{ Type }}) = {{ T }}Mat3(x * s, y * s, z * s)

    @JvmName("add")
    inline operator fun plus (m: {{ T }}Mat3) = {{ T }}Mat3(x + m.x, y + m.y, z + m.z)
    @JvmName("sub")
    inline operator fun minus(m: {{ T }}Mat3) = {{ T }}Mat3(x - m.x, y - m.y, z - m.z)

    @JvmName("mul")
    inline operator fun times(m: {{ T }}Mat3) = {{ T }}Mat3(
        x.x * m.x.x + y.x * m.x.y + z.x * m.x.z,  x.y * m.x.x + y.y * m.x.y + z.y * m.x.z,  x.z * m.x.x + y.z * m.x.y + z.z * m.x.z,
        x.x * m.y.x + y.x * m.y.y + z.x * m.y.z,  x.y * m.y.x + y.y * m.y.y + z.y * m.y.z,  x.z * m.y.x + y.z * m.y.y + z.z * m.y.z,
        x.x * m.z.x + y.x * m.z.y + z.x * m.z.z,  x.y * m.z.x + y.y * m.z.y + z.y * m.z.z,  x.z * m.z.x + y.z * m.z.y + z.z * m.z.z,
    )
{% endif %}
}

{% if isNumber %}
@JvmName("add")
inline operator fun {{ Type }}.plus (m: {{ T }}Mat3) = {{ T }}Mat3(this + m.x, this + m.y, this + m.z)
@JvmName("sub")
inline operator fun {{ Type }}.minus(m: {{ T }}Mat3) = {{ T }}Mat3(this - m.x, this - m.y, this - m.z)
@JvmName("mul")
inline operator fun {{ Type }}.times(m: {{ T }}Mat3) = {{ T }}Mat3(this * m.x, this * m.y, this * m.z)
{% endif %}

inline fun transpose(m: {{ T }}Mat3) = {{ T }}Mat3(
    m[0, 0], m[0, 1], m[0, 2],
    m[1, 0], m[1, 1], m[1, 2],
    m[2, 0], m[2, 1], m[2, 2],
)

{% if isNumber %}
inline fun determinant(m: {{ T }}Mat3) =
    m[0, 0] * (m[1, 1] * m[2, 2] - m[2, 1] * m[1, 2]) -
    m[1, 0] * (m[0, 1] * m[2, 2] - m[2, 1] * m[0, 2]) +
    m[2, 0] * (m[0, 1] * m[1, 2] - m[1, 1] * m[0, 2])

{% if isDecimal %}
inline fun inverse(m: {{ T }}Mat3) = {{ T }}Mat3(
      (m[1, 1] * m[2, 2] - m[2, 1] * m[1, 2]), - (m[1, 0] * m[2, 2] - m[2, 0] * m[1, 2]),   (m[1, 0] * m[2, 1] - m[2, 0] * m[1, 1]),
    - (m[0, 1] * m[2, 2] - m[2, 1] * m[0, 2]),   (m[0, 0] * m[2, 2] - m[2, 0] * m[0, 2]), - (m[0, 0] * m[2, 1] - m[2, 0] * m[0, 1]),
      (m[0, 1] * m[1, 2] - m[1, 1] * m[0, 2]), - (m[0, 0] * m[1, 2] - m[1, 0] * m[0, 2]),   (m[0, 0] * m[1, 1] - m[1, 0] * m[0, 1]),
) * ({{ one }} / determinant(m))
{% endif %}
{% endif %}
