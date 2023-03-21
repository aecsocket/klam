@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

data class FMat2(@JvmField var x: FVec2, @JvmField var y: FVec2) {
    companion object {
        fun identity() = FMat2(
            1.0f, 0.0f,
            0.0f, 1.0f,
        )
    }

    constructor(m: FMat2) : this(FVec2(m.x), FVec2(m.y))
    constructor(
        xx: Float, xy: Float,
        yx: Float, yy: Float,
    ) : this(
        FVec2(xx, xy),
        FVec2(yx, yy),
    )
    constructor(s: Float) : this(
        s, s,
        s, s,
    )

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    inline operator fun unaryMinus() = FMat2( -x,  -y)
    inline operator fun inc()        = FMat2(++x, ++y)
    inline operator fun dec()        = FMat2(--x, --y)

    inline operator fun plus(s: Float)  = FMat2(x + s, y + s)
    inline operator fun minus(s: Float) = FMat2(x - s, y - s)
    inline operator fun times(s: Float) = FMat2(x * s, y * s)
    inline operator fun div(s: Float)   = FMat2(x / s, y / s)

    inline operator fun plus(v: FVec2)  = FMat2(x + v.x, y + v.y)
    inline operator fun minus(v: FVec2) = FMat2(x - v.x, y - v.y)
    inline operator fun times(v: FVec2) = FMat2(x * v.x, y * v.y)
    inline operator fun div(v: FVec2)   = FMat2(x / v.x, y / v.y)

    inline fun compareTo(m: FMat2) = IMat2(x.compareTo(m.x), y.compareTo(m.y))
    inline fun equalTo(v: FMat2)   = x.equalTo(v.x) && y.equalTo(v.y)

    inline fun map(block: (Float) -> Float) = FMat2(x.map(block), y.map(block))
    inline fun toArray() = floatArrayOf(
        x.x, x.y,
        y.x, y.y,
    )

    inline fun asString(fmt: String = "%f") = """
        [
          $fmt $fmt
          $fmt $fmt
        ]
    """.trimIndent().format(
        x.x, x.y,
        y.x, y.y,
    )
    override fun toString() = asString(DECIMAL_FORMAT)
}