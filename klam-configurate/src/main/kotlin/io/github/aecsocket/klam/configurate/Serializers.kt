package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.*
import org.spongepowered.configurate.serialize.TypeSerializerCollection

internal const val EXPECTED_LIST_OF = "Expected list of"
internal const val EXPECTED_SCALAR = "Expected scalar"

val klamSerializers = TypeSerializerCollection.builder()
    .registerExact(BVec2::class.java, BVec2Serializer)
    .registerExact(IVec2::class.java, IVec2Serializer)
    .registerExact(FVec2::class.java, FVec2Serializer)
    .registerExact(DVec2::class.java, DVec2Serializer)

    .registerExact(BVec3::class.java, BVec3Serializer)
    .registerExact(IVec3::class.java, IVec3Serializer)
    .registerExact(FVec3::class.java, FVec3Serializer)
    .registerExact(DVec3::class.java, DVec3Serializer)

    .registerExact(BVec4::class.java, BVec4Serializer)
    .registerExact(IVec4::class.java, IVec4Serializer)
    .registerExact(FVec4::class.java, FVec4Serializer)
    .registerExact(DVec4::class.java, DVec4Serializer)

    .registerExact(Quat::class.java, QuatSerializer)
    .build()
