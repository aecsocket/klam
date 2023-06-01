@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Affine3(
    @JvmField val translation: {{ T }}Vec3 = {{ T }}Vec3.{{ Zero }},
    @JvmField val rotation: {{ T }}Quat = {{ T }}Quat.Identity,
    @JvmField val scale: {{ T }}Vec3 = {{ T }}Vec3.{{ One }},
) {
    constructor(iso: {{ T }}Iso3, scale: {{ T }}Vec3 = {{ T }}Vec3.{{ Zero }}) : this(iso.translation, iso.rotation, scale)

    constructor(t: {{ S }}Affine3) : this({{ T }}Vec3(t.translation), {{ T }}Quat(t.rotation), {{ T }}Vec3(t.scale))

    fun asString(fmt: String) = "[${translation.asString(fmt)}, ${rotation.asString(fmt)}, ${scale.asString(fmt)}]"
    override fun toString() = asString("{{ toStringFormat }}")

    @JvmName("mul")
    inline operator fun times(t: {{ T }}Affine3): {{ T }}Affine3 {
        val scale = this.scale * t.scale
        val rotation = this.rotation * t.rotation
        val translation = (this.rotation * (t.translation * this.scale)) + this.translation
        return {{ T }}Affine3(translation, rotation, scale)
    }

    @JvmName("transform")
    inline operator fun times(v: {{ T }}Vec3) = (rotation * (v * scale)) + translation
}

inline fun inverse(t: {{ T }}Affine3): {{ T }}Affine3 {
    val scaleInv = {{ one }} / t.scale
    val rotInv = inverse(t.rotation)
    return {{ T }}Affine3((rotInv * -t.translation) * scaleInv, rotInv, scaleInv)
}
