package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.*
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.kotlin.extensions.get
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

private const val TRANSLATION = "translation"
private const val ROTATION = "rotation"

object {{ T }}Iso3Serializer : TypeSerializer<{{ T }}Iso3> {
    override fun serialize(type: Type, obj: {{ T }}Iso3?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.node(TRANSLATION).set(obj.translation)
            node.node(ROTATION).set(obj.rotation)
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): {{ T }}Iso3 {
        return {{ T }}Iso3(
            translation = node.node(TRANSLATION).get { {{ T }}Vec3.Zero },
            rotation = node.node(ROTATION).get { {{ T }}Quat.Identity },
        )
    }
}