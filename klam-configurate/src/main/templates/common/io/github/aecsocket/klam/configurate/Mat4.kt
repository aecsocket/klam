package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.*
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.serialize.SerializationException
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

object {{ T }}Mat4Serializer : TypeSerializer<{{ T }}Mat4> {
    override fun serialize(type: Type, obj: {{ T }}Mat4?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.appendListNode().set(obj.x.x)
            node.appendListNode().set(obj.y.x)
            node.appendListNode().set(obj.z.x)
            node.appendListNode().set(obj.w.x)

            node.appendListNode().set(obj.x.y)
            node.appendListNode().set(obj.y.y)
            node.appendListNode().set(obj.z.y)
            node.appendListNode().set(obj.w.y)

            node.appendListNode().set(obj.x.z)
            node.appendListNode().set(obj.y.z)
            node.appendListNode().set(obj.z.z)
            node.appendListNode().set(obj.w.z)

            node.appendListNode().set(obj.x.w)
            node.appendListNode().set(obj.y.w)
            node.appendListNode().set(obj.z.w)
            node.appendListNode().set(obj.w.w)
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): {{ T }}Mat4 {
        if (!node.isList)
            throw SerializationException(node, type, "Expected list of 4 column vectors, or 16 row-major scalars")
        val list = node.childrenList()
        return when (list.size) {
            4 -> {
                // list of column vectors
                {{ T }}Mat4(
                    list[0].force(),
                    list[1].force(),
                    list[2].force(),
                    list[3].force(),
                )
            }
            16 -> {
                // list of row-major scalars
                {{ T }}Mat4(
                    list[ 0].force(), list[ 1].force(), list[ 2].force(), list[ 3].force(),
                    list[ 4].force(), list[ 5].force(), list[ 6].force(), list[ 7].force(),
                    list[ 8].force(), list[ 9].force(), list[10].force(), list[11].force(),
                    list[12].force(), list[13].force(), list[14].force(), list[15].force(),
                )
            }
            else -> throw SerializationException(node, type, "Expected list of 4 column vectors, or 16 row-major scalars")
        }
    }
}
