package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.*
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

private const val MIN = "min"
private const val MAX = "max"

object {{ T }}Aabb2Serializer : TypeSerializer<{{ T }}Aabb2> {
    override fun serialize(type: Type, obj: {{ T }}Aabb2?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.node(MIN).set(obj.min)
            node.node(MAX).set(obj.max)
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): {{ T }}Aabb2 {
        return {{ T }}Aabb2(
            min = node.node(MIN).force<{{ T }}Vec2>(),
            max = node.node(MAX).force<{{ T }}Vec2>(),
        )
    }
}
