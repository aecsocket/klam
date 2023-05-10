@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

internal const val DECIMAL_FORMAT = "%f"

const val PI_D = kotlin.math.PI
const val PI_F = PI_D.toFloat()

const val EPSILON_D     = 0.000001
const val EPSILON_F     = 0.000001f
const val ONE_EPSILON_D = 0.999999
const val ONE_EPSILON_F = 0.999999f

inline fun sqr(x: Float) = x * x
inline fun sqr(x: Double) = x * x

inline fun degrees(x: Float) = x * (180.0f / PI_F)
inline fun degrees(x: Double) = x * (180.0 / PI_D)

inline fun radians(x: Float) = x * (PI_F / 180.0f)
inline fun radians(x: Double) = x * (PI_D / 180.0)

inline fun clamp(x: Int, min: Int, max: Int) = if (x < min) min else if (x > max) max else x
inline fun clamp(x: Long, min: Long, max: Long) = if (x < min) min else if (x > max) max else x
inline fun clamp(x: Float, min: Float, max: Float) = if (x < min) min else if (x > max) max else x
inline fun clamp(x: Double, min: Double, max: Double) = if (x < min) min else if (x > max) max else x

inline fun clamp01(x: Int) = clamp(x, 0, 1)
inline fun clamp01(x: Long) = clamp(x, 0, 1)
inline fun clamp01(x: Float) = clamp(x, 0.0f, 1.0f)
inline fun clamp01(x: Double) = clamp(x, 0.0, 1.0)

inline fun mix(a: Float, b: Float, f: Float) = a + f * (b - a)
inline fun mix(a: Double, b: Double, f: Double) = a + f * (b - a)
