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

    .registerExact(BMat2Serializer)
    .registerExact(IMat2Serializer)
    .registerExact(LMat2Serializer)
    .registerExact(FMat2Serializer)
    .registerExact(DMat2Serializer)

    .registerExact(BMat3Serializer)
    .registerExact(IMat3Serializer)
    .registerExact(LMat3Serializer)
    .registerExact(FMat3Serializer)
    .registerExact(DMat3Serializer)

    .registerExact(BMat4Serializer)
    .registerExact(IMat4Serializer)
    .registerExact(LMat4Serializer)
    .registerExact(FMat4Serializer)
    .registerExact(DMat4Serializer)

    .registerExact(FQuatSerializer)
    .registerExact(DQuatSerializer)

    .registerExact(FAabb2Serializer)
    .registerExact(DAabb2Serializer)

    .registerExact(FAabb3Serializer)
    .registerExact(DAabb3Serializer)

    .registerExact(FAabb4Serializer)
    .registerExact(DAabb4Serializer)

    .registerExact(FIso3Serializer)
    .registerExact(DIso3Serializer)

    .registerExact(FAffine3Serializer)
    .registerExact(DAffine3Serializer)
    .build()
