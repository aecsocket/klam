package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.*
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.serialize.SerializationException
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

object {{ T }}Mat3Serializer : TypeSerializer<{{ T }}Mat3> {
    override fun serialize(type: Type, obj: {{ T }}Mat3?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.appendListNode().set(obj.x.x)
            node.appendListNode().set(obj.y.x)
            node.appendListNode().set(obj.z.x)

            node.appendListNode().set(obj.x.y)
            node.appendListNode().set(obj.y.y)
            node.appendListNode().set(obj.z.y)

            node.appendListNode().set(obj.x.z)
            node.appendListNode().set(obj.y.z)
            node.appendListNode().set(obj.z.z)
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): {{ T }}Mat3 {
        if (!node.isList)
            throw SerializationException(node, type, "Expected list of 3 column vectors, or 9 row-major scalars")
        val list = node.childrenList()
        return when (list.size) {
            3 -> {
                // list of column vectors
                {{ T }}Mat3(
                    list[0].force(),
                    list[1].force(),
                    list[2].force(),
                )
            }
            9 -> {
                // list of row-major scalars
                {{ T }}Mat3(
                    list[0].force(), list[1].force(), list[2].force(),
                    list[3].force(), list[4].force(), list[5].force(),
                    list[6].force(), list[7].force(), list[8].force(),
                )
            }
            else -> throw SerializationException(node, type, "Expected list of 3 column vectors, or 9 row-major scalars")
        }
    }
}
