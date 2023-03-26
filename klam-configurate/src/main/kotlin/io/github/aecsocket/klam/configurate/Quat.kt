package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.*
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.kotlin.extensions.get
import org.spongepowered.configurate.serialize.SerializationException
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

private const val EXPECTED_LIST_QUAT = "$EXPECTED_LIST_OF [x, y, z, w] or [order, x, y, z]"

abstract class QuatSerializer<Q, E> : TypeSerializer<Q> {
    protected abstract fun Q.component(idx: Int): E
    protected abstract fun element(node: ConfigurationNode): E
    protected abstract fun quatOf(x: E, y: E, z: E, w: E): Q

    override fun serialize(type: Type, obj: Q?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.appendListNode().set(obj.component(0))
            node.appendListNode().set(obj.component(1))
            node.appendListNode().set(obj.component(2))
            node.appendListNode().set(obj.component(3))
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): Q {
        if (!node.isList)
            throw SerializationException(node, type, EXPECTED_LIST_QUAT)
        val list = node.childrenList()
        if (list.size != 4)
            throw SerializationException(node, type, EXPECTED_LIST_QUAT)
        return when (list[0].raw()) {
            is String -> {
                val order = list[0].get<EulerOrder>()
                    ?: throw SerializationException(list[0], type, "Expected Euler order; one of ${EulerOrder.values()}")
                TODO()
            }
            is Number -> quatOf(element(list[0]), element(list[1]), element(list[2]), element(list[3]))
            else -> throw SerializationException(list[0], type, EXPECTED_LIST_QUAT)
        }
    }
}

object FQuatSerializer : QuatSerializer<FQuat, Float>() {
    override fun FQuat.component(idx: Int) = get(idx)
    override fun element(node: ConfigurationNode) = node.float
    override fun quatOf(x: Float, y: Float, z: Float, w: Float) = FQuat(x, y, z, w)
}

object DQuatSerializer : QuatSerializer<DQuat, Double>() {
    override fun DQuat.component(idx: Int) = get(idx)
    override fun element(node: ConfigurationNode) = node.double
    override fun quatOf(x: Double, y: Double, z: Double, w: Double) = DQuat(x, y, z, w)
}
