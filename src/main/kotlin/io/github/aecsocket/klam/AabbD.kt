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

    inline fun mapVector(block: (DVec2) -> DVec2) = DAabb2(block(min), block(max))
    inline fun mapScalar(block: (Double) -> Double) = DAabb2(min.map(block), max.map(block))

    inline operator fun unaryMinus() = DAabb2(-min, -max)

    inline operator fun plus(s: Double)  = DAabb2(min + s, max + s)
    inline operator fun minus(s: Double) = DAabb2(min - s, max - s)
    inline operator fun times(s: Double) = DAabb2(min * s, max * s)
    inline operator fun div(s: Double)   = DAabb2(min / s, max / s)

    inline operator fun plusAssign(s: Double)  { min += s; max += s }
    inline operator fun minusAssign(s: Double) { min -= s; max -= s }
    inline operator fun timesAssign(s: Double) { min *= s; max *= s }
    inline operator fun divAssign(s: Double)   { min /= s; max /= s }

    inline operator fun plus(v: DVec2)  = DAabb2(min + v, max + v)
    inline operator fun minus(v: DVec2) = DAabb2(min - v, max - v)
    inline operator fun times(v: DVec2) = DAabb2(min * v, max * v)
    inline operator fun div(v: DVec2)   = DAabb2(min / v, max / v)

    inline operator fun plusAssign(v: DVec2)  { min += v; max += v }
    inline operator fun minusAssign(v: DVec2) { min -= v; max -= v }
    inline operator fun timesAssign(v: DVec2) { min *= v; max *= v }
    inline operator fun divAssign(v: DVec2)   { min /= v; max /= v }

    inline operator fun plus(b: DAabb2)  = DAabb2(min + b.min, max + b.max)
    inline operator fun minus(b: DAabb2) = DAabb2(min - b.min, max - b.max)
    inline operator fun times(b: DAabb2) = DAabb2(min * b.min, max * b.max)
    inline operator fun div(b: DAabb2)   = DAabb2(min / b.min, max / b.max)

    inline operator fun plusAssign(b: DAabb2)  { min += b.min; max += b.max }
    inline operator fun minusAssign(b: DAabb2) { min -= b.min; max -= b.max }
    inline operator fun timesAssign(b: DAabb2) { min *= b.min; max *= b.max }
    inline operator fun divAssign(b: DAabb2)   { min /= b.min; max /= b.max }
}

inline operator fun Double.plus(b: DAabb2)  = DAabb2(this + b.min, this + b.max)
inline operator fun Double.minus(b: DAabb2) = DAabb2(this - b.min, this - b.max)
inline operator fun Double.times(b: DAabb2) = DAabb2(this * b.min, this * b.max)
inline operator fun Double.div(b: DAabb2)   = DAabb2(this / b.min, this / b.max)

data class DAabb3(@JvmField val min: DVec3, @JvmField val max: DVec3) {
    constructor(b: DAabb3) : this(DVec3(b.min), DVec3(b.max))

    fun from(min: DVec3, max: DVec3) {
        this.min.from(min)
        this.max.from(max)
    }
    fun from(b: DAabb3) = from(b.min, b.max)

    fun asString(fmt: String) = "[${min.asString(fmt)} .. ${max.asString(fmt)}]"
    override fun toString() = asString("%f")

    inline fun mapVector(block: (DVec3) -> DVec3) = DAabb3(block(min), block(max))
    inline fun mapScalar(block: (Double) -> Double) = DAabb3(min.map(block), max.map(block))

    inline operator fun unaryMinus() = DAabb3(-min, -max)

    inline operator fun plus(s: Double)  = DAabb3(min + s, max + s)
    inline operator fun minus(s: Double) = DAabb3(min - s, max - s)
    inline operator fun times(s: Double) = DAabb3(min * s, max * s)
    inline operator fun div(s: Double)   = DAabb3(min / s, max / s)

    inline operator fun plusAssign(s: Double)  { min += s; max += s }
    inline operator fun minusAssign(s: Double) { min -= s; max -= s }
    inline operator fun timesAssign(s: Double) { min *= s; max *= s }
    inline operator fun divAssign(s: Double)   { min /= s; max /= s }

    inline operator fun plus(v: DVec3)  = DAabb3(min + v, max + v)
    inline operator fun minus(v: DVec3) = DAabb3(min - v, max - v)
    inline operator fun times(v: DVec3) = DAabb3(min * v, max * v)
    inline operator fun div(v: DVec3)   = DAabb3(min / v, max / v)

    inline operator fun plusAssign(v: DVec3)  { min += v; max += v }
    inline operator fun minusAssign(v: DVec3) { min -= v; max -= v }
    inline operator fun timesAssign(v: DVec3) { min *= v; max *= v }
    inline operator fun divAssign(v: DVec3)   { min /= v; max /= v }

    inline operator fun plus(b: DAabb3)  = DAabb3(min + b.min, max + b.max)
    inline operator fun minus(b: DAabb3) = DAabb3(min - b.min, max - b.max)
    inline operator fun times(b: DAabb3) = DAabb3(min * b.min, max * b.max)
    inline operator fun div(b: DAabb3)   = DAabb3(min / b.min, max / b.max)

    inline operator fun plusAssign(b: DAabb3)  { min += b.min; max += b.max }
    inline operator fun minusAssign(b: DAabb3) { min -= b.min; max -= b.max }
    inline operator fun timesAssign(b: DAabb3) { min *= b.min; max *= b.max }
    inline operator fun divAssign(b: DAabb3)   { min /= b.min; max /= b.max }
}

inline operator fun Double.plus(b: DAabb3)  = DAabb3(this + b.min, this + b.max)
inline operator fun Double.minus(b: DAabb3) = DAabb3(this - b.min, this - b.max)
inline operator fun Double.times(b: DAabb3) = DAabb3(this * b.min, this * b.max)
inline operator fun Double.div(b: DAabb3)   = DAabb3(this / b.min, this / b.max)

data class DAabb4(@JvmField val min: DVec4, @JvmField val max: DVec4) {
    constructor(b: DAabb4) : this(DVec4(b.min), DVec4(b.max))

    fun from(min: DVec4, max: DVec4) {
        this.min.from(min)
        this.max.from(max)
    }
    fun from(b: DAabb4) = from(b.min, b.max)

    fun asString(fmt: String) = "[${min.asString(fmt)} .. ${max.asString(fmt)}]"
    override fun toString() = asString("%f")

    inline fun mapVector(block: (DVec4) -> DVec4) = DAabb4(block(min), block(max))
    inline fun mapScalar(block: (Double) -> Double) = DAabb4(min.map(block), max.map(block))

    inline operator fun unaryMinus() = DAabb4(-min, -max)

    inline operator fun plus(s: Double)  = DAabb4(min + s, max + s)
    inline operator fun minus(s: Double) = DAabb4(min - s, max - s)
    inline operator fun times(s: Double) = DAabb4(min * s, max * s)
    inline operator fun div(s: Double)   = DAabb4(min / s, max / s)

    inline operator fun plusAssign(s: Double)  { min += s; max += s }
    inline operator fun minusAssign(s: Double) { min -= s; max -= s }
    inline operator fun timesAssign(s: Double) { min *= s; max *= s }
    inline operator fun divAssign(s: Double)   { min /= s; max /= s }

    inline operator fun plus(v: DVec4)  = DAabb4(min + v, max + v)
    inline operator fun minus(v: DVec4) = DAabb4(min - v, max - v)
    inline operator fun times(v: DVec4) = DAabb4(min * v, max * v)
    inline operator fun div(v: DVec4)   = DAabb4(min / v, max / v)

    inline operator fun plusAssign(v: DVec4)  { min += v; max += v }
    inline operator fun minusAssign(v: DVec4) { min -= v; max -= v }
    inline operator fun timesAssign(v: DVec4) { min *= v; max *= v }
    inline operator fun divAssign(v: DVec4)   { min /= v; max /= v }

    inline operator fun plus(b: DAabb4)  = DAabb4(min + b.min, max + b.max)
    inline operator fun minus(b: DAabb4) = DAabb4(min - b.min, max - b.max)
    inline operator fun times(b: DAabb4) = DAabb4(min * b.min, max * b.max)
    inline operator fun div(b: DAabb4)   = DAabb4(min / b.min, max / b.max)

    inline operator fun plusAssign(b: DAabb4)  { min += b.min; max += b.max }
    inline operator fun minusAssign(b: DAabb4) { min -= b.min; max -= b.max }
    inline operator fun timesAssign(b: DAabb4) { min *= b.min; max *= b.max }
    inline operator fun divAssign(b: DAabb4)   { min /= b.min; max /= b.max }
}

inline operator fun Double.plus(b: DAabb4)  = DAabb4(this + b.min, this + b.max)
inline operator fun Double.minus(b: DAabb4) = DAabb4(this - b.min, this - b.max)
inline operator fun Double.times(b: DAabb4) = DAabb4(this * b.min, this * b.max)
inline operator fun Double.div(b: DAabb4)   = DAabb4(this / b.min, this / b.max)
