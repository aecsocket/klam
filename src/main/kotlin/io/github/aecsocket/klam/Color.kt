package io.github.aecsocket.klam

typealias ARGB = IVec4
typealias RGBA = IVec4

//    RR GG BB AA
// 0x ff ff ff ff
fun rgbaToInt(v: RGBA) =
    ((v.r and 0xff) shl 24) or
    ((v.g and 0xff) shl 16) or
    ((v.b and 0xff) shl  8) or
    ((v.a and 0xff) shl  0)

fun intToRGBA(i: Int) = RGBA(
    (i shr 24) and 0xff,
    (i shr 16) and 0xff,
    (i shr  8) and 0xff,
    (i shr  0) and 0xff,
)

//    AA RR GG BB
// 0x ff ff ff ff
fun argbToInt(v: ARGB) =
    ((v.a and 0xff) shl 24) or
    ((v.r and 0xff) shl 16) or
    ((v.g and 0xff) shl  8) or
    ((v.b and 0xff) shl  0)

fun intToARGB(i: Int) = ARGB(
    (i shr 16) and 0xff,
    (i shr  8) and 0xff,
    (i shr  0) and 0xff,
    (i shr 24) and 0xff,
)
