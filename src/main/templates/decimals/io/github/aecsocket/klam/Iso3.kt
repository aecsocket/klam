@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Iso3(
    @JvmField val translation: {{ T }}Vec3 = {{ T }}Vec3.{{ Zero }},
    @JvmField val rotation: {{ T }}Quat = {{ T }}Quat.Identity,
) {
    fun asString(fmt: String) = "[${translation.asString(fmt)}, ${rotation.asString(fmt)}]"
    override fun toString() = asString("{{ toStringFormat }}")

    @JvmName("mul")
    inline operator fun times(t: {{ T }}Iso3): {{ T }}Iso3 {
        val rotation = this.rotation * t.rotation
        val translation = (this.rotation * t.translation) + this.translation
        return {{ T }}Iso3(translation, rotation)
    }

    @JvmName("transform")
    inline operator fun times(v: {{ T }}Vec3) = (rotation * v) + translation
}

inline fun inverse(t: {{ T }}Iso3): {{ T }}Iso3 {
    val rotInv = inverse(t.rotation)
    return {{ T }}Iso3(rotInv * -t.translation, rotInv)
}