@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

data class DAabb2(@JvmField val min: DVec2, @JvmField val max: DVec2) {
    constructor(b: DAabb2) : this(DVec2(b.min), DVec2(b.max))

    fun from(min: DVec2, max: DVec2) {
        this.min.from(min)
        this.max.from(max)
    }
    fun from(b: DAabb2) = from(b.min, b.max)

    fun asString(fmt: String) = "[${min.asString(fmt)} .. ${max.asString(fmt)}]"
    override fun toString() = asString("%f")
}

inline fun DAabb2.mapVector(block: (DVec2) -> DVec2) = DAabb2(block(min), block(max))
inline fun DAabb2.mapScalar(block: (Double) -> Double) = DAabb2(min.map(block), max.map(block))

inline operator fun DAabb2.unaryMinus() = DAabb2(-min, -max)

inline operator fun DAabb2.plus(s: Double)  = DAabb2(min + s, max + s)
inline operator fun DAabb2.minus(s: Double) = DAabb2(min - s, max - s)
inline operator fun DAabb2.times(s: Double) = DAabb2(min * s, max * s)
inline operator fun DAabb2.div(s: Double)   = DAabb2(min / s, max / s)

inline operator fun Double.plus(b: DAabb2)  = DAabb2(this + b.min, this + b.max)
inline operator fun Double.minus(b: DAabb2) = DAabb2(this - b.min, this - b.max)
inline operator fun Double.times(b: DAabb2) = DAabb2(this * b.min, this * b.max)
inline operator fun Double.div(b: DAabb2)   = DAabb2(this / b.min, this / b.max)

inline operator fun DAabb2.plusAssign(s: Double)  { min += s; max += s }
inline operator fun DAabb2.minusAssign(s: Double) { min -= s; max -= s }
inline operator fun DAabb2.timesAssign(s: Double) { min *= s; max *= s }
inline operator fun DAabb2.divAssign(s: Double)   { min /= s; max /= s }

inline operator fun DAabb2.plus(v: DVec2)  = DAabb2(min + v, max + v)
inline operator fun DAabb2.minus(v: DVec2) = DAabb2(min - v, max - v)
inline operator fun DAabb2.times(v: DVec2) = DAabb2(min * v, max * v)
inline operator fun DAabb2.div(v: DVec2)   = DAabb2(min / v, max / v)

inline operator fun DAabb2.plusAssign(v: DVec2)  { min += v; max += v }
inline operator fun DAabb2.minusAssign(v: DVec2) { min -= v; max -= v }
inline operator fun DAabb2.timesAssign(v: DVec2) { min *= v; max *= v }
inline operator fun DAabb2.divAssign(v: DVec2)   { min /= v; max /= v }

inline operator fun DAabb2.plus(b: DAabb2)  = DAabb2(min + b.min, max + b.max)
inline operator fun DAabb2.minus(b: DAabb2) = DAabb2(min - b.min, max - b.max)
inline operator fun DAabb2.times(b: DAabb2) = DAabb2(min * b.min, max * b.max)
inline operator fun DAabb2.div(b: DAabb2)   = DAabb2(min / b.min, max / b.max)

inline operator fun DAabb2.plusAssign(b: DAabb2)  { min += b.min; max += b.max }
inline operator fun DAabb2.minusAssign(b: DAabb2) { min -= b.min; max -= b.max }
inline operator fun DAabb2.timesAssign(b: DAabb2) { min *= b.min; max *= b.max }
inline operator fun DAabb2.divAssign(b: DAabb2)   { min /= b.min; max /= b.max }

data class DAabb3(@JvmField val min: DVec3, @JvmField val max: DVec3) {
    constructor(b: DAabb3) : this(DVec3(b.min), DVec3(b.max))

    fun from(min: DVec3, max: DVec3) {
        this.min.from(min)
        this.max.from(max)
    }
    fun from(b: DAabb3) = from(b.min, b.max)

    fun asString(fmt: String) = "[${min.asString(fmt)} .. ${max.asString(fmt)}]"
    override fun toString() = asString("%f")
}

inline fun DAabb3.mapVector(block: (DVec3) -> DVec3) = DAabb3(block(min), block(max))
inline fun DAabb3.mapScalar(block: (Double) -> Double) = DAabb3(min.map(block), max.map(block))

inline operator fun DAabb3.unaryMinus() = DAabb3(-min, -max)

inline operator fun DAabb3.plus(s: Double)  = DAabb3(min + s, max + s)
inline operator fun DAabb3.minus(s: Double) = DAabb3(min - s, max - s)
inline operator fun DAabb3.times(s: Double) = DAabb3(min * s, max * s)
inline operator fun DAabb3.div(s: Double)   = DAabb3(min / s, max / s)

inline operator fun Double.plus(b: DAabb3)  = DAabb3(this + b.min, this + b.max)
inline operator fun Double.minus(b: DAabb3) = DAabb3(this - b.min, this - b.max)
inline operator fun Double.times(b: DAabb3) = DAabb3(this * b.min, this * b.max)
inline operator fun Double.div(b: DAabb3)   = DAabb3(this / b.min, this / b.max)

inline operator fun DAabb3.plusAssign(s: Double)  { min += s; max += s }
inline operator fun DAabb3.minusAssign(s: Double) { min -= s; max -= s }
inline operator fun DAabb3.timesAssign(s: Double) { min *= s; max *= s }
inline operator fun DAabb3.divAssign(s: Double)   { min /= s; max /= s }

inline operator fun DAabb3.plus(v: DVec3)  = DAabb3(min + v, max + v)
inline operator fun DAabb3.minus(v: DVec3) = DAabb3(min - v, max - v)
inline operator fun DAabb3.times(v: DVec3) = DAabb3(min * v, max * v)
inline operator fun DAabb3.div(v: DVec3)   = DAabb3(min / v, max / v)

inline operator fun DAabb3.plusAssign(v: DVec3)  { min += v; max += v }
inline operator fun DAabb3.minusAssign(v: DVec3) { min -= v; max -= v }
inline operator fun DAabb3.timesAssign(v: DVec3) { min *= v; max *= v }
inline operator fun DAabb3.divAssign(v: DVec3)   { min /= v; max /= v }

inline operator fun DAabb3.plus(b: DAabb3)  = DAabb3(min + b.min, max + b.max)
inline operator fun DAabb3.minus(b: DAabb3) = DAabb3(min - b.min, max - b.max)
inline operator fun DAabb3.times(b: DAabb3) = DAabb3(min * b.min, max * b.max)
inline operator fun DAabb3.div(b: DAabb3)   = DAabb3(min / b.min, max / b.max)

inline operator fun DAabb3.plusAssign(b: DAabb3)  { min += b.min; max += b.max }
inline operator fun DAabb3.minusAssign(b: DAabb3) { min -= b.min; max -= b.max }
inline operator fun DAabb3.timesAssign(b: DAabb3) { min *= b.min; max *= b.max }
inline operator fun DAabb3.divAssign(b: DAabb3)   { min /= b.min; max /= b.max }

data class DAabb4(@JvmField val min: DVec4, @JvmField val max: DVec4) {
    constructor(b: DAabb4) : this(DVec4(b.min), DVec4(b.max))

    fun from(min: DVec4, max: DVec4) {
        this.min.from(min)
        this.max.from(max)
    }
    fun from(b: DAabb4) = from(b.min, b.max)

    fun asString(fmt: String) = "[${min.asString(fmt)} .. ${max.asString(fmt)}]"
    override fun toString() = asString("%f")
}

inline fun DAabb4.mapVector(block: (DVec4) -> DVec4) = DAabb4(block(min), block(max))
inline fun DAabb4.mapScalar(block: (Double) -> Double) = DAabb4(min.map(block), max.map(block))

inline operator fun DAabb4.unaryMinus() = DAabb4(-min, -max)

inline operator fun DAabb4.plus(s: Double)  = DAabb4(min + s, max + s)
inline operator fun DAabb4.minus(s: Double) = DAabb4(min - s, max - s)
inline operator fun DAabb4.times(s: Double) = DAabb4(min * s, max * s)
inline operator fun DAabb4.div(s: Double)   = DAabb4(min / s, max / s)

inline operator fun Double.plus(b: DAabb4)  = DAabb4(this + b.min, this + b.max)
inline operator fun Double.minus(b: DAabb4) = DAabb4(this - b.min, this - b.max)
inline operator fun Double.times(b: DAabb4) = DAabb4(this * b.min, this * b.max)
inline operator fun Double.div(b: DAabb4)   = DAabb4(this / b.min, this / b.max)

inline operator fun DAabb4.plusAssign(s: Double)  { min += s; max += s }
inline operator fun DAabb4.minusAssign(s: Double) { min -= s; max -= s }
inline operator fun DAabb4.timesAssign(s: Double) { min *= s; max *= s }
inline operator fun DAabb4.divAssign(s: Double)   { min /= s; max /= s }

inline operator fun DAabb4.plus(v: DVec4)  = DAabb4(min + v, max + v)
inline operator fun DAabb4.minus(v: DVec4) = DAabb4(min - v, max - v)
inline operator fun DAabb4.times(v: DVec4) = DAabb4(min * v, max * v)
inline operator fun DAabb4.div(v: DVec4)   = DAabb4(min / v, max / v)

inline operator fun DAabb4.plusAssign(v: DVec4)  { min += v; max += v }
inline operator fun DAabb4.minusAssign(v: DVec4) { min -= v; max -= v }
inline operator fun DAabb4.timesAssign(v: DVec4) { min *= v; max *= v }
inline operator fun DAabb4.divAssign(v: DVec4)   { min /= v; max /= v }

inline operator fun DAabb4.plus(b: DAabb4)  = DAabb4(min + b.min, max + b.max)
inline operator fun DAabb4.minus(b: DAabb4) = DAabb4(min - b.min, max - b.max)
inline operator fun DAabb4.times(b: DAabb4) = DAabb4(min * b.min, max * b.max)
inline operator fun DAabb4.div(b: DAabb4)   = DAabb4(min / b.min, max / b.max)

inline operator fun DAabb4.plusAssign(b: DAabb4)  { min += b.min; max += b.max }
inline operator fun DAabb4.minusAssign(b: DAabb4) { min -= b.min; max -= b.max }
inline operator fun DAabb4.timesAssign(b: DAabb4) { min *= b.min; max *= b.max }
inline operator fun DAabb4.divAssign(b: DAabb4)   { min /= b.min; max /= b.max }
