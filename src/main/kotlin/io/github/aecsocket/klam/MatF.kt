@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

private const val AS_STRING_FORMAT = "%f"
private const val TO_STRING_FORMAT = "%.3f"
private inline fun typeArrayOf(vararg elements: Float) = floatArrayOf(*elements)

data class FMat2(@JvmField val x: FVec2, @JvmField val y: FVec2) {
    companion object {
        val Identity = FMat2(
            1.0f, 0.0f,
            0.0f, 1.0f,
        )
    }

    constructor(m: FMat2) : this(FVec2(m.x), FVec2(m.y))
    constructor(
        xx: Float, xy: Float,
        yx: Float, yy: Float,
    ) : this(
        FVec2(xx, yx),
        FVec2(xy, yy),
    )
    constructor(s: Float) : this(
        s, s,
        s, s,
    )

    fun from(
        xx: Float, xy: Float,
        yx: Float, yy: Float,
    ) { x.from(xx, yx); y.from(xy, yy) }
    fun from(x: FVec2, y: FVec2) { this.x.from(x); this.y.from(y); }
    fun from(m: FMat2) = from(m.x, m.y)

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    fun compareTo(m: FMat2) = IMat2(x.compareTo(m.x), y.compareTo(m.y))
    fun equalTo(v: FMat2)   = x.equalTo(v.x) && y.equalTo(v.y)
    fun toArray() = typeArrayOf(
        x.x, x.y,
        y.x, y.y,
    )

    fun asString(fmt: String = AS_STRING_FORMAT) = """
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

inline fun FMat2.mapVector(block: (FVec2) -> FVec2) = FMat2(block(x), block(y))
inline fun FMat2.mapScalar(block: (Float) -> Float) = FMat2(x.map(block), y.map(block))

inline operator fun FMat2.unaryMinus() = FMat2(-x, -y)
inline operator fun FMat2.inc()        = FMat2(x + 1.0f, y + 1.0f)
inline operator fun FMat2.dec()        = FMat2(x - 1.0f, y - 1.0f)

inline operator fun FMat2.plus(s: Float)  = FMat2(x + s, y + s)
inline operator fun FMat2.minus(s: Float) = FMat2(x - s, y - s)
inline operator fun FMat2.times(s: Float) = FMat2(x * s, y * s)

inline operator fun Float.plus(m: FMat2)  = FMat2(this + m.x, this + m.y)
inline operator fun Float.minus(m: FMat2) = FMat2(this - m.x, this - m.y)
inline operator fun Float.times(m: FMat2) = FMat2(this * m.x, this * m.y)

inline operator fun FMat2.plusAssign(s: Float)  { x += s; y += s }
inline operator fun FMat2.minusAssign(s: Float) { x -= s; y -= s }
inline operator fun FMat2.timesAssign(s: Float) { x *= s; y *= s }

inline operator fun FMat2.times(m: FMat2) = FMat2(this).apply { this *= m }

inline operator fun FMat2.timesAssign(m: FMat2) {
    from(
        x.x*m.x.x + y.x*m.x.y,  x.y*m.x.x + y.y*m.x.y,
        x.x*m.y.x + y.x*m.y.y,  x.y*m.y.x + y.y*m.y.y,
    )
}

inline operator fun FMat2.times(v: FVec2) = FVec2(
    x.x*v.x + y.x*v.y,
    y.x*v.x + y.y*v.y,
)

data class FMat3(@JvmField val x: FVec3, @JvmField val y: FVec3, @JvmField val z: FVec3) {
    companion object {
        val Identity = FMat3(
            1.0f, 0.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 0.0f, 1.0f,
        )
    }

    constructor(m: FMat3) : this(FVec3(m.x), FVec3(m.y), FVec3(m.z))
    constructor(
        xx: Float, xy: Float, xz: Float,
        yx: Float, yy: Float, yz: Float,
        zx: Float, zy: Float, zz: Float,
    ) : this(
        FVec3(xx, yx, zx),
        FVec3(xy, yy, zy),
        FVec3(xz, yz, zz),
    )
    constructor(s: Float) : this(
        s, s, s,
        s, s, s,
        s, s, s,
    )

    fun from(
        xx: Float, xy: Float, xz: Float,
        yx: Float, yy: Float, yz: Float,
        zx: Float, zy: Float, zz: Float,
    ) { x.from(xx, yx, zx); y.from(xy, yy, zy); z.from(xz, yz, zz) }
    fun from(x: FVec3, y: FVec3, z: FVec3) { this.x.from(x); this.y.from(y); this.z.from(z) }
    fun from(m: FMat3) = from(m.x, m.y, m.z)

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    fun compareTo(m: FMat3) = IMat3(x.compareTo(m.x), y.compareTo(m.y), z.compareTo(m.z))
    fun equalTo(v: FMat3)   = x.equalTo(v.x) && y.equalTo(v.y) && z.equalTo(v.z)
    fun toArray() = typeArrayOf(
        x.x, x.y, x.z,
        y.x, y.y, y.z,
        z.x, z.y, z.z,
    )

    fun asString(fmt: String = AS_STRING_FORMAT) = """
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

inline fun FMat3.mapVector(block: (FVec3) -> FVec3) = FMat3(block(x), block(y), block(z))
inline fun FMat3.mapScalar(block: (Float) -> Float) = FMat3(x.map(block), y.map(block), z.map(block))

inline operator fun FMat3.unaryMinus() = FMat3(-x, -y, -z)
inline operator fun FMat3.inc()        = FMat3(x + 1.0f, y + 1.0f, z + 1.0f)
inline operator fun FMat3.dec()        = FMat3(x - 1.0f, y - 1.0f, z - 1.0f)

inline operator fun FMat3.plus(s: Float)  = FMat3(x + s, y + s, z + s)
inline operator fun FMat3.minus(s: Float) = FMat3(x - s, y - s, z - s)
inline operator fun FMat3.times(s: Float) = FMat3(x * s, y * s, z * s)

inline operator fun Float.plus(m: FMat3)  = FMat3(this + m.x, this + m.y, this + m.z)
inline operator fun Float.minus(m: FMat3) = FMat3(this - m.x, this - m.y, this - m.z)
inline operator fun Float.times(m: FMat3) = FMat3(this * m.x, this * m.y, this * m.z)

inline operator fun FMat3.plusAssign(s: Float)  { x += s; y += s; z += s }
inline operator fun FMat3.minusAssign(s: Float) { x -= s; y -= s; z -= s }
inline operator fun FMat3.timesAssign(s: Float) { x *= s; y *= s; z *= s }

inline operator fun FMat3.times(m: FMat3) = FMat3(this).apply { this *= m }

inline operator fun FMat3.timesAssign(m: FMat3) {
    from(
        x.x*m.x.x + y.x*m.x.y + z.x*m.x.z,  x.y*m.x.x + y.y*m.x.y + z.y*m.x.z,  x.z*m.x.x + y.z*m.x.y + z.z*m.x.z,
        x.x*m.y.x + y.x*m.y.y + z.x*m.y.z,  x.y*m.y.x + y.y*m.y.y + z.y*m.y.z,  x.z*m.y.x + y.z*m.y.y + z.z*m.y.z,
        x.x*m.z.x + y.x*m.z.y + z.x*m.z.z,  x.y*m.z.x + y.y*m.z.y + z.y*m.z.z,  x.z*m.z.x + y.z*m.z.y + z.z*m.z.z,
    )
}

inline operator fun FMat3.times(v: FVec3) = FVec3(
    x.x*v.x + y.x*v.y + z.x*v.z,
    x.y*v.x + y.y*v.y + z.y*v.z,
    x.z*v.x + y.z*v.y + z.z*v.z,
)

data class FMat4(@JvmField val x: FVec4, @JvmField val y: FVec4, @JvmField val z: FVec4, @JvmField val w: FVec4) {
    companion object {
        val Identity = FMat4(
            1.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 1.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 1.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 1.0f,
        )
    }

    constructor(m: FMat4) : this(FVec4(m.x), FVec4(m.y), FVec4(m.z), FVec4(m.w))
    constructor(
        xx: Float, xy: Float, xz: Float, xw: Float,
        yx: Float, yy: Float, yz: Float, yw: Float,
        zx: Float, zy: Float, zz: Float, zw: Float,
        wx: Float, wy: Float, wz: Float, ww: Float,
    ) : this(
        FVec4(xx, yx, zx, wx),
        FVec4(xy, yy, zy, wy),
        FVec4(xz, yz, zz, wz),
        FVec4(xw, yw, zw, ww),
    )
    constructor(s: Float) : this(
        s, s, s, s,
        s, s, s, s,
        s, s, s, s,
        s, s, s, s,
    )

    fun from(
        xx: Float, xy: Float, xz: Float, xw: Float,
        yx: Float, yy: Float, yz: Float, yw: Float,
        zx: Float, zy: Float, zz: Float, zw: Float,
        wx: Float, wy: Float, wz: Float, ww: Float,
    ) { x.from(xx, yx, zx, wx); y.from(xy, yy, zy, wy); z.from(xz, yz, zz, wz); w.from(xw, yw, zw, ww) }
    fun from(x: FVec4, y: FVec4, z: FVec4, w: FVec4) { this.x.from(x); this.y.from(y); this.z.from(z); this.w.from(w) }
    fun from(m: FMat4) = from(m.x, m.y, m.z, m.w)

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    fun compareTo(m: FMat4) = IMat4(x.compareTo(m.x), y.compareTo(m.y), z.compareTo(m.z), w.compareTo(m.w))
    fun equalTo(v: FMat4)   = x.equalTo(v.x) && y.equalTo(v.y) && z.equalTo(v.z) && w.equalTo(v.w)
    fun toArray() = typeArrayOf(
        x.x, x.y, x.z, x.w,
        y.x, y.y, y.z, y.w,
        z.x, z.y, z.z, z.w,
        w.x, w.y, w.z, w.w,
    )

    fun asString(fmt: String = AS_STRING_FORMAT) = """
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

inline fun FMat4.mapVector(block: (FVec4) -> FVec4) = FMat4(block(x), block(y), block(z), block(w))
inline fun FMat4.mapScalar(block: (Float) -> Float) = FMat4(x.map(block), y.map(block), z.map(block), w.map(block))

inline operator fun FMat4.unaryMinus() = FMat4(-x, -y, -z, -w)
inline operator fun FMat4.inc()        = FMat4(x + 1.0f, y + 1.0f, z + 1.0f, w + 1.0f)
inline operator fun FMat4.dec()        = FMat4(x - 1.0f, y - 1.0f, z - 1.0f, w - 1.0f)

inline operator fun FMat4.plus(s: Float)  = FMat4(x + s, y + s, z + s, w + s)
inline operator fun FMat4.minus(s: Float) = FMat4(x - s, y - s, z - s, w - s)
inline operator fun FMat4.times(s: Float) = FMat4(x * s, y * s, z * s, w * s)

inline operator fun Float.plus(m: FMat4)  = FMat4(this + m.x, this + m.y, this + m.z, this + m.w)
inline operator fun Float.minus(m: FMat4) = FMat4(this - m.x, this - m.y, this - m.z, this - m.w)
inline operator fun Float.times(m: FMat4) = FMat4(this * m.x, this * m.y, this * m.z, this * m.w)

inline operator fun FMat4.plusAssign(s: Float)  { x += s; y += s; z += s; w += s }
inline operator fun FMat4.minusAssign(s: Float) { x -= s; y -= s; z -= s; w -= s }
inline operator fun FMat4.timesAssign(s: Float) { x *= s; y *= s; z *= s; w *= s }

inline operator fun FMat4.times(m: FMat4) = FMat4(this).apply { this *= m }

inline operator fun FMat4.timesAssign(m: FMat4) {
    from(
        x.x*m.x.x + y.x*m.x.y + z.x*m.x.z + w.x*m.x.w,  x.y*m.x.x + y.y*m.x.y + z.y*m.x.z + w.y*m.x.w,  x.z*m.x.x + y.z*m.x.y + z.z*m.x.z + w.z*m.x.w,  x.w*m.x.x + y.w*m.x.y + z.w*m.x.z + w.w*m.x.w,
        x.x*m.y.x + y.x*m.y.y + z.x*m.y.z + w.x*m.y.w,  x.y*m.y.x + y.y*m.y.y + z.y*m.y.z + w.y*m.y.w,  x.z*m.y.x + y.z*m.y.y + z.z*m.y.z + w.z*m.y.w,  x.w*m.y.x + y.w*m.y.y + z.w*m.y.z + w.w*m.y.w,
        x.x*m.z.x + y.x*m.z.y + z.x*m.z.z + w.x*m.z.w,  x.y*m.z.x + y.y*m.z.y + z.y*m.z.z + w.y*m.z.w,  x.z*m.z.x + y.z*m.z.y + z.z*m.z.z + w.z*m.z.w,  x.w*m.z.x + y.w*m.z.y + z.w*m.z.z + w.w*m.z.w,
        x.x*m.w.x + y.x*m.w.y + z.x*m.w.z + w.x*m.w.w,  x.y*m.w.x + y.y*m.w.y + z.y*m.w.z + w.y*m.w.w,  x.z*m.w.x + y.z*m.w.y + z.z*m.w.z + w.z*m.w.w,  x.w*m.w.x + y.w*m.w.y + z.w*m.w.z + w.w*m.w.w,
    )
}

inline operator fun FMat4.times(v: FVec4) = FVec4(
    x.x*v.x + y.x*v.y + z.x*v.z + w.x*v.w,
    x.y*v.x + y.y*v.y + z.y*v.z + w.y*v.w,
    x.z*v.x + y.z*v.y + z.z*v.z + w.z*v.w,
    x.w*v.x + y.w*v.y + z.w*v.z + w.w*v.w,
)
