package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.*
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.kotlin.extensions.get
import org.spongepowered.configurate.serialize.SerializationException
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

private const val EXPECTED_LIST_QUAT = "$EXPECTED_LIST_OF [x, y, z, w] or [order, x, y, z]"

object {{ T }}QuatSerializer : TypeSerializer<{{ T }}Quat> {
    override fun serialize(type: Type, obj: {{ T }}Quat?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.appendListNode().set(obj.x)
            node.appendListNode().set(obj.y)
            node.appendListNode().set(obj.z)
            node.appendListNode().set(obj.w)
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): {{ T }}Quat {
        if (!node.isList)
            throw SerializationException(node, type, EXPECTED_LIST_QUAT)
        val list = node.childrenList()
        if (list.size != 4)
            throw SerializationException(node, type, EXPECTED_LIST_QUAT)
        return when (list[0].raw()) {
            is String -> {
                val order = list[0].get<EulerOrder>()
                    ?: throw SerializationException(list[0], type, "Expected Euler order; one of ${EulerOrder.values()}")
                asQuat({{ T }}Vec3(
                    list[1].force<{{ Type }}>(),
                    list[2].force<{{ Type }}>(),
                    list[3].force<{{ Type }}>(),
                ), order)
            }
            is Number -> {{ T }}Quat(
                list[0].force<{{ Type }}>(),
                list[1].force<{{ Type }}>(),
                list[2].force<{{ Type }}>(),
                list[3].force<{{ Type }}>(),
            )
            else -> throw SerializationException(list[0], type, EXPECTED_LIST_QUAT)
        }
    }
}
