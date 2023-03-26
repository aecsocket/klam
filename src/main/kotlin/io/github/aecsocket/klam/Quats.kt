@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

import kotlin.math.sqrt

inline fun lengthSq(q: FQuat) = sqr(q.x) + sqr(q.y) + sqr(q.z) + sqr(q.w)
inline fun lengthSq(q: DQuat) = sqr(q.x) + sqr(q.y) + sqr(q.z) + sqr(q.w)

inline fun length(q: FQuat) = sqrt(lengthSq(q))
inline fun length(q: DQuat) = sqrt(lengthSq(q))

inline fun normalize(q: FQuat): FQuat {
    val l = 1.0f / length(q)
    return FQuat(q.x * l, q.y * l, q.z * l, q.w * l)
}
inline fun normalize(q: DQuat): DQuat {
    val l = 1.0 / length(q)
    return DQuat(q.x * l, q.y * l, q.z * l, q.w * l)
}

inline fun inverse(q: FQuat) = FQuat(-q.x, -q.y, -q.z, q.w)
inline fun inverse(q: DQuat) = DQuat(-q.x, -q.y, -q.z, q.w)
