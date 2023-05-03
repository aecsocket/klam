@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

private const val TO_STRING_FORMAT = "%f"
private inline fun typeArrayOf(vararg elements: Double) = doubleArrayOf(*elements)

data class DMat2(@JvmField val x: DVec2, @JvmField val y: DVec2) {
    companion object {
        val Identity = DMat2(
            1.0, 0.0,
            0.0, 1.0,
        )
    }

    constructor(m: DMat2) : this(DVec2(m.x), DVec2(m.y))
    constructor(
        xx: Double, xy: Double,
        yx: Double, yy: Double,
    ) : this(
        DVec2(xx, yx),
        DVec2(xy, yy),
    )
    constructor(s: Double) : this(
        s, s,
        s, s,
    )

    fun from(
        xx: Double, xy: Double,
        yx: Double, yy: Double,
    ) { x.from(xx, yx); y.from(xy, yy) }
    fun from(x: DVec2, y: DVec2) { this.x.from(x); this.y.from(y); }
    fun from(m: DMat2) = from(m.x, m.y)

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    fun compareTo(m: DMat2) = IMat2(x.compareTo(m.x), y.compareTo(m.y))
    fun equalTo(v: DMat2)   = x.equalTo(v.x) && y.equalTo(v.y)
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

    inline fun mapVector(block: (DVec2) -> DVec2) = DMat2(block(x), block(y))
    inline fun mapScalar(block: (Double) -> Double) = DMat2(x.map(block), y.map(block))

    inline operator fun unaryMinus() = DMat2(-x, -y)
    inline operator fun inc()        = DMat2(x + 1.0, y + 1.0)
    inline operator fun dec()        = DMat2(x - 1.0, y - 1.0)

    inline operator fun plus(s: Double)  = DMat2(x + s, y + s)
    inline operator fun minus(s: Double) = DMat2(x - s, y - s)
    inline operator fun times(s: Double) = DMat2(x * s, y * s)

    inline operator fun plusAssign(s: Double)  { x += s; y += s }
    inline operator fun minusAssign(s: Double) { x -= s; y -= s }
    inline operator fun timesAssign(s: Double) { x *= s; y *= s }

    inline operator fun plus(m: DMat2)  = DMat2(x + m.x, y + m.y)
    inline operator fun minus(m: DMat2) = DMat2(x - m.x, y - m.y)
    inline operator fun times(m: DMat2) = DMat2(this).apply { this *= m }

    inline operator fun plusAssign(m: DMat2)  { x += m.x; y += m.y }
    inline operator fun minusAssign(m: DMat2) { x -= m.x; y -= m.y }
    inline operator fun timesAssign(m: DMat2) {
        from(
            x.x*m.x.x + y.x*m.x.y,  x.y*m.x.x + y.y*m.x.y,
            x.x*m.y.x + y.x*m.y.y,  x.y*m.y.x + y.y*m.y.y,
        )
    }

    inline operator fun times(v: DVec2) = DVec2(
        x.x*v.x + y.x*v.y,
        y.x*v.x + y.y*v.y,
    )
}

inline operator fun Double.plus(m: DMat2)  = DMat2(this + m.x, this + m.y)
inline operator fun Double.minus(m: DMat2) = DMat2(this - m.x, this - m.y)
inline operator fun Double.times(m: DMat2) = DMat2(this * m.x, this * m.y)

data class DMat3(@JvmField val x: DVec3, @JvmField val y: DVec3, @JvmField val z: DVec3) {
    companion object {
        val Identity = DMat3(
            1.0, 0.0, 0.0,
            0.0, 1.0, 0.0,
            0.0, 0.0, 1.0,
        )
    }

    constructor(m: DMat3) : this(DVec3(m.x), DVec3(m.y), DVec3(m.z))
    constructor(
        xx: Double, xy: Double, xz: Double,
        yx: Double, yy: Double, yz: Double,
        zx: Double, zy: Double, zz: Double,
    ) : this(
        DVec3(xx, yx, zx),
        DVec3(xy, yy, zy),
        DVec3(xz, yz, zz),
    )
    constructor(s: Double) : this(
        s, s, s,
        s, s, s,
        s, s, s,
    )

    fun from(
        xx: Double, xy: Double, xz: Double,
        yx: Double, yy: Double, yz: Double,
        zx: Double, zy: Double, zz: Double,
    ) { x.from(xx, yx, zx); y.from(xy, yy, zy); z.from(xz, yz, zz) }
    fun from(x: DVec3, y: DVec3, z: DVec3) { this.x.from(x); this.y.from(y); this.z.from(z) }
    fun from(m: DMat3) = from(m.x, m.y, m.z)

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    fun compareTo(m: DMat3) = IMat3(x.compareTo(m.x), y.compareTo(m.y), z.compareTo(m.z))
    fun equalTo(v: DMat3)   = x.equalTo(v.x) && y.equalTo(v.y) && z.equalTo(v.z)
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

    inline fun mapVector(block: (DVec3) -> DVec3) = DMat3(block(x), block(y), block(z))
    inline fun mapScalar(block: (Double) -> Double) = DMat3(x.map(block), y.map(block), z.map(block))

    inline operator fun unaryMinus() = DMat3(-x, -y, -z)
    inline operator fun inc()        = DMat3(x + 1.0, y + 1.0, z + 1.0)
    inline operator fun dec()        = DMat3(x - 1.0, y - 1.0, z - 1.0)

    inline operator fun plus(s: Double)  = DMat3(x + s, y + s, z + s)
    inline operator fun minus(s: Double) = DMat3(x - s, y - s, z - s)
    inline operator fun times(s: Double) = DMat3(x * s, y * s, z * s)

    inline operator fun plusAssign(s: Double)  { x += s; y += s; z += s }
    inline operator fun minusAssign(s: Double) { x -= s; y -= s; z -= s }
    inline operator fun timesAssign(s: Double) { x *= s; y *= s; z *= s }

    inline operator fun plus(m: DMat3)  = DMat3(x + m.x, y + m.y, z + m.z)
    inline operator fun minus(m: DMat3) = DMat3(x - m.x, y - m.y, z - m.z)
    inline operator fun times(m: DMat3) = DMat3(this).apply { this *= m }

    inline operator fun plusAssign(m: DMat3)  { x += m.x; y += m.y; z += m.z }
    inline operator fun minusAssign(m: DMat3) { x -= m.x; y -= m.y; z -= m.z }
    inline operator fun timesAssign(m: DMat3) {
        from(
            x.x*m.x.x + y.x*m.x.y + z.x*m.x.z,  x.y*m.x.x + y.y*m.x.y + z.y*m.x.z,  x.z*m.x.x + y.z*m.x.y + z.z*m.x.z,
            x.x*m.y.x + y.x*m.y.y + z.x*m.y.z,  x.y*m.y.x + y.y*m.y.y + z.y*m.y.z,  x.z*m.y.x + y.z*m.y.y + z.z*m.y.z,
            x.x*m.z.x + y.x*m.z.y + z.x*m.z.z,  x.y*m.z.x + y.y*m.z.y + z.y*m.z.z,  x.z*m.z.x + y.z*m.z.y + z.z*m.z.z,
        )
    }

    inline operator fun times(v: DVec3) = DVec3(
        x.x*v.x + y.x*v.y + z.x*v.z,
        x.y*v.x + y.y*v.y + z.y*v.z,
        x.z*v.x + y.z*v.y + z.z*v.z,
    )
}

inline operator fun Double.plus(m: DMat3)  = DMat3(this + m.x, this + m.y, this + m.z)
inline operator fun Double.minus(m: DMat3) = DMat3(this - m.x, this - m.y, this - m.z)
inline operator fun Double.times(m: DMat3) = DMat3(this * m.x, this * m.y, this * m.z)

data class DMat4(@JvmField val x: DVec4, @JvmField val y: DVec4, @JvmField val z: DVec4, @JvmField val w: DVec4) {
    companion object {
        val Identity = DMat4(
            1.0, 0.0, 0.0, 0.0,
            0.0, 1.0, 0.0, 0.0,
            0.0, 0.0, 1.0, 0.0,
            0.0, 0.0, 0.0, 1.0,
        )
    }

    constructor(m: DMat4) : this(DVec4(m.x), DVec4(m.y), DVec4(m.z), DVec4(m.w))
    constructor(
        xx: Double, xy: Double, xz: Double, xw: Double,
        yx: Double, yy: Double, yz: Double, yw: Double,
        zx: Double, zy: Double, zz: Double, zw: Double,
        wx: Double, wy: Double, wz: Double, ww: Double,
    ) : this(
        DVec4(xx, yx, zx, wx),
        DVec4(xy, yy, zy, wy),
        DVec4(xz, yz, zz, wz),
        DVec4(xw, yw, zw, ww),
    )
    constructor(s: Double) : this(
        s, s, s, s,
        s, s, s, s,
        s, s, s, s,
        s, s, s, s,
    )

    fun from(
        xx: Double, xy: Double, xz: Double, xw: Double,
        yx: Double, yy: Double, yz: Double, yw: Double,
        zx: Double, zy: Double, zz: Double, zw: Double,
        wx: Double, wy: Double, wz: Double, ww: Double,
    ) { x.from(xx, yx, zx, wx); y.from(xy, yy, zy, wy); z.from(xz, yz, zz, wz); w.from(xw, yw, zw, ww) }
    fun from(x: DVec4, y: DVec4, z: DVec4, w: DVec4) { this.x.from(x); this.y.from(y); this.z.from(z); this.w.from(w) }
    fun from(m: DMat4) = from(m.x, m.y, m.z, m.w)

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    fun compareTo(m: DMat4) = IMat4(x.compareTo(m.x), y.compareTo(m.y), z.compareTo(m.z), w.compareTo(m.w))
    fun equalTo(v: DMat4)   = x.equalTo(v.x) && y.equalTo(v.y) && z.equalTo(v.z) && w.equalTo(v.w)
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

    inline fun mapVector(block: (DVec4) -> DVec4) = DMat4(block(x), block(y), block(z), block(w))
    inline fun mapScalar(block: (Double) -> Double) = DMat4(x.map(block), y.map(block), z.map(block), w.map(block))

    inline operator fun unaryMinus() = DMat4(-x, -y, -z, -w)
    inline operator fun inc()        = DMat4(x + 1.0, y + 1.0, z + 1.0, w + 1.0)
    inline operator fun dec()        = DMat4(x - 1.0, y - 1.0, z - 1.0, w - 1.0)

    inline operator fun plus(s: Double)  = DMat4(x + s, y + s, z + s, w + s)
    inline operator fun minus(s: Double) = DMat4(x - s, y - s, z - s, w - s)
    inline operator fun times(s: Double) = DMat4(x * s, y * s, z * s, w * s)

    inline operator fun plusAssign(s: Double)  { x += s; y += s; z += s; w += s }
    inline operator fun minusAssign(s: Double) { x -= s; y -= s; z -= s; w -= s }
    inline operator fun timesAssign(s: Double) { x *= s; y *= s; z *= s; w *= s }

    inline operator fun plus(m: DMat4)  = DMat4(x + m.x, y + m.y, z + m.z, w + m.w)
    inline operator fun minus(m: DMat4) = DMat4(x - m.x, y - m.y, z - m.z, w + m.w)
    inline operator fun times(m: DMat4) = DMat4(this).apply { this *= m }

    inline operator fun plusAssign(m: DMat4)  { x += m.x; y += m.y; z += m.z; w += m.w }
    inline operator fun minusAssign(m: DMat4) { x -= m.x; y -= m.y; z -= m.z; w -= m.w }
    inline operator fun timesAssign(m: DMat4) {
        from(
            x.x*m.x.x + y.x*m.x.y + z.x*m.x.z + w.x*m.x.w,  x.y*m.x.x + y.y*m.x.y + z.y*m.x.z + w.y*m.x.w,  x.z*m.x.x + y.z*m.x.y + z.z*m.x.z + w.z*m.x.w,  x.w*m.x.x + y.w*m.x.y + z.w*m.x.z + w.w*m.x.w,
            x.x*m.y.x + y.x*m.y.y + z.x*m.y.z + w.x*m.y.w,  x.y*m.y.x + y.y*m.y.y + z.y*m.y.z + w.y*m.y.w,  x.z*m.y.x + y.z*m.y.y + z.z*m.y.z + w.z*m.y.w,  x.w*m.y.x + y.w*m.y.y + z.w*m.y.z + w.w*m.y.w,
            x.x*m.z.x + y.x*m.z.y + z.x*m.z.z + w.x*m.z.w,  x.y*m.z.x + y.y*m.z.y + z.y*m.z.z + w.y*m.z.w,  x.z*m.z.x + y.z*m.z.y + z.z*m.z.z + w.z*m.z.w,  x.w*m.z.x + y.w*m.z.y + z.w*m.z.z + w.w*m.z.w,
            x.x*m.w.x + y.x*m.w.y + z.x*m.w.z + w.x*m.w.w,  x.y*m.w.x + y.y*m.w.y + z.y*m.w.z + w.y*m.w.w,  x.z*m.w.x + y.z*m.w.y + z.z*m.w.z + w.z*m.w.w,  x.w*m.w.x + y.w*m.w.y + z.w*m.w.z + w.w*m.w.w,
        )
    }

    inline operator fun times(v: DVec4) = DVec4(
        x.x*v.x + y.x*v.y + z.x*v.z + w.x*v.w,
        x.y*v.x + y.y*v.y + z.y*v.z + w.y*v.w,
        x.z*v.x + y.z*v.y + z.z*v.z + w.z*v.w,
        x.w*v.x + y.w*v.y + z.w*v.z + w.w*v.w,
    )
}

inline operator fun Double.plus(m: DMat4)  = DMat4(this + m.x, this + m.y, this + m.z, this + m.w)
inline operator fun Double.minus(m: DMat4) = DMat4(this - m.x, this - m.y, this - m.z, this - m.w)
inline operator fun Double.times(m: DMat4) = DMat4(this * m.x, this * m.y, this * m.z, this * m.w)
