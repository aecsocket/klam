package io.github.aecsocket.klam.configurate

import org.spongepowered.configurate.serialize.TypeSerializerCollection

internal const val EXPECTED_LIST_OF = "Expected list of"
internal const val EXPECTED_SCALAR = "Expected scalar"

val klamSerializers: TypeSerializerCollection = TypeSerializerCollection.builder()
    .registerExact(BVec2Serializer)
    .registerExact(IVec2Serializer)
    .registerExact(LVec2Serializer)
    .registerExact(FVec2Serializer)
    .registerExact(DVec2Serializer)

    .registerExact(BVec3Serializer)
    .registerExact(IVec3Serializer)
    .registerExact(LVec3Serializer)
    .registerExact(FVec3Serializer)
    .registerExact(DVec3Serializer)

    .registerExact(BVec4Serializer)
    .registerExact(IVec4Serializer)
    .registerExact(LVec4Serializer)
    .registerExact(FVec4Serializer)
    .registerExact(DVec4Serializer)

    .registerExact(FQuatSerializer)
    .registerExact(DQuatSerializer)

    .registerExact(FAffine3Serializer)
    .registerExact(DAffine3Serializer)
    .build()
