@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

private val left     = FVec3( 1.0f,  0.0f,  0.0f)
private val right    = FVec3(-1.0f,  0.0f,  0.0f)
private val up       = FVec3( 0.0f,  1.0f,  0.0f)
private val down     = FVec3( 0.0f, -1.0f,  0.0f)
private val forward  = FVec3( 0.0f,  0.0f,  1.0f)
private val backward = FVec3( 0.0f,  0.0f, -1.0f)

data class FAffine3(
    @JvmField val position: FVec3 = FVec3(0.0f),
    @JvmField val rotation: FQuat = FQuat(0.0f, 0.0f, 0.0f, 1.0f),
    @JvmField val scale: FVec3 = FVec3(1.0f),
) {
    constructor(t: FAffine3) : this(FVec3(t.position), FQuat(t.rotation), FVec3(t.scale))

    fun from(position: FVec3, rotation: FQuat, scale: FVec3) {
        this.position.from(position)
        this.rotation.from(rotation)
        this.scale.from(scale)
    }
    fun from(t: FAffine3) = from(t.position, t.rotation, t.scale)

    fun left() = rotation * left

    fun right() = rotation * right

    fun up() = rotation * up

    fun down() = rotation * down

    fun forward() = rotation * forward

    fun backward() = rotation * backward

    fun asString(fmt: String) = "[${position.asString(fmt)}, ${rotation.asString(fmt)}, ${scale.asString(fmt)}]"
    override fun toString() = asString("%f")
}

inline operator fun FAffine3.times(t: FAffine3) = FAffine3(this).apply { this *= t }

inline operator fun FAffine3.timesAssign(t: FAffine3) {
    val scale = this.scale * t.scale
    val rotation = this.rotation * t.rotation
    val position = (this.rotation * (t.position * this.scale)) + this.position
    from(position, rotation, scale)
}

inline operator fun FAffine3.times(v: FVec3) = (rotation * (v * scale)) + position
