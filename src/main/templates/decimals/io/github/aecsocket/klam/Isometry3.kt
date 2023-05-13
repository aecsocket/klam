@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Isometry3(
    @JvmField val position: {{ T }}Vec3 = {{ T }}Vec3.{{ Zero }},
    @JvmField val rotation: {{ T }}Quat = {{ T }}Quat.Identity,
) {
    fun asString(fmt: String) = "[${position.asString(fmt)}, ${rotation.asString(fmt)}]"
    override fun toString() = asString("{{ toStringFormat }}")

    @JvmName("mul")
    inline operator fun times(t: {{ T }}Isometry3): {{ T }}Isometry3 {
        val rotation = this.rotation * t.rotation
        val position = (this.rotation * t.position) + this.position
        return {{ T }}Isometry3(position, rotation)
    }

    @JvmName("transform")
    inline operator fun times(v: {{ T }}Vec3) = (rotation * v) + position
}

inline fun inverse(t: {{ T }}Isometry3): {{ T }}Isometry3 {
    val rotInv = inverse(t.rotation)
    return {{ T }}Isometry3(rotInv * -t.position, rotInv)
}
