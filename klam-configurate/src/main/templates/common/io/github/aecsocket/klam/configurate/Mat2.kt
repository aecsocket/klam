package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.*
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.serialize.SerializationException
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

object {{ T }}Mat2Serializer : TypeSerializer<{{ T }}Mat2> {
    override fun serialize(type: Type, obj: {{ T }}Mat2?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.appendListNode().set(obj.x.x)
            node.appendListNode().set(obj.y.x)

            node.appendListNode().set(obj.x.y)
            node.appendListNode().set(obj.y.y)
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): {{ T }}Mat2 {
        if (!node.isList)
            throw SerializationException(node, type, "Expected list of 2 column vectors, or 4 row-major scalars")
        val list = node.childrenList()
        return when (list.size) {
            2 -> {
                // list of column vectors
                {{ T }}Mat2(
                    list[0].force(),
                    list[1].force(),
                )
            }
            4 -> {
                // list of row-major scalars
                {{ T }}Mat2(
                    list[0].force(), list[1].force(),
                    list[2].force(), list[3].force(),
                )
            }
            else -> throw SerializationException(node, type, "Expected list of 2 column vectors, or 4 row-major scalars")
        }
    }
}
