package io.github.aecsocket.klam

private typealias JRandom = java.util.Random
private typealias KRandom = kotlin.random.Random

// kotlin

fun KRandom.nextFVec2() = FVec2(nextFloat(), nextFloat())
fun KRandom.nextFVec3() = FVec3(nextFloat(), nextFloat(), nextFloat())
fun KRandom.nextFVec4() = FVec4(nextFloat(), nextFloat(), nextFloat(), nextFloat())

fun KRandom.nextDVec2() = DVec2(nextDouble(), nextDouble())
fun KRandom.nextDVec3() = DVec3(nextDouble(), nextDouble(), nextDouble())
fun KRandom.nextDVec4() = DVec4(nextDouble(), nextDouble(), nextDouble(), nextDouble())

fun KRandom.nextFQuat() = normalize(FQuat(nextFloat(), nextFloat(), nextFloat(), nextFloat()))
fun KRandom.nextDQuat() = normalize(DQuat(nextDouble(), nextDouble(), nextDouble(), nextDouble()))

// java

fun JRandom.nextFVec2() = FVec2(nextFloat(), nextFloat())
fun JRandom.nextFVec3() = FVec3(nextFloat(), nextFloat(), nextFloat())
fun JRandom.nextFVec4() = FVec4(nextFloat(), nextFloat(), nextFloat(), nextFloat())

fun JRandom.nextDVec2() = DVec2(nextDouble(), nextDouble())
fun JRandom.nextDVec3() = DVec3(nextDouble(), nextDouble(), nextDouble())
fun JRandom.nextDVec4() = DVec4(nextDouble(), nextDouble(), nextDouble(), nextDouble())

fun JRandom.nextFQuat() = normalize(FQuat(nextFloat(), nextFloat(), nextFloat(), nextFloat()))
fun JRandom.nextDQuat() = normalize(DQuat(nextDouble(), nextDouble(), nextDouble(), nextDouble()))

