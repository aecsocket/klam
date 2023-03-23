@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

data class IMat2(@JvmField val x: IVec2, @JvmField val y: IVec2) {
    companion object {
        val Identity = IMat2(
            1, 0,
            0, 1,
        )
    }

    constructor(m: IMat2) : this(m.x, m.y)
    constructor(
        xx: Int, xy: Int,
        yx: Int, yy: Int,
    ) : this(
        IVec2(xx, yx),
        IVec2(xy, yy),
    )
    constructor(s: Int) : this(
        s, s,
        s, s,
    )

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    inline operator fun unaryMinus() = IMat2( -x,  -y)

    inline operator fun plus(s: Int)  = IMat2(x + s, y + s)
    inline operator fun minus(s: Int) = IMat2(x - s, y - s)
    inline operator fun times(s: Int) = IMat2(x * s, y * s)
    inline operator fun div(s: Int)   = IMat2(x / s, y / s)

    inline operator fun times(m: IMat2) = IMat2(
        IVec2(
            x.x*m.x.x + y.x*m.x.y,
            x.y*m.x.x + y.y*m.x.y,
        ),
        IVec2(
            x.x*m.y.x + y.x*m.y.y,
            x.y*m.y.x + y.y*m.y.y,
        ),
    )
    inline operator fun times(v: IVec2) = IVec2(
        x.x*v.x + y.x*v.y,
        x.y*v.x + y.y*v.y,
    )

    inline fun compareTo(m: IMat2) = IMat2(x.compareTo(m.x), y.compareTo(m.y))
    inline fun equalTo(v: IMat2)   = x.equalTo(v.x) && y.equalTo(v.y)

    inline fun map(block: (Int) -> Int) = IMat2(x.map(block), y.map(block))
    inline fun toArray() = intArrayOf(
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

data class IMat3(@JvmField val x: IVec3, @JvmField val y: IVec3, @JvmField val z: IVec3) {
    companion object {
        val Identity = IMat3(
            1, 0, 0,
            0, 1, 0,
            0, 0, 1,
        )
    }

    constructor(m: IMat3) : this(m.x, m.y, m.z)
    constructor(
        xx: Int, xy: Int, xz: Int,
        yx: Int, yy: Int, yz: Int,
        zx: Int, zy: Int, zz: Int,
    ) : this(
        IVec3(xx, yx, zx),
        IVec3(xy, yy, zy),
        IVec3(xz, yz, zz),
    )
    constructor(s: Int) : this(
        s, s, s,
        s, s, s,
        s, s, s,
    )

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    inline operator fun unaryMinus() = IMat3( -x,  -y,  -z)

    inline operator fun plus(s: Int)  = IMat3(x + s, y + s, z + s)
    inline operator fun minus(s: Int) = IMat3(x - s, y - s, z - s)
    inline operator fun times(s: Int) = IMat3(x * s, y * s, z * s)
    inline operator fun div(s: Int)   = IMat3(x / s, y / s, z / s)

    inline fun compareTo(m: IMat3) = IMat3(x.compareTo(m.x), y.compareTo(m.y), z.compareTo(m.z))
    inline fun equalTo(v: IMat3)   = x.equalTo(v.x) && y.equalTo(v.y) && z.equalTo(v.z)

    inline fun map(block: (Int) -> Int) = IMat3(x.map(block), y.map(block), z.map(block))
    inline fun toArray() = intArrayOf(
        x.x, x.y, x.z,
        y.x, y.y, y.z,
        z.x, z.y, z.z,
    )

    inline fun asString(fmt: String = "%f") = """
        [
          $fmt $fmt $fmt
          $fmt $fmt $fmt
          $fmt $fmt $fmt
        ]
    """.trimIndent().format(
        x.x, x.y, x.z,
        y.x, y.y, y.z,
        z.x, z.y, z.z,
    )
    override fun toString() = asString(DECIMAL_FORMAT)
}

data class IMat4(@JvmField val x: IVec4, @JvmField val y: IVec4, @JvmField val z: IVec4, @JvmField val w: IVec4) {
    companion object {
        val Identity = IMat4(
            1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1,
        )
    }

    constructor(m: IMat4) : this(m.x, m.y, m.z, m.w)
    constructor(
        xx: Int, xy: Int, xz: Int, xw: Int,
        yx: Int, yy: Int, yz: Int, yw: Int,
        zx: Int, zy: Int, zz: Int, zw: Int,
        wx: Int, wy: Int, wz: Int, ww: Int,
    ) : this(
        IVec4(xx, yx, zx, wx),
        IVec4(xy, yy, zy, wy),
        IVec4(xz, yz, zz, wz),
        IVec4(xw, yw, zw, ww),
    )
    constructor(s: Int) : this(
        s, s, s, s,
        s, s, s, s,
        s, s, s, s,
        s, s, s, s,
    )

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    inline operator fun unaryMinus() = IMat4( -x,  -y,  -z,  -w)

    inline operator fun plus(s: Int)  = IMat4(x + s, y + s, z + s, w + s)
    inline operator fun minus(s: Int) = IMat4(x - s, y - s, z - s, w + s)
    inline operator fun times(s: Int) = IMat4(x * s, y * s, z * s, w * s)
    inline operator fun div(s: Int)   = IMat4(x / s, y / s, z / s, w / s)

    inline fun compareTo(m: IMat4) = IMat4(x.compareTo(m.x), y.compareTo(m.y), z.compareTo(m.z), w.compareTo(m.w))
    inline fun equalTo(v: IMat4)   = x.equalTo(v.x) && y.equalTo(v.y) && z.equalTo(v.z) && w.equalTo(v.w)

    inline fun map(block: (Int) -> Int) = IMat4(x.map(block), y.map(block), z.map(block), w.map(block))
    inline fun toArray() = intArrayOf(
        x.x, x.y, x.z, x.w,
        y.x, y.y, y.z, y.w,
        z.x, z.y, z.z, z.w,
        w.x, w.y, w.z, w.w,
    )

    inline fun asString(fmt: String = "%f") = """
        [
          $fmt $fmt $fmt $fmt
          $fmt $fmt $fmt $fmt
          $fmt $fmt $fmt $fmt
          $fmt $fmt $fmt $fmt
        ]
    """.trimIndent().format(
        x.x, x.y, x.z, x.w,
        y.x, y.y, y.z, y.w,
        z.x, z.y, z.z, z.w,
        w.x, w.y, w.z, w.w,
    )
    override fun toString() = asString(DECIMAL_FORMAT)
}
