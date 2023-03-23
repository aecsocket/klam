@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

private const val AS_STRING_FORMAT = "%f"
private const val TO_STRING_FORMAT = DECIMAL_FORMAT
private inline fun typeArrayOf(vararg elements: Float) = floatArrayOf(*elements)

data class FMat2(@JvmField val x: FVec2, @JvmField val y: FVec2) {
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
        FVec2(xx, yx),
        FVec2(xy, yy),
    )
    constructor(s: Float) : this(
        s, s,
        s, s,
    )

    fun from(x: FVec2, y: FVec2) { this.x.from(x); this.y.from(y) }
    fun from(m: FMat2) = from(m.x, m.y)

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    operator fun set(col: Index, v: FVec2) = get(col).from(v)
    operator fun set(col: Index, row: Index, s: Float) { get(col)[row] = s }

    inline operator fun unaryMinus() = FMat2(-x, -y)
    inline operator fun inc()        = FMat2(x + 1.0f, y + 1.0f)
    inline operator fun dec()        = FMat2(x + 1.0f, y + 1.0f)

    inline operator fun plus(s: Float)  = FMat2(x + s, y + s)
    inline operator fun minus(s: Float) = FMat2(x - s, y - s)
    inline operator fun times(s: Float) = FMat2(x * s, y * s)

    inline operator fun plus(v: FVec2)  = FMat2(x + v, y + v)
    inline operator fun minus(v: FVec2) = FMat2(x - v, y - v)

    inline operator fun plus(m: FMat2)  = FMat2(x + m.x, y + m.y)
    inline operator fun minus(m: FMat2) = FMat2(x - m.x, y - m.y)

    inline operator fun plusAssign(s: Float)  { x += s; y += s }
    inline operator fun minusAssign(s: Float) { x -= s; y -= s }
    inline operator fun timesAssign(s: Float) { x *= s; y *= s }

    inline operator fun plusAssign(s: FVec2)  { x += s; y += s }
    inline operator fun minusAssign(s: FVec2) { x -= s; y -= s }

    inline operator fun plusAssign(m: FMat2)  { x += m.x; y += m.y }
    inline operator fun minusAssign(m: FMat2) { x -= m.x; y -= m.y }

    inline operator fun times(v: FVec2) = FVec2(
        x.x*v.x + y.x*v.y,
        x.y*v.x + y.y*v.y,
    )

    inline operator fun timesAssign(m: FMat2) {
        val xx = x.x*m.x.x + y.x*m.x.y
        val xy = x.y*m.x.x + y.y*m.x.y
        val yx = x.x*m.y.x + y.x*m.y.y
        val yy = x.y*m.y.x + y.y*m.y.y
        x.from(xx, xy)
        y.from(yx, yy)
    }
    inline operator fun times(m: FMat2) = FMat2(this).apply { this *= m }

    inline fun compareTo(m: FMat2) = IMat2(x.compareTo(m.x), y.compareTo(m.y))
    inline fun equalTo(v: FMat2) = x.equalTo(v.x) && y.equalTo(v.y)

    inline fun mapVector(block: (FVec2) -> FVec2) = FMat2(block(x), block(y))
    inline fun mapScalar(block: (Float) -> Float) = FMat2(x.map(block), y.map(block))
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
        x.x, x.y,
        y.x, y.y,
    )
    override fun toString() = asString(TO_STRING_FORMAT)
}

data class FMat3(@JvmField val x: FVec3, @JvmField val y: FVec3, @JvmField val z: FVec3) {
    companion object {
        fun identity() = FMat3(
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

    fun from(x: FVec3, y: FVec3, z: FVec3) { this.x.from(x); this.y.from(y); this.z.from(z) }
    fun from(m: FMat3) = from(m.x, m.y, m.z)

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    operator fun set(col: Index, v: FVec3) = get(col).from(v)
    operator fun set(col: Index, row: Index, s: Float) { get(col)[row] = s }

    inline operator fun unaryMinus() = FMat3(-x, -y, -z)
    inline operator fun inc()        = FMat3(x + 1.0f, y + 1.0f, z + 1.0f)
    inline operator fun dec()        = FMat3(x + 1.0f, y + 1.0f, z + 1.0f)

    inline operator fun plus(s: Float)  = FMat3(x + s, y + s, z + s)
    inline operator fun minus(s: Float) = FMat3(x - s, y - s, z - s)
    inline operator fun times(s: Float) = FMat3(x * s, y * s, z * s)

    inline operator fun plus(v: FVec3)  = FMat3(x + v, y + v, z + v)
    inline operator fun minus(v: FVec3) = FMat3(x - v, y - v, z - v)

    inline operator fun plus(m: FMat3)  = FMat3(x + m.x, y + m.y, z + m.z)
    inline operator fun minus(m: FMat3) = FMat3(x - m.x, y - m.y, z - m.z)

    inline operator fun plusAssign(s: Float)  { x += s; y += s; z += s }
    inline operator fun minusAssign(s: Float) { x -= s; y -= s; z -= s }
    inline operator fun timesAssign(s: Float) { x *= s; y *= s; z *= s }

    inline operator fun plusAssign(s: FVec3)  { x += s; y += s; z += s }
    inline operator fun minusAssign(s: FVec3) { x -= s; y -= s; z -= s }

    inline operator fun plusAssign(m: FMat3)  { x += m.x; y += m.y; z += m.z }
    inline operator fun minusAssign(m: FMat3) { x -= m.x; y -= m.y; z -= m.z }

    inline operator fun times(v: FVec3) = FVec3(
        x.x*v.x + y.x*v.y + z.x*v.z,
        x.y*v.x + y.y*v.y + z.y*v.z,
        x.z*v.x + y.z*v.y + z.z*v.z,
    )

    inline operator fun timesAssign(m: FMat3) {
        val xx = x.x*m.x.x + y.x*m.x.y + z.x*m.x.z
        val xy = x.y*m.x.x + y.y*m.x.y + z.y*m.x.z
        val xz = x.z*m.x.x + y.z*m.x.y + z.z*m.x.z
        val yx = x.x*m.y.x + y.x*m.y.y + z.x*m.y.z
        val yy = x.y*m.y.x + y.y*m.y.y + z.y*m.y.z
        val yz = x.z*m.y.x + y.z*m.y.y + z.z*m.y.z
        val zx = x.x*m.z.x + y.x*m.z.y + z.x*m.z.z
        val zy = x.y*m.z.x + y.y*m.z.y + z.y*m.z.z
        val zz = x.z*m.z.x + y.z*m.z.y + z.z*m.z.z
        x.from(xx, xy, xz)
        y.from(yx, yy, yz)
        z.from(zx, zy, zz)
    }
    inline operator fun times(m: FMat3) = FMat3(this).apply { this *= m }

    inline fun compareTo(m: FMat3) = IMat3(x.compareTo(m.x), y.compareTo(m.y), z.compareTo(m.z))
    inline fun equalTo(v: FMat3) = x.equalTo(v.x) && y.equalTo(v.y) && z.equalTo(v.z)

    inline fun mapVector(block: (FVec3) -> FVec3) = FMat3(block(x), block(y), block(z))
    inline fun mapScalar(block: (Float) -> Float) = FMat3(x.map(block), y.map(block), z.map(block))
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
        x.x, x.y, x.z,
        y.x, y.y, y.z,
        z.x, z.y, z.z,
    )
    override fun toString() = asString(TO_STRING_FORMAT)
}