@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

private const val DEFAULT: Double = 0.0

data class DVec2(@JvmField var x: Double, @JvmField var y: Double) {
    constructor(v: DVec2) : this(v.x, v.y)
    constructor(s: Double) : this(s, s)

    operator fun get(index: USize) = when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException(index)
    }

    operator fun set(index: USize, s: Double) = when (index) {
        0 -> x = s
        1 -> y = s
        else -> throw IndexOutOfBoundsException(index)
    }

    inline operator fun unaryMinus() = DVec2( -x,  -y)
    inline operator fun inc()        = DVec2(++x, ++y)
    inline operator fun dec()        = DVec2(--x, --y)

    inline operator fun plus(s: Double)  = DVec2(x + s, y + s)
    inline operator fun minus(s: Double) = DVec2(x - s, y - s)
    inline operator fun times(s: Double) = DVec2(x * s, y * s)
    inline operator fun div(s: Double)   = DVec2(x / s, y / s)

    inline operator fun plus(v: DVec2)  = DVec2(x + v.x, y + v.y)
    inline operator fun minus(v: DVec2) = DVec2(x - v.x, y - v.y)
    inline operator fun times(v: DVec2) = DVec2(x * v.x, y * v.y)
    inline operator fun div(v: DVec2)   = DVec2(x / v.x, y / v.y)

    inline fun compareTo(v: DVec2) = IVec2(x.compareTo(v.x), y.compareTo(v.y))
    inline fun equalTo(v: DVec2)   = x.compareTo(v.x) == 0 && y.compareTo(v.y) == 0

    inline fun map(block: (Double) -> Double) = DVec2(block(x), block(y))
    inline fun toArray() = doubleArrayOf(x, y)

    inline fun asString(fmt: String = "%f") = "($fmt, $fmt)".format(x, y)
    override fun toString() = asString("%.3f")
}

data class DVec3(@JvmField var x: Double, @JvmField var y: Double, @JvmField var z: Double) {
    constructor(v: DVec3) : this(v.x, v.y, v.z)
    constructor(v: DVec2, z: Double = DEFAULT) : this(v.x, v.y, z)
    constructor(s: Double) : this(s, s, s)

    operator fun get(index: USize) = when (index) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException(index)
    }

    operator fun set(index: USize, s: Double) = when (index) {
        0 -> x = s
        1 -> y = s
        2 -> z = s
        else -> throw IndexOutOfBoundsException(index)
    }

    inline operator fun unaryMinus() = DVec3( -x,  -y,  -z)
    inline operator fun inc()        = DVec3(++x, ++y, ++z)
    inline operator fun dec()        = DVec3(--x, --y, --z)

    inline operator fun plus(s: Double)  = DVec3(x + s, y + s, z + s)
    inline operator fun minus(s: Double) = DVec3(x - s, y - s, z - s)
    inline operator fun times(s: Double) = DVec3(x * s, y * s, z * s)
    inline operator fun div(s: Double)   = DVec3(x / s, y / s, z / s)

    inline operator fun plus(v: DVec3)  = DVec3(x + v.x, y + v.y, z + v.z)
    inline operator fun minus(v: DVec3) = DVec3(x - v.x, y - v.y, z - v.z)
    inline operator fun times(v: DVec3) = DVec3(x * v.x, y * v.y, z * v.z)
    inline operator fun div(v: DVec3)   = DVec3(x / v.x, y / v.y, z / v.z)

    inline fun compareTo(v: DVec3) = IVec3(x.compareTo(v.x), y.compareTo(v.y), z.compareTo(v.z))
    inline fun equalTo(v: DVec3)   = x.compareTo(v.x) == 0 && y.compareTo(v.y) == 0 && z.compareTo(v.z) == 0

    inline fun map(block: (Double) -> Double) = DVec3(block(x), block(y), block(z))
    inline fun toArray() = doubleArrayOf(x, y, z)

    inline fun asString(fmt: String = "%f") = "($fmt, $fmt, $fmt)".format(x, y, z)
    override fun toString() = asString("%.3f")
}

data class DVec4(@JvmField var x: Double, @JvmField var y: Double, @JvmField var z: Double, @JvmField var w: Double) {
    constructor(v: DVec4) : this(v.x, v.y, v.z, v.w)
    constructor(v: DVec3, w: Double = DEFAULT) : this(v.x, v.y, v.z, w)
    constructor(v: DVec2, z: Double = DEFAULT, w: Double = DEFAULT) : this(v.x, v.y, z, w)
    constructor(s: Double) : this(s, s, s, s)

    operator fun get(index: USize) = when (index) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException(index)
    }

    operator fun set(index: USize, s: Double) = when (index) {
        0 -> x = s
        1 -> y = s
        2 -> z = s
        3 -> w = s
        else -> throw IndexOutOfBoundsException(index)
    }

    inline operator fun unaryMinus() = DVec4( -x,  -y,  -z,  -w)
    inline operator fun inc()        = DVec4(++x, ++y, ++z, ++w)
    inline operator fun dec()        = DVec4(--x, --y, --z, --w)

    inline operator fun plus(s: Double)  = DVec4(x + s, y + s, z + s, w + s)
    inline operator fun minus(s: Double) = DVec4(x - s, y - s, z - s, w - s)
    inline operator fun times(s: Double) = DVec4(x * s, y * s, z * s, w * s)
    inline operator fun div(s: Double)   = DVec4(x / s, y / s, z / s, w / s)

    inline operator fun plus(v: DVec4)  = DVec4(x + v.x, y + v.y, z + v.z, w + v.w)
    inline operator fun minus(v: DVec4) = DVec4(x - v.x, y - v.y, z - v.z, w - v.w)
    inline operator fun times(v: DVec4) = DVec4(x * v.x, y * v.y, z * v.z, w * v.w)
    inline operator fun div(v: DVec4)   = DVec4(x / v.x, y / v.y, z / v.z, w / v.w)

    inline fun compareTo(v: DVec4) = IVec4(x.compareTo(v.x), y.compareTo(v.y), z.compareTo(v.z), w.compareTo(v.w))
    inline fun equalTo(v: DVec4)   = x.compareTo(v.x) == 0 && y.compareTo(v.y) == 0 && z.compareTo(v.z) == 0 && w.compareTo(v.w) == 0

    inline fun map(block: (Double) -> Double) = DVec4(block(x), block(y), block(z), block(w))
    inline fun toArray() = doubleArrayOf(x, y, z, w)

    inline fun asString(fmt: String = "%f") = "($fmt, $fmt, $fmt, $fmt)".format(x, y, z, w)
    override fun toString() = asString("%.3f")
}

//region Alternate accessors
inline var DVec2.r: Double
    get() = x
    set(value) { x = value }
inline var DVec2.g: Double
    get() = y
    set(value) { y = value }

inline var DVec3.r: Double
    get() = x
    set(value) { x = value }
inline var DVec3.g: Double
    get() = y
    set(value) { y = value }
inline var DVec3.b: Double
    get() = z
    set(value) { z = value }

inline var DVec4.r: Double
    get() = x
    set(value) { x = value }
inline var DVec4.g: Double
    get() = y
    set(value) { y = value }
inline var DVec4.b: Double
    get() = z
    set(value) { z = value }
inline var DVec4.a: Double
    get() = w
    set(value) { w = value }

inline var DVec2.s: Double
    get() = x
    set(value) { x = value }
inline var DVec2.t: Double
    get() = y
    set(value) { y = value }

inline var DVec3.s: Double
    get() = x
    set(value) { x = value }
inline var DVec3.t: Double
    get() = y
    set(value) { y = value }
inline var DVec3.p: Double
    get() = z
    set(value) { z = value }

inline var DVec4.s: Double
    get() = x
    set(value) { x = value }
inline var DVec4.t: Double
    get() = y
    set(value) { y = value }
inline var DVec4.p: Double
    get() = z
    set(value) { z = value }
inline var DVec4.q: Double
    get() = w
    set(value) { w = value }
//endregion

//region Swizzling Vec2
inline val DVec2.xxxx get() = DVec4(x, x, x, x)
inline val DVec2.xxxy get() = DVec4(x, x, x, y)
inline val DVec2.xxyx get() = DVec4(x, x, y, x)
inline val DVec2.xxyy get() = DVec4(x, x, y, y)
inline val DVec2.xyxx get() = DVec4(x, y, x, x)
inline val DVec2.xyxy get() = DVec4(x, y, x, y)
inline val DVec2.xyyx get() = DVec4(x, y, y, x)
inline val DVec2.xyyy get() = DVec4(x, y, y, y)
inline val DVec2.yxxx get() = DVec4(y, x, x, x)
inline val DVec2.yxxy get() = DVec4(y, x, x, y)
inline val DVec2.yxyx get() = DVec4(y, x, y, x)
inline val DVec2.yxyy get() = DVec4(y, x, y, y)
inline val DVec2.yyxx get() = DVec4(y, y, x, x)
inline val DVec2.yyxy get() = DVec4(y, y, x, y)
inline val DVec2.yyyx get() = DVec4(y, y, y, x)
inline val DVec2.yyyy get() = DVec4(y, y, y, y)

inline val DVec2.xxx get() = DVec3(x, x, x)
inline val DVec2.xxy get() = DVec3(x, x, y)
inline val DVec2.xyx get() = DVec3(x, y, x)
inline val DVec2.xyy get() = DVec3(x, y, y)
inline val DVec2.yxx get() = DVec3(y, x, x)
inline val DVec2.yxy get() = DVec3(y, x, y)
inline val DVec2.yyx get() = DVec3(y, y, x)
inline val DVec2.yyy get() = DVec3(y, y, y)

inline val DVec2.xx get() = DVec2(x, x)
inline val DVec2.xy get() = DVec2(x, y)
inline val DVec2.yx get() = DVec2(y, x)
inline val DVec2.yy get() = DVec2(y, y)
//endregion

//region Swizzling Vec3
inline val DVec3.xxxx get() = DVec4(x, x, x, x)
inline val DVec3.xxxy get() = DVec4(x, x, x, y)
inline val DVec3.xxxz get() = DVec4(x, x, x, z)
inline val DVec3.xxyx get() = DVec4(x, x, y, x)
inline val DVec3.xxyy get() = DVec4(x, x, y, y)
inline val DVec3.xxyz get() = DVec4(x, x, y, z)
inline val DVec3.xxzx get() = DVec4(x, x, z, x)
inline val DVec3.xxzy get() = DVec4(x, x, z, y)
inline val DVec3.xxzz get() = DVec4(x, x, z, z)
inline val DVec3.xyxx get() = DVec4(x, y, x, x)
inline val DVec3.xyxy get() = DVec4(x, y, x, y)
inline val DVec3.xyxz get() = DVec4(x, y, x, z)
inline val DVec3.xyyx get() = DVec4(x, y, y, x)
inline val DVec3.xyyy get() = DVec4(x, y, y, y)
inline val DVec3.xyyz get() = DVec4(x, y, y, z)
inline val DVec3.xyzx get() = DVec4(x, y, z, x)
inline val DVec3.xyzy get() = DVec4(x, y, z, y)
inline val DVec3.xyzz get() = DVec4(x, y, z, z)
inline val DVec3.xzxx get() = DVec4(x, z, x, x)
inline val DVec3.xzxy get() = DVec4(x, z, x, y)
inline val DVec3.xzxz get() = DVec4(x, z, x, z)
inline val DVec3.xzyx get() = DVec4(x, z, y, x)
inline val DVec3.xzyy get() = DVec4(x, z, y, y)
inline val DVec3.xzyz get() = DVec4(x, z, y, z)
inline val DVec3.xzzx get() = DVec4(x, z, z, x)
inline val DVec3.xzzy get() = DVec4(x, z, z, y)
inline val DVec3.xzzz get() = DVec4(x, z, z, z)
inline val DVec3.yxxx get() = DVec4(y, x, x, x)
inline val DVec3.yxxy get() = DVec4(y, x, x, y)
inline val DVec3.yxxz get() = DVec4(y, x, x, z)
inline val DVec3.yxyx get() = DVec4(y, x, y, x)
inline val DVec3.yxyy get() = DVec4(y, x, y, y)
inline val DVec3.yxyz get() = DVec4(y, x, y, z)
inline val DVec3.yxzx get() = DVec4(y, x, z, x)
inline val DVec3.yxzy get() = DVec4(y, x, z, y)
inline val DVec3.yxzz get() = DVec4(y, x, z, z)
inline val DVec3.yyxx get() = DVec4(y, y, x, x)
inline val DVec3.yyxy get() = DVec4(y, y, x, y)
inline val DVec3.yyxz get() = DVec4(y, y, x, z)
inline val DVec3.yyyx get() = DVec4(y, y, y, x)
inline val DVec3.yyyy get() = DVec4(y, y, y, y)
inline val DVec3.yyyz get() = DVec4(y, y, y, z)
inline val DVec3.yyzx get() = DVec4(y, y, z, x)
inline val DVec3.yyzy get() = DVec4(y, y, z, y)
inline val DVec3.yyzz get() = DVec4(y, y, z, z)
inline val DVec3.yzxx get() = DVec4(y, z, x, x)
inline val DVec3.yzxy get() = DVec4(y, z, x, y)
inline val DVec3.yzxz get() = DVec4(y, z, x, z)
inline val DVec3.yzyx get() = DVec4(y, z, y, x)
inline val DVec3.yzyy get() = DVec4(y, z, y, y)
inline val DVec3.yzyz get() = DVec4(y, z, y, z)
inline val DVec3.yzzx get() = DVec4(y, z, z, x)
inline val DVec3.yzzy get() = DVec4(y, z, z, y)
inline val DVec3.yzzz get() = DVec4(y, z, z, z)
inline val DVec3.zxxx get() = DVec4(z, x, x, x)
inline val DVec3.zxxy get() = DVec4(z, x, x, y)
inline val DVec3.zxxz get() = DVec4(z, x, x, z)
inline val DVec3.zxyx get() = DVec4(z, x, y, x)
inline val DVec3.zxyy get() = DVec4(z, x, y, y)
inline val DVec3.zxyz get() = DVec4(z, x, y, z)
inline val DVec3.zxzx get() = DVec4(z, x, z, x)
inline val DVec3.zxzy get() = DVec4(z, x, z, y)
inline val DVec3.zxzz get() = DVec4(z, x, z, z)
inline val DVec3.zyxx get() = DVec4(z, y, x, x)
inline val DVec3.zyxy get() = DVec4(z, y, x, y)
inline val DVec3.zyxz get() = DVec4(z, y, x, z)
inline val DVec3.zyyx get() = DVec4(z, y, y, x)
inline val DVec3.zyyy get() = DVec4(z, y, y, y)
inline val DVec3.zyyz get() = DVec4(z, y, y, z)
inline val DVec3.zyzx get() = DVec4(z, y, z, x)
inline val DVec3.zyzy get() = DVec4(z, y, z, y)
inline val DVec3.zyzz get() = DVec4(z, y, z, z)
inline val DVec3.zzxx get() = DVec4(z, z, x, x)
inline val DVec3.zzxy get() = DVec4(z, z, x, y)
inline val DVec3.zzxz get() = DVec4(z, z, x, z)
inline val DVec3.zzyx get() = DVec4(z, z, y, x)
inline val DVec3.zzyy get() = DVec4(z, z, y, y)
inline val DVec3.zzyz get() = DVec4(z, z, y, z)
inline val DVec3.zzzx get() = DVec4(z, z, z, x)
inline val DVec3.zzzy get() = DVec4(z, z, z, y)
inline val DVec3.zzzz get() = DVec4(z, z, z, z)

inline val DVec3.xxx get() = DVec3(x, x, x)
inline val DVec3.xxy get() = DVec3(x, x, y)
inline val DVec3.xxz get() = DVec3(x, x, z)
inline val DVec3.xyx get() = DVec3(x, y, x)
inline val DVec3.xyy get() = DVec3(x, y, y)
inline val DVec3.xyz get() = DVec3(x, y, z)
inline val DVec3.xzx get() = DVec3(x, z, x)
inline val DVec3.xzy get() = DVec3(x, z, y)
inline val DVec3.xzz get() = DVec3(x, z, z)
inline val DVec3.yxx get() = DVec3(y, x, x)
inline val DVec3.yxy get() = DVec3(y, x, y)
inline val DVec3.yxz get() = DVec3(y, x, z)
inline val DVec3.yyx get() = DVec3(y, y, x)
inline val DVec3.yyy get() = DVec3(y, y, y)
inline val DVec3.yyz get() = DVec3(y, y, z)
inline val DVec3.yzx get() = DVec3(y, z, x)
inline val DVec3.yzy get() = DVec3(y, z, y)
inline val DVec3.yzz get() = DVec3(y, z, z)
inline val DVec3.zxx get() = DVec3(z, x, x)
inline val DVec3.zxy get() = DVec3(z, x, y)
inline val DVec3.zxz get() = DVec3(z, x, z)
inline val DVec3.zyx get() = DVec3(z, y, x)
inline val DVec3.zyy get() = DVec3(z, y, y)
inline val DVec3.zyz get() = DVec3(z, y, z)
inline val DVec3.zzx get() = DVec3(z, z, x)
inline val DVec3.zzy get() = DVec3(z, z, y)
inline val DVec3.zzz get() = DVec3(z, z, z)

inline val DVec3.xx get() = DVec2(x, x)
inline val DVec3.xy get() = DVec2(x, y)
inline val DVec3.xz get() = DVec2(x, z)
inline val DVec3.yx get() = DVec2(y, x)
inline val DVec3.yy get() = DVec2(y, y)
inline val DVec3.yz get() = DVec2(y, z)
inline val DVec3.zx get() = DVec2(z, x)
inline val DVec3.zy get() = DVec2(z, y)
inline val DVec3.zz get() = DVec2(z, z)
//endregion

//region Swizzling Vec4
inline val DVec4.xxxx get() = DVec4(x, x, x, x)
inline val DVec4.xxxy get() = DVec4(x, x, x, y)
inline val DVec4.xxxz get() = DVec4(x, x, x, z)
inline val DVec4.xxxw get() = DVec4(x, x, x, w)
inline val DVec4.xxyx get() = DVec4(x, x, y, x)
inline val DVec4.xxyy get() = DVec4(x, x, y, y)
inline val DVec4.xxyz get() = DVec4(x, x, y, z)
inline val DVec4.xxyw get() = DVec4(x, x, y, w)
inline val DVec4.xxzx get() = DVec4(x, x, z, x)
inline val DVec4.xxzy get() = DVec4(x, x, z, y)
inline val DVec4.xxzz get() = DVec4(x, x, z, z)
inline val DVec4.xxzw get() = DVec4(x, x, z, w)
inline val DVec4.xxwx get() = DVec4(x, x, w, x)
inline val DVec4.xxwy get() = DVec4(x, x, w, y)
inline val DVec4.xxwz get() = DVec4(x, x, w, z)
inline val DVec4.xxww get() = DVec4(x, x, w, w)
inline val DVec4.xyxx get() = DVec4(x, y, x, x)
inline val DVec4.xyxy get() = DVec4(x, y, x, y)
inline val DVec4.xyxz get() = DVec4(x, y, x, z)
inline val DVec4.xyxw get() = DVec4(x, y, x, w)
inline val DVec4.xyyx get() = DVec4(x, y, y, x)
inline val DVec4.xyyy get() = DVec4(x, y, y, y)
inline val DVec4.xyyz get() = DVec4(x, y, y, z)
inline val DVec4.xyyw get() = DVec4(x, y, y, w)
inline val DVec4.xyzx get() = DVec4(x, y, z, x)
inline val DVec4.xyzy get() = DVec4(x, y, z, y)
inline val DVec4.xyzz get() = DVec4(x, y, z, z)
inline val DVec4.xyzw get() = DVec4(x, y, z, w)
inline val DVec4.xywx get() = DVec4(x, y, w, x)
inline val DVec4.xywy get() = DVec4(x, y, w, y)
inline val DVec4.xywz get() = DVec4(x, y, w, z)
inline val DVec4.xyww get() = DVec4(x, y, w, w)
inline val DVec4.xzxx get() = DVec4(x, z, x, x)
inline val DVec4.xzxy get() = DVec4(x, z, x, y)
inline val DVec4.xzxz get() = DVec4(x, z, x, z)
inline val DVec4.xzxw get() = DVec4(x, z, x, w)
inline val DVec4.xzyx get() = DVec4(x, z, y, x)
inline val DVec4.xzyy get() = DVec4(x, z, y, y)
inline val DVec4.xzyz get() = DVec4(x, z, y, z)
inline val DVec4.xzyw get() = DVec4(x, z, y, w)
inline val DVec4.xzzx get() = DVec4(x, z, z, x)
inline val DVec4.xzzy get() = DVec4(x, z, z, y)
inline val DVec4.xzzz get() = DVec4(x, z, z, z)
inline val DVec4.xzzw get() = DVec4(x, z, z, w)
inline val DVec4.xzwx get() = DVec4(x, z, w, x)
inline val DVec4.xzwy get() = DVec4(x, z, w, y)
inline val DVec4.xzwz get() = DVec4(x, z, w, z)
inline val DVec4.xzww get() = DVec4(x, z, w, w)
inline val DVec4.xwxx get() = DVec4(x, w, x, x)
inline val DVec4.xwxy get() = DVec4(x, w, x, y)
inline val DVec4.xwxz get() = DVec4(x, w, x, z)
inline val DVec4.xwxw get() = DVec4(x, w, x, w)
inline val DVec4.xwyx get() = DVec4(x, w, y, x)
inline val DVec4.xwyy get() = DVec4(x, w, y, y)
inline val DVec4.xwyz get() = DVec4(x, w, y, z)
inline val DVec4.xwyw get() = DVec4(x, w, y, w)
inline val DVec4.xwzx get() = DVec4(x, w, z, x)
inline val DVec4.xwzy get() = DVec4(x, w, z, y)
inline val DVec4.xwzz get() = DVec4(x, w, z, z)
inline val DVec4.xwzw get() = DVec4(x, w, z, w)
inline val DVec4.xwwx get() = DVec4(x, w, w, x)
inline val DVec4.xwwy get() = DVec4(x, w, w, y)
inline val DVec4.xwwz get() = DVec4(x, w, w, z)
inline val DVec4.xwww get() = DVec4(x, w, w, w)
inline val DVec4.yxxx get() = DVec4(y, x, x, x)
inline val DVec4.yxxy get() = DVec4(y, x, x, y)
inline val DVec4.yxxz get() = DVec4(y, x, x, z)
inline val DVec4.yxxw get() = DVec4(y, x, x, w)
inline val DVec4.yxyx get() = DVec4(y, x, y, x)
inline val DVec4.yxyy get() = DVec4(y, x, y, y)
inline val DVec4.yxyz get() = DVec4(y, x, y, z)
inline val DVec4.yxyw get() = DVec4(y, x, y, w)
inline val DVec4.yxzx get() = DVec4(y, x, z, x)
inline val DVec4.yxzy get() = DVec4(y, x, z, y)
inline val DVec4.yxzz get() = DVec4(y, x, z, z)
inline val DVec4.yxzw get() = DVec4(y, x, z, w)
inline val DVec4.yxwx get() = DVec4(y, x, w, x)
inline val DVec4.yxwy get() = DVec4(y, x, w, y)
inline val DVec4.yxwz get() = DVec4(y, x, w, z)
inline val DVec4.yxww get() = DVec4(y, x, w, w)
inline val DVec4.yyxx get() = DVec4(y, y, x, x)
inline val DVec4.yyxy get() = DVec4(y, y, x, y)
inline val DVec4.yyxz get() = DVec4(y, y, x, z)
inline val DVec4.yyxw get() = DVec4(y, y, x, w)
inline val DVec4.yyyx get() = DVec4(y, y, y, x)
inline val DVec4.yyyy get() = DVec4(y, y, y, y)
inline val DVec4.yyyz get() = DVec4(y, y, y, z)
inline val DVec4.yyyw get() = DVec4(y, y, y, w)
inline val DVec4.yyzx get() = DVec4(y, y, z, x)
inline val DVec4.yyzy get() = DVec4(y, y, z, y)
inline val DVec4.yyzz get() = DVec4(y, y, z, z)
inline val DVec4.yyzw get() = DVec4(y, y, z, w)
inline val DVec4.yywx get() = DVec4(y, y, w, x)
inline val DVec4.yywy get() = DVec4(y, y, w, y)
inline val DVec4.yywz get() = DVec4(y, y, w, z)
inline val DVec4.yyww get() = DVec4(y, y, w, w)
inline val DVec4.yzxx get() = DVec4(y, z, x, x)
inline val DVec4.yzxy get() = DVec4(y, z, x, y)
inline val DVec4.yzxz get() = DVec4(y, z, x, z)
inline val DVec4.yzxw get() = DVec4(y, z, x, w)
inline val DVec4.yzyx get() = DVec4(y, z, y, x)
inline val DVec4.yzyy get() = DVec4(y, z, y, y)
inline val DVec4.yzyz get() = DVec4(y, z, y, z)
inline val DVec4.yzyw get() = DVec4(y, z, y, w)
inline val DVec4.yzzx get() = DVec4(y, z, z, x)
inline val DVec4.yzzy get() = DVec4(y, z, z, y)
inline val DVec4.yzzz get() = DVec4(y, z, z, z)
inline val DVec4.yzzw get() = DVec4(y, z, z, w)
inline val DVec4.yzwx get() = DVec4(y, z, w, x)
inline val DVec4.yzwy get() = DVec4(y, z, w, y)
inline val DVec4.yzwz get() = DVec4(y, z, w, z)
inline val DVec4.yzww get() = DVec4(y, z, w, w)
inline val DVec4.ywxx get() = DVec4(y, w, x, x)
inline val DVec4.ywxy get() = DVec4(y, w, x, y)
inline val DVec4.ywxz get() = DVec4(y, w, x, z)
inline val DVec4.ywxw get() = DVec4(y, w, x, w)
inline val DVec4.ywyx get() = DVec4(y, w, y, x)
inline val DVec4.ywyy get() = DVec4(y, w, y, y)
inline val DVec4.ywyz get() = DVec4(y, w, y, z)
inline val DVec4.ywyw get() = DVec4(y, w, y, w)
inline val DVec4.ywzx get() = DVec4(y, w, z, x)
inline val DVec4.ywzy get() = DVec4(y, w, z, y)
inline val DVec4.ywzz get() = DVec4(y, w, z, z)
inline val DVec4.ywzw get() = DVec4(y, w, z, w)
inline val DVec4.ywwx get() = DVec4(y, w, w, x)
inline val DVec4.ywwy get() = DVec4(y, w, w, y)
inline val DVec4.ywwz get() = DVec4(y, w, w, z)
inline val DVec4.ywww get() = DVec4(y, w, w, w)
inline val DVec4.zxxx get() = DVec4(z, x, x, x)
inline val DVec4.zxxy get() = DVec4(z, x, x, y)
inline val DVec4.zxxz get() = DVec4(z, x, x, z)
inline val DVec4.zxxw get() = DVec4(z, x, x, w)
inline val DVec4.zxyx get() = DVec4(z, x, y, x)
inline val DVec4.zxyy get() = DVec4(z, x, y, y)
inline val DVec4.zxyz get() = DVec4(z, x, y, z)
inline val DVec4.zxyw get() = DVec4(z, x, y, w)
inline val DVec4.zxzx get() = DVec4(z, x, z, x)
inline val DVec4.zxzy get() = DVec4(z, x, z, y)
inline val DVec4.zxzz get() = DVec4(z, x, z, z)
inline val DVec4.zxzw get() = DVec4(z, x, z, w)
inline val DVec4.zxwx get() = DVec4(z, x, w, x)
inline val DVec4.zxwy get() = DVec4(z, x, w, y)
inline val DVec4.zxwz get() = DVec4(z, x, w, z)
inline val DVec4.zxww get() = DVec4(z, x, w, w)
inline val DVec4.zyxx get() = DVec4(z, y, x, x)
inline val DVec4.zyxy get() = DVec4(z, y, x, y)
inline val DVec4.zyxz get() = DVec4(z, y, x, z)
inline val DVec4.zyxw get() = DVec4(z, y, x, w)
inline val DVec4.zyyx get() = DVec4(z, y, y, x)
inline val DVec4.zyyy get() = DVec4(z, y, y, y)
inline val DVec4.zyyz get() = DVec4(z, y, y, z)
inline val DVec4.zyyw get() = DVec4(z, y, y, w)
inline val DVec4.zyzx get() = DVec4(z, y, z, x)
inline val DVec4.zyzy get() = DVec4(z, y, z, y)
inline val DVec4.zyzz get() = DVec4(z, y, z, z)
inline val DVec4.zyzw get() = DVec4(z, y, z, w)
inline val DVec4.zywx get() = DVec4(z, y, w, x)
inline val DVec4.zywy get() = DVec4(z, y, w, y)
inline val DVec4.zywz get() = DVec4(z, y, w, z)
inline val DVec4.zyww get() = DVec4(z, y, w, w)
inline val DVec4.zzxx get() = DVec4(z, z, x, x)
inline val DVec4.zzxy get() = DVec4(z, z, x, y)
inline val DVec4.zzxz get() = DVec4(z, z, x, z)
inline val DVec4.zzxw get() = DVec4(z, z, x, w)
inline val DVec4.zzyx get() = DVec4(z, z, y, x)
inline val DVec4.zzyy get() = DVec4(z, z, y, y)
inline val DVec4.zzyz get() = DVec4(z, z, y, z)
inline val DVec4.zzyw get() = DVec4(z, z, y, w)
inline val DVec4.zzzx get() = DVec4(z, z, z, x)
inline val DVec4.zzzy get() = DVec4(z, z, z, y)
inline val DVec4.zzzz get() = DVec4(z, z, z, z)
inline val DVec4.zzzw get() = DVec4(z, z, z, w)
inline val DVec4.zzwx get() = DVec4(z, z, w, x)
inline val DVec4.zzwy get() = DVec4(z, z, w, y)
inline val DVec4.zzwz get() = DVec4(z, z, w, z)
inline val DVec4.zzww get() = DVec4(z, z, w, w)
inline val DVec4.zwxx get() = DVec4(z, w, x, x)
inline val DVec4.zwxy get() = DVec4(z, w, x, y)
inline val DVec4.zwxz get() = DVec4(z, w, x, z)
inline val DVec4.zwxw get() = DVec4(z, w, x, w)
inline val DVec4.zwyx get() = DVec4(z, w, y, x)
inline val DVec4.zwyy get() = DVec4(z, w, y, y)
inline val DVec4.zwyz get() = DVec4(z, w, y, z)
inline val DVec4.zwyw get() = DVec4(z, w, y, w)
inline val DVec4.zwzx get() = DVec4(z, w, z, x)
inline val DVec4.zwzy get() = DVec4(z, w, z, y)
inline val DVec4.zwzz get() = DVec4(z, w, z, z)
inline val DVec4.zwzw get() = DVec4(z, w, z, w)
inline val DVec4.zwwx get() = DVec4(z, w, w, x)
inline val DVec4.zwwy get() = DVec4(z, w, w, y)
inline val DVec4.zwwz get() = DVec4(z, w, w, z)
inline val DVec4.zwww get() = DVec4(z, w, w, w)
inline val DVec4.wxxx get() = DVec4(w, x, x, x)
inline val DVec4.wxxy get() = DVec4(w, x, x, y)
inline val DVec4.wxxz get() = DVec4(w, x, x, z)
inline val DVec4.wxxw get() = DVec4(w, x, x, w)
inline val DVec4.wxyx get() = DVec4(w, x, y, x)
inline val DVec4.wxyy get() = DVec4(w, x, y, y)
inline val DVec4.wxyz get() = DVec4(w, x, y, z)
inline val DVec4.wxyw get() = DVec4(w, x, y, w)
inline val DVec4.wxzx get() = DVec4(w, x, z, x)
inline val DVec4.wxzy get() = DVec4(w, x, z, y)
inline val DVec4.wxzz get() = DVec4(w, x, z, z)
inline val DVec4.wxzw get() = DVec4(w, x, z, w)
inline val DVec4.wxwx get() = DVec4(w, x, w, x)
inline val DVec4.wxwy get() = DVec4(w, x, w, y)
inline val DVec4.wxwz get() = DVec4(w, x, w, z)
inline val DVec4.wxww get() = DVec4(w, x, w, w)
inline val DVec4.wyxx get() = DVec4(w, y, x, x)
inline val DVec4.wyxy get() = DVec4(w, y, x, y)
inline val DVec4.wyxz get() = DVec4(w, y, x, z)
inline val DVec4.wyxw get() = DVec4(w, y, x, w)
inline val DVec4.wyyx get() = DVec4(w, y, y, x)
inline val DVec4.wyyy get() = DVec4(w, y, y, y)
inline val DVec4.wyyz get() = DVec4(w, y, y, z)
inline val DVec4.wyyw get() = DVec4(w, y, y, w)
inline val DVec4.wyzx get() = DVec4(w, y, z, x)
inline val DVec4.wyzy get() = DVec4(w, y, z, y)
inline val DVec4.wyzz get() = DVec4(w, y, z, z)
inline val DVec4.wyzw get() = DVec4(w, y, z, w)
inline val DVec4.wywx get() = DVec4(w, y, w, x)
inline val DVec4.wywy get() = DVec4(w, y, w, y)
inline val DVec4.wywz get() = DVec4(w, y, w, z)
inline val DVec4.wyww get() = DVec4(w, y, w, w)
inline val DVec4.wzxx get() = DVec4(w, z, x, x)
inline val DVec4.wzxy get() = DVec4(w, z, x, y)
inline val DVec4.wzxz get() = DVec4(w, z, x, z)
inline val DVec4.wzxw get() = DVec4(w, z, x, w)
inline val DVec4.wzyx get() = DVec4(w, z, y, x)
inline val DVec4.wzyy get() = DVec4(w, z, y, y)
inline val DVec4.wzyz get() = DVec4(w, z, y, z)
inline val DVec4.wzyw get() = DVec4(w, z, y, w)
inline val DVec4.wzzx get() = DVec4(w, z, z, x)
inline val DVec4.wzzy get() = DVec4(w, z, z, y)
inline val DVec4.wzzz get() = DVec4(w, z, z, z)
inline val DVec4.wzzw get() = DVec4(w, z, z, w)
inline val DVec4.wzwx get() = DVec4(w, z, w, x)
inline val DVec4.wzwy get() = DVec4(w, z, w, y)
inline val DVec4.wzwz get() = DVec4(w, z, w, z)
inline val DVec4.wzww get() = DVec4(w, z, w, w)
inline val DVec4.wwxx get() = DVec4(w, w, x, x)
inline val DVec4.wwxy get() = DVec4(w, w, x, y)
inline val DVec4.wwxz get() = DVec4(w, w, x, z)
inline val DVec4.wwxw get() = DVec4(w, w, x, w)
inline val DVec4.wwyx get() = DVec4(w, w, y, x)
inline val DVec4.wwyy get() = DVec4(w, w, y, y)
inline val DVec4.wwyz get() = DVec4(w, w, y, z)
inline val DVec4.wwyw get() = DVec4(w, w, y, w)
inline val DVec4.wwzx get() = DVec4(w, w, z, x)
inline val DVec4.wwzy get() = DVec4(w, w, z, y)
inline val DVec4.wwzz get() = DVec4(w, w, z, z)
inline val DVec4.wwzw get() = DVec4(w, w, z, w)
inline val DVec4.wwwx get() = DVec4(w, w, w, x)
inline val DVec4.wwwy get() = DVec4(w, w, w, y)
inline val DVec4.wwwz get() = DVec4(w, w, w, z)
inline val DVec4.wwww get() = DVec4(w, w, w, w)

inline val DVec4.xxx get() = DVec3(x, x, x)
inline val DVec4.xxy get() = DVec3(x, x, y)
inline val DVec4.xxz get() = DVec3(x, x, z)
inline val DVec4.xxw get() = DVec3(x, x, w)
inline val DVec4.xyx get() = DVec3(x, y, x)
inline val DVec4.xyy get() = DVec3(x, y, y)
inline val DVec4.xyz get() = DVec3(x, y, z)
inline val DVec4.xyw get() = DVec3(x, y, w)
inline val DVec4.xzx get() = DVec3(x, z, x)
inline val DVec4.xzy get() = DVec3(x, z, y)
inline val DVec4.xzz get() = DVec3(x, z, z)
inline val DVec4.xzw get() = DVec3(x, z, w)
inline val DVec4.xwx get() = DVec3(x, w, x)
inline val DVec4.xwy get() = DVec3(x, w, y)
inline val DVec4.xwz get() = DVec3(x, w, z)
inline val DVec4.xww get() = DVec3(x, w, w)
inline val DVec4.yxx get() = DVec3(y, x, x)
inline val DVec4.yxy get() = DVec3(y, x, y)
inline val DVec4.yxz get() = DVec3(y, x, z)
inline val DVec4.yxw get() = DVec3(y, x, w)
inline val DVec4.yyx get() = DVec3(y, y, x)
inline val DVec4.yyy get() = DVec3(y, y, y)
inline val DVec4.yyz get() = DVec3(y, y, z)
inline val DVec4.yyw get() = DVec3(y, y, w)
inline val DVec4.yzx get() = DVec3(y, z, x)
inline val DVec4.yzy get() = DVec3(y, z, y)
inline val DVec4.yzz get() = DVec3(y, z, z)
inline val DVec4.yzw get() = DVec3(y, z, w)
inline val DVec4.ywx get() = DVec3(y, w, x)
inline val DVec4.ywy get() = DVec3(y, w, y)
inline val DVec4.ywz get() = DVec3(y, w, z)
inline val DVec4.yww get() = DVec3(y, w, w)
inline val DVec4.zxx get() = DVec3(z, x, x)
inline val DVec4.zxy get() = DVec3(z, x, y)
inline val DVec4.zxz get() = DVec3(z, x, z)
inline val DVec4.zxw get() = DVec3(z, x, w)
inline val DVec4.zyx get() = DVec3(z, y, x)
inline val DVec4.zyy get() = DVec3(z, y, y)
inline val DVec4.zyz get() = DVec3(z, y, z)
inline val DVec4.zyw get() = DVec3(z, y, w)
inline val DVec4.zzx get() = DVec3(z, z, x)
inline val DVec4.zzy get() = DVec3(z, z, y)
inline val DVec4.zzz get() = DVec3(z, z, z)
inline val DVec4.zzw get() = DVec3(z, z, w)
inline val DVec4.zwx get() = DVec3(z, w, x)
inline val DVec4.zwy get() = DVec3(z, w, y)
inline val DVec4.zwz get() = DVec3(z, w, z)
inline val DVec4.zww get() = DVec3(z, w, w)
inline val DVec4.wxx get() = DVec3(w, x, x)
inline val DVec4.wxy get() = DVec3(w, x, y)
inline val DVec4.wxz get() = DVec3(w, x, z)
inline val DVec4.wxw get() = DVec3(w, x, w)
inline val DVec4.wyx get() = DVec3(w, y, x)
inline val DVec4.wyy get() = DVec3(w, y, y)
inline val DVec4.wyz get() = DVec3(w, y, z)
inline val DVec4.wyw get() = DVec3(w, y, w)
inline val DVec4.wzx get() = DVec3(w, z, x)
inline val DVec4.wzy get() = DVec3(w, z, y)
inline val DVec4.wzz get() = DVec3(w, z, z)
inline val DVec4.wzw get() = DVec3(w, z, w)
inline val DVec4.wwx get() = DVec3(w, w, x)
inline val DVec4.wwy get() = DVec3(w, w, y)
inline val DVec4.wwz get() = DVec3(w, w, z)
inline val DVec4.www get() = DVec3(w, w, w)

inline val DVec4.xx get() = DVec2(x, x)
inline val DVec4.xy get() = DVec2(x, y)
inline val DVec4.xz get() = DVec2(x, z)
inline val DVec4.xw get() = DVec2(x, w)
inline val DVec4.yx get() = DVec2(y, x)
inline val DVec4.yy get() = DVec2(y, y)
inline val DVec4.yz get() = DVec2(y, z)
inline val DVec4.yw get() = DVec2(y, w)
inline val DVec4.zx get() = DVec2(z, x)
inline val DVec4.zy get() = DVec2(z, y)
inline val DVec4.zz get() = DVec2(z, z)
inline val DVec4.zw get() = DVec2(z, w)
inline val DVec4.wx get() = DVec2(w, x)
inline val DVec4.wy get() = DVec2(w, y)
inline val DVec4.wz get() = DVec2(w, z)
inline val DVec4.ww get() = DVec2(w, w)
//endregion
