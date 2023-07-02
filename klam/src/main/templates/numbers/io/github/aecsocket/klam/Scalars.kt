@file:Suppress("NOTHING_TO_INLINE")

package io.github.aecsocket.klam

inline fun sqr(s: {{ Type }}) = s * s

inline fun clamp(s: {{ Type }}, min: {{ Type }}, max: {{ Type }}) = kotlin.math.min(max, kotlin.math.max(min, s))

inline fun clamp01(s: {{ Type }}) = clamp(s, {{ zero }}, {{ one }})
