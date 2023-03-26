@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

private const val TO_STRING_FORMAT = "%s"
private inline fun typeArrayOf(vararg elements: Boolean) = booleanArrayOf(*elements)

data class BMat2(@JvmField val x: BVec2, @JvmField val y: BVec2) {
    constructor(m: BMat2) : this(BVec2(m.x), BVec2(m.y))
    constructor(
        xx: Boolean, xy: Boolean,
        yx: Boolean, yy: Boolean,
    ) : this(
        BVec2(xx, yx),
        BVec2(xy, yy),
    )
    constructor(s: Boolean) : this(
        s, s,
        s, s,
    )

    fun from(
        xx: Boolean, xy: Boolean,
        yx: Boolean, yy: Boolean,
    ) { x.from(xx, yx); y.from(xy, yy) }
    fun from(x: BVec2, y: BVec2) { this.x.from(x); this.y.from(y); }
    fun from(m: BMat2) = from(m.x, m.y)

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    operator fun set(col: Index, v: BVec2) = when (col) {
        0 -> x.from(v)
        1 -> y.from(v)
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun set(col: Index, row: Index, s: Boolean) { get(col)[row] = s }

    fun compareTo(m: BMat2) = IMat2(x.compareTo(m.x), y.compareTo(m.y))
    fun equalTo(v: BMat2)   = x.equalTo(v.x) && y.equalTo(v.y)
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
        x.x, x.y,
        y.x, y.y,
    )
    override fun toString() = asString(TO_STRING_FORMAT)
}

inline fun BMat2.mapVector(block: (BVec2) -> BVec2) = BMat2(block(x), block(y))
inline fun BMat2.mapScalar(block: (Boolean) -> Boolean) = BMat2(x.map(block), y.map(block))

inline operator fun BMat2.not() = BMat2(!x, !y)

data class BMat3(@JvmField val x: BVec3, @JvmField val y: BVec3, @JvmField val z: BVec3) {
    constructor(m: BMat3) : this(BVec3(m.x), BVec3(m.y), BVec3(m.z))
    constructor(
        xx: Boolean, xy: Boolean, xz: Boolean,
        yx: Boolean, yy: Boolean, yz: Boolean,
        zx: Boolean, zy: Boolean, zz: Boolean,
    ) : this(
        BVec3(xx, yx, zx),
        BVec3(xy, yy, zy),
        BVec3(xz, yz, zz),
    )
    constructor(s: Boolean) : this(
        s, s, s,
        s, s, s,
        s, s, s,
    )

    fun from(
        xx: Boolean, xy: Boolean, xz: Boolean,
        yx: Boolean, yy: Boolean, yz: Boolean,
        zx: Boolean, zy: Boolean, zz: Boolean,
    ) { x.from(xx, yx, zx); y.from(xy, yy, zy); z.from(xz, yz, zz) }
    fun from(x: BVec3, y: BVec3, z: BVec3) { this.x.from(x); this.y.from(y); this.z.from(z) }
    fun from(m: BMat3) = from(m.x, m.y, m.z)

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    operator fun set(col: Index, v: BVec3) = when (col) {
        0 -> x.from(v)
        1 -> y.from(v)
        2 -> z.from(v)
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun set(col: Index, row: Index, s: Boolean) { get(col)[row] = s }

    fun compareTo(m: BMat3) = IMat3(x.compareTo(m.x), y.compareTo(m.y), z.compareTo(m.z))
    fun equalTo(v: BMat3)   = x.equalTo(v.x) && y.equalTo(v.y) && z.equalTo(v.z)
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
        y.x, y.y, y.z,
        z.x, z.y, z.z,
    )
    override fun toString() = asString(TO_STRING_FORMAT)
}

inline fun BMat3.mapVector(block: (BVec3) -> BVec3) = BMat3(block(x), block(y), block(z))
inline fun BMat3.mapScalar(block: (Boolean) -> Boolean) = BMat3(x.map(block), y.map(block), z.map(block))

inline operator fun BMat3.not() = BMat3(!x, !y, !z)

data class BMat4(@JvmField val x: BVec4, @JvmField val y: BVec4, @JvmField val z: BVec4, @JvmField val w: BVec4) {
    constructor(m: BMat4) : this(BVec4(m.x), BVec4(m.y), BVec4(m.z), BVec4(m.w))
    constructor(
        xx: Boolean, xy: Boolean, xz: Boolean, xw: Boolean,
        yx: Boolean, yy: Boolean, yz: Boolean, yw: Boolean,
        zx: Boolean, zy: Boolean, zz: Boolean, zw: Boolean,
        wx: Boolean, wy: Boolean, wz: Boolean, ww: Boolean,
    ) : this(
        BVec4(xx, yx, zx, wx),
        BVec4(xy, yy, zy, wy),
        BVec4(xz, yz, zz, wz),
        BVec4(xw, yw, zw, ww),
    )
    constructor(s: Boolean) : this(
        s, s, s, s,
        s, s, s, s,
        s, s, s, s,
        s, s, s, s,
    )

    fun from(
        xx: Boolean, xy: Boolean, xz: Boolean, xw: Boolean,
        yx: Boolean, yy: Boolean, yz: Boolean, yw: Boolean,
        zx: Boolean, zy: Boolean, zz: Boolean, zw: Boolean,
        wx: Boolean, wy: Boolean, wz: Boolean, ww: Boolean,
    ) { x.from(xx, yx, zx, wx); y.from(xy, yy, zy, wy); z.from(xz, yz, zz, wz); w.from(xw, yw, zw, ww) }
    fun from(x: BVec4, y: BVec4, z: BVec4, w: BVec4) { this.x.from(x); this.y.from(y); this.z.from(z); this.w.from(w) }
    fun from(m: BMat4) = from(m.x, m.y, m.z, m.w)

    operator fun get(col: Index) = when (col) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun get(col: Index, row: Index) = get(col)[row]

    operator fun set(col: Index, v: BVec4) = when (col) {
        0 -> x.from(v)
        1 -> y.from(v)
        2 -> z.from(v)
        3 -> w.from(v)
        else -> throw IndexOutOfBoundsException(col)
    }
    operator fun set(col: Index, row: Index, s: Boolean) { get(col)[row] = s }

    fun compareTo(m: BMat4) = IMat4(x.compareTo(m.x), y.compareTo(m.y), z.compareTo(m.z), w.compareTo(m.w))
    fun equalTo(v: BMat4)   = x.equalTo(v.x) && y.equalTo(v.y) && z.equalTo(v.z)
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
        y.x, y.y, y.z,
        z.x, z.y, z.z,
    )
    override fun toString() = asString(TO_STRING_FORMAT)
}

inline fun BMat4.mapVector(block: (BVec4) -> BVec4) = BMat4(block(x), block(y), block(z), block(w))
inline fun BMat4.mapScalar(block: (Boolean) -> Boolean) = BMat4(x.map(block), y.map(block), z.map(block), w.map(block))

inline operator fun BMat4.not() = BMat4(!x, !y, !z, !w)
