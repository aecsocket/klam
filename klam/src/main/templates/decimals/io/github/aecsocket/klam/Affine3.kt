@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Affine3(
    @JvmField val translation: {{ T }}Vec3,
    @JvmField val rotation: {{ T }}Quat,
    @JvmField val scale: {{ T }}Vec3,
) {
    companion object {
        val identity = {{ T }}Affine3(
            translation = {{ T }}Vec3.zero,
            rotation = {{ T }}Quat.identity,
            scale = {{ T }}Vec3.{{ oneField }},
        )
    }

    constructor(iso: {{ T }}Iso3, scale: {{ T }}Vec3 = {{ T }}Vec3.zero) : this(iso.translation, iso.rotation, scale)

{% for cast in decimalCasts %}
    fun {{ cast.fn }} = {{ cast.T }}Affine3(translation.{{ cast.fn }}, rotation.{{ cast.fn }}, scale.{{ cast.fn }})

{% endfor %}
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
