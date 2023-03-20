@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

private const val DEFAULT: Boolean = false

data class BVec2(@JvmField var x: Boolean, @JvmField var y: Boolean) {
    constructor(v: BVec2) : this(v.x, v.y)
    constructor(s: Boolean) : this(s, s)

    operator fun get(index: USize) = when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException(index)
    }

    operator fun set(index: USize, s: Boolean) = when (index) {
        0 -> x = s
        1 -> y = s
        else -> throw IndexOutOfBoundsException(index)
    }

    inline fun equalTo(v: BVec2)   = x == v.x && y == v.y

    inline fun map(block: (Boolean) -> Boolean) = BVec2(block(x), block(y))
    inline fun toArray() = booleanArrayOf(x, y)

    inline fun asString(fmt: String = "%s") = "($fmt, $fmt)".format(x, y)
    override fun toString() = asString()
}

data class BVec3(@JvmField var x: Boolean, @JvmField var y: Boolean, @JvmField var z: Boolean) {
    constructor(v: BVec3) : this(v.x, v.y, v.z)
    constructor(v: BVec2, z: Boolean = DEFAULT) : this(v.x, v.y, z)
    constructor(s: Boolean) : this(s, s, s)

    operator fun get(index: USize) = when (index) {
        0 -> x
        1 -> y
        2 -> z
        else -> throw IndexOutOfBoundsException(index)
    }

    operator fun set(index: USize, s: Boolean) = when (index) {
        0 -> x = s
        1 -> y = s
        2 -> z = s
        else -> throw IndexOutOfBoundsException(index)
    }

    inline fun equalTo(v: BVec3)   = x == v.x && y == v.y && z == v.z

    inline fun map(block: (Boolean) -> Boolean) = BVec3(block(x), block(y), block(z))
    inline fun toArray() = booleanArrayOf(x, y, z)

    inline fun asString(fmt: String = "%s") = "($fmt, $fmt, $fmt)".format(x, y, z)
    override fun toString() = asString()
}

data class BVec4(@JvmField var x: Boolean, @JvmField var y: Boolean, @JvmField var z: Boolean, @JvmField var w: Boolean) {
    constructor(v: BVec4) : this(v.x, v.y, v.z, v.w)
    constructor(v: BVec3, w: Boolean = DEFAULT) : this(v.x, v.y, v.z, w)
    constructor(v: BVec2, z: Boolean = DEFAULT, w: Boolean = DEFAULT) : this(v.x, v.y, z, w)
    constructor(s: Boolean) : this(s, s, s, s)

    operator fun get(index: USize) = when (index) {
        0 -> x
        1 -> y
        2 -> z
        3 -> w
        else -> throw IndexOutOfBoundsException(index)
    }

    operator fun set(index: USize, s: Boolean) = when (index) {
        0 -> x = s
        1 -> y = s
        2 -> z = s
        3 -> w = s
        else -> throw IndexOutOfBoundsException(index)
    }

    inline fun equalTo(v: BVec4)   = x == v.x && y == v.y && z == v.z && w == v.w

    inline fun map(block: (Boolean) -> Boolean) = BVec4(block(x), block(y), block(z), block(w))
    inline fun toArray() = booleanArrayOf(x, y, z, w)

    inline fun asString(fmt: String = "%s") = "($fmt, $fmt, $fmt, $fmt)".format(x, y, z, w)
    override fun toString() = asString()
}

//region Alternate accessors
inline var BVec2.r: Boolean
    get() = x
    set(value) { x = value }
inline var BVec2.g: Boolean
    get() = y
    set(value) { y = value }

inline var BVec3.r: Boolean
    get() = x
    set(value) { x = value }
inline var BVec3.g: Boolean
    get() = y
    set(value) { y = value }
inline var BVec3.b: Boolean
    get() = z
    set(value) { z = value }

inline var BVec4.r: Boolean
    get() = x
    set(value) { x = value }
inline var BVec4.g: Boolean
    get() = y
    set(value) { y = value }
inline var BVec4.b: Boolean
    get() = z
    set(value) { z = value }
inline var BVec4.a: Boolean
    get() = w
    set(value) { w = value }

inline var BVec2.s: Boolean
    get() = x
    set(value) { x = value }
inline var BVec2.t: Boolean
    get() = y
    set(value) { y = value }

inline var BVec3.s: Boolean
    get() = x
    set(value) { x = value }
inline var BVec3.t: Boolean
    get() = y
    set(value) { y = value }
inline var BVec3.p: Boolean
    get() = z
    set(value) { z = value }

inline var BVec4.s: Boolean
    get() = x
    set(value) { x = value }
inline var BVec4.t: Boolean
    get() = y
    set(value) { y = value }
inline var BVec4.p: Boolean
    get() = z
    set(value) { z = value }
inline var BVec4.q: Boolean
    get() = w
    set(value) { w = value }
//endregion

//region Swizzling Vec2
inline val BVec2.xxxx get() = BVec4(x, x, x, x)
inline val BVec2.xxxy get() = BVec4(x, x, x, y)
inline val BVec2.xxyx get() = BVec4(x, x, y, x)
inline val BVec2.xxyy get() = BVec4(x, x, y, y)
inline val BVec2.xyxx get() = BVec4(x, y, x, x)
inline val BVec2.xyxy get() = BVec4(x, y, x, y)
inline val BVec2.xyyx get() = BVec4(x, y, y, x)
inline val BVec2.xyyy get() = BVec4(x, y, y, y)
inline val BVec2.yxxx get() = BVec4(y, x, x, x)
inline val BVec2.yxxy get() = BVec4(y, x, x, y)
inline val BVec2.yxyx get() = BVec4(y, x, y, x)
inline val BVec2.yxyy get() = BVec4(y, x, y, y)
inline val BVec2.yyxx get() = BVec4(y, y, x, x)
inline val BVec2.yyxy get() = BVec4(y, y, x, y)
inline val BVec2.yyyx get() = BVec4(y, y, y, x)
inline val BVec2.yyyy get() = BVec4(y, y, y, y)

inline val BVec2.xxx get() = BVec3(x, x, x)
inline val BVec2.xxy get() = BVec3(x, x, y)
inline val BVec2.xyx get() = BVec3(x, y, x)
inline val BVec2.xyy get() = BVec3(x, y, y)
inline val BVec2.yxx get() = BVec3(y, x, x)
inline val BVec2.yxy get() = BVec3(y, x, y)
inline val BVec2.yyx get() = BVec3(y, y, x)
inline val BVec2.yyy get() = BVec3(y, y, y)

inline val BVec2.xx get() = BVec2(x, x)
inline val BVec2.xy get() = BVec2(x, y)
inline val BVec2.yx get() = BVec2(y, x)
inline val BVec2.yy get() = BVec2(y, y)
//endregion

//region Swizzling Vec3
inline val BVec3.xxxx get() = BVec4(x, x, x, x)
inline val BVec3.xxxy get() = BVec4(x, x, x, y)
inline val BVec3.xxxz get() = BVec4(x, x, x, z)
inline val BVec3.xxyx get() = BVec4(x, x, y, x)
inline val BVec3.xxyy get() = BVec4(x, x, y, y)
inline val BVec3.xxyz get() = BVec4(x, x, y, z)
inline val BVec3.xxzx get() = BVec4(x, x, z, x)
inline val BVec3.xxzy get() = BVec4(x, x, z, y)
inline val BVec3.xxzz get() = BVec4(x, x, z, z)
inline val BVec3.xyxx get() = BVec4(x, y, x, x)
inline val BVec3.xyxy get() = BVec4(x, y, x, y)
inline val BVec3.xyxz get() = BVec4(x, y, x, z)
inline val BVec3.xyyx get() = BVec4(x, y, y, x)
inline val BVec3.xyyy get() = BVec4(x, y, y, y)
inline val BVec3.xyyz get() = BVec4(x, y, y, z)
inline val BVec3.xyzx get() = BVec4(x, y, z, x)
inline val BVec3.xyzy get() = BVec4(x, y, z, y)
inline val BVec3.xyzz get() = BVec4(x, y, z, z)
inline val BVec3.xzxx get() = BVec4(x, z, x, x)
inline val BVec3.xzxy get() = BVec4(x, z, x, y)
inline val BVec3.xzxz get() = BVec4(x, z, x, z)
inline val BVec3.xzyx get() = BVec4(x, z, y, x)
inline val BVec3.xzyy get() = BVec4(x, z, y, y)
inline val BVec3.xzyz get() = BVec4(x, z, y, z)
inline val BVec3.xzzx get() = BVec4(x, z, z, x)
inline val BVec3.xzzy get() = BVec4(x, z, z, y)
inline val BVec3.xzzz get() = BVec4(x, z, z, z)
inline val BVec3.yxxx get() = BVec4(y, x, x, x)
inline val BVec3.yxxy get() = BVec4(y, x, x, y)
inline val BVec3.yxxz get() = BVec4(y, x, x, z)
inline val BVec3.yxyx get() = BVec4(y, x, y, x)
inline val BVec3.yxyy get() = BVec4(y, x, y, y)
inline val BVec3.yxyz get() = BVec4(y, x, y, z)
inline val BVec3.yxzx get() = BVec4(y, x, z, x)
inline val BVec3.yxzy get() = BVec4(y, x, z, y)
inline val BVec3.yxzz get() = BVec4(y, x, z, z)
inline val BVec3.yyxx get() = BVec4(y, y, x, x)
inline val BVec3.yyxy get() = BVec4(y, y, x, y)
inline val BVec3.yyxz get() = BVec4(y, y, x, z)
inline val BVec3.yyyx get() = BVec4(y, y, y, x)
inline val BVec3.yyyy get() = BVec4(y, y, y, y)
inline val BVec3.yyyz get() = BVec4(y, y, y, z)
inline val BVec3.yyzx get() = BVec4(y, y, z, x)
inline val BVec3.yyzy get() = BVec4(y, y, z, y)
inline val BVec3.yyzz get() = BVec4(y, y, z, z)
inline val BVec3.yzxx get() = BVec4(y, z, x, x)
inline val BVec3.yzxy get() = BVec4(y, z, x, y)
inline val BVec3.yzxz get() = BVec4(y, z, x, z)
inline val BVec3.yzyx get() = BVec4(y, z, y, x)
inline val BVec3.yzyy get() = BVec4(y, z, y, y)
inline val BVec3.yzyz get() = BVec4(y, z, y, z)
inline val BVec3.yzzx get() = BVec4(y, z, z, x)
inline val BVec3.yzzy get() = BVec4(y, z, z, y)
inline val BVec3.yzzz get() = BVec4(y, z, z, z)
inline val BVec3.zxxx get() = BVec4(z, x, x, x)
inline val BVec3.zxxy get() = BVec4(z, x, x, y)
inline val BVec3.zxxz get() = BVec4(z, x, x, z)
inline val BVec3.zxyx get() = BVec4(z, x, y, x)
inline val BVec3.zxyy get() = BVec4(z, x, y, y)
inline val BVec3.zxyz get() = BVec4(z, x, y, z)
inline val BVec3.zxzx get() = BVec4(z, x, z, x)
inline val BVec3.zxzy get() = BVec4(z, x, z, y)
inline val BVec3.zxzz get() = BVec4(z, x, z, z)
inline val BVec3.zyxx get() = BVec4(z, y, x, x)
inline val BVec3.zyxy get() = BVec4(z, y, x, y)
inline val BVec3.zyxz get() = BVec4(z, y, x, z)
inline val BVec3.zyyx get() = BVec4(z, y, y, x)
inline val BVec3.zyyy get() = BVec4(z, y, y, y)
inline val BVec3.zyyz get() = BVec4(z, y, y, z)
inline val BVec3.zyzx get() = BVec4(z, y, z, x)
inline val BVec3.zyzy get() = BVec4(z, y, z, y)
inline val BVec3.zyzz get() = BVec4(z, y, z, z)
inline val BVec3.zzxx get() = BVec4(z, z, x, x)
inline val BVec3.zzxy get() = BVec4(z, z, x, y)
inline val BVec3.zzxz get() = BVec4(z, z, x, z)
inline val BVec3.zzyx get() = BVec4(z, z, y, x)
inline val BVec3.zzyy get() = BVec4(z, z, y, y)
inline val BVec3.zzyz get() = BVec4(z, z, y, z)
inline val BVec3.zzzx get() = BVec4(z, z, z, x)
inline val BVec3.zzzy get() = BVec4(z, z, z, y)
inline val BVec3.zzzz get() = BVec4(z, z, z, z)

inline val BVec3.xxx get() = BVec3(x, x, x)
inline val BVec3.xxy get() = BVec3(x, x, y)
inline val BVec3.xxz get() = BVec3(x, x, z)
inline val BVec3.xyx get() = BVec3(x, y, x)
inline val BVec3.xyy get() = BVec3(x, y, y)
inline val BVec3.xyz get() = BVec3(x, y, z)
inline val BVec3.xzx get() = BVec3(x, z, x)
inline val BVec3.xzy get() = BVec3(x, z, y)
inline val BVec3.xzz get() = BVec3(x, z, z)
inline val BVec3.yxx get() = BVec3(y, x, x)
inline val BVec3.yxy get() = BVec3(y, x, y)
inline val BVec3.yxz get() = BVec3(y, x, z)
inline val BVec3.yyx get() = BVec3(y, y, x)
inline val BVec3.yyy get() = BVec3(y, y, y)
inline val BVec3.yyz get() = BVec3(y, y, z)
inline val BVec3.yzx get() = BVec3(y, z, x)
inline val BVec3.yzy get() = BVec3(y, z, y)
inline val BVec3.yzz get() = BVec3(y, z, z)
inline val BVec3.zxx get() = BVec3(z, x, x)
inline val BVec3.zxy get() = BVec3(z, x, y)
inline val BVec3.zxz get() = BVec3(z, x, z)
inline val BVec3.zyx get() = BVec3(z, y, x)
inline val BVec3.zyy get() = BVec3(z, y, y)
inline val BVec3.zyz get() = BVec3(z, y, z)
inline val BVec3.zzx get() = BVec3(z, z, x)
inline val BVec3.zzy get() = BVec3(z, z, y)
inline val BVec3.zzz get() = BVec3(z, z, z)

inline val BVec3.xx get() = BVec2(x, x)
inline val BVec3.xy get() = BVec2(x, y)
inline val BVec3.xz get() = BVec2(x, z)
inline val BVec3.yx get() = BVec2(y, x)
inline val BVec3.yy get() = BVec2(y, y)
inline val BVec3.yz get() = BVec2(y, z)
inline val BVec3.zx get() = BVec2(z, x)
inline val BVec3.zy get() = BVec2(z, y)
inline val BVec3.zz get() = BVec2(z, z)
//endregion

//region Swizzling Vec4
inline val BVec4.xxxx get() = BVec4(x, x, x, x)
inline val BVec4.xxxy get() = BVec4(x, x, x, y)
inline val BVec4.xxxz get() = BVec4(x, x, x, z)
inline val BVec4.xxxw get() = BVec4(x, x, x, w)
inline val BVec4.xxyx get() = BVec4(x, x, y, x)
inline val BVec4.xxyy get() = BVec4(x, x, y, y)
inline val BVec4.xxyz get() = BVec4(x, x, y, z)
inline val BVec4.xxyw get() = BVec4(x, x, y, w)
inline val BVec4.xxzx get() = BVec4(x, x, z, x)
inline val BVec4.xxzy get() = BVec4(x, x, z, y)
inline val BVec4.xxzz get() = BVec4(x, x, z, z)
inline val BVec4.xxzw get() = BVec4(x, x, z, w)
inline val BVec4.xxwx get() = BVec4(x, x, w, x)
inline val BVec4.xxwy get() = BVec4(x, x, w, y)
inline val BVec4.xxwz get() = BVec4(x, x, w, z)
inline val BVec4.xxww get() = BVec4(x, x, w, w)
inline val BVec4.xyxx get() = BVec4(x, y, x, x)
inline val BVec4.xyxy get() = BVec4(x, y, x, y)
inline val BVec4.xyxz get() = BVec4(x, y, x, z)
inline val BVec4.xyxw get() = BVec4(x, y, x, w)
inline val BVec4.xyyx get() = BVec4(x, y, y, x)
inline val BVec4.xyyy get() = BVec4(x, y, y, y)
inline val BVec4.xyyz get() = BVec4(x, y, y, z)
inline val BVec4.xyyw get() = BVec4(x, y, y, w)
inline val BVec4.xyzx get() = BVec4(x, y, z, x)
inline val BVec4.xyzy get() = BVec4(x, y, z, y)
inline val BVec4.xyzz get() = BVec4(x, y, z, z)
inline val BVec4.xyzw get() = BVec4(x, y, z, w)
inline val BVec4.xywx get() = BVec4(x, y, w, x)
inline val BVec4.xywy get() = BVec4(x, y, w, y)
inline val BVec4.xywz get() = BVec4(x, y, w, z)
inline val BVec4.xyww get() = BVec4(x, y, w, w)
inline val BVec4.xzxx get() = BVec4(x, z, x, x)
inline val BVec4.xzxy get() = BVec4(x, z, x, y)
inline val BVec4.xzxz get() = BVec4(x, z, x, z)
inline val BVec4.xzxw get() = BVec4(x, z, x, w)
inline val BVec4.xzyx get() = BVec4(x, z, y, x)
inline val BVec4.xzyy get() = BVec4(x, z, y, y)
inline val BVec4.xzyz get() = BVec4(x, z, y, z)
inline val BVec4.xzyw get() = BVec4(x, z, y, w)
inline val BVec4.xzzx get() = BVec4(x, z, z, x)
inline val BVec4.xzzy get() = BVec4(x, z, z, y)
inline val BVec4.xzzz get() = BVec4(x, z, z, z)
inline val BVec4.xzzw get() = BVec4(x, z, z, w)
inline val BVec4.xzwx get() = BVec4(x, z, w, x)
inline val BVec4.xzwy get() = BVec4(x, z, w, y)
inline val BVec4.xzwz get() = BVec4(x, z, w, z)
inline val BVec4.xzww get() = BVec4(x, z, w, w)
inline val BVec4.xwxx get() = BVec4(x, w, x, x)
inline val BVec4.xwxy get() = BVec4(x, w, x, y)
inline val BVec4.xwxz get() = BVec4(x, w, x, z)
inline val BVec4.xwxw get() = BVec4(x, w, x, w)
inline val BVec4.xwyx get() = BVec4(x, w, y, x)
inline val BVec4.xwyy get() = BVec4(x, w, y, y)
inline val BVec4.xwyz get() = BVec4(x, w, y, z)
inline val BVec4.xwyw get() = BVec4(x, w, y, w)
inline val BVec4.xwzx get() = BVec4(x, w, z, x)
inline val BVec4.xwzy get() = BVec4(x, w, z, y)
inline val BVec4.xwzz get() = BVec4(x, w, z, z)
inline val BVec4.xwzw get() = BVec4(x, w, z, w)
inline val BVec4.xwwx get() = BVec4(x, w, w, x)
inline val BVec4.xwwy get() = BVec4(x, w, w, y)
inline val BVec4.xwwz get() = BVec4(x, w, w, z)
inline val BVec4.xwww get() = BVec4(x, w, w, w)
inline val BVec4.yxxx get() = BVec4(y, x, x, x)
inline val BVec4.yxxy get() = BVec4(y, x, x, y)
inline val BVec4.yxxz get() = BVec4(y, x, x, z)
inline val BVec4.yxxw get() = BVec4(y, x, x, w)
inline val BVec4.yxyx get() = BVec4(y, x, y, x)
inline val BVec4.yxyy get() = BVec4(y, x, y, y)
inline val BVec4.yxyz get() = BVec4(y, x, y, z)
inline val BVec4.yxyw get() = BVec4(y, x, y, w)
inline val BVec4.yxzx get() = BVec4(y, x, z, x)
inline val BVec4.yxzy get() = BVec4(y, x, z, y)
inline val BVec4.yxzz get() = BVec4(y, x, z, z)
inline val BVec4.yxzw get() = BVec4(y, x, z, w)
inline val BVec4.yxwx get() = BVec4(y, x, w, x)
inline val BVec4.yxwy get() = BVec4(y, x, w, y)
inline val BVec4.yxwz get() = BVec4(y, x, w, z)
inline val BVec4.yxww get() = BVec4(y, x, w, w)
inline val BVec4.yyxx get() = BVec4(y, y, x, x)
inline val BVec4.yyxy get() = BVec4(y, y, x, y)
inline val BVec4.yyxz get() = BVec4(y, y, x, z)
inline val BVec4.yyxw get() = BVec4(y, y, x, w)
inline val BVec4.yyyx get() = BVec4(y, y, y, x)
inline val BVec4.yyyy get() = BVec4(y, y, y, y)
inline val BVec4.yyyz get() = BVec4(y, y, y, z)
inline val BVec4.yyyw get() = BVec4(y, y, y, w)
inline val BVec4.yyzx get() = BVec4(y, y, z, x)
inline val BVec4.yyzy get() = BVec4(y, y, z, y)
inline val BVec4.yyzz get() = BVec4(y, y, z, z)
inline val BVec4.yyzw get() = BVec4(y, y, z, w)
inline val BVec4.yywx get() = BVec4(y, y, w, x)
inline val BVec4.yywy get() = BVec4(y, y, w, y)
inline val BVec4.yywz get() = BVec4(y, y, w, z)
inline val BVec4.yyww get() = BVec4(y, y, w, w)
inline val BVec4.yzxx get() = BVec4(y, z, x, x)
inline val BVec4.yzxy get() = BVec4(y, z, x, y)
inline val BVec4.yzxz get() = BVec4(y, z, x, z)
inline val BVec4.yzxw get() = BVec4(y, z, x, w)
inline val BVec4.yzyx get() = BVec4(y, z, y, x)
inline val BVec4.yzyy get() = BVec4(y, z, y, y)
inline val BVec4.yzyz get() = BVec4(y, z, y, z)
inline val BVec4.yzyw get() = BVec4(y, z, y, w)
inline val BVec4.yzzx get() = BVec4(y, z, z, x)
inline val BVec4.yzzy get() = BVec4(y, z, z, y)
inline val BVec4.yzzz get() = BVec4(y, z, z, z)
inline val BVec4.yzzw get() = BVec4(y, z, z, w)
inline val BVec4.yzwx get() = BVec4(y, z, w, x)
inline val BVec4.yzwy get() = BVec4(y, z, w, y)
inline val BVec4.yzwz get() = BVec4(y, z, w, z)
inline val BVec4.yzww get() = BVec4(y, z, w, w)
inline val BVec4.ywxx get() = BVec4(y, w, x, x)
inline val BVec4.ywxy get() = BVec4(y, w, x, y)
inline val BVec4.ywxz get() = BVec4(y, w, x, z)
inline val BVec4.ywxw get() = BVec4(y, w, x, w)
inline val BVec4.ywyx get() = BVec4(y, w, y, x)
inline val BVec4.ywyy get() = BVec4(y, w, y, y)
inline val BVec4.ywyz get() = BVec4(y, w, y, z)
inline val BVec4.ywyw get() = BVec4(y, w, y, w)
inline val BVec4.ywzx get() = BVec4(y, w, z, x)
inline val BVec4.ywzy get() = BVec4(y, w, z, y)
inline val BVec4.ywzz get() = BVec4(y, w, z, z)
inline val BVec4.ywzw get() = BVec4(y, w, z, w)
inline val BVec4.ywwx get() = BVec4(y, w, w, x)
inline val BVec4.ywwy get() = BVec4(y, w, w, y)
inline val BVec4.ywwz get() = BVec4(y, w, w, z)
inline val BVec4.ywww get() = BVec4(y, w, w, w)
inline val BVec4.zxxx get() = BVec4(z, x, x, x)
inline val BVec4.zxxy get() = BVec4(z, x, x, y)
inline val BVec4.zxxz get() = BVec4(z, x, x, z)
inline val BVec4.zxxw get() = BVec4(z, x, x, w)
inline val BVec4.zxyx get() = BVec4(z, x, y, x)
inline val BVec4.zxyy get() = BVec4(z, x, y, y)
inline val BVec4.zxyz get() = BVec4(z, x, y, z)
inline val BVec4.zxyw get() = BVec4(z, x, y, w)
inline val BVec4.zxzx get() = BVec4(z, x, z, x)
inline val BVec4.zxzy get() = BVec4(z, x, z, y)
inline val BVec4.zxzz get() = BVec4(z, x, z, z)
inline val BVec4.zxzw get() = BVec4(z, x, z, w)
inline val BVec4.zxwx get() = BVec4(z, x, w, x)
inline val BVec4.zxwy get() = BVec4(z, x, w, y)
inline val BVec4.zxwz get() = BVec4(z, x, w, z)
inline val BVec4.zxww get() = BVec4(z, x, w, w)
inline val BVec4.zyxx get() = BVec4(z, y, x, x)
inline val BVec4.zyxy get() = BVec4(z, y, x, y)
inline val BVec4.zyxz get() = BVec4(z, y, x, z)
inline val BVec4.zyxw get() = BVec4(z, y, x, w)
inline val BVec4.zyyx get() = BVec4(z, y, y, x)
inline val BVec4.zyyy get() = BVec4(z, y, y, y)
inline val BVec4.zyyz get() = BVec4(z, y, y, z)
inline val BVec4.zyyw get() = BVec4(z, y, y, w)
inline val BVec4.zyzx get() = BVec4(z, y, z, x)
inline val BVec4.zyzy get() = BVec4(z, y, z, y)
inline val BVec4.zyzz get() = BVec4(z, y, z, z)
inline val BVec4.zyzw get() = BVec4(z, y, z, w)
inline val BVec4.zywx get() = BVec4(z, y, w, x)
inline val BVec4.zywy get() = BVec4(z, y, w, y)
inline val BVec4.zywz get() = BVec4(z, y, w, z)
inline val BVec4.zyww get() = BVec4(z, y, w, w)
inline val BVec4.zzxx get() = BVec4(z, z, x, x)
inline val BVec4.zzxy get() = BVec4(z, z, x, y)
inline val BVec4.zzxz get() = BVec4(z, z, x, z)
inline val BVec4.zzxw get() = BVec4(z, z, x, w)
inline val BVec4.zzyx get() = BVec4(z, z, y, x)
inline val BVec4.zzyy get() = BVec4(z, z, y, y)
inline val BVec4.zzyz get() = BVec4(z, z, y, z)
inline val BVec4.zzyw get() = BVec4(z, z, y, w)
inline val BVec4.zzzx get() = BVec4(z, z, z, x)
inline val BVec4.zzzy get() = BVec4(z, z, z, y)
inline val BVec4.zzzz get() = BVec4(z, z, z, z)
inline val BVec4.zzzw get() = BVec4(z, z, z, w)
inline val BVec4.zzwx get() = BVec4(z, z, w, x)
inline val BVec4.zzwy get() = BVec4(z, z, w, y)
inline val BVec4.zzwz get() = BVec4(z, z, w, z)
inline val BVec4.zzww get() = BVec4(z, z, w, w)
inline val BVec4.zwxx get() = BVec4(z, w, x, x)
inline val BVec4.zwxy get() = BVec4(z, w, x, y)
inline val BVec4.zwxz get() = BVec4(z, w, x, z)
inline val BVec4.zwxw get() = BVec4(z, w, x, w)
inline val BVec4.zwyx get() = BVec4(z, w, y, x)
inline val BVec4.zwyy get() = BVec4(z, w, y, y)
inline val BVec4.zwyz get() = BVec4(z, w, y, z)
inline val BVec4.zwyw get() = BVec4(z, w, y, w)
inline val BVec4.zwzx get() = BVec4(z, w, z, x)
inline val BVec4.zwzy get() = BVec4(z, w, z, y)
inline val BVec4.zwzz get() = BVec4(z, w, z, z)
inline val BVec4.zwzw get() = BVec4(z, w, z, w)
inline val BVec4.zwwx get() = BVec4(z, w, w, x)
inline val BVec4.zwwy get() = BVec4(z, w, w, y)
inline val BVec4.zwwz get() = BVec4(z, w, w, z)
inline val BVec4.zwww get() = BVec4(z, w, w, w)
inline val BVec4.wxxx get() = BVec4(w, x, x, x)
inline val BVec4.wxxy get() = BVec4(w, x, x, y)
inline val BVec4.wxxz get() = BVec4(w, x, x, z)
inline val BVec4.wxxw get() = BVec4(w, x, x, w)
inline val BVec4.wxyx get() = BVec4(w, x, y, x)
inline val BVec4.wxyy get() = BVec4(w, x, y, y)
inline val BVec4.wxyz get() = BVec4(w, x, y, z)
inline val BVec4.wxyw get() = BVec4(w, x, y, w)
inline val BVec4.wxzx get() = BVec4(w, x, z, x)
inline val BVec4.wxzy get() = BVec4(w, x, z, y)
inline val BVec4.wxzz get() = BVec4(w, x, z, z)
inline val BVec4.wxzw get() = BVec4(w, x, z, w)
inline val BVec4.wxwx get() = BVec4(w, x, w, x)
inline val BVec4.wxwy get() = BVec4(w, x, w, y)
inline val BVec4.wxwz get() = BVec4(w, x, w, z)
inline val BVec4.wxww get() = BVec4(w, x, w, w)
inline val BVec4.wyxx get() = BVec4(w, y, x, x)
inline val BVec4.wyxy get() = BVec4(w, y, x, y)
inline val BVec4.wyxz get() = BVec4(w, y, x, z)
inline val BVec4.wyxw get() = BVec4(w, y, x, w)
inline val BVec4.wyyx get() = BVec4(w, y, y, x)
inline val BVec4.wyyy get() = BVec4(w, y, y, y)
inline val BVec4.wyyz get() = BVec4(w, y, y, z)
inline val BVec4.wyyw get() = BVec4(w, y, y, w)
inline val BVec4.wyzx get() = BVec4(w, y, z, x)
inline val BVec4.wyzy get() = BVec4(w, y, z, y)
inline val BVec4.wyzz get() = BVec4(w, y, z, z)
inline val BVec4.wyzw get() = BVec4(w, y, z, w)
inline val BVec4.wywx get() = BVec4(w, y, w, x)
inline val BVec4.wywy get() = BVec4(w, y, w, y)
inline val BVec4.wywz get() = BVec4(w, y, w, z)
inline val BVec4.wyww get() = BVec4(w, y, w, w)
inline val BVec4.wzxx get() = BVec4(w, z, x, x)
inline val BVec4.wzxy get() = BVec4(w, z, x, y)
inline val BVec4.wzxz get() = BVec4(w, z, x, z)
inline val BVec4.wzxw get() = BVec4(w, z, x, w)
inline val BVec4.wzyx get() = BVec4(w, z, y, x)
inline val BVec4.wzyy get() = BVec4(w, z, y, y)
inline val BVec4.wzyz get() = BVec4(w, z, y, z)
inline val BVec4.wzyw get() = BVec4(w, z, y, w)
inline val BVec4.wzzx get() = BVec4(w, z, z, x)
inline val BVec4.wzzy get() = BVec4(w, z, z, y)
inline val BVec4.wzzz get() = BVec4(w, z, z, z)
inline val BVec4.wzzw get() = BVec4(w, z, z, w)
inline val BVec4.wzwx get() = BVec4(w, z, w, x)
inline val BVec4.wzwy get() = BVec4(w, z, w, y)
inline val BVec4.wzwz get() = BVec4(w, z, w, z)
inline val BVec4.wzww get() = BVec4(w, z, w, w)
inline val BVec4.wwxx get() = BVec4(w, w, x, x)
inline val BVec4.wwxy get() = BVec4(w, w, x, y)
inline val BVec4.wwxz get() = BVec4(w, w, x, z)
inline val BVec4.wwxw get() = BVec4(w, w, x, w)
inline val BVec4.wwyx get() = BVec4(w, w, y, x)
inline val BVec4.wwyy get() = BVec4(w, w, y, y)
inline val BVec4.wwyz get() = BVec4(w, w, y, z)
inline val BVec4.wwyw get() = BVec4(w, w, y, w)
inline val BVec4.wwzx get() = BVec4(w, w, z, x)
inline val BVec4.wwzy get() = BVec4(w, w, z, y)
inline val BVec4.wwzz get() = BVec4(w, w, z, z)
inline val BVec4.wwzw get() = BVec4(w, w, z, w)
inline val BVec4.wwwx get() = BVec4(w, w, w, x)
inline val BVec4.wwwy get() = BVec4(w, w, w, y)
inline val BVec4.wwwz get() = BVec4(w, w, w, z)
inline val BVec4.wwww get() = BVec4(w, w, w, w)

inline val BVec4.xxx get() = BVec3(x, x, x)
inline val BVec4.xxy get() = BVec3(x, x, y)
inline val BVec4.xxz get() = BVec3(x, x, z)
inline val BVec4.xxw get() = BVec3(x, x, w)
inline val BVec4.xyx get() = BVec3(x, y, x)
inline val BVec4.xyy get() = BVec3(x, y, y)
inline val BVec4.xyz get() = BVec3(x, y, z)
inline val BVec4.xyw get() = BVec3(x, y, w)
inline val BVec4.xzx get() = BVec3(x, z, x)
inline val BVec4.xzy get() = BVec3(x, z, y)
inline val BVec4.xzz get() = BVec3(x, z, z)
inline val BVec4.xzw get() = BVec3(x, z, w)
inline val BVec4.xwx get() = BVec3(x, w, x)
inline val BVec4.xwy get() = BVec3(x, w, y)
inline val BVec4.xwz get() = BVec3(x, w, z)
inline val BVec4.xww get() = BVec3(x, w, w)
inline val BVec4.yxx get() = BVec3(y, x, x)
inline val BVec4.yxy get() = BVec3(y, x, y)
inline val BVec4.yxz get() = BVec3(y, x, z)
inline val BVec4.yxw get() = BVec3(y, x, w)
inline val BVec4.yyx get() = BVec3(y, y, x)
inline val BVec4.yyy get() = BVec3(y, y, y)
inline val BVec4.yyz get() = BVec3(y, y, z)
inline val BVec4.yyw get() = BVec3(y, y, w)
inline val BVec4.yzx get() = BVec3(y, z, x)
inline val BVec4.yzy get() = BVec3(y, z, y)
inline val BVec4.yzz get() = BVec3(y, z, z)
inline val BVec4.yzw get() = BVec3(y, z, w)
inline val BVec4.ywx get() = BVec3(y, w, x)
inline val BVec4.ywy get() = BVec3(y, w, y)
inline val BVec4.ywz get() = BVec3(y, w, z)
inline val BVec4.yww get() = BVec3(y, w, w)
inline val BVec4.zxx get() = BVec3(z, x, x)
inline val BVec4.zxy get() = BVec3(z, x, y)
inline val BVec4.zxz get() = BVec3(z, x, z)
inline val BVec4.zxw get() = BVec3(z, x, w)
inline val BVec4.zyx get() = BVec3(z, y, x)
inline val BVec4.zyy get() = BVec3(z, y, y)
inline val BVec4.zyz get() = BVec3(z, y, z)
inline val BVec4.zyw get() = BVec3(z, y, w)
inline val BVec4.zzx get() = BVec3(z, z, x)
inline val BVec4.zzy get() = BVec3(z, z, y)
inline val BVec4.zzz get() = BVec3(z, z, z)
inline val BVec4.zzw get() = BVec3(z, z, w)
inline val BVec4.zwx get() = BVec3(z, w, x)
inline val BVec4.zwy get() = BVec3(z, w, y)
inline val BVec4.zwz get() = BVec3(z, w, z)
inline val BVec4.zww get() = BVec3(z, w, w)
inline val BVec4.wxx get() = BVec3(w, x, x)
inline val BVec4.wxy get() = BVec3(w, x, y)
inline val BVec4.wxz get() = BVec3(w, x, z)
inline val BVec4.wxw get() = BVec3(w, x, w)
inline val BVec4.wyx get() = BVec3(w, y, x)
inline val BVec4.wyy get() = BVec3(w, y, y)
inline val BVec4.wyz get() = BVec3(w, y, z)
inline val BVec4.wyw get() = BVec3(w, y, w)
inline val BVec4.wzx get() = BVec3(w, z, x)
inline val BVec4.wzy get() = BVec3(w, z, y)
inline val BVec4.wzz get() = BVec3(w, z, z)
inline val BVec4.wzw get() = BVec3(w, z, w)
inline val BVec4.wwx get() = BVec3(w, w, x)
inline val BVec4.wwy get() = BVec3(w, w, y)
inline val BVec4.wwz get() = BVec3(w, w, z)
inline val BVec4.www get() = BVec3(w, w, w)

inline val BVec4.xx get() = BVec2(x, x)
inline val BVec4.xy get() = BVec2(x, y)
inline val BVec4.xz get() = BVec2(x, z)
inline val BVec4.xw get() = BVec2(x, w)
inline val BVec4.yx get() = BVec2(y, x)
inline val BVec4.yy get() = BVec2(y, y)
inline val BVec4.yz get() = BVec2(y, z)
inline val BVec4.yw get() = BVec2(y, w)
inline val BVec4.zx get() = BVec2(z, x)
inline val BVec4.zy get() = BVec2(z, y)
inline val BVec4.zz get() = BVec2(z, z)
inline val BVec4.zw get() = BVec2(z, w)
inline val BVec4.wx get() = BVec2(w, x)
inline val BVec4.wy get() = BVec2(w, y)
inline val BVec4.wz get() = BVec2(w, z)
inline val BVec4.ww get() = BVec2(w, w)
//endregion
