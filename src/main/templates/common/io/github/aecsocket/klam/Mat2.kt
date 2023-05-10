@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Mat2(
    @JvmField val x: {{ T }}Vec2,
    @JvmField val y: {{ T }}Vec2,
) {
    companion object {
        val {{ Zero }} get() = {{ T }}Mat2(
            {{ T }}Vec2.{{ Zero }},
            {{ T }}Vec2.{{ Zero }},
        )

        val {{ One }} get() = {{ T }}Mat2(
            {{ T }}Vec2.{{ One }},
            {{ T }}Vec2.{{ One }},
        )

        val Identity get() = {{ T }}Mat2(
            {{ one }}, {{ zero }},
            {{ zero }}, {{ one }},
        )
    }

    constructor(
        xx: {{ Type }}, xy: {{ Type }},
        yx: {{ Type }}, yy: {{ Type }},
    ) : this(
        {{ T }}Vec2(xx, yx),
        {{ T }}Vec2(xy, yy),
    )

    constructor(s: {{ Type }}) : this(
        s, s,
        s, s,
    )

    operator fun get(col: Int) = when (col) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Int, row: Int) = get(col)[row]

    fun compareTo(m: {{ T }}Mat2) = IMat2(x.compareTo(m.x), y.compareTo(m.y))
    fun toArray() = {{ arrayOf }}(
        x.x, x.y,
        y.x, y.y,
    )

    fun asString(fmt: String) = """
        [
          $fmt $fmt
          $fmt $fmt
        ]
    """.trimIndent().format(
        x.x, y.x,
        x.y, y.y,
    )
    override fun toString() = asString("{{ toStringFormat }}")

    inline fun mapVector(block: ({{ T }}Vec2) -> {{ T }}Vec2) = {{ T }}Mat2(block(x), block(y))
    inline fun mapScalar(block: ({{ Type }}) -> {{ Type }}) = {{ T }}Mat2(x.map(block), y.map(block))

{% if isNumber %}
    inline operator fun unaryMinus() = {{ T }}Mat2(-x, -y)

    @JvmName("add")
    inline operator fun plus (s: {{ Type }}) = {{ T }}Mat2(x + s, y + s)
    @JvmName("sub")
    inline operator fun minus(s: {{ Type }}) = {{ T }}Mat2(x - s, y - s)
    @JvmName("mul")
    inline operator fun times(s: {{ Type }}) = {{ T }}Mat2(x * s, y * s)

    @JvmName("add")
    inline operator fun plus (m: {{ T }}Mat2) = {{ T }}Mat2(x + m.x, y + m.y)
    @JvmName("sub")
    inline operator fun minus(m: {{ T }}Mat2) = {{ T }}Mat2(x - m.x, y - m.y)

    @JvmName("mul")
    inline operator fun times(m: {{ T }}Mat2) = {{ T }}Mat2(
        x.x * m.x.x + y.x * m.x.y,  x.y * m.x.x + y.y * m.x.y,
        x.x * m.y.x + y.x * m.y.y,  x.y * m.y.x + y.y * m.y.y,
    )
{% endif %}
}

{% if isNumber %}
@JvmName("add")
inline operator fun {{ Type }}.plus (m: {{ T }}Mat2) = {{ T }}Mat2(this + m.x, this + m.y)
@JvmName("sub")
inline operator fun {{ Type }}.minus(m: {{ T }}Mat2) = {{ T }}Mat2(this - m.x, this - m.y)
@JvmName("mul")
inline operator fun {{ Type }}.times(m: {{ T }}Mat2) = {{ T }}Mat2(this * m.x, this * m.y)
{% endif %}

inline fun transpose(m: {{ T }}Mat2) = {{ T }}Mat2(
    m[0, 0], m[0, 1],
    m[1, 0], m[1, 1],
)

{% if isNumber %}
inline fun determinant(m: {{ T }}Mat2) =
    m[0, 0] * m[1, 1] -
    m[1, 0] * m[0, 1]

{% if isDecimal %}
inline fun inverse(m: {{ T }}Mat2) = {{ T }}Mat2(
     m[1, 1], -m[0, 1],
    -m[1, 0],  m[0, 0],
) * ({{ one }} / determinant(m))
{% endif %}
{% endif %}
