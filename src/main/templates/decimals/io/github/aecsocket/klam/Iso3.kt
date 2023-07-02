@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Iso3(
    @JvmField val translation: {{ T }}Vec3,
    @JvmField val rotation: {{ T }}Quat,
) {
    companion object {
        val identity = {{ T }}Iso3(
            translation = {{ T }}Vec3.zero,
            rotation = {{ T }}Quat.identity,
        )
    }

{% for cast in decimalCasts %}
    fun {{ cast.fn }} = {{ cast.T }}Iso3(translation.{{ cast.fn }}, rotation.{{ cast.fn }})

{% endfor %}
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
