@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

internal typealias USize = Int
internal const val DECIMAL_FORMAT = "%.3f"

const val DPI = kotlin.math.PI
const val FPI = DPI.toFloat()

inline fun sqr(x: Float) = x * x
inline fun sqr(x: Double) = x * x

inline fun degrees(x: Float) = x * (180.0f / FPI)
inline fun degrees(x: Double) = x * (180.0 / DPI)

inline fun radians(x: Float) = x * (FPI / 180.0f)
inline fun radians(x: Double) = x * (DPI / 180.0)

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
