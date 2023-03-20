@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

private const val DEFAULT: Float = 0.0f

data class FVec2(@JvmField var x: Float, @JvmField var y: Float) {
    constructor(v: FVec2) : this(v.x, v.y)
    constructor(s: Float) : this(s, s)

    operator fun get(index: USize) = when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException(index)
    }

    operator fun set(index: USize, s: Float) = when (index) {
        0 -> x = s
        1 -> y = s
        else -> throw IndexOutOfBoundsException(index)
    }

    inline operator fun unaryMinus() = FVec2( -x,  -y)
    inline operator fun inc()        = FVec2(++x, ++y)
    inline operator fun dec()        = FVec2(--x, --y)

    inline operator fun plus(s: Float)  = FVec2(x + s, y + s)
    inline operator fun minus(s: Float) = FVec2(x - s, y - s)
    inline operator fun times(s: Float) = FVec2(x * s, y * s)
    inline operator fun div(s: Float)   = FVec2(x / s, y / s)

    inline operator fun plus(v: FVec2)  = FVec2(x + v.x, y + v.y)
    inline operator fun minus(v: FVec2) = FVec2(x - v.x, y - v.y)
    inline operator fun times(v: FVec2) = FVec2(x * v.x, y * v.y)
    inline operator fun div(v: FVec2)   = FVec2(x / v.x, y / v.y)

    inline fun compareTo(v: FVec2) = IVec2(x.compareTo(v.x), y.compareTo(v.y))
    inline fun equalTo(v: FVec2)   = x.compareTo(v.x) == 0 && y.compareTo(v.y) == 0

    inline fun map(block: (Float) -> Float) = FVec2(block(x), block(y))
    inline fun toArray() = floatArrayOf(x, y)

    inline fun asString(fmt: String = "%f") = "($fmt, $fmt)".format(x, y)
    override fun toString() = asString(DECIMAL_FORMAT)
}

data class FVec3(@JvmField var x: Float, @JvmField var y: Float, @JvmField var z: Float) {
    constructor(v: FVec3) : this(v.x, v.y, v.z)
    constructor(v: FVec2, z: Float = DEFAULT) : this(v.x, v.y, z)
    constructor(s: Float) : this(s, s, s)

    operator fun get(index: USize) = when (index) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException(index)
    }

    operator fun set(index: USize, s: Float) = when (index) {
        0 -> x = s
        1 -> y = s
        2 -> z = s
        else -> throw IndexOutOfBoundsException(index)
    }

    inline operator fun unaryMinus() = FVec3( -x,  -y,  -z)
    inline operator fun inc()        = FVec3(++x, ++y, ++z)
    inline operator fun dec()        = FVec3(--x, --y, --z)

    inline operator fun plus(s: Float)  = FVec3(x + s, y + s, z + s)
    inline operator fun minus(s: Float) = FVec3(x - s, y - s, z - s)
    inline operator fun times(s: Float) = FVec3(x * s, y * s, z * s)
    inline operator fun div(s: Float)   = FVec3(x / s, y / s, z / s)

    inline operator fun plus(v: FVec3)  = FVec3(x + v.x, y + v.y, z + v.z)
    inline operator fun minus(v: FVec3) = FVec3(x - v.x, y - v.y, z - v.z)
    inline operator fun times(v: FVec3) = FVec3(x * v.x, y * v.y, z * v.z)
    inline operator fun div(v: FVec3)   = FVec3(x / v.x, y / v.y, z / v.z)

    inline fun compareTo(v: FVec3) = IVec3(x.compareTo(v.x), y.compareTo(v.y), z.compareTo(v.z))
    inline fun equalTo(v: FVec3)   = x.compareTo(v.x) == 0 && y.compareTo(v.y) == 0 && z.compareTo(v.z) == 0

    inline fun map(block: (Float) -> Float) = FVec3(block(x), block(y), block(z))
    inline fun toArray() = floatArrayOf(x, y, z)

    inline fun asString(fmt: String = "%f") = "($fmt, $fmt, $fmt)".format(x, y, z)
    override fun toString() = asString(DECIMAL_FORMAT)
}

data class FVec4(@JvmField var x: Float, @JvmField var y: Float, @JvmField var z: Float, @JvmField var w: Float) {
    constructor(v: FVec4) : this(v.x, v.y, v.z, v.w)
    constructor(v: FVec3, w: Float = DEFAULT) : this(v.x, v.y, v.z, w)
    constructor(v: FVec2, z: Float = DEFAULT, w: Float = DEFAULT) : this(v.x, v.y, z, w)
    constructor(s: Float) : this(s, s, s, s)

    operator fun get(index: USize) = when (index) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException(index)
    }

    operator fun set(index: USize, s: Float) = when (index) {
        0 -> x = s
        1 -> y = s
        2 -> z = s
        3 -> w = s
        else -> throw IndexOutOfBoundsException(index)
    }

    inline operator fun unaryMinus() = FVec4( -x,  -y,  -z,  -w)
    inline operator fun inc()        = FVec4(++x, ++y, ++z, ++w)
    inline operator fun dec()        = FVec4(--x, --y, --z, --w)

    inline operator fun plus(s: Float)  = FVec4(x + s, y + s, z + s, w + s)
    inline operator fun minus(s: Float) = FVec4(x - s, y - s, z - s, w - s)
    inline operator fun times(s: Float) = FVec4(x * s, y * s, z * s, w * s)
    inline operator fun div(s: Float)   = FVec4(x / s, y / s, z / s, w / s)

    inline operator fun plus(v: FVec4)  = FVec4(x + v.x, y + v.y, z + v.z, w + v.w)
    inline operator fun minus(v: FVec4) = FVec4(x - v.x, y - v.y, z - v.z, w - v.w)
    inline operator fun times(v: FVec4) = FVec4(x * v.x, y * v.y, z * v.z, w * v.w)
    inline operator fun div(v: FVec4)   = FVec4(x / v.x, y / v.y, z / v.z, w / v.w)

    inline fun compareTo(v: FVec4) = IVec4(x.compareTo(v.x), y.compareTo(v.y), z.compareTo(v.z), w.compareTo(v.w))
    inline fun equalTo(v: FVec4)   = x.compareTo(v.x) == 0 && y.compareTo(v.y) == 0 && z.compareTo(v.z) == 0 && w.compareTo(v.w) == 0

    inline fun map(block: (Float) -> Float) = FVec4(block(x), block(y), block(z), block(w))
    inline fun toArray() = floatArrayOf(x, y, z, w)

    inline fun asString(fmt: String = "%f") = "($fmt, $fmt, $fmt, $fmt)".format(x, y, z, w)
    override fun toString() = asString(DECIMAL_FORMAT)
}

//region Alternate accessors
inline var FVec2.r: Float
    get() = x
    set(value) { x = value }
inline var FVec2.g: Float
    get() = y
    set(value) { y = value }

inline var FVec3.r: Float
    get() = x
    set(value) { x = value }
inline var FVec3.g: Float
    get() = y
    set(value) { y = value }
inline var FVec3.b: Float
    get() = z
    set(value) { z = value }

inline var FVec4.r: Float
    get() = x
    set(value) { x = value }
inline var FVec4.g: Float
    get() = y
    set(value) { y = value }
inline var FVec4.b: Float
    get() = z
    set(value) { z = value }
inline var FVec4.a: Float
    get() = w
    set(value) { w = value }

inline var FVec2.s: Float
    get() = x
    set(value) { x = value }
inline var FVec2.t: Float
    get() = y
    set(value) { y = value }

inline var FVec3.s: Float
    get() = x
    set(value) { x = value }
inline var FVec3.t: Float
    get() = y
    set(value) { y = value }
inline var FVec3.p: Float
    get() = z
    set(value) { z = value }

inline var FVec4.s: Float
    get() = x
    set(value) { x = value }
inline var FVec4.t: Float
    get() = y
    set(value) { y = value }
inline var FVec4.p: Float
    get() = z
    set(value) { z = value }
inline var FVec4.q: Float
    get() = w
    set(value) { w = value }
//endregion

//region Swizzling Vec2
inline val FVec2.xxxx get() = FVec4(x, x, x, x)
inline val FVec2.xxxy get() = FVec4(x, x, x, y)
inline val FVec2.xxyx get() = FVec4(x, x, y, x)
inline val FVec2.xxyy get() = FVec4(x, x, y, y)
inline val FVec2.xyxx get() = FVec4(x, y, x, x)
inline val FVec2.xyxy get() = FVec4(x, y, x, y)
inline val FVec2.xyyx get() = FVec4(x, y, y, x)
inline val FVec2.xyyy get() = FVec4(x, y, y, y)
inline val FVec2.yxxx get() = FVec4(y, x, x, x)
inline val FVec2.yxxy get() = FVec4(y, x, x, y)
inline val FVec2.yxyx get() = FVec4(y, x, y, x)
inline val FVec2.yxyy get() = FVec4(y, x, y, y)
inline val FVec2.yyxx get() = FVec4(y, y, x, x)
inline val FVec2.yyxy get() = FVec4(y, y, x, y)
inline val FVec2.yyyx get() = FVec4(y, y, y, x)
inline val FVec2.yyyy get() = FVec4(y, y, y, y)

inline val FVec2.xxx get() = FVec3(x, x, x)
inline val FVec2.xxy get() = FVec3(x, x, y)
inline val FVec2.xyx get() = FVec3(x, y, x)
inline val FVec2.xyy get() = FVec3(x, y, y)
inline val FVec2.yxx get() = FVec3(y, x, x)
inline val FVec2.yxy get() = FVec3(y, x, y)
inline val FVec2.yyx get() = FVec3(y, y, x)
inline val FVec2.yyy get() = FVec3(y, y, y)

inline val FVec2.xx get() = FVec2(x, x)
inline val FVec2.xy get() = FVec2(x, y)
inline val FVec2.yx get() = FVec2(y, x)
inline val FVec2.yy get() = FVec2(y, y)
//endregion

//region Swizzling Vec3
inline val FVec3.xxxx get() = FVec4(x, x, x, x)
inline val FVec3.xxxy get() = FVec4(x, x, x, y)
inline val FVec3.xxxz get() = FVec4(x, x, x, z)
inline val FVec3.xxyx get() = FVec4(x, x, y, x)
inline val FVec3.xxyy get() = FVec4(x, x, y, y)
inline val FVec3.xxyz get() = FVec4(x, x, y, z)
inline val FVec3.xxzx get() = FVec4(x, x, z, x)
inline val FVec3.xxzy get() = FVec4(x, x, z, y)
inline val FVec3.xxzz get() = FVec4(x, x, z, z)
inline val FVec3.xyxx get() = FVec4(x, y, x, x)
inline val FVec3.xyxy get() = FVec4(x, y, x, y)
inline val FVec3.xyxz get() = FVec4(x, y, x, z)
inline val FVec3.xyyx get() = FVec4(x, y, y, x)
inline val FVec3.xyyy get() = FVec4(x, y, y, y)
inline val FVec3.xyyz get() = FVec4(x, y, y, z)
inline val FVec3.xyzx get() = FVec4(x, y, z, x)
inline val FVec3.xyzy get() = FVec4(x, y, z, y)
inline val FVec3.xyzz get() = FVec4(x, y, z, z)
inline val FVec3.xzxx get() = FVec4(x, z, x, x)
inline val FVec3.xzxy get() = FVec4(x, z, x, y)
inline val FVec3.xzxz get() = FVec4(x, z, x, z)
inline val FVec3.xzyx get() = FVec4(x, z, y, x)
inline val FVec3.xzyy get() = FVec4(x, z, y, y)
inline val FVec3.xzyz get() = FVec4(x, z, y, z)
inline val FVec3.xzzx get() = FVec4(x, z, z, x)
inline val FVec3.xzzy get() = FVec4(x, z, z, y)
inline val FVec3.xzzz get() = FVec4(x, z, z, z)
inline val FVec3.yxxx get() = FVec4(y, x, x, x)
inline val FVec3.yxxy get() = FVec4(y, x, x, y)
inline val FVec3.yxxz get() = FVec4(y, x, x, z)
inline val FVec3.yxyx get() = FVec4(y, x, y, x)
inline val FVec3.yxyy get() = FVec4(y, x, y, y)
inline val FVec3.yxyz get() = FVec4(y, x, y, z)
inline val FVec3.yxzx get() = FVec4(y, x, z, x)
inline val FVec3.yxzy get() = FVec4(y, x, z, y)
inline val FVec3.yxzz get() = FVec4(y, x, z, z)
inline val FVec3.yyxx get() = FVec4(y, y, x, x)
inline val FVec3.yyxy get() = FVec4(y, y, x, y)
inline val FVec3.yyxz get() = FVec4(y, y, x, z)
inline val FVec3.yyyx get() = FVec4(y, y, y, x)
inline val FVec3.yyyy get() = FVec4(y, y, y, y)
inline val FVec3.yyyz get() = FVec4(y, y, y, z)
inline val FVec3.yyzx get() = FVec4(y, y, z, x)
inline val FVec3.yyzy get() = FVec4(y, y, z, y)
inline val FVec3.yyzz get() = FVec4(y, y, z, z)
inline val FVec3.yzxx get() = FVec4(y, z, x, x)
inline val FVec3.yzxy get() = FVec4(y, z, x, y)
inline val FVec3.yzxz get() = FVec4(y, z, x, z)
inline val FVec3.yzyx get() = FVec4(y, z, y, x)
inline val FVec3.yzyy get() = FVec4(y, z, y, y)
inline val FVec3.yzyz get() = FVec4(y, z, y, z)
inline val FVec3.yzzx get() = FVec4(y, z, z, x)
inline val FVec3.yzzy get() = FVec4(y, z, z, y)
inline val FVec3.yzzz get() = FVec4(y, z, z, z)
inline val FVec3.zxxx get() = FVec4(z, x, x, x)
inline val FVec3.zxxy get() = FVec4(z, x, x, y)
inline val FVec3.zxxz get() = FVec4(z, x, x, z)
inline val FVec3.zxyx get() = FVec4(z, x, y, x)
inline val FVec3.zxyy get() = FVec4(z, x, y, y)
inline val FVec3.zxyz get() = FVec4(z, x, y, z)
inline val FVec3.zxzx get() = FVec4(z, x, z, x)
inline val FVec3.zxzy get() = FVec4(z, x, z, y)
inline val FVec3.zxzz get() = FVec4(z, x, z, z)
inline val FVec3.zyxx get() = FVec4(z, y, x, x)
inline val FVec3.zyxy get() = FVec4(z, y, x, y)
inline val FVec3.zyxz get() = FVec4(z, y, x, z)
inline val FVec3.zyyx get() = FVec4(z, y, y, x)
inline val FVec3.zyyy get() = FVec4(z, y, y, y)
inline val FVec3.zyyz get() = FVec4(z, y, y, z)
inline val FVec3.zyzx get() = FVec4(z, y, z, x)
inline val FVec3.zyzy get() = FVec4(z, y, z, y)
inline val FVec3.zyzz get() = FVec4(z, y, z, z)
inline val FVec3.zzxx get() = FVec4(z, z, x, x)
inline val FVec3.zzxy get() = FVec4(z, z, x, y)
inline val FVec3.zzxz get() = FVec4(z, z, x, z)
inline val FVec3.zzyx get() = FVec4(z, z, y, x)
inline val FVec3.zzyy get() = FVec4(z, z, y, y)
inline val FVec3.zzyz get() = FVec4(z, z, y, z)
inline val FVec3.zzzx get() = FVec4(z, z, z, x)
inline val FVec3.zzzy get() = FVec4(z, z, z, y)
inline val FVec3.zzzz get() = FVec4(z, z, z, z)

inline val FVec3.xxx get() = FVec3(x, x, x)
inline val FVec3.xxy get() = FVec3(x, x, y)
inline val FVec3.xxz get() = FVec3(x, x, z)
inline val FVec3.xyx get() = FVec3(x, y, x)
inline val FVec3.xyy get() = FVec3(x, y, y)
inline val FVec3.xyz get() = FVec3(x, y, z)
inline val FVec3.xzx get() = FVec3(x, z, x)
inline val FVec3.xzy get() = FVec3(x, z, y)
inline val FVec3.xzz get() = FVec3(x, z, z)
inline val FVec3.yxx get() = FVec3(y, x, x)
inline val FVec3.yxy get() = FVec3(y, x, y)
inline val FVec3.yxz get() = FVec3(y, x, z)
inline val FVec3.yyx get() = FVec3(y, y, x)
inline val FVec3.yyy get() = FVec3(y, y, y)
inline val FVec3.yyz get() = FVec3(y, y, z)
inline val FVec3.yzx get() = FVec3(y, z, x)
inline val FVec3.yzy get() = FVec3(y, z, y)
inline val FVec3.yzz get() = FVec3(y, z, z)
inline val FVec3.zxx get() = FVec3(z, x, x)
inline val FVec3.zxy get() = FVec3(z, x, y)
inline val FVec3.zxz get() = FVec3(z, x, z)
inline val FVec3.zyx get() = FVec3(z, y, x)
inline val FVec3.zyy get() = FVec3(z, y, y)
inline val FVec3.zyz get() = FVec3(z, y, z)
inline val FVec3.zzx get() = FVec3(z, z, x)
inline val FVec3.zzy get() = FVec3(z, z, y)
inline val FVec3.zzz get() = FVec3(z, z, z)

inline val FVec3.xx get() = FVec2(x, x)
inline val FVec3.xy get() = FVec2(x, y)
inline val FVec3.xz get() = FVec2(x, z)
inline val FVec3.yx get() = FVec2(y, x)
inline val FVec3.yy get() = FVec2(y, y)
inline val FVec3.yz get() = FVec2(y, z)
inline val FVec3.zx get() = FVec2(z, x)
inline val FVec3.zy get() = FVec2(z, y)
inline val FVec3.zz get() = FVec2(z, z)
//endregion

//region Swizzling Vec4
inline val FVec4.xxxx get() = FVec4(x, x, x, x)
inline val FVec4.xxxy get() = FVec4(x, x, x, y)
inline val FVec4.xxxz get() = FVec4(x, x, x, z)
inline val FVec4.xxxw get() = FVec4(x, x, x, w)
inline val FVec4.xxyx get() = FVec4(x, x, y, x)
inline val FVec4.xxyy get() = FVec4(x, x, y, y)
inline val FVec4.xxyz get() = FVec4(x, x, y, z)
inline val FVec4.xxyw get() = FVec4(x, x, y, w)
inline val FVec4.xxzx get() = FVec4(x, x, z, x)
inline val FVec4.xxzy get() = FVec4(x, x, z, y)
inline val FVec4.xxzz get() = FVec4(x, x, z, z)
inline val FVec4.xxzw get() = FVec4(x, x, z, w)
inline val FVec4.xxwx get() = FVec4(x, x, w, x)
inline val FVec4.xxwy get() = FVec4(x, x, w, y)
inline val FVec4.xxwz get() = FVec4(x, x, w, z)
inline val FVec4.xxww get() = FVec4(x, x, w, w)
inline val FVec4.xyxx get() = FVec4(x, y, x, x)
inline val FVec4.xyxy get() = FVec4(x, y, x, y)
inline val FVec4.xyxz get() = FVec4(x, y, x, z)
inline val FVec4.xyxw get() = FVec4(x, y, x, w)
inline val FVec4.xyyx get() = FVec4(x, y, y, x)
inline val FVec4.xyyy get() = FVec4(x, y, y, y)
inline val FVec4.xyyz get() = FVec4(x, y, y, z)
inline val FVec4.xyyw get() = FVec4(x, y, y, w)
inline val FVec4.xyzx get() = FVec4(x, y, z, x)
inline val FVec4.xyzy get() = FVec4(x, y, z, y)
inline val FVec4.xyzz get() = FVec4(x, y, z, z)
inline val FVec4.xyzw get() = FVec4(x, y, z, w)
inline val FVec4.xywx get() = FVec4(x, y, w, x)
inline val FVec4.xywy get() = FVec4(x, y, w, y)
inline val FVec4.xywz get() = FVec4(x, y, w, z)
inline val FVec4.xyww get() = FVec4(x, y, w, w)
inline val FVec4.xzxx get() = FVec4(x, z, x, x)
inline val FVec4.xzxy get() = FVec4(x, z, x, y)
inline val FVec4.xzxz get() = FVec4(x, z, x, z)
inline val FVec4.xzxw get() = FVec4(x, z, x, w)
inline val FVec4.xzyx get() = FVec4(x, z, y, x)
inline val FVec4.xzyy get() = FVec4(x, z, y, y)
inline val FVec4.xzyz get() = FVec4(x, z, y, z)
inline val FVec4.xzyw get() = FVec4(x, z, y, w)
inline val FVec4.xzzx get() = FVec4(x, z, z, x)
inline val FVec4.xzzy get() = FVec4(x, z, z, y)
inline val FVec4.xzzz get() = FVec4(x, z, z, z)
inline val FVec4.xzzw get() = FVec4(x, z, z, w)
inline val FVec4.xzwx get() = FVec4(x, z, w, x)
inline val FVec4.xzwy get() = FVec4(x, z, w, y)
inline val FVec4.xzwz get() = FVec4(x, z, w, z)
inline val FVec4.xzww get() = FVec4(x, z, w, w)
inline val FVec4.xwxx get() = FVec4(x, w, x, x)
inline val FVec4.xwxy get() = FVec4(x, w, x, y)
inline val FVec4.xwxz get() = FVec4(x, w, x, z)
inline val FVec4.xwxw get() = FVec4(x, w, x, w)
inline val FVec4.xwyx get() = FVec4(x, w, y, x)
inline val FVec4.xwyy get() = FVec4(x, w, y, y)
inline val FVec4.xwyz get() = FVec4(x, w, y, z)
inline val FVec4.xwyw get() = FVec4(x, w, y, w)
inline val FVec4.xwzx get() = FVec4(x, w, z, x)
inline val FVec4.xwzy get() = FVec4(x, w, z, y)
inline val FVec4.xwzz get() = FVec4(x, w, z, z)
inline val FVec4.xwzw get() = FVec4(x, w, z, w)
inline val FVec4.xwwx get() = FVec4(x, w, w, x)
inline val FVec4.xwwy get() = FVec4(x, w, w, y)
inline val FVec4.xwwz get() = FVec4(x, w, w, z)
inline val FVec4.xwww get() = FVec4(x, w, w, w)
inline val FVec4.yxxx get() = FVec4(y, x, x, x)
inline val FVec4.yxxy get() = FVec4(y, x, x, y)
inline val FVec4.yxxz get() = FVec4(y, x, x, z)
inline val FVec4.yxxw get() = FVec4(y, x, x, w)
inline val FVec4.yxyx get() = FVec4(y, x, y, x)
inline val FVec4.yxyy get() = FVec4(y, x, y, y)
inline val FVec4.yxyz get() = FVec4(y, x, y, z)
inline val FVec4.yxyw get() = FVec4(y, x, y, w)
inline val FVec4.yxzx get() = FVec4(y, x, z, x)
inline val FVec4.yxzy get() = FVec4(y, x, z, y)
inline val FVec4.yxzz get() = FVec4(y, x, z, z)
inline val FVec4.yxzw get() = FVec4(y, x, z, w)
inline val FVec4.yxwx get() = FVec4(y, x, w, x)
inline val FVec4.yxwy get() = FVec4(y, x, w, y)
inline val FVec4.yxwz get() = FVec4(y, x, w, z)
inline val FVec4.yxww get() = FVec4(y, x, w, w)
inline val FVec4.yyxx get() = FVec4(y, y, x, x)
inline val FVec4.yyxy get() = FVec4(y, y, x, y)
inline val FVec4.yyxz get() = FVec4(y, y, x, z)
inline val FVec4.yyxw get() = FVec4(y, y, x, w)
inline val FVec4.yyyx get() = FVec4(y, y, y, x)
inline val FVec4.yyyy get() = FVec4(y, y, y, y)
inline val FVec4.yyyz get() = FVec4(y, y, y, z)
inline val FVec4.yyyw get() = FVec4(y, y, y, w)
inline val FVec4.yyzx get() = FVec4(y, y, z, x)
inline val FVec4.yyzy get() = FVec4(y, y, z, y)
inline val FVec4.yyzz get() = FVec4(y, y, z, z)
inline val FVec4.yyzw get() = FVec4(y, y, z, w)
inline val FVec4.yywx get() = FVec4(y, y, w, x)
inline val FVec4.yywy get() = FVec4(y, y, w, y)
inline val FVec4.yywz get() = FVec4(y, y, w, z)
inline val FVec4.yyww get() = FVec4(y, y, w, w)
inline val FVec4.yzxx get() = FVec4(y, z, x, x)
inline val FVec4.yzxy get() = FVec4(y, z, x, y)
inline val FVec4.yzxz get() = FVec4(y, z, x, z)
inline val FVec4.yzxw get() = FVec4(y, z, x, w)
inline val FVec4.yzyx get() = FVec4(y, z, y, x)
inline val FVec4.yzyy get() = FVec4(y, z, y, y)
inline val FVec4.yzyz get() = FVec4(y, z, y, z)
inline val FVec4.yzyw get() = FVec4(y, z, y, w)
inline val FVec4.yzzx get() = FVec4(y, z, z, x)
inline val FVec4.yzzy get() = FVec4(y, z, z, y)
inline val FVec4.yzzz get() = FVec4(y, z, z, z)
inline val FVec4.yzzw get() = FVec4(y, z, z, w)
inline val FVec4.yzwx get() = FVec4(y, z, w, x)
inline val FVec4.yzwy get() = FVec4(y, z, w, y)
inline val FVec4.yzwz get() = FVec4(y, z, w, z)
inline val FVec4.yzww get() = FVec4(y, z, w, w)
inline val FVec4.ywxx get() = FVec4(y, w, x, x)
inline val FVec4.ywxy get() = FVec4(y, w, x, y)
inline val FVec4.ywxz get() = FVec4(y, w, x, z)
inline val FVec4.ywxw get() = FVec4(y, w, x, w)
inline val FVec4.ywyx get() = FVec4(y, w, y, x)
inline val FVec4.ywyy get() = FVec4(y, w, y, y)
inline val FVec4.ywyz get() = FVec4(y, w, y, z)
inline val FVec4.ywyw get() = FVec4(y, w, y, w)
inline val FVec4.ywzx get() = FVec4(y, w, z, x)
inline val FVec4.ywzy get() = FVec4(y, w, z, y)
inline val FVec4.ywzz get() = FVec4(y, w, z, z)
inline val FVec4.ywzw get() = FVec4(y, w, z, w)
inline val FVec4.ywwx get() = FVec4(y, w, w, x)
inline val FVec4.ywwy get() = FVec4(y, w, w, y)
inline val FVec4.ywwz get() = FVec4(y, w, w, z)
inline val FVec4.ywww get() = FVec4(y, w, w, w)
inline val FVec4.zxxx get() = FVec4(z, x, x, x)
inline val FVec4.zxxy get() = FVec4(z, x, x, y)
inline val FVec4.zxxz get() = FVec4(z, x, x, z)
inline val FVec4.zxxw get() = FVec4(z, x, x, w)
inline val FVec4.zxyx get() = FVec4(z, x, y, x)
inline val FVec4.zxyy get() = FVec4(z, x, y, y)
inline val FVec4.zxyz get() = FVec4(z, x, y, z)
inline val FVec4.zxyw get() = FVec4(z, x, y, w)
inline val FVec4.zxzx get() = FVec4(z, x, z, x)
inline val FVec4.zxzy get() = FVec4(z, x, z, y)
inline val FVec4.zxzz get() = FVec4(z, x, z, z)
inline val FVec4.zxzw get() = FVec4(z, x, z, w)
inline val FVec4.zxwx get() = FVec4(z, x, w, x)
inline val FVec4.zxwy get() = FVec4(z, x, w, y)
inline val FVec4.zxwz get() = FVec4(z, x, w, z)
inline val FVec4.zxww get() = FVec4(z, x, w, w)
inline val FVec4.zyxx get() = FVec4(z, y, x, x)
inline val FVec4.zyxy get() = FVec4(z, y, x, y)
inline val FVec4.zyxz get() = FVec4(z, y, x, z)
inline val FVec4.zyxw get() = FVec4(z, y, x, w)
inline val FVec4.zyyx get() = FVec4(z, y, y, x)
inline val FVec4.zyyy get() = FVec4(z, y, y, y)
inline val FVec4.zyyz get() = FVec4(z, y, y, z)
inline val FVec4.zyyw get() = FVec4(z, y, y, w)
inline val FVec4.zyzx get() = FVec4(z, y, z, x)
inline val FVec4.zyzy get() = FVec4(z, y, z, y)
inline val FVec4.zyzz get() = FVec4(z, y, z, z)
inline val FVec4.zyzw get() = FVec4(z, y, z, w)
inline val FVec4.zywx get() = FVec4(z, y, w, x)
inline val FVec4.zywy get() = FVec4(z, y, w, y)
inline val FVec4.zywz get() = FVec4(z, y, w, z)
inline val FVec4.zyww get() = FVec4(z, y, w, w)
inline val FVec4.zzxx get() = FVec4(z, z, x, x)
inline val FVec4.zzxy get() = FVec4(z, z, x, y)
inline val FVec4.zzxz get() = FVec4(z, z, x, z)
inline val FVec4.zzxw get() = FVec4(z, z, x, w)
inline val FVec4.zzyx get() = FVec4(z, z, y, x)
inline val FVec4.zzyy get() = FVec4(z, z, y, y)
inline val FVec4.zzyz get() = FVec4(z, z, y, z)
inline val FVec4.zzyw get() = FVec4(z, z, y, w)
inline val FVec4.zzzx get() = FVec4(z, z, z, x)
inline val FVec4.zzzy get() = FVec4(z, z, z, y)
inline val FVec4.zzzz get() = FVec4(z, z, z, z)
inline val FVec4.zzzw get() = FVec4(z, z, z, w)
inline val FVec4.zzwx get() = FVec4(z, z, w, x)
inline val FVec4.zzwy get() = FVec4(z, z, w, y)
inline val FVec4.zzwz get() = FVec4(z, z, w, z)
inline val FVec4.zzww get() = FVec4(z, z, w, w)
inline val FVec4.zwxx get() = FVec4(z, w, x, x)
inline val FVec4.zwxy get() = FVec4(z, w, x, y)
inline val FVec4.zwxz get() = FVec4(z, w, x, z)
inline val FVec4.zwxw get() = FVec4(z, w, x, w)
inline val FVec4.zwyx get() = FVec4(z, w, y, x)
inline val FVec4.zwyy get() = FVec4(z, w, y, y)
inline val FVec4.zwyz get() = FVec4(z, w, y, z)
inline val FVec4.zwyw get() = FVec4(z, w, y, w)
inline val FVec4.zwzx get() = FVec4(z, w, z, x)
inline val FVec4.zwzy get() = FVec4(z, w, z, y)
inline val FVec4.zwzz get() = FVec4(z, w, z, z)
inline val FVec4.zwzw get() = FVec4(z, w, z, w)
inline val FVec4.zwwx get() = FVec4(z, w, w, x)
inline val FVec4.zwwy get() = FVec4(z, w, w, y)
inline val FVec4.zwwz get() = FVec4(z, w, w, z)
inline val FVec4.zwww get() = FVec4(z, w, w, w)
inline val FVec4.wxxx get() = FVec4(w, x, x, x)
inline val FVec4.wxxy get() = FVec4(w, x, x, y)
inline val FVec4.wxxz get() = FVec4(w, x, x, z)
inline val FVec4.wxxw get() = FVec4(w, x, x, w)
inline val FVec4.wxyx get() = FVec4(w, x, y, x)
inline val FVec4.wxyy get() = FVec4(w, x, y, y)
inline val FVec4.wxyz get() = FVec4(w, x, y, z)
inline val FVec4.wxyw get() = FVec4(w, x, y, w)
inline val FVec4.wxzx get() = FVec4(w, x, z, x)
inline val FVec4.wxzy get() = FVec4(w, x, z, y)
inline val FVec4.wxzz get() = FVec4(w, x, z, z)
inline val FVec4.wxzw get() = FVec4(w, x, z, w)
inline val FVec4.wxwx get() = FVec4(w, x, w, x)
inline val FVec4.wxwy get() = FVec4(w, x, w, y)
inline val FVec4.wxwz get() = FVec4(w, x, w, z)
inline val FVec4.wxww get() = FVec4(w, x, w, w)
inline val FVec4.wyxx get() = FVec4(w, y, x, x)
inline val FVec4.wyxy get() = FVec4(w, y, x, y)
inline val FVec4.wyxz get() = FVec4(w, y, x, z)
inline val FVec4.wyxw get() = FVec4(w, y, x, w)
inline val FVec4.wyyx get() = FVec4(w, y, y, x)
inline val FVec4.wyyy get() = FVec4(w, y, y, y)
inline val FVec4.wyyz get() = FVec4(w, y, y, z)
inline val FVec4.wyyw get() = FVec4(w, y, y, w)
inline val FVec4.wyzx get() = FVec4(w, y, z, x)
inline val FVec4.wyzy get() = FVec4(w, y, z, y)
inline val FVec4.wyzz get() = FVec4(w, y, z, z)
inline val FVec4.wyzw get() = FVec4(w, y, z, w)
inline val FVec4.wywx get() = FVec4(w, y, w, x)
inline val FVec4.wywy get() = FVec4(w, y, w, y)
inline val FVec4.wywz get() = FVec4(w, y, w, z)
inline val FVec4.wyww get() = FVec4(w, y, w, w)
inline val FVec4.wzxx get() = FVec4(w, z, x, x)
inline val FVec4.wzxy get() = FVec4(w, z, x, y)
inline val FVec4.wzxz get() = FVec4(w, z, x, z)
inline val FVec4.wzxw get() = FVec4(w, z, x, w)
inline val FVec4.wzyx get() = FVec4(w, z, y, x)
inline val FVec4.wzyy get() = FVec4(w, z, y, y)
inline val FVec4.wzyz get() = FVec4(w, z, y, z)
inline val FVec4.wzyw get() = FVec4(w, z, y, w)
inline val FVec4.wzzx get() = FVec4(w, z, z, x)
inline val FVec4.wzzy get() = FVec4(w, z, z, y)
inline val FVec4.wzzz get() = FVec4(w, z, z, z)
inline val FVec4.wzzw get() = FVec4(w, z, z, w)
inline val FVec4.wzwx get() = FVec4(w, z, w, x)
inline val FVec4.wzwy get() = FVec4(w, z, w, y)
inline val FVec4.wzwz get() = FVec4(w, z, w, z)
inline val FVec4.wzww get() = FVec4(w, z, w, w)
inline val FVec4.wwxx get() = FVec4(w, w, x, x)
inline val FVec4.wwxy get() = FVec4(w, w, x, y)
inline val FVec4.wwxz get() = FVec4(w, w, x, z)
inline val FVec4.wwxw get() = FVec4(w, w, x, w)
inline val FVec4.wwyx get() = FVec4(w, w, y, x)
inline val FVec4.wwyy get() = FVec4(w, w, y, y)
inline val FVec4.wwyz get() = FVec4(w, w, y, z)
inline val FVec4.wwyw get() = FVec4(w, w, y, w)
inline val FVec4.wwzx get() = FVec4(w, w, z, x)
inline val FVec4.wwzy get() = FVec4(w, w, z, y)
inline val FVec4.wwzz get() = FVec4(w, w, z, z)
inline val FVec4.wwzw get() = FVec4(w, w, z, w)
inline val FVec4.wwwx get() = FVec4(w, w, w, x)
inline val FVec4.wwwy get() = FVec4(w, w, w, y)
inline val FVec4.wwwz get() = FVec4(w, w, w, z)
inline val FVec4.wwww get() = FVec4(w, w, w, w)

inline val FVec4.xxx get() = FVec3(x, x, x)
inline val FVec4.xxy get() = FVec3(x, x, y)
inline val FVec4.xxz get() = FVec3(x, x, z)
inline val FVec4.xxw get() = FVec3(x, x, w)
inline val FVec4.xyx get() = FVec3(x, y, x)
inline val FVec4.xyy get() = FVec3(x, y, y)
inline val FVec4.xyz get() = FVec3(x, y, z)
inline val FVec4.xyw get() = FVec3(x, y, w)
inline val FVec4.xzx get() = FVec3(x, z, x)
inline val FVec4.xzy get() = FVec3(x, z, y)
inline val FVec4.xzz get() = FVec3(x, z, z)
inline val FVec4.xzw get() = FVec3(x, z, w)
inline val FVec4.xwx get() = FVec3(x, w, x)
inline val FVec4.xwy get() = FVec3(x, w, y)
inline val FVec4.xwz get() = FVec3(x, w, z)
inline val FVec4.xww get() = FVec3(x, w, w)
inline val FVec4.yxx get() = FVec3(y, x, x)
inline val FVec4.yxy get() = FVec3(y, x, y)
inline val FVec4.yxz get() = FVec3(y, x, z)
inline val FVec4.yxw get() = FVec3(y, x, w)
inline val FVec4.yyx get() = FVec3(y, y, x)
inline val FVec4.yyy get() = FVec3(y, y, y)
inline val FVec4.yyz get() = FVec3(y, y, z)
inline val FVec4.yyw get() = FVec3(y, y, w)
inline val FVec4.yzx get() = FVec3(y, z, x)
inline val FVec4.yzy get() = FVec3(y, z, y)
inline val FVec4.yzz get() = FVec3(y, z, z)
inline val FVec4.yzw get() = FVec3(y, z, w)
inline val FVec4.ywx get() = FVec3(y, w, x)
inline val FVec4.ywy get() = FVec3(y, w, y)
inline val FVec4.ywz get() = FVec3(y, w, z)
inline val FVec4.yww get() = FVec3(y, w, w)
inline val FVec4.zxx get() = FVec3(z, x, x)
inline val FVec4.zxy get() = FVec3(z, x, y)
inline val FVec4.zxz get() = FVec3(z, x, z)
inline val FVec4.zxw get() = FVec3(z, x, w)
inline val FVec4.zyx get() = FVec3(z, y, x)
inline val FVec4.zyy get() = FVec3(z, y, y)
inline val FVec4.zyz get() = FVec3(z, y, z)
inline val FVec4.zyw get() = FVec3(z, y, w)
inline val FVec4.zzx get() = FVec3(z, z, x)
inline val FVec4.zzy get() = FVec3(z, z, y)
inline val FVec4.zzz get() = FVec3(z, z, z)
inline val FVec4.zzw get() = FVec3(z, z, w)
inline val FVec4.zwx get() = FVec3(z, w, x)
inline val FVec4.zwy get() = FVec3(z, w, y)
inline val FVec4.zwz get() = FVec3(z, w, z)
inline val FVec4.zww get() = FVec3(z, w, w)
inline val FVec4.wxx get() = FVec3(w, x, x)
inline val FVec4.wxy get() = FVec3(w, x, y)
inline val FVec4.wxz get() = FVec3(w, x, z)
inline val FVec4.wxw get() = FVec3(w, x, w)
inline val FVec4.wyx get() = FVec3(w, y, x)
inline val FVec4.wyy get() = FVec3(w, y, y)
inline val FVec4.wyz get() = FVec3(w, y, z)
inline val FVec4.wyw get() = FVec3(w, y, w)
inline val FVec4.wzx get() = FVec3(w, z, x)
inline val FVec4.wzy get() = FVec3(w, z, y)
inline val FVec4.wzz get() = FVec3(w, z, z)
inline val FVec4.wzw get() = FVec3(w, z, w)
inline val FVec4.wwx get() = FVec3(w, w, x)
inline val FVec4.wwy get() = FVec3(w, w, y)
inline val FVec4.wwz get() = FVec3(w, w, z)
inline val FVec4.www get() = FVec3(w, w, w)

inline val FVec4.xx get() = FVec2(x, x)
inline val FVec4.xy get() = FVec2(x, y)
inline val FVec4.xz get() = FVec2(x, z)
inline val FVec4.xw get() = FVec2(x, w)
inline val FVec4.yx get() = FVec2(y, x)
inline val FVec4.yy get() = FVec2(y, y)
inline val FVec4.yz get() = FVec2(y, z)
inline val FVec4.yw get() = FVec2(y, w)
inline val FVec4.zx get() = FVec2(z, x)
inline val FVec4.zy get() = FVec2(z, y)
inline val FVec4.zz get() = FVec2(z, z)
inline val FVec4.zw get() = FVec2(z, w)
inline val FVec4.wx get() = FVec2(w, x)
inline val FVec4.wy get() = FVec2(w, y)
inline val FVec4.wz get() = FVec2(w, z)
inline val FVec4.ww get() = FVec2(w, w)
//endregion
