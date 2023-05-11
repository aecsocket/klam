package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.*
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.serialize.SerializationException
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

object {{ T }}Vec3Serializer : TypeSerializer<{{ T }}Vec3> {
    override fun serialize(type: Type, obj: {{ T }}Vec3?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.appendListNode().set(obj.x)
            node.appendListNode().set(obj.y)
            node.appendListNode().set(obj.z)
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): {{ T }}Vec3 {
        return if (node.isList) {
            val list = node.childrenList()
            if (list.size != 3)
                throw SerializationException(node, type, "$EXPECTED_LIST_OF [x, y, z]")
            {{ T }}Vec3(
                list[0].force<{{ Type }}>(),
                list[1].force<{{ Type }}>(),
                list[2].force<{{ Type }}>(),
            )
        } else {
            val num = node.raw() as? {{ Type }} ?: throw SerializationException(node, type, EXPECTED_SCALAR)
            {{ T }}Vec3(num)
        }
    }
}
