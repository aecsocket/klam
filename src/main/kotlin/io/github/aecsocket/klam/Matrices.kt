@file:Suppress("NOTHING_TO_INLINE", "MemberVisibilityCanBePrivate", "unused", "SpellCheckingInspection")

package io.github.aecsocket.klam

inline fun transpose(m: FMat2) = FMat2(
    m[0, 0], m[0, 1],
    m[1, 0], m[1, 1],
)
inline fun transpose(m: FMat3) = FMat3(
    m[0, 0], m[0, 1], m[0, 2],
    m[1, 0], m[1, 1], m[1, 2],
    m[2, 0], m[2, 1], m[2, 2],
)

inline fun determinant(m: FMat2) =
    m[0, 0] * m[1, 1] -
    m[1, 0] * m[0, 1]
inline fun determinant(m: FMat3) =
    m[0, 0] * (m[1, 1] * m[2, 2] - m[2, 1] * m[1, 2]) -
    m[1, 0] * (m[0, 1] * m[2, 2] - m[2, 1] * m[0, 2]) +
    m[2, 0] * (m[0, 1] * m[1, 2] - m[1, 1] * m[0, 2])

inline fun inverse(m: FMat2) = FMat2(
     m[1, 1], -m[0, 1],
    -m[1, 0],  m[0, 0],
) * (1 / determinant(m))
inline fun inverse(m: FMat3) = FMat3(
     (m[1, 1] * m[2, 2] - m[2, 1] * m[1, 2]), -(m[1, 0] * m[2, 2] - m[2, 0] * m[1, 2]),  (m[1, 0] * m[2, 1] - m[2, 0] * m[1, 1]),
    -(m[0, 1] * m[2, 2] - m[2, 1] * m[0, 2]),  (m[0, 0] * m[2, 2] - m[2, 0] * m[0, 2]), -(m[0, 0] * m[2, 1] - m[2, 0] * m[0, 1]),
     (m[0, 1] * m[1, 2] - m[1, 1] * m[0, 2]), -(m[0, 0] * m[1, 2] - m[1, 0] * m[0, 2]),  (m[0, 0] * m[1, 1] - m[1, 0] * m[0, 1]),
) * (1 / determinant(m))
