package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.*
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.kotlin.extensions.get
import org.spongepowered.configurate.serialize.SerializationException
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

private const val POSITION = "position"
private const val ROTATION = "rotation"
private const val SCALE = "scale"

object FAffine3Serializer : TypeSerializer<FAffine3> {
    override fun serialize(type: Type, obj: FAffine3?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.node(POSITION).set(obj.position)
            node.node(ROTATION).set(obj.rotation)
            node.node(SCALE).set(obj.scale)
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): FAffine3 {
        return FAffine3(
            node.node(POSITION).get { FVec3(0.0f) },
            node.node(ROTATION).get { FQuat.identity() },
            node.node(SCALE).get { FVec3(1.0f) },
        )
    }
}

object DAffine3Serializer : TypeSerializer<DAffine3> {
    override fun serialize(type: Type, obj: DAffine3?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.node(POSITION).set(obj.position)
            node.node(ROTATION).set(obj.rotation)
            node.node(SCALE).set(obj.scale)
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): DAffine3 {
        return DAffine3(
            node.node(POSITION).get { DVec3(0.0) },
            node.node(ROTATION).get { FQuat.identity() },
            node.node(SCALE).get { FVec3(1.0f) },
        )
    }
}
