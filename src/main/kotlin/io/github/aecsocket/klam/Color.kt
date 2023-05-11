package io.github.aecsocket.klam

//typealias RGB = IVec3
//typealias RGBA = IVec4
//
////    RR GG BB AA
//// 0x ff ff ff ff
//fun asRGBA(v: RGBA) = ((v.r and 0xff) shl 24) or
//        ((v.g and 0xff) shl 16) or
//        ((v.b and 0xff) shl 8) or
//        ((v.a and 0xff) shl 0)
//
//fun fromRGBA(i: Int) = RGBA(
//    (i shr 24) and 0xff,
//    (i shr 16) and 0xff,
//    (i shr 8) and 0xff,
//    (i shr 0) and 0xff,
//)
//
////    AA RR GG BB
//// 0x ff ff ff ff
//fun asARGB(v: RGBA) = ((v.a and 0xff) shl 24) or
//        ((v.r and 0xff) shl 16) or
//        ((v.g and 0xff) shl 8) or
//        ((v.b and 0xff) shl 0)
//
//fun fromARGB(i: Int) = RGBA(
//    (i shr 16) and 0xff,
//    (i shr 8) and 0xff,
//    (i shr 0) and 0xff,
//    (i shr 24) and 0xff,
//)
