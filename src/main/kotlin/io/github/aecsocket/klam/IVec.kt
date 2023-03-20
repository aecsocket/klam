@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

private const val DEFAULT: Int = 0

data class IVec2(@JvmField var x: Int, @JvmField var y: Int) {
    constructor(v: IVec2) : this(v.x, v.y)
    constructor(s: Int) : this(s, s)

    operator fun get(index: USize) = when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException(index)
    }

    operator fun set(index: USize, s: Int) = when (index) {
        0 -> x = s
        1 -> y = s
        else -> throw IndexOutOfBoundsException(index)
    }

    inline operator fun unaryMinus() = IVec2( -x,  -y)
    inline operator fun inc()        = IVec2(++x, ++y)
    inline operator fun dec()        = IVec2(--x, --y)

    inline operator fun plus(s: Int)  = IVec2(x + s, y + s)
    inline operator fun minus(s: Int) = IVec2(x - s, y - s)
    inline operator fun times(s: Int) = IVec2(x * s, y * s)
    inline operator fun div(s: Int)   = IVec2(x / s, y / s)

    inline operator fun plus(v: IVec2)  = IVec2(x + v.x, y + v.y)
    inline operator fun minus(v: IVec2) = IVec2(x - v.x, y - v.y)
    inline operator fun times(v: IVec2) = IVec2(x * v.x, y * v.y)
    inline operator fun div(v: IVec2)   = IVec2(x / v.x, y / v.y)

    inline fun compareTo(v: IVec2) = IVec2(x.compareTo(v.x), y.compareTo(v.y))
    inline fun equalTo(v: IVec2)   = x == v.x && y == v.y

    inline fun map(block: (Int) -> Int) = IVec2(block(x), block(y))
    inline fun toArray() = intArrayOf(x, y)

    inline fun asString(fmt: String = "%d") = "($fmt, $fmt)".format(x, y)
    override fun toString() = asString()
}

data class IVec3(@JvmField var x: Int, @JvmField var y: Int, @JvmField var z: Int) {
    constructor(v: IVec3) : this(v.x, v.y, v.z)
    constructor(v: IVec2, z: Int = DEFAULT) : this(v.x, v.y, z)
    constructor(s: Int) : this(s, s, s)

    operator fun get(index: USize) = when (index) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException(index)
    }

    operator fun set(index: USize, s: Int) = when (index) {
        0 -> x = s
        1 -> y = s
        2 -> z = s
        else -> throw IndexOutOfBoundsException(index)
    }

    inline operator fun unaryMinus() = IVec3( -x,  -y,  -z)
    inline operator fun inc()        = IVec3(++x, ++y, ++z)
    inline operator fun dec()        = IVec3(--x, --y, --z)

    inline operator fun plus(s: Int)  = IVec3(x + s, y + s, z + s)
    inline operator fun minus(s: Int) = IVec3(x - s, y - s, z - s)
    inline operator fun times(s: Int) = IVec3(x * s, y * s, z * s)
    inline operator fun div(s: Int)   = IVec3(x / s, y / s, z / s)

    inline operator fun plus(v: IVec3)  = IVec3(x + v.x, y + v.y, z + v.z)
    inline operator fun minus(v: IVec3) = IVec3(x - v.x, y - v.y, z - v.z)
    inline operator fun times(v: IVec3) = IVec3(x * v.x, y * v.y, z * v.z)
    inline operator fun div(v: IVec3)   = IVec3(x / v.x, y / v.y, z / v.z)

    inline fun compareTo(v: IVec3) = IVec3(x.compareTo(v.x), y.compareTo(v.y), z.compareTo(v.z))
    inline fun equalTo(v: IVec3)   = x == v.x && y == v.y && z == v.z

    inline fun map(block: (Int) -> Int) = IVec3(block(x), block(y), block(z))
    inline fun toArray() = intArrayOf(x, y, z)

    inline fun asString(fmt: String = "%d") = "($fmt, $fmt, $fmt)".format(x, y, z)
    override fun toString() = asString()
}

data class IVec4(@JvmField var x: Int, @JvmField var y: Int, @JvmField var z: Int, @JvmField var w: Int) {
    constructor(v: IVec4) : this(v.x, v.y, v.z, v.w)
    constructor(v: IVec3, w: Int = DEFAULT) : this(v.x, v.y, v.z, w)
    constructor(v: IVec2, z: Int = DEFAULT, w: Int = DEFAULT) : this(v.x, v.y, z, w)
    constructor(s: Int) : this(s, s, s, s)

    operator fun get(index: USize) = when (index) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException(index)
    }

    operator fun set(index: USize, s: Int) = when (index) {
        0 -> x = s
        1 -> y = s
        2 -> z = s
        3 -> w = s
        else -> throw IndexOutOfBoundsException(index)
    }

    inline operator fun unaryMinus() = IVec4( -x,  -y,  -z,  -w)
    inline operator fun inc()        = IVec4(++x, ++y, ++z, ++w)
    inline operator fun dec()        = IVec4(--x, --y, --z, --w)

    inline operator fun plus(s: Int)  = IVec4(x + s, y + s, z + s, w + s)
    inline operator fun minus(s: Int) = IVec4(x - s, y - s, z - s, w - s)
    inline operator fun times(s: Int) = IVec4(x * s, y * s, z * s, w * s)
    inline operator fun div(s: Int)   = IVec4(x / s, y / s, z / s, w / s)

    inline operator fun plus(v: IVec4)  = IVec4(x + v.x, y + v.y, z + v.z, w + v.w)
    inline operator fun minus(v: IVec4) = IVec4(x - v.x, y - v.y, z - v.z, w - v.w)
    inline operator fun times(v: IVec4) = IVec4(x * v.x, y * v.y, z * v.z, w * v.w)
    inline operator fun div(v: IVec4)   = IVec4(x / v.x, y / v.y, z / v.z, w / v.w)

    inline fun compareTo(v: IVec4) = IVec4(x.compareTo(v.x), y.compareTo(v.y), z.compareTo(v.z), w.compareTo(v.w))
    inline fun equalTo(v: IVec4)   = x == v.x && y == v.y && z == v.z && w == v.w

    inline fun map(block: (Int) -> Int) = IVec4(block(x), block(y), block(z), block(w))
    inline fun toArray() = intArrayOf(x, y, z, w)

    inline fun asString(fmt: String = "%d") = "($fmt, $fmt, $fmt, $fmt)".format(x, y, z, w)
    override fun toString() = asString()
}

//region Alternate accessors
inline var IVec2.r: Int
    get() = x
    set(value) { x = value }
inline var IVec2.g: Int
    get() = y
    set(value) { y = value }

inline var IVec3.r: Int
    get() = x
    set(value) { x = value }
inline var IVec3.g: Int
    get() = y
    set(value) { y = value }
inline var IVec3.b: Int
    get() = z
    set(value) { z = value }

inline var IVec4.r: Int
    get() = x
    set(value) { x = value }
inline var IVec4.g: Int
    get() = y
    set(value) { y = value }
inline var IVec4.b: Int
    get() = z
    set(value) { z = value }
inline var IVec4.a: Int
    get() = w
    set(value) { w = value }

inline var IVec2.s: Int
    get() = x
    set(value) { x = value }
inline var IVec2.t: Int
    get() = y
    set(value) { y = value }

inline var IVec3.s: Int
    get() = x
    set(value) { x = value }
inline var IVec3.t: Int
    get() = y
    set(value) { y = value }
inline var IVec3.p: Int
    get() = z
    set(value) { z = value }

inline var IVec4.s: Int
    get() = x
    set(value) { x = value }
inline var IVec4.t: Int
    get() = y
    set(value) { y = value }
inline var IVec4.p: Int
    get() = z
    set(value) { z = value }
inline var IVec4.q: Int
    get() = w
    set(value) { w = value }
//endregion

//region Swizzling Vec2
inline val IVec2.xxxx get() = IVec4(x, x, x, x)
inline val IVec2.xxxy get() = IVec4(x, x, x, y)
inline val IVec2.xxyx get() = IVec4(x, x, y, x)
inline val IVec2.xxyy get() = IVec4(x, x, y, y)
inline val IVec2.xyxx get() = IVec4(x, y, x, x)
inline val IVec2.xyxy get() = IVec4(x, y, x, y)
inline val IVec2.xyyx get() = IVec4(x, y, y, x)
inline val IVec2.xyyy get() = IVec4(x, y, y, y)
inline val IVec2.yxxx get() = IVec4(y, x, x, x)
inline val IVec2.yxxy get() = IVec4(y, x, x, y)
inline val IVec2.yxyx get() = IVec4(y, x, y, x)
inline val IVec2.yxyy get() = IVec4(y, x, y, y)
inline val IVec2.yyxx get() = IVec4(y, y, x, x)
inline val IVec2.yyxy get() = IVec4(y, y, x, y)
inline val IVec2.yyyx get() = IVec4(y, y, y, x)
inline val IVec2.yyyy get() = IVec4(y, y, y, y)

inline val IVec2.xxx get() = IVec3(x, x, x)
inline val IVec2.xxy get() = IVec3(x, x, y)
inline val IVec2.xyx get() = IVec3(x, y, x)
inline val IVec2.xyy get() = IVec3(x, y, y)
inline val IVec2.yxx get() = IVec3(y, x, x)
inline val IVec2.yxy get() = IVec3(y, x, y)
inline val IVec2.yyx get() = IVec3(y, y, x)
inline val IVec2.yyy get() = IVec3(y, y, y)

inline val IVec2.xx get() = IVec2(x, x)
inline val IVec2.xy get() = IVec2(x, y)
inline val IVec2.yx get() = IVec2(y, x)
inline val IVec2.yy get() = IVec2(y, y)
//endregion

//region Swizzling Vec3
inline val IVec3.xxxx get() = IVec4(x, x, x, x)
inline val IVec3.xxxy get() = IVec4(x, x, x, y)
inline val IVec3.xxxz get() = IVec4(x, x, x, z)
inline val IVec3.xxyx get() = IVec4(x, x, y, x)
inline val IVec3.xxyy get() = IVec4(x, x, y, y)
inline val IVec3.xxyz get() = IVec4(x, x, y, z)
inline val IVec3.xxzx get() = IVec4(x, x, z, x)
inline val IVec3.xxzy get() = IVec4(x, x, z, y)
inline val IVec3.xxzz get() = IVec4(x, x, z, z)
inline val IVec3.xyxx get() = IVec4(x, y, x, x)
inline val IVec3.xyxy get() = IVec4(x, y, x, y)
inline val IVec3.xyxz get() = IVec4(x, y, x, z)
inline val IVec3.xyyx get() = IVec4(x, y, y, x)
inline val IVec3.xyyy get() = IVec4(x, y, y, y)
inline val IVec3.xyyz get() = IVec4(x, y, y, z)
inline val IVec3.xyzx get() = IVec4(x, y, z, x)
inline val IVec3.xyzy get() = IVec4(x, y, z, y)
inline val IVec3.xyzz get() = IVec4(x, y, z, z)
inline val IVec3.xzxx get() = IVec4(x, z, x, x)
inline val IVec3.xzxy get() = IVec4(x, z, x, y)
inline val IVec3.xzxz get() = IVec4(x, z, x, z)
inline val IVec3.xzyx get() = IVec4(x, z, y, x)
inline val IVec3.xzyy get() = IVec4(x, z, y, y)
inline val IVec3.xzyz get() = IVec4(x, z, y, z)
inline val IVec3.xzzx get() = IVec4(x, z, z, x)
inline val IVec3.xzzy get() = IVec4(x, z, z, y)
inline val IVec3.xzzz get() = IVec4(x, z, z, z)
inline val IVec3.yxxx get() = IVec4(y, x, x, x)
inline val IVec3.yxxy get() = IVec4(y, x, x, y)
inline val IVec3.yxxz get() = IVec4(y, x, x, z)
inline val IVec3.yxyx get() = IVec4(y, x, y, x)
inline val IVec3.yxyy get() = IVec4(y, x, y, y)
inline val IVec3.yxyz get() = IVec4(y, x, y, z)
inline val IVec3.yxzx get() = IVec4(y, x, z, x)
inline val IVec3.yxzy get() = IVec4(y, x, z, y)
inline val IVec3.yxzz get() = IVec4(y, x, z, z)
inline val IVec3.yyxx get() = IVec4(y, y, x, x)
inline val IVec3.yyxy get() = IVec4(y, y, x, y)
inline val IVec3.yyxz get() = IVec4(y, y, x, z)
inline val IVec3.yyyx get() = IVec4(y, y, y, x)
inline val IVec3.yyyy get() = IVec4(y, y, y, y)
inline val IVec3.yyyz get() = IVec4(y, y, y, z)
inline val IVec3.yyzx get() = IVec4(y, y, z, x)
inline val IVec3.yyzy get() = IVec4(y, y, z, y)
inline val IVec3.yyzz get() = IVec4(y, y, z, z)
inline val IVec3.yzxx get() = IVec4(y, z, x, x)
inline val IVec3.yzxy get() = IVec4(y, z, x, y)
inline val IVec3.yzxz get() = IVec4(y, z, x, z)
inline val IVec3.yzyx get() = IVec4(y, z, y, x)
inline val IVec3.yzyy get() = IVec4(y, z, y, y)
inline val IVec3.yzyz get() = IVec4(y, z, y, z)
inline val IVec3.yzzx get() = IVec4(y, z, z, x)
inline val IVec3.yzzy get() = IVec4(y, z, z, y)
inline val IVec3.yzzz get() = IVec4(y, z, z, z)
inline val IVec3.zxxx get() = IVec4(z, x, x, x)
inline val IVec3.zxxy get() = IVec4(z, x, x, y)
inline val IVec3.zxxz get() = IVec4(z, x, x, z)
inline val IVec3.zxyx get() = IVec4(z, x, y, x)
inline val IVec3.zxyy get() = IVec4(z, x, y, y)
inline val IVec3.zxyz get() = IVec4(z, x, y, z)
inline val IVec3.zxzx get() = IVec4(z, x, z, x)
inline val IVec3.zxzy get() = IVec4(z, x, z, y)
inline val IVec3.zxzz get() = IVec4(z, x, z, z)
inline val IVec3.zyxx get() = IVec4(z, y, x, x)
inline val IVec3.zyxy get() = IVec4(z, y, x, y)
inline val IVec3.zyxz get() = IVec4(z, y, x, z)
inline val IVec3.zyyx get() = IVec4(z, y, y, x)
inline val IVec3.zyyy get() = IVec4(z, y, y, y)
inline val IVec3.zyyz get() = IVec4(z, y, y, z)
inline val IVec3.zyzx get() = IVec4(z, y, z, x)
inline val IVec3.zyzy get() = IVec4(z, y, z, y)
inline val IVec3.zyzz get() = IVec4(z, y, z, z)
inline val IVec3.zzxx get() = IVec4(z, z, x, x)
inline val IVec3.zzxy get() = IVec4(z, z, x, y)
inline val IVec3.zzxz get() = IVec4(z, z, x, z)
inline val IVec3.zzyx get() = IVec4(z, z, y, x)
inline val IVec3.zzyy get() = IVec4(z, z, y, y)
inline val IVec3.zzyz get() = IVec4(z, z, y, z)
inline val IVec3.zzzx get() = IVec4(z, z, z, x)
inline val IVec3.zzzy get() = IVec4(z, z, z, y)
inline val IVec3.zzzz get() = IVec4(z, z, z, z)

inline val IVec3.xxx get() = IVec3(x, x, x)
inline val IVec3.xxy get() = IVec3(x, x, y)
inline val IVec3.xxz get() = IVec3(x, x, z)
inline val IVec3.xyx get() = IVec3(x, y, x)
inline val IVec3.xyy get() = IVec3(x, y, y)
inline val IVec3.xyz get() = IVec3(x, y, z)
inline val IVec3.xzx get() = IVec3(x, z, x)
inline val IVec3.xzy get() = IVec3(x, z, y)
inline val IVec3.xzz get() = IVec3(x, z, z)
inline val IVec3.yxx get() = IVec3(y, x, x)
inline val IVec3.yxy get() = IVec3(y, x, y)
inline val IVec3.yxz get() = IVec3(y, x, z)
inline val IVec3.yyx get() = IVec3(y, y, x)
inline val IVec3.yyy get() = IVec3(y, y, y)
inline val IVec3.yyz get() = IVec3(y, y, z)
inline val IVec3.yzx get() = IVec3(y, z, x)
inline val IVec3.yzy get() = IVec3(y, z, y)
inline val IVec3.yzz get() = IVec3(y, z, z)
inline val IVec3.zxx get() = IVec3(z, x, x)
inline val IVec3.zxy get() = IVec3(z, x, y)
inline val IVec3.zxz get() = IVec3(z, x, z)
inline val IVec3.zyx get() = IVec3(z, y, x)
inline val IVec3.zyy get() = IVec3(z, y, y)
inline val IVec3.zyz get() = IVec3(z, y, z)
inline val IVec3.zzx get() = IVec3(z, z, x)
inline val IVec3.zzy get() = IVec3(z, z, y)
inline val IVec3.zzz get() = IVec3(z, z, z)

inline val IVec3.xx get() = IVec2(x, x)
inline val IVec3.xy get() = IVec2(x, y)
inline val IVec3.xz get() = IVec2(x, z)
inline val IVec3.yx get() = IVec2(y, x)
inline val IVec3.yy get() = IVec2(y, y)
inline val IVec3.yz get() = IVec2(y, z)
inline val IVec3.zx get() = IVec2(z, x)
inline val IVec3.zy get() = IVec2(z, y)
inline val IVec3.zz get() = IVec2(z, z)
//endregion

//region Swizzling Vec4
inline val IVec4.xxxx get() = IVec4(x, x, x, x)
inline val IVec4.xxxy get() = IVec4(x, x, x, y)
inline val IVec4.xxxz get() = IVec4(x, x, x, z)
inline val IVec4.xxxw get() = IVec4(x, x, x, w)
inline val IVec4.xxyx get() = IVec4(x, x, y, x)
inline val IVec4.xxyy get() = IVec4(x, x, y, y)
inline val IVec4.xxyz get() = IVec4(x, x, y, z)
inline val IVec4.xxyw get() = IVec4(x, x, y, w)
inline val IVec4.xxzx get() = IVec4(x, x, z, x)
inline val IVec4.xxzy get() = IVec4(x, x, z, y)
inline val IVec4.xxzz get() = IVec4(x, x, z, z)
inline val IVec4.xxzw get() = IVec4(x, x, z, w)
inline val IVec4.xxwx get() = IVec4(x, x, w, x)
inline val IVec4.xxwy get() = IVec4(x, x, w, y)
inline val IVec4.xxwz get() = IVec4(x, x, w, z)
inline val IVec4.xxww get() = IVec4(x, x, w, w)
inline val IVec4.xyxx get() = IVec4(x, y, x, x)
inline val IVec4.xyxy get() = IVec4(x, y, x, y)
inline val IVec4.xyxz get() = IVec4(x, y, x, z)
inline val IVec4.xyxw get() = IVec4(x, y, x, w)
inline val IVec4.xyyx get() = IVec4(x, y, y, x)
inline val IVec4.xyyy get() = IVec4(x, y, y, y)
inline val IVec4.xyyz get() = IVec4(x, y, y, z)
inline val IVec4.xyyw get() = IVec4(x, y, y, w)
inline val IVec4.xyzx get() = IVec4(x, y, z, x)
inline val IVec4.xyzy get() = IVec4(x, y, z, y)
inline val IVec4.xyzz get() = IVec4(x, y, z, z)
inline val IVec4.xyzw get() = IVec4(x, y, z, w)
inline val IVec4.xywx get() = IVec4(x, y, w, x)
inline val IVec4.xywy get() = IVec4(x, y, w, y)
inline val IVec4.xywz get() = IVec4(x, y, w, z)
inline val IVec4.xyww get() = IVec4(x, y, w, w)
inline val IVec4.xzxx get() = IVec4(x, z, x, x)
inline val IVec4.xzxy get() = IVec4(x, z, x, y)
inline val IVec4.xzxz get() = IVec4(x, z, x, z)
inline val IVec4.xzxw get() = IVec4(x, z, x, w)
inline val IVec4.xzyx get() = IVec4(x, z, y, x)
inline val IVec4.xzyy get() = IVec4(x, z, y, y)
inline val IVec4.xzyz get() = IVec4(x, z, y, z)
inline val IVec4.xzyw get() = IVec4(x, z, y, w)
inline val IVec4.xzzx get() = IVec4(x, z, z, x)
inline val IVec4.xzzy get() = IVec4(x, z, z, y)
inline val IVec4.xzzz get() = IVec4(x, z, z, z)
inline val IVec4.xzzw get() = IVec4(x, z, z, w)
inline val IVec4.xzwx get() = IVec4(x, z, w, x)
inline val IVec4.xzwy get() = IVec4(x, z, w, y)
inline val IVec4.xzwz get() = IVec4(x, z, w, z)
inline val IVec4.xzww get() = IVec4(x, z, w, w)
inline val IVec4.xwxx get() = IVec4(x, w, x, x)
inline val IVec4.xwxy get() = IVec4(x, w, x, y)
inline val IVec4.xwxz get() = IVec4(x, w, x, z)
inline val IVec4.xwxw get() = IVec4(x, w, x, w)
inline val IVec4.xwyx get() = IVec4(x, w, y, x)
inline val IVec4.xwyy get() = IVec4(x, w, y, y)
inline val IVec4.xwyz get() = IVec4(x, w, y, z)
inline val IVec4.xwyw get() = IVec4(x, w, y, w)
inline val IVec4.xwzx get() = IVec4(x, w, z, x)
inline val IVec4.xwzy get() = IVec4(x, w, z, y)
inline val IVec4.xwzz get() = IVec4(x, w, z, z)
inline val IVec4.xwzw get() = IVec4(x, w, z, w)
inline val IVec4.xwwx get() = IVec4(x, w, w, x)
inline val IVec4.xwwy get() = IVec4(x, w, w, y)
inline val IVec4.xwwz get() = IVec4(x, w, w, z)
inline val IVec4.xwww get() = IVec4(x, w, w, w)
inline val IVec4.yxxx get() = IVec4(y, x, x, x)
inline val IVec4.yxxy get() = IVec4(y, x, x, y)
inline val IVec4.yxxz get() = IVec4(y, x, x, z)
inline val IVec4.yxxw get() = IVec4(y, x, x, w)
inline val IVec4.yxyx get() = IVec4(y, x, y, x)
inline val IVec4.yxyy get() = IVec4(y, x, y, y)
inline val IVec4.yxyz get() = IVec4(y, x, y, z)
inline val IVec4.yxyw get() = IVec4(y, x, y, w)
inline val IVec4.yxzx get() = IVec4(y, x, z, x)
inline val IVec4.yxzy get() = IVec4(y, x, z, y)
inline val IVec4.yxzz get() = IVec4(y, x, z, z)
inline val IVec4.yxzw get() = IVec4(y, x, z, w)
inline val IVec4.yxwx get() = IVec4(y, x, w, x)
inline val IVec4.yxwy get() = IVec4(y, x, w, y)
inline val IVec4.yxwz get() = IVec4(y, x, w, z)
inline val IVec4.yxww get() = IVec4(y, x, w, w)
inline val IVec4.yyxx get() = IVec4(y, y, x, x)
inline val IVec4.yyxy get() = IVec4(y, y, x, y)
inline val IVec4.yyxz get() = IVec4(y, y, x, z)
inline val IVec4.yyxw get() = IVec4(y, y, x, w)
inline val IVec4.yyyx get() = IVec4(y, y, y, x)
inline val IVec4.yyyy get() = IVec4(y, y, y, y)
inline val IVec4.yyyz get() = IVec4(y, y, y, z)
inline val IVec4.yyyw get() = IVec4(y, y, y, w)
inline val IVec4.yyzx get() = IVec4(y, y, z, x)
inline val IVec4.yyzy get() = IVec4(y, y, z, y)
inline val IVec4.yyzz get() = IVec4(y, y, z, z)
inline val IVec4.yyzw get() = IVec4(y, y, z, w)
inline val IVec4.yywx get() = IVec4(y, y, w, x)
inline val IVec4.yywy get() = IVec4(y, y, w, y)
inline val IVec4.yywz get() = IVec4(y, y, w, z)
inline val IVec4.yyww get() = IVec4(y, y, w, w)
inline val IVec4.yzxx get() = IVec4(y, z, x, x)
inline val IVec4.yzxy get() = IVec4(y, z, x, y)
inline val IVec4.yzxz get() = IVec4(y, z, x, z)
inline val IVec4.yzxw get() = IVec4(y, z, x, w)
inline val IVec4.yzyx get() = IVec4(y, z, y, x)
inline val IVec4.yzyy get() = IVec4(y, z, y, y)
inline val IVec4.yzyz get() = IVec4(y, z, y, z)
inline val IVec4.yzyw get() = IVec4(y, z, y, w)
inline val IVec4.yzzx get() = IVec4(y, z, z, x)
inline val IVec4.yzzy get() = IVec4(y, z, z, y)
inline val IVec4.yzzz get() = IVec4(y, z, z, z)
inline val IVec4.yzzw get() = IVec4(y, z, z, w)
inline val IVec4.yzwx get() = IVec4(y, z, w, x)
inline val IVec4.yzwy get() = IVec4(y, z, w, y)
inline val IVec4.yzwz get() = IVec4(y, z, w, z)
inline val IVec4.yzww get() = IVec4(y, z, w, w)
inline val IVec4.ywxx get() = IVec4(y, w, x, x)
inline val IVec4.ywxy get() = IVec4(y, w, x, y)
inline val IVec4.ywxz get() = IVec4(y, w, x, z)
inline val IVec4.ywxw get() = IVec4(y, w, x, w)
inline val IVec4.ywyx get() = IVec4(y, w, y, x)
inline val IVec4.ywyy get() = IVec4(y, w, y, y)
inline val IVec4.ywyz get() = IVec4(y, w, y, z)
inline val IVec4.ywyw get() = IVec4(y, w, y, w)
inline val IVec4.ywzx get() = IVec4(y, w, z, x)
inline val IVec4.ywzy get() = IVec4(y, w, z, y)
inline val IVec4.ywzz get() = IVec4(y, w, z, z)
inline val IVec4.ywzw get() = IVec4(y, w, z, w)
inline val IVec4.ywwx get() = IVec4(y, w, w, x)
inline val IVec4.ywwy get() = IVec4(y, w, w, y)
inline val IVec4.ywwz get() = IVec4(y, w, w, z)
inline val IVec4.ywww get() = IVec4(y, w, w, w)
inline val IVec4.zxxx get() = IVec4(z, x, x, x)
inline val IVec4.zxxy get() = IVec4(z, x, x, y)
inline val IVec4.zxxz get() = IVec4(z, x, x, z)
inline val IVec4.zxxw get() = IVec4(z, x, x, w)
inline val IVec4.zxyx get() = IVec4(z, x, y, x)
inline val IVec4.zxyy get() = IVec4(z, x, y, y)
inline val IVec4.zxyz get() = IVec4(z, x, y, z)
inline val IVec4.zxyw get() = IVec4(z, x, y, w)
inline val IVec4.zxzx get() = IVec4(z, x, z, x)
inline val IVec4.zxzy get() = IVec4(z, x, z, y)
inline val IVec4.zxzz get() = IVec4(z, x, z, z)
inline val IVec4.zxzw get() = IVec4(z, x, z, w)
inline val IVec4.zxwx get() = IVec4(z, x, w, x)
inline val IVec4.zxwy get() = IVec4(z, x, w, y)
inline val IVec4.zxwz get() = IVec4(z, x, w, z)
inline val IVec4.zxww get() = IVec4(z, x, w, w)
inline val IVec4.zyxx get() = IVec4(z, y, x, x)
inline val IVec4.zyxy get() = IVec4(z, y, x, y)
inline val IVec4.zyxz get() = IVec4(z, y, x, z)
inline val IVec4.zyxw get() = IVec4(z, y, x, w)
inline val IVec4.zyyx get() = IVec4(z, y, y, x)
inline val IVec4.zyyy get() = IVec4(z, y, y, y)
inline val IVec4.zyyz get() = IVec4(z, y, y, z)
inline val IVec4.zyyw get() = IVec4(z, y, y, w)
inline val IVec4.zyzx get() = IVec4(z, y, z, x)
inline val IVec4.zyzy get() = IVec4(z, y, z, y)
inline val IVec4.zyzz get() = IVec4(z, y, z, z)
inline val IVec4.zyzw get() = IVec4(z, y, z, w)
inline val IVec4.zywx get() = IVec4(z, y, w, x)
inline val IVec4.zywy get() = IVec4(z, y, w, y)
inline val IVec4.zywz get() = IVec4(z, y, w, z)
inline val IVec4.zyww get() = IVec4(z, y, w, w)
inline val IVec4.zzxx get() = IVec4(z, z, x, x)
inline val IVec4.zzxy get() = IVec4(z, z, x, y)
inline val IVec4.zzxz get() = IVec4(z, z, x, z)
inline val IVec4.zzxw get() = IVec4(z, z, x, w)
inline val IVec4.zzyx get() = IVec4(z, z, y, x)
inline val IVec4.zzyy get() = IVec4(z, z, y, y)
inline val IVec4.zzyz get() = IVec4(z, z, y, z)
inline val IVec4.zzyw get() = IVec4(z, z, y, w)
inline val IVec4.zzzx get() = IVec4(z, z, z, x)
inline val IVec4.zzzy get() = IVec4(z, z, z, y)
inline val IVec4.zzzz get() = IVec4(z, z, z, z)
inline val IVec4.zzzw get() = IVec4(z, z, z, w)
inline val IVec4.zzwx get() = IVec4(z, z, w, x)
inline val IVec4.zzwy get() = IVec4(z, z, w, y)
inline val IVec4.zzwz get() = IVec4(z, z, w, z)
inline val IVec4.zzww get() = IVec4(z, z, w, w)
inline val IVec4.zwxx get() = IVec4(z, w, x, x)
inline val IVec4.zwxy get() = IVec4(z, w, x, y)
inline val IVec4.zwxz get() = IVec4(z, w, x, z)
inline val IVec4.zwxw get() = IVec4(z, w, x, w)
inline val IVec4.zwyx get() = IVec4(z, w, y, x)
inline val IVec4.zwyy get() = IVec4(z, w, y, y)
inline val IVec4.zwyz get() = IVec4(z, w, y, z)
inline val IVec4.zwyw get() = IVec4(z, w, y, w)
inline val IVec4.zwzx get() = IVec4(z, w, z, x)
inline val IVec4.zwzy get() = IVec4(z, w, z, y)
inline val IVec4.zwzz get() = IVec4(z, w, z, z)
inline val IVec4.zwzw get() = IVec4(z, w, z, w)
inline val IVec4.zwwx get() = IVec4(z, w, w, x)
inline val IVec4.zwwy get() = IVec4(z, w, w, y)
inline val IVec4.zwwz get() = IVec4(z, w, w, z)
inline val IVec4.zwww get() = IVec4(z, w, w, w)
inline val IVec4.wxxx get() = IVec4(w, x, x, x)
inline val IVec4.wxxy get() = IVec4(w, x, x, y)
inline val IVec4.wxxz get() = IVec4(w, x, x, z)
inline val IVec4.wxxw get() = IVec4(w, x, x, w)
inline val IVec4.wxyx get() = IVec4(w, x, y, x)
inline val IVec4.wxyy get() = IVec4(w, x, y, y)
inline val IVec4.wxyz get() = IVec4(w, x, y, z)
inline val IVec4.wxyw get() = IVec4(w, x, y, w)
inline val IVec4.wxzx get() = IVec4(w, x, z, x)
inline val IVec4.wxzy get() = IVec4(w, x, z, y)
inline val IVec4.wxzz get() = IVec4(w, x, z, z)
inline val IVec4.wxzw get() = IVec4(w, x, z, w)
inline val IVec4.wxwx get() = IVec4(w, x, w, x)
inline val IVec4.wxwy get() = IVec4(w, x, w, y)
inline val IVec4.wxwz get() = IVec4(w, x, w, z)
inline val IVec4.wxww get() = IVec4(w, x, w, w)
inline val IVec4.wyxx get() = IVec4(w, y, x, x)
inline val IVec4.wyxy get() = IVec4(w, y, x, y)
inline val IVec4.wyxz get() = IVec4(w, y, x, z)
inline val IVec4.wyxw get() = IVec4(w, y, x, w)
inline val IVec4.wyyx get() = IVec4(w, y, y, x)
inline val IVec4.wyyy get() = IVec4(w, y, y, y)
inline val IVec4.wyyz get() = IVec4(w, y, y, z)
inline val IVec4.wyyw get() = IVec4(w, y, y, w)
inline val IVec4.wyzx get() = IVec4(w, y, z, x)
inline val IVec4.wyzy get() = IVec4(w, y, z, y)
inline val IVec4.wyzz get() = IVec4(w, y, z, z)
inline val IVec4.wyzw get() = IVec4(w, y, z, w)
inline val IVec4.wywx get() = IVec4(w, y, w, x)
inline val IVec4.wywy get() = IVec4(w, y, w, y)
inline val IVec4.wywz get() = IVec4(w, y, w, z)
inline val IVec4.wyww get() = IVec4(w, y, w, w)
inline val IVec4.wzxx get() = IVec4(w, z, x, x)
inline val IVec4.wzxy get() = IVec4(w, z, x, y)
inline val IVec4.wzxz get() = IVec4(w, z, x, z)
inline val IVec4.wzxw get() = IVec4(w, z, x, w)
inline val IVec4.wzyx get() = IVec4(w, z, y, x)
inline val IVec4.wzyy get() = IVec4(w, z, y, y)
inline val IVec4.wzyz get() = IVec4(w, z, y, z)
inline val IVec4.wzyw get() = IVec4(w, z, y, w)
inline val IVec4.wzzx get() = IVec4(w, z, z, x)
inline val IVec4.wzzy get() = IVec4(w, z, z, y)
inline val IVec4.wzzz get() = IVec4(w, z, z, z)
inline val IVec4.wzzw get() = IVec4(w, z, z, w)
inline val IVec4.wzwx get() = IVec4(w, z, w, x)
inline val IVec4.wzwy get() = IVec4(w, z, w, y)
inline val IVec4.wzwz get() = IVec4(w, z, w, z)
inline val IVec4.wzww get() = IVec4(w, z, w, w)
inline val IVec4.wwxx get() = IVec4(w, w, x, x)
inline val IVec4.wwxy get() = IVec4(w, w, x, y)
inline val IVec4.wwxz get() = IVec4(w, w, x, z)
inline val IVec4.wwxw get() = IVec4(w, w, x, w)
inline val IVec4.wwyx get() = IVec4(w, w, y, x)
inline val IVec4.wwyy get() = IVec4(w, w, y, y)
inline val IVec4.wwyz get() = IVec4(w, w, y, z)
inline val IVec4.wwyw get() = IVec4(w, w, y, w)
inline val IVec4.wwzx get() = IVec4(w, w, z, x)
inline val IVec4.wwzy get() = IVec4(w, w, z, y)
inline val IVec4.wwzz get() = IVec4(w, w, z, z)
inline val IVec4.wwzw get() = IVec4(w, w, z, w)
inline val IVec4.wwwx get() = IVec4(w, w, w, x)
inline val IVec4.wwwy get() = IVec4(w, w, w, y)
inline val IVec4.wwwz get() = IVec4(w, w, w, z)
inline val IVec4.wwww get() = IVec4(w, w, w, w)

inline val IVec4.xxx get() = IVec3(x, x, x)
inline val IVec4.xxy get() = IVec3(x, x, y)
inline val IVec4.xxz get() = IVec3(x, x, z)
inline val IVec4.xxw get() = IVec3(x, x, w)
inline val IVec4.xyx get() = IVec3(x, y, x)
inline val IVec4.xyy get() = IVec3(x, y, y)
inline val IVec4.xyz get() = IVec3(x, y, z)
inline val IVec4.xyw get() = IVec3(x, y, w)
inline val IVec4.xzx get() = IVec3(x, z, x)
inline val IVec4.xzy get() = IVec3(x, z, y)
inline val IVec4.xzz get() = IVec3(x, z, z)
inline val IVec4.xzw get() = IVec3(x, z, w)
inline val IVec4.xwx get() = IVec3(x, w, x)
inline val IVec4.xwy get() = IVec3(x, w, y)
inline val IVec4.xwz get() = IVec3(x, w, z)
inline val IVec4.xww get() = IVec3(x, w, w)
inline val IVec4.yxx get() = IVec3(y, x, x)
inline val IVec4.yxy get() = IVec3(y, x, y)
inline val IVec4.yxz get() = IVec3(y, x, z)
inline val IVec4.yxw get() = IVec3(y, x, w)
inline val IVec4.yyx get() = IVec3(y, y, x)
inline val IVec4.yyy get() = IVec3(y, y, y)
inline val IVec4.yyz get() = IVec3(y, y, z)
inline val IVec4.yyw get() = IVec3(y, y, w)
inline val IVec4.yzx get() = IVec3(y, z, x)
inline val IVec4.yzy get() = IVec3(y, z, y)
inline val IVec4.yzz get() = IVec3(y, z, z)
inline val IVec4.yzw get() = IVec3(y, z, w)
inline val IVec4.ywx get() = IVec3(y, w, x)
inline val IVec4.ywy get() = IVec3(y, w, y)
inline val IVec4.ywz get() = IVec3(y, w, z)
inline val IVec4.yww get() = IVec3(y, w, w)
inline val IVec4.zxx get() = IVec3(z, x, x)
inline val IVec4.zxy get() = IVec3(z, x, y)
inline val IVec4.zxz get() = IVec3(z, x, z)
inline val IVec4.zxw get() = IVec3(z, x, w)
inline val IVec4.zyx get() = IVec3(z, y, x)
inline val IVec4.zyy get() = IVec3(z, y, y)
inline val IVec4.zyz get() = IVec3(z, y, z)
inline val IVec4.zyw get() = IVec3(z, y, w)
inline val IVec4.zzx get() = IVec3(z, z, x)
inline val IVec4.zzy get() = IVec3(z, z, y)
inline val IVec4.zzz get() = IVec3(z, z, z)
inline val IVec4.zzw get() = IVec3(z, z, w)
inline val IVec4.zwx get() = IVec3(z, w, x)
inline val IVec4.zwy get() = IVec3(z, w, y)
inline val IVec4.zwz get() = IVec3(z, w, z)
inline val IVec4.zww get() = IVec3(z, w, w)
inline val IVec4.wxx get() = IVec3(w, x, x)
inline val IVec4.wxy get() = IVec3(w, x, y)
inline val IVec4.wxz get() = IVec3(w, x, z)
inline val IVec4.wxw get() = IVec3(w, x, w)
inline val IVec4.wyx get() = IVec3(w, y, x)
inline val IVec4.wyy get() = IVec3(w, y, y)
inline val IVec4.wyz get() = IVec3(w, y, z)
inline val IVec4.wyw get() = IVec3(w, y, w)
inline val IVec4.wzx get() = IVec3(w, z, x)
inline val IVec4.wzy get() = IVec3(w, z, y)
inline val IVec4.wzz get() = IVec3(w, z, z)
inline val IVec4.wzw get() = IVec3(w, z, w)
inline val IVec4.wwx get() = IVec3(w, w, x)
inline val IVec4.wwy get() = IVec3(w, w, y)
inline val IVec4.wwz get() = IVec3(w, w, z)
inline val IVec4.www get() = IVec3(w, w, w)

inline val IVec4.xx get() = IVec2(x, x)
inline val IVec4.xy get() = IVec2(x, y)
inline val IVec4.xz get() = IVec2(x, z)
inline val IVec4.xw get() = IVec2(x, w)
inline val IVec4.yx get() = IVec2(y, x)
inline val IVec4.yy get() = IVec2(y, y)
inline val IVec4.yz get() = IVec2(y, z)
inline val IVec4.yw get() = IVec2(y, w)
inline val IVec4.zx get() = IVec2(z, x)
inline val IVec4.zy get() = IVec2(z, y)
inline val IVec4.zz get() = IVec2(z, z)
inline val IVec4.zw get() = IVec2(z, w)
inline val IVec4.wx get() = IVec2(w, x)
inline val IVec4.wy get() = IVec2(w, y)
inline val IVec4.wz get() = IVec2(w, z)
inline val IVec4.ww get() = IVec2(w, w)
//endregion
