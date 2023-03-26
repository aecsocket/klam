@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

private const val TO_STRING_FORMAT = "%d"
private inline fun typeArrayOf(vararg elements: Int) = intArrayOf(*elements)

data class IMat2(@JvmField val x: IVec2, @JvmField val y: IVec2) {
    companion object {
        val Identity = IMat2(
            1, 0,
            0, 1,
        )
    }

    constructor(m: IMat2) : this(IVec2(m.x), IVec2(m.y))
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

    fun from(
        xx: Int, xy: Int,
        yx: Int, yy: Int,
    ) { x.from(xx, yx); y.from(xy, yy) }
    fun from(x: IVec2, y: IVec2) { this.x.from(x); this.y.from(y); }
    fun from(m: IMat2) = from(m.x, m.y)

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    fun compareTo(m: IMat2) = IMat2(x.compareTo(m.x), y.compareTo(m.y))
    fun equalTo(v: IMat2)   = x.equalTo(v.x) && y.equalTo(v.y)
    fun toArray() = typeArrayOf(
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
    override fun toString() = asString(TO_STRING_FORMAT)
}

inline fun IMat2.mapVector(block: (IVec2) -> IVec2) = IMat2(block(x), block(y))
inline fun IMat2.mapScalar(block: (Int) -> Int) = IMat2(x.map(block), y.map(block))

inline operator fun IMat2.unaryMinus() = IMat2(-x, -y)
inline operator fun IMat2.inc()        = IMat2(x + 1, y + 1)
inline operator fun IMat2.dec()        = IMat2(x - 1, y - 1)

inline operator fun IMat2.plus(s: Int)  = IMat2(x + s, y + s)
inline operator fun IMat2.minus(s: Int) = IMat2(x - s, y - s)
inline operator fun IMat2.times(s: Int) = IMat2(x * s, y * s)

inline operator fun Int.plus(m: IMat2)  = IMat2(this + m.x, this + m.y)
inline operator fun Int.minus(m: IMat2) = IMat2(this - m.x, this - m.y)
inline operator fun Int.times(m: IMat2) = IMat2(this * m.x, this * m.y)

inline operator fun IMat2.plusAssign(s: Int)  { x += s; y += s }
inline operator fun IMat2.minusAssign(s: Int) { x -= s; y -= s }
inline operator fun IMat2.timesAssign(s: Int) { x *= s; y *= s }

inline operator fun IMat2.plus(m: IMat2)  = IMat2(x + m.x, y + m.y)
inline operator fun IMat2.minus(m: IMat2) = IMat2(x - m.x, y - m.y)
inline operator fun IMat2.times(m: IMat2) = IMat2(this).apply { this *= m }

inline operator fun IMat2.plusAssign(m: IMat2)  { x += m.x; y += m.y }
inline operator fun IMat2.minusAssign(m: IMat2) { x -= m.x; y -= m.y }
inline operator fun IMat2.timesAssign(m: IMat2) {
    from(
        x.x*m.x.x + y.x*m.x.y,  x.y*m.x.x + y.y*m.x.y,
        x.x*m.y.x + y.x*m.y.y,  x.y*m.y.x + y.y*m.y.y,
    )
}

inline operator fun IMat2.times(v: IVec2) = IVec2(
    x.x*v.x + y.x*v.y,
    y.x*v.x + y.y*v.y,
)

data class IMat3(@JvmField val x: IVec3, @JvmField val y: IVec3, @JvmField val z: IVec3) {
    companion object {
        val Identity = IMat3(
            1, 0, 0,
            0, 1, 0,
            0, 0, 1,
        )
    }

    constructor(m: IMat3) : this(IVec3(m.x), IVec3(m.y), IVec3(m.z))
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

    fun from(
        xx: Int, xy: Int, xz: Int,
        yx: Int, yy: Int, yz: Int,
        zx: Int, zy: Int, zz: Int,
    ) { x.from(xx, yx, zx); y.from(xy, yy, zy); z.from(xz, yz, zz) }
    fun from(x: IVec3, y: IVec3, z: IVec3) { this.x.from(x); this.y.from(y); this.z.from(z) }
    fun from(m: IMat3) = from(m.x, m.y, m.z)

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    fun compareTo(m: IMat3) = IMat3(x.compareTo(m.x), y.compareTo(m.y), z.compareTo(m.z))
    fun equalTo(v: IMat3)   = x.equalTo(v.x) && y.equalTo(v.y) && z.equalTo(v.z)
    fun toArray() = typeArrayOf(
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
    override fun toString() = asString(TO_STRING_FORMAT)
}

inline fun IMat3.mapVector(block: (IVec3) -> IVec3) = IMat3(block(x), block(y), block(z))
inline fun IMat3.mapScalar(block: (Int) -> Int) = IMat3(x.map(block), y.map(block), z.map(block))

inline operator fun IMat3.unaryMinus() = IMat3(-x, -y, -z)
inline operator fun IMat3.inc()        = IMat3(x + 1, y + 1, z + 1)
inline operator fun IMat3.dec()        = IMat3(x - 1, y - 1, z - 1)

inline operator fun IMat3.plus(s: Int)  = IMat3(x + s, y + s, z + s)
inline operator fun IMat3.minus(s: Int) = IMat3(x - s, y - s, z - s)
inline operator fun IMat3.times(s: Int) = IMat3(x * s, y * s, z * s)

inline operator fun Int.plus(m: IMat3)  = IMat3(this + m.x, this + m.y, this + m.z)
inline operator fun Int.minus(m: IMat3) = IMat3(this - m.x, this - m.y, this - m.z)
inline operator fun Int.times(m: IMat3) = IMat3(this * m.x, this * m.y, this * m.z)

inline operator fun IMat3.plusAssign(s: Int)  { x += s; y += s; z += s }
inline operator fun IMat3.minusAssign(s: Int) { x -= s; y -= s; z -= s }
inline operator fun IMat3.timesAssign(s: Int) { x *= s; y *= s; z *= s }

inline operator fun IMat3.plus(m: IMat3)  = IMat3(x + m.x, y + m.y, z + m.z)
inline operator fun IMat3.minus(m: IMat3) = IMat3(x - m.x, y - m.y, z - m.z)
inline operator fun IMat3.times(m: IMat3) = IMat3(this).apply { this *= m }

inline operator fun IMat3.plusAssign(m: IMat3)  { x += m.x; y += m.y; z += m.z }
inline operator fun IMat3.minusAssign(m: IMat3) { x -= m.x; y -= m.y; z -= m.z }
inline operator fun IMat3.timesAssign(m: IMat3) {
    from(
        x.x*m.x.x + y.x*m.x.y + z.x*m.x.z,  x.y*m.x.x + y.y*m.x.y + z.y*m.x.z,  x.z*m.x.x + y.z*m.x.y + z.z*m.x.z,
        x.x*m.y.x + y.x*m.y.y + z.x*m.y.z,  x.y*m.y.x + y.y*m.y.y + z.y*m.y.z,  x.z*m.y.x + y.z*m.y.y + z.z*m.y.z,
        x.x*m.z.x + y.x*m.z.y + z.x*m.z.z,  x.y*m.z.x + y.y*m.z.y + z.y*m.z.z,  x.z*m.z.x + y.z*m.z.y + z.z*m.z.z,
    )
}

inline operator fun IMat3.times(v: IVec3) = IVec3(
    x.x*v.x + y.x*v.y + z.x*v.z,
    x.y*v.x + y.y*v.y + z.y*v.z,
    x.z*v.x + y.z*v.y + z.z*v.z,
)

data class IMat4(@JvmField val x: IVec4, @JvmField val y: IVec4, @JvmField val z: IVec4, @JvmField val w: IVec4) {
    companion object {
        val Identity = IMat4(
            1, 0, 0, 0,
            0, 1, 0, 0,
            0, 0, 1, 0,
            0, 0, 0, 1,
        )
    }

    constructor(m: IMat4) : this(IVec4(m.x), IVec4(m.y), IVec4(m.z), IVec4(m.w))
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

    fun from(
        xx: Int, xy: Int, xz: Int, xw: Int,
        yx: Int, yy: Int, yz: Int, yw: Int,
        zx: Int, zy: Int, zz: Int, zw: Int,
        wx: Int, wy: Int, wz: Int, ww: Int,
    ) { x.from(xx, yx, zx, wx); y.from(xy, yy, zy, wy); z.from(xz, yz, zz, wz); w.from(xw, yw, zw, ww) }
    fun from(x: IVec4, y: IVec4, z: IVec4, w: IVec4) { this.x.from(x); this.y.from(y); this.z.from(z); this.w.from(w) }
    fun from(m: IMat4) = from(m.x, m.y, m.z, m.w)

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    fun compareTo(m: IMat4) = IMat4(x.compareTo(m.x), y.compareTo(m.y), z.compareTo(m.z), w.compareTo(m.w))
    fun equalTo(v: IMat4)   = x.equalTo(v.x) && y.equalTo(v.y) && z.equalTo(v.z) && w.equalTo(v.w)
    fun toArray() = typeArrayOf(
        x.x, x.y, x.z, x.w,
        y.x, y.y, y.z, y.w,
        z.x, z.y, z.z, z.w,
        w.x, w.y, w.z, w.w,
    )

    fun asString(fmt: String) = """
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
    override fun toString() = asString(TO_STRING_FORMAT)
}

inline fun IMat4.mapVector(block: (IVec4) -> IVec4) = IMat4(block(x), block(y), block(z), block(w))
inline fun IMat4.mapScalar(block: (Int) -> Int) = IMat4(x.map(block), y.map(block), z.map(block), w.map(block))

inline operator fun IMat4.unaryMinus() = IMat4(-x, -y, -z, -w)
inline operator fun IMat4.inc()        = IMat4(x + 1, y + 1, z + 1, w + 1)
inline operator fun IMat4.dec()        = IMat4(x - 1, y - 1, z - 1, w - 1)

inline operator fun IMat4.plus(s: Int)  = IMat4(x + s, y + s, z + s, w + s)
inline operator fun IMat4.minus(s: Int) = IMat4(x - s, y - s, z - s, w - s)
inline operator fun IMat4.times(s: Int) = IMat4(x * s, y * s, z * s, w * s)

inline operator fun Int.plus(m: IMat4)  = IMat4(this + m.x, this + m.y, this + m.z, this + m.w)
inline operator fun Int.minus(m: IMat4) = IMat4(this - m.x, this - m.y, this - m.z, this - m.w)
inline operator fun Int.times(m: IMat4) = IMat4(this * m.x, this * m.y, this * m.z, this * m.w)

inline operator fun IMat4.plusAssign(s: Int)  { x += s; y += s; z += s; w += s }
inline operator fun IMat4.minusAssign(s: Int) { x -= s; y -= s; z -= s; w -= s }
inline operator fun IMat4.timesAssign(s: Int) { x *= s; y *= s; z *= s; w *= s }

inline operator fun IMat4.plus(m: IMat4)  = IMat4(x + m.x, y + m.y, z + m.z, w + m.w)
inline operator fun IMat4.minus(m: IMat4) = IMat4(x - m.x, y - m.y, z - m.z, w + m.w)
inline operator fun IMat4.times(m: IMat4) = IMat4(this).apply { this *= m }

inline operator fun IMat4.plusAssign(m: IMat4)  { x += m.x; y += m.y; z += m.z; w += m.w }
inline operator fun IMat4.minusAssign(m: IMat4) { x -= m.x; y -= m.y; z -= m.z; w -= m.w }
inline operator fun IMat4.timesAssign(m: IMat4) {
    from(
        x.x*m.x.x + y.x*m.x.y + z.x*m.x.z + w.x*m.x.w,  x.y*m.x.x + y.y*m.x.y + z.y*m.x.z + w.y*m.x.w,  x.z*m.x.x + y.z*m.x.y + z.z*m.x.z + w.z*m.x.w,  x.w*m.x.x + y.w*m.x.y + z.w*m.x.z + w.w*m.x.w,
        x.x*m.y.x + y.x*m.y.y + z.x*m.y.z + w.x*m.y.w,  x.y*m.y.x + y.y*m.y.y + z.y*m.y.z + w.y*m.y.w,  x.z*m.y.x + y.z*m.y.y + z.z*m.y.z + w.z*m.y.w,  x.w*m.y.x + y.w*m.y.y + z.w*m.y.z + w.w*m.y.w,
        x.x*m.z.x + y.x*m.z.y + z.x*m.z.z + w.x*m.z.w,  x.y*m.z.x + y.y*m.z.y + z.y*m.z.z + w.y*m.z.w,  x.z*m.z.x + y.z*m.z.y + z.z*m.z.z + w.z*m.z.w,  x.w*m.z.x + y.w*m.z.y + z.w*m.z.z + w.w*m.z.w,
        x.x*m.w.x + y.x*m.w.y + z.x*m.w.z + w.x*m.w.w,  x.y*m.w.x + y.y*m.w.y + z.y*m.w.z + w.y*m.w.w,  x.z*m.w.x + y.z*m.w.y + z.z*m.w.z + w.z*m.w.w,  x.w*m.w.x + y.w*m.w.y + z.w*m.w.z + w.w*m.w.w,
    )
}

inline operator fun IMat4.times(v: IVec4) = IVec4(
    x.x*v.x + y.x*v.y + z.x*v.z + w.x*v.w,
    x.y*v.x + y.y*v.y + z.y*v.z + w.y*v.w,
    x.z*v.x + y.z*v.y + z.z*v.z + w.z*v.w,
    x.w*v.x + y.w*v.y + z.w*v.z + w.w*v.w,
)
