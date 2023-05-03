@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

data class FAabb2(@JvmField val min: FVec2, @JvmField val max: FVec2) {
    constructor(b: FAabb2) : this(FVec2(b.min), FVec2(b.max))

    fun from(min: FVec2, max: FVec2) {
        this.min.from(min)
        this.max.from(max)
    }
    fun from(b: FAabb2) = from(b.min, b.max)

    fun asString(fmt: String) = "[${min.asString(fmt)} .. ${max.asString(fmt)}]"
    override fun toString() = asString("%f")

    inline fun mapVector(block: (FVec2) -> FVec2) = FAabb2(block(min), block(max))
    inline fun mapScalar(block: (Float) -> Float) = FAabb2(min.map(block), max.map(block))

    inline operator fun unaryMinus() = FAabb2(-min, -max)

    inline operator fun plus(s: Float)  = FAabb2(min + s, max + s)
    inline operator fun minus(s: Float) = FAabb2(min - s, max - s)
    inline operator fun times(s: Float) = FAabb2(min * s, max * s)
    inline operator fun div(s: Float)   = FAabb2(min / s, max / s)

    inline operator fun plusAssign(s: Float)  { min += s; max += s }
    inline operator fun minusAssign(s: Float) { min -= s; max -= s }
    inline operator fun timesAssign(s: Float) { min *= s; max *= s }
    inline operator fun divAssign(s: Float)   { min /= s; max /= s }

    inline operator fun plus(v: FVec2)  = FAabb2(min + v, max + v)
    inline operator fun minus(v: FVec2) = FAabb2(min - v, max - v)
    inline operator fun times(v: FVec2) = FAabb2(min * v, max * v)
    inline operator fun div(v: FVec2)   = FAabb2(min / v, max / v)

    inline operator fun plusAssign(v: FVec2)  { min += v; max += v }
    inline operator fun minusAssign(v: FVec2) { min -= v; max -= v }
    inline operator fun timesAssign(v: FVec2) { min *= v; max *= v }
    inline operator fun divAssign(v: FVec2)   { min /= v; max /= v }

    inline operator fun plus(b: FAabb2)  = FAabb2(min + b.min, max + b.max)
    inline operator fun minus(b: FAabb2) = FAabb2(min - b.min, max - b.max)
    inline operator fun times(b: FAabb2) = FAabb2(min * b.min, max * b.max)
    inline operator fun div(b: FAabb2)   = FAabb2(min / b.min, max / b.max)

    inline operator fun plusAssign(b: FAabb2)  { min += b.min; max += b.max }
    inline operator fun minusAssign(b: FAabb2) { min -= b.min; max -= b.max }
    inline operator fun timesAssign(b: FAabb2) { min *= b.min; max *= b.max }
    inline operator fun divAssign(b: FAabb2)   { min /= b.min; max /= b.max }
}

inline operator fun Float.plus(b: FAabb2)  = FAabb2(this + b.min, this + b.max)
inline operator fun Float.minus(b: FAabb2) = FAabb2(this - b.min, this - b.max)
inline operator fun Float.times(b: FAabb2) = FAabb2(this * b.min, this * b.max)
inline operator fun Float.div(b: FAabb2)   = FAabb2(this / b.min, this / b.max)

data class FAabb3(@JvmField val min: FVec3, @JvmField val max: FVec3) {
    constructor(b: FAabb3) : this(FVec3(b.min), FVec3(b.max))

    fun from(min: FVec3, max: FVec3) {
        this.min.from(min)
        this.max.from(max)
    }
    fun from(b: FAabb3) = from(b.min, b.max)

    fun asString(fmt: String) = "[${min.asString(fmt)} .. ${max.asString(fmt)}]"
    override fun toString() = asString("%f")

    inline fun mapVector(block: (FVec3) -> FVec3) = FAabb3(block(min), block(max))
    inline fun mapScalar(block: (Float) -> Float) = FAabb3(min.map(block), max.map(block))

    inline operator fun unaryMinus() = FAabb3(-min, -max)

    inline operator fun plus(s: Float)  = FAabb3(min + s, max + s)
    inline operator fun minus(s: Float) = FAabb3(min - s, max - s)
    inline operator fun times(s: Float) = FAabb3(min * s, max * s)
    inline operator fun div(s: Float)   = FAabb3(min / s, max / s)

    inline operator fun plusAssign(s: Float)  { min += s; max += s }
    inline operator fun minusAssign(s: Float) { min -= s; max -= s }
    inline operator fun timesAssign(s: Float) { min *= s; max *= s }
    inline operator fun divAssign(s: Float)   { min /= s; max /= s }

    inline operator fun plus(v: FVec3)  = FAabb3(min + v, max + v)
    inline operator fun minus(v: FVec3) = FAabb3(min - v, max - v)
    inline operator fun times(v: FVec3) = FAabb3(min * v, max * v)
    inline operator fun div(v: FVec3)   = FAabb3(min / v, max / v)

    inline operator fun plusAssign(v: FVec3)  { min += v; max += v }
    inline operator fun minusAssign(v: FVec3) { min -= v; max -= v }
    inline operator fun timesAssign(v: FVec3) { min *= v; max *= v }
    inline operator fun divAssign(v: FVec3)   { min /= v; max /= v }

    inline operator fun plus(b: FAabb3)  = FAabb3(min + b.min, max + b.max)
    inline operator fun minus(b: FAabb3) = FAabb3(min - b.min, max - b.max)
    inline operator fun times(b: FAabb3) = FAabb3(min * b.min, max * b.max)
    inline operator fun div(b: FAabb3)   = FAabb3(min / b.min, max / b.max)

    inline operator fun plusAssign(b: FAabb3)  { min += b.min; max += b.max }
    inline operator fun minusAssign(b: FAabb3) { min -= b.min; max -= b.max }
    inline operator fun timesAssign(b: FAabb3) { min *= b.min; max *= b.max }
    inline operator fun divAssign(b: FAabb3)   { min /= b.min; max /= b.max }
}

inline operator fun Float.plus(b: FAabb3)  = FAabb3(this + b.min, this + b.max)
inline operator fun Float.minus(b: FAabb3) = FAabb3(this - b.min, this - b.max)
inline operator fun Float.times(b: FAabb3) = FAabb3(this * b.min, this * b.max)
inline operator fun Float.div(b: FAabb3)   = FAabb3(this / b.min, this / b.max)

data class FAabb4(@JvmField val min: FVec4, @JvmField val max: FVec4) {
    constructor(b: FAabb4) : this(FVec4(b.min), FVec4(b.max))

    fun from(min: FVec4, max: FVec4) {
        this.min.from(min)
        this.max.from(max)
    }
    fun from(b: FAabb4) = from(b.min, b.max)

    fun asString(fmt: String) = "[${min.asString(fmt)} .. ${max.asString(fmt)}]"
    override fun toString() = asString("%f")

    inline fun mapVector(block: (FVec4) -> FVec4) = FAabb4(block(min), block(max))
    inline fun mapScalar(block: (Float) -> Float) = FAabb4(min.map(block), max.map(block))

    inline operator fun unaryMinus() = FAabb4(-min, -max)

    inline operator fun plus(s: Float)  = FAabb4(min + s, max + s)
    inline operator fun minus(s: Float) = FAabb4(min - s, max - s)
    inline operator fun times(s: Float) = FAabb4(min * s, max * s)
    inline operator fun div(s: Float)   = FAabb4(min / s, max / s)

    inline operator fun plusAssign(s: Float)  { min += s; max += s }
    inline operator fun minusAssign(s: Float) { min -= s; max -= s }
    inline operator fun timesAssign(s: Float) { min *= s; max *= s }
    inline operator fun divAssign(s: Float)   { min /= s; max /= s }

    inline operator fun plus(v: FVec4)  = FAabb4(min + v, max + v)
    inline operator fun minus(v: FVec4) = FAabb4(min - v, max - v)
    inline operator fun times(v: FVec4) = FAabb4(min * v, max * v)
    inline operator fun div(v: FVec4)   = FAabb4(min / v, max / v)

    inline operator fun plusAssign(v: FVec4)  { min += v; max += v }
    inline operator fun minusAssign(v: FVec4) { min -= v; max -= v }
    inline operator fun timesAssign(v: FVec4) { min *= v; max *= v }
    inline operator fun divAssign(v: FVec4)   { min /= v; max /= v }

    inline operator fun plus(b: FAabb4)  = FAabb4(min + b.min, max + b.max)
    inline operator fun minus(b: FAabb4) = FAabb4(min - b.min, max - b.max)
    inline operator fun times(b: FAabb4) = FAabb4(min * b.min, max * b.max)
    inline operator fun div(b: FAabb4)   = FAabb4(min / b.min, max / b.max)

    inline operator fun plusAssign(b: FAabb4)  { min += b.min; max += b.max }
    inline operator fun minusAssign(b: FAabb4) { min -= b.min; max -= b.max }
    inline operator fun timesAssign(b: FAabb4) { min *= b.min; max *= b.max }
    inline operator fun divAssign(b: FAabb4)   { min /= b.min; max /= b.max }
}

inline operator fun Float.plus(b: FAabb4)  = FAabb4(this + b.min, this + b.max)
inline operator fun Float.minus(b: FAabb4) = FAabb4(this - b.min, this - b.max)
inline operator fun Float.times(b: FAabb4) = FAabb4(this * b.min, this * b.max)
inline operator fun Float.div(b: FAabb4)   = FAabb4(this / b.min, this / b.max)
