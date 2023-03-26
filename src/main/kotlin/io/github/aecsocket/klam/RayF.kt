package io.github.aecsocket.klam

data class FRay2(@JvmField val origin: FVec2, @JvmField val direction: FVec2) {
    constructor(r: FRay2) : this(FVec2(r.origin), FVec2(r.direction))

    fun at(t: Float) = origin + direction * t

    fun asString(fmt: String) = "FRay[${origin.asString(fmt)} -> ${direction.asString(fmt)}]"
    override fun toString() = asString(DECIMAL_FORMAT)
}

data class FRay3(@JvmField val origin: FVec3, @JvmField val direction: FVec3) {
    constructor(r: FRay3) : this(FVec3(r.origin), FVec3(r.direction))

    fun at(t: Float) = origin + direction * t

    fun asString(fmt: String) = "FRay[${origin.asString(fmt)} -> ${direction.asString(fmt)}]"
    override fun toString() = asString(DECIMAL_FORMAT)
}

data class FRay4(@JvmField val origin: FVec4, @JvmField val direction: FVec4) {
    constructor(r: FRay4) : this(FVec4(r.origin), FVec4(r.direction))

    fun at(t: Float) = origin + direction * t

    fun asString(fmt: String) = "FRay[${origin.asString(fmt)} -> ${direction.asString(fmt)}]"
    override fun toString() = asString(DECIMAL_FORMAT)
}
