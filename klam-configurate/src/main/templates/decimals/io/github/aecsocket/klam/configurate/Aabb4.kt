package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.*
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

private const val MIN = "min"
private const val MAX = "max"

object {{ T }}Aabb4Serializer : TypeSerializer<{{ T }}Aabb4> {
    override fun serialize(type: Type, obj: {{ T }}Aabb4?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.node(MIN).set(obj.min)
            node.node(MAX).set(obj.max)
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): {{ T }}Aabb4 {
        return {{ T }}Aabb4(
            min = node.node(MIN).force<{{ T }}Vec4>(),
            max = node.node(MAX).force<{{ T }}Vec4>(),
        )
    }
}
