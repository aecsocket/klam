@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

const val PI_{{ T }} = {{ pi }}

inline fun {{ Type }}.equalTo(s: {{ Type }}, delta: {{ Type }}) = kotlin.math.abs(this - s) < delta

inline fun mix(a: {{ Type }}, b: {{ Type }}, f: {{ Type }}) = a + f * (b - a)

inline fun degrees(s: {{ Type }}) = s * ({{ oneEighty }} / PI_{{ T }})

inline fun radians(s: {{ Type }}) = s * (PI_{{ T }} / {{ oneEighty }})
