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
}

inline fun FAabb2.mapVector(block: (FVec2) -> FVec2) = FAabb2(block(min), block(max))
inline fun FAabb2.mapScalar(block: (Float) -> Float) = FAabb2(min.map(block), max.map(block))

inline operator fun FAabb2.unaryMinus() = FAabb2(-min, -max)

inline operator fun FAabb2.plus(s: Float)  = FAabb2(min + s, max + s)
inline operator fun FAabb2.minus(s: Float) = FAabb2(min - s, max - s)
inline operator fun FAabb2.times(s: Float) = FAabb2(min * s, max * s)
inline operator fun FAabb2.div(s: Float)   = FAabb2(min / s, max / s)

inline operator fun Float.plus(b: FAabb2)  = FAabb2(this + b.min, this + b.max)
inline operator fun Float.minus(b: FAabb2) = FAabb2(this - b.min, this - b.max)
inline operator fun Float.times(b: FAabb2) = FAabb2(this * b.min, this * b.max)
inline operator fun Float.div(b: FAabb2)   = FAabb2(this / b.min, this / b.max)

inline operator fun FAabb2.plusAssign(s: Float)  { min += s; max += s }
inline operator fun FAabb2.minusAssign(s: Float) { min -= s; max -= s }
inline operator fun FAabb2.timesAssign(s: Float) { min *= s; max *= s }
inline operator fun FAabb2.divAssign(s: Float)   { min /= s; max /= s }

inline operator fun FAabb2.plus(v: FVec2)  = FAabb2(min + v, max + v)
inline operator fun FAabb2.minus(v: FVec2) = FAabb2(min - v, max - v)
inline operator fun FAabb2.times(v: FVec2) = FAabb2(min * v, max * v)
inline operator fun FAabb2.div(v: FVec2)   = FAabb2(min / v, max / v)

inline operator fun FAabb2.plusAssign(v: FVec2)  { min += v; max += v }
inline operator fun FAabb2.minusAssign(v: FVec2) { min -= v; max -= v }
inline operator fun FAabb2.timesAssign(v: FVec2) { min *= v; max *= v }
inline operator fun FAabb2.divAssign(v: FVec2)   { min /= v; max /= v }

inline operator fun FAabb2.plus(b: FAabb2)  = FAabb2(min + b.min, max + b.max)
inline operator fun FAabb2.minus(b: FAabb2) = FAabb2(min - b.min, max - b.max)
inline operator fun FAabb2.times(b: FAabb2) = FAabb2(min * b.min, max * b.max)
inline operator fun FAabb2.div(b: FAabb2)   = FAabb2(min / b.min, max / b.max)

inline operator fun FAabb2.plusAssign(b: FAabb2)  { min += b.min; max += b.max }
inline operator fun FAabb2.minusAssign(b: FAabb2) { min -= b.min; max -= b.max }
inline operator fun FAabb2.timesAssign(b: FAabb2) { min *= b.min; max *= b.max }
inline operator fun FAabb2.divAssign(b: FAabb2)   { min /= b.min; max /= b.max }

data class FAabb3(@JvmField val min: FVec3, @JvmField val max: FVec3) {
    constructor(b: FAabb3) : this(FVec3(b.min), FVec3(b.max))

    fun from(min: FVec3, max: FVec3) {
        this.min.from(min)
        this.max.from(max)
    }
    fun from(b: FAabb3) = from(b.min, b.max)

    fun asString(fmt: String) = "[${min.asString(fmt)} .. ${max.asString(fmt)}]"
    override fun toString() = asString("%f")
}

inline fun FAabb3.mapVector(block: (FVec3) -> FVec3) = FAabb3(block(min), block(max))
inline fun FAabb3.mapScalar(block: (Float) -> Float) = FAabb3(min.map(block), max.map(block))

inline operator fun FAabb3.unaryMinus() = FAabb3(-min, -max)

inline operator fun FAabb3.plus(s: Float)  = FAabb3(min + s, max + s)
inline operator fun FAabb3.minus(s: Float) = FAabb3(min - s, max - s)
inline operator fun FAabb3.times(s: Float) = FAabb3(min * s, max * s)
inline operator fun FAabb3.div(s: Float)   = FAabb3(min / s, max / s)

inline operator fun Float.plus(b: FAabb3)  = FAabb3(this + b.min, this + b.max)
inline operator fun Float.minus(b: FAabb3) = FAabb3(this - b.min, this - b.max)
inline operator fun Float.times(b: FAabb3) = FAabb3(this * b.min, this * b.max)
inline operator fun Float.div(b: FAabb3)   = FAabb3(this / b.min, this / b.max)

inline operator fun FAabb3.plusAssign(s: Float)  { min += s; max += s }
inline operator fun FAabb3.minusAssign(s: Float) { min -= s; max -= s }
inline operator fun FAabb3.timesAssign(s: Float) { min *= s; max *= s }
inline operator fun FAabb3.divAssign(s: Float)   { min /= s; max /= s }

inline operator fun FAabb3.plus(v: FVec3)  = FAabb3(min + v, max + v)
inline operator fun FAabb3.minus(v: FVec3) = FAabb3(min - v, max - v)
inline operator fun FAabb3.times(v: FVec3) = FAabb3(min * v, max * v)
inline operator fun FAabb3.div(v: FVec3)   = FAabb3(min / v, max / v)

inline operator fun FAabb3.plusAssign(v: FVec3)  { min += v; max += v }
inline operator fun FAabb3.minusAssign(v: FVec3) { min -= v; max -= v }
inline operator fun FAabb3.timesAssign(v: FVec3) { min *= v; max *= v }
inline operator fun FAabb3.divAssign(v: FVec3)   { min /= v; max /= v }

inline operator fun FAabb3.plus(b: FAabb3)  = FAabb3(min + b.min, max + b.max)
inline operator fun FAabb3.minus(b: FAabb3) = FAabb3(min - b.min, max - b.max)
inline operator fun FAabb3.times(b: FAabb3) = FAabb3(min * b.min, max * b.max)
inline operator fun FAabb3.div(b: FAabb3)   = FAabb3(min / b.min, max / b.max)

inline operator fun FAabb3.plusAssign(b: FAabb3)  { min += b.min; max += b.max }
inline operator fun FAabb3.minusAssign(b: FAabb3) { min -= b.min; max -= b.max }
inline operator fun FAabb3.timesAssign(b: FAabb3) { min *= b.min; max *= b.max }
inline operator fun FAabb3.divAssign(b: FAabb3)   { min /= b.min; max /= b.max }

data class FAabb4(@JvmField val min: FVec4, @JvmField val max: FVec4) {
    constructor(b: FAabb4) : this(FVec4(b.min), FVec4(b.max))

    fun from(min: FVec4, max: FVec4) {
        this.min.from(min)
        this.max.from(max)
    }
    fun from(b: FAabb4) = from(b.min, b.max)

    fun asString(fmt: String) = "[${min.asString(fmt)} .. ${max.asString(fmt)}]"
    override fun toString() = asString("%f")
}

inline fun FAabb4.mapVector(block: (FVec4) -> FVec4) = FAabb4(block(min), block(max))
inline fun FAabb4.mapScalar(block: (Float) -> Float) = FAabb4(min.map(block), max.map(block))

inline operator fun FAabb4.unaryMinus() = FAabb4(-min, -max)

inline operator fun FAabb4.plus(s: Float)  = FAabb4(min + s, max + s)
inline operator fun FAabb4.minus(s: Float) = FAabb4(min - s, max - s)
inline operator fun FAabb4.times(s: Float) = FAabb4(min * s, max * s)
inline operator fun FAabb4.div(s: Float)   = FAabb4(min / s, max / s)

inline operator fun Float.plus(b: FAabb4)  = FAabb4(this + b.min, this + b.max)
inline operator fun Float.minus(b: FAabb4) = FAabb4(this - b.min, this - b.max)
inline operator fun Float.times(b: FAabb4) = FAabb4(this * b.min, this * b.max)
inline operator fun Float.div(b: FAabb4)   = FAabb4(this / b.min, this / b.max)

inline operator fun FAabb4.plusAssign(s: Float)  { min += s; max += s }
inline operator fun FAabb4.minusAssign(s: Float) { min -= s; max -= s }
inline operator fun FAabb4.timesAssign(s: Float) { min *= s; max *= s }
inline operator fun FAabb4.divAssign(s: Float)   { min /= s; max /= s }

inline operator fun FAabb4.plus(v: FVec4)  = FAabb4(min + v, max + v)
inline operator fun FAabb4.minus(v: FVec4) = FAabb4(min - v, max - v)
inline operator fun FAabb4.times(v: FVec4) = FAabb4(min * v, max * v)
inline operator fun FAabb4.div(v: FVec4)   = FAabb4(min / v, max / v)

inline operator fun FAabb4.plusAssign(v: FVec4)  { min += v; max += v }
inline operator fun FAabb4.minusAssign(v: FVec4) { min -= v; max -= v }
inline operator fun FAabb4.timesAssign(v: FVec4) { min *= v; max *= v }
inline operator fun FAabb4.divAssign(v: FVec4)   { min /= v; max /= v }

inline operator fun FAabb4.plus(b: FAabb4)  = FAabb4(min + b.min, max + b.max)
inline operator fun FAabb4.minus(b: FAabb4) = FAabb4(min - b.min, max - b.max)
inline operator fun FAabb4.times(b: FAabb4) = FAabb4(min * b.min, max * b.max)
inline operator fun FAabb4.div(b: FAabb4)   = FAabb4(min / b.min, max / b.max)

inline operator fun FAabb4.plusAssign(b: FAabb4)  { min += b.min; max += b.max }
inline operator fun FAabb4.minusAssign(b: FAabb4) { min -= b.min; max -= b.max }
inline operator fun FAabb4.timesAssign(b: FAabb4) { min *= b.min; max *= b.max }
inline operator fun FAabb4.divAssign(b: FAabb4)   { min /= b.min; max /= b.max }
