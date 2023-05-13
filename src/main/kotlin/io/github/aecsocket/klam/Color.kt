package io.github.aecsocket.klam

//    RR GG BB AA
// 0x ff ff ff ff
fun asRGBA(v: IVec4) = ((v.r and 0xff) shl 24) or
        ((v.g and 0xff) shl 16) or
        ((v.b and 0xff) shl 8) or
        ((v.a and 0xff) shl 0)

fun fromRGBA(i: Int) = IVec4(
    (i shr 24) and 0xff,
    (i shr 16) and 0xff,
    (i shr 8) and 0xff,
    (i shr 0) and 0xff,
)

//    AA RR GG BB
// 0x ff ff ff ff
fun asARGB(v: IVec4) = ((v.a and 0xff) shl 24) or
        ((v.r and 0xff) shl 16) or
        ((v.g and 0xff) shl 8) or
        ((v.b and 0xff) shl 0)

fun fromARGB(i: Int) = IVec4(
    (i shr 16) and 0xff,
    (i shr 8) and 0xff,
    (i shr 0) and 0xff,
    (i shr 24) and 0xff,
)
