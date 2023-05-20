package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.*
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.serialize.SerializationException
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

object {{ T }}Vec2Serializer : TypeSerializer<{{ T }}Vec2> {
    override fun serialize(type: Type, obj: {{ T }}Vec2?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.appendListNode().set(obj.x)
            node.appendListNode().set(obj.y)
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): {{ T }}Vec2 {
        if (!node.isList)
            throw SerializationException(node, type, "Expected list of [x, y]")
        val list = node.childrenList()
        return {{ T }}Vec2(
            list[0].force<{{ Type }}>(),
            list[1].force<{{ Type }}>(),
        )
    }
}
