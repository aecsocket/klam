package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.*
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.serialize.SerializationException
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

object {{ T }}Vec4Serializer : TypeSerializer<{{ T }}Vec4> {
    override fun serialize(type: Type, obj: {{ T }}Vec4?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.appendListNode().set(obj.x)
            node.appendListNode().set(obj.y)
            node.appendListNode().set(obj.z)
            node.appendListNode().set(obj.w)
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): {{ T }}Vec4 {
        return if (node.isList) {
            val list = node.childrenList()
            if (list.size != 4)
                throw SerializationException(node, type, "$EXPECTED_LIST_OF [x, y, z, w]")
            {{ T }}Vec4(
                list[0].force<{{ Type }}>(),
                list[1].force<{{ Type }}>(),
                list[2].force<{{ Type }}>(),
                list[3].force<{{ Type }}>(),
            )
        } else {
            val num = node.raw() as? {{ Type }} ?: throw SerializationException(node, type, EXPECTED_SCALAR)
            {{ T }}Vec4(num)
        }
    }
}
