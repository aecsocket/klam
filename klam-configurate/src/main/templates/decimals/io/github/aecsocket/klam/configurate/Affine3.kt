package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.*
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.kotlin.extensions.get
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

private const val POSITION = "position"
private const val ROTATION = "rotation"
private const val SCALE = "scale"

object {{ T }}Affine3Serializer : TypeSerializer<{{ T }}Affine3> {
    override fun serialize(type: Type, obj: {{ T }}Affine3?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.node(POSITION).set(obj.position)
            node.node(ROTATION).set(obj.rotation)
            node.node(SCALE).set(obj.scale)
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): {{ T }}Affine3 {
        return {{ T }}Affine3(
            node.node(POSITION).get { {{ T }}Vec3.Zero },
            node.node(ROTATION).get { {{ T }}Quat.Identity },
            node.node(SCALE).get { {{ T }}Vec3.One },
        )
    }
}
