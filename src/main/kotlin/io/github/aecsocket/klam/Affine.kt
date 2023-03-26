@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

inline fun inverse(t: DAffine3): DAffine3 {
    val rotInv = inverse(t.rotation)
    return DAffine3(rotInv * -t.position, rotInv)
}
