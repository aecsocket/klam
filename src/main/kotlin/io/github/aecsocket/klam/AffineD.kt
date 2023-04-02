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
) {
    constructor(t: DAffine3) : this(DVec3(t.position), FQuat(t.rotation))

    fun from(position: DVec3, rotation: FQuat) {
        this.position.from(position)
        this.rotation.from(rotation)
    }
    fun from(t: DAffine3) = from(t.position, t.rotation)

    fun left() = rotation * left

    fun right() = rotation * right

    fun up() = rotation * up

    fun down() = rotation * down

    fun forward() = rotation * forward

    fun backward() = rotation * backward

    fun asString(fmt: String) = "[${position.asString(fmt)}, ${rotation.asString(fmt)}]"
    override fun toString() = asString("%f")
}

inline operator fun DAffine3.times(t: DAffine3) = DAffine3(this).apply { this *= t }

inline operator fun DAffine3.timesAssign(t: DAffine3) {
    from(
        rotation * t.position + position,
        rotation * t.rotation,
    )
}

inline operator fun DAffine3.times(v: DVec3) = rotation * v + position
