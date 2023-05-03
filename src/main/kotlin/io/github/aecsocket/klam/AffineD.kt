@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

private val left     = DVec3( 1.0,  0.0,  0.0)
private val right    = DVec3(-1.0,  0.0,  0.0)
private val up       = DVec3( 0.0,  1.0,  0.0)
private val down     = DVec3( 0.0, -1.0,  0.0)
private val forward  = DVec3( 0.0,  0.0,  1.0)
private val backward = DVec3( 0.0,  0.0, -1.0)

data class DAffine3(
    @JvmField val position: DVec3 = DVec3(0.0),
    @JvmField val rotation: FQuat = FQuat(0.0f, 0.0f, 0.0f, 1.0f),
    @JvmField val scale: FVec3 = FVec3(1.0f),
) {
    constructor(t: DAffine3) : this(DVec3(t.position), FQuat(t.rotation), FVec3(t.scale))

    fun from(position: DVec3, rotation: FQuat, scale: FVec3) {
        this.position.from(position)
        this.rotation.from(rotation)
        this.scale.from(scale)
    }
    fun from(t: DAffine3) = from(t.position, t.rotation, t.scale)

    fun left() = rotation * left

    fun right() = rotation * right

    fun up() = rotation * up

    fun down() = rotation * down

    fun forward() = rotation * forward

    fun backward() = rotation * backward

    fun asString(fmt: String) = "[${position.asString(fmt)}, ${rotation.asString(fmt)}, ${scale.asString(fmt)}]"
    override fun toString() = asString("%f")

    inline operator fun times(t: DAffine3) = DAffine3(this).apply { this *= t }

    inline operator fun timesAssign(t: DAffine3) {
        val scale = this.scale * t.scale
        val rotation = this.rotation * t.rotation
        val position = (this.rotation * (t.position * DVec3(this.scale))) + this.position
        from(position, rotation, scale)
    }

    inline operator fun times(v: DVec3) = (rotation * (v * DVec3(scale))) + position

}