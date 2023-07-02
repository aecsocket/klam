@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

data class {{ T }}Ray2(
    @JvmField val origin: {{ T }}Vec2,
    @JvmField val direction: {{ T }}Vec2,
) {
    fun at(t: {{ Type }}) = origin + direction * t

{% for cast in decimalCasts %}
    fun {{ cast.fn }} = {{ cast.T }}Ray2(origin.{{ cast.fn }}, direction.{{ cast.fn }})

{% endfor %}
    fun asString(fmt: String) = "[${origin.asString(fmt)} -> ${direction.asString(fmt)}]"
    override fun toString() = asString("{{ toStringFormat }}")
}
