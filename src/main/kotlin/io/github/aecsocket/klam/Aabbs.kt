@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

inline fun overlaps(b: FAabb2, v: FVec2) = all(v ge b.min) && all(v le b.max)
inline fun overlaps(b: FAabb3, v: FVec3) = all(v ge b.min) && all(v le b.max)
inline fun overlaps(b: FAabb4, v: FVec4) = all(v ge b.min) && all(v le b.max)

inline fun overlaps(b: DAabb2, v: DVec2) = all(v ge b.min) && all(v le b.max)
inline fun overlaps(b: DAabb3, v: DVec3) = all(v ge b.min) && all(v le b.max)
inline fun overlaps(b: DAabb4, v: DVec4) = all(v ge b.min) && all(v le b.max)

inline fun extend(a: FAabb2, b: FAabb2) = FAabb2(min(a.min, b.min), max(a.max, b.max))
inline fun extend(a: FAabb3, b: FAabb3) = FAabb3(min(a.min, b.min), max(a.max, b.max))
inline fun extend(a: FAabb4, b: FAabb4) = FAabb4(min(a.min, b.min), max(a.max, b.max))

inline fun extend(a: DAabb2, b: DAabb2) = DAabb2(min(a.min, b.min), max(a.max, b.max))
inline fun extend(a: DAabb3, b: DAabb3) = DAabb3(min(a.min, b.min), max(a.max, b.max))
inline fun extend(a: DAabb4, b: DAabb4) = DAabb4(min(a.min, b.min), max(a.max, b.max))
