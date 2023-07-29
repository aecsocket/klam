@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Ray3(
    @JvmField val origin: {{ T }}Vec3,
    @JvmField val direction: {{ T }}Vec3,
) {
    fun at(t: {{ Type }}) = origin + direction * t

    fun origin(origin: {{ T }}Vec3) = {{ T }}Ray3(origin, direction)
    fun direction(direction: {{ T }}Vec3) = {{ T }}Ray3(origin, direction)

{% for cast in decimalCasts %}
    fun {{ cast.fn }} = {{ cast.T }}Ray3(origin.{{ cast.fn }}, direction.{{ cast.fn }})

{% endfor %}
    fun asString(fmt: String) = "[${origin.asString(fmt)} -> ${direction.asString(fmt)}]"
    override fun toString() = asString("{{ toStringFormat }}")
}
