@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

inline fun inverse(t: FAffine3): FAffine3 {
    val scaleInv = 1.0f / t.scale
    val rotInv = inverse(t.rotation)
    return FAffine3((rotInv * -t.position) * scaleInv, rotInv, scaleInv)
}
inline fun inverse(t: DAffine3): DAffine3 {
    val scaleInv = 1.0f / t.scale
    val rotInv = inverse(t.rotation)
    return DAffine3((rotInv * -t.position) * DVec3(scaleInv), rotInv, scaleInv)
}
