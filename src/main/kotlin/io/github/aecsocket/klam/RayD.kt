package io.github.aecsocket.klam

data class DRay2(@JvmField val origin: DVec2, @JvmField val direction: FVec2) {
    constructor(r: DRay2) : this(DVec2(r.origin), FVec2(r.direction))

    fun at(t: Float) = origin + DVec2(direction * t)

    fun asString(fmt: String) = "DRay[${origin.asString(fmt)} -> ${direction.asString(fmt)}]"
    override fun toString() = asString(DECIMAL_FORMAT)
}

data class DRay3(@JvmField val origin: DVec3, @JvmField val direction: FVec3) {
    constructor(r: DRay3) : this(DVec3(r.origin), FVec3(r.direction))

    fun at(t: Float) = origin + DVec3(direction * t)

    fun asString(fmt: String) = "DRay[${origin.asString(fmt)} -> ${direction.asString(fmt)}]"
    override fun toString() = asString(DECIMAL_FORMAT)
}

data class DRay4(@JvmField val origin: DVec4, @JvmField val direction: FVec4) {
    constructor(r: DRay4) : this(DVec4(r.origin), FVec4(r.direction))

    fun at(t: Float) = origin + DVec4(direction * t)

    fun asString(fmt: String) = "DRay[${origin.asString(fmt)} -> ${direction.asString(fmt)}]"
    override fun toString() = asString(DECIMAL_FORMAT)
}
