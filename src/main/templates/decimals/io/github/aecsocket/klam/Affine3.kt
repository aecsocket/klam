@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Affine3(
    @JvmField val position: {{ T }}Vec3 = {{ T }}Vec3.{{ Zero }},
    @JvmField val rotation: {{ T }}Quat = {{ T }}Quat.Identity,
    @JvmField val scale: {{ T }}Vec3 = {{ T }}Vec3.{{ One }},
) {
    fun asString(fmt: String) = "[${position.asString(fmt)}, ${rotation.asString(fmt)}, ${scale.asString(fmt)}]"
    override fun toString() = asString("{{ toStringFormat }}")

    @JvmName("mul")
    inline operator fun times(t: {{ T }}Affine3): {{ T }}Affine3 {
        val scale = this.scale * t.scale
        val rotation = this.rotation * t.rotation
        val position = (this.rotation * (t.position * this.scale)) + this.position
        return {{ T }}Affine3(position, rotation, scale)
    }

    @JvmName("transform")
    inline operator fun times(v: {{ T }}Vec3) = (rotation * (v * scale)) + position
}

inline fun inverse(t: {{ T }}Affine3): {{ T }}Affine3 {
    val scaleInv = {{ one }} / t.scale
    val rotInv = inverse(t.rotation)
    return {{ T }}Affine3((rotInv * -t.position) * scaleInv, rotInv, scaleInv)
}
