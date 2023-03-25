package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.BVec2
import io.github.aecsocket.klam.DVec2
import io.github.aecsocket.klam.FVec2
import io.github.aecsocket.klam.IVec2
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.serialize.SerializationException
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

abstract class Vec2Serializer<V, E> : TypeSerializer<V> {
    protected abstract fun V.component(idx: Int): E
    protected abstract fun element(node: ConfigurationNode): E
    protected abstract fun vectorOf(x: E, y: E): V
    protected abstract fun vectorOf(s: E): V

    override fun serialize(type: Type, obj: V?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.appendListNode().set(obj.component(0))
            node.appendListNode().set(obj.component(1))
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): V {
        return if (node.isList) {
            val list = node.childrenList()
            if (list.size != 2)
                throw SerializationException(node, type, "$EXPECTED_LIST_OF [x, y]")
            vectorOf(element(list[0]), element(list[1]))
        } else {
            @Suppress("UNCHECKED_CAST")
            val num = node.raw() as? E
                ?: throw SerializationException(node, type, EXPECTED_SCALAR)
            vectorOf(num)
        }
    }
}

object BVec2Serializer : Vec2Serializer<BVec2, Boolean>() {
    override fun BVec2.component(idx: Int) = get(idx)
    override fun element(node: ConfigurationNode) = node.boolean
    override fun vectorOf(x: Boolean, y: Boolean) = BVec2(x, y)
    override fun vectorOf(s: Boolean) = BVec2(s)
}

object IVec2Serializer : Vec2Serializer<IVec2, Int>() {
    override fun IVec2.component(idx: Int) = get(idx)
    override fun element(node: ConfigurationNode) = node.int
    override fun vectorOf(x: Int, y: Int) = IVec2(x, y)
    override fun vectorOf(s: Int) = IVec2(s)
}

object FVec2Serializer : Vec2Serializer<FVec2, Float>() {
    override fun FVec2.component(idx: Int) = get(idx)
    override fun element(node: ConfigurationNode) = node.float
    override fun vectorOf(x: Float, y: Float) = FVec2(x, y)
    override fun vectorOf(s: Float) = FVec2(s)
}

object DVec2Serializer : Vec2Serializer<DVec2, Double>() {
    override fun DVec2.component(idx: Int) = get(idx)
    override fun element(node: ConfigurationNode) = node.double
    override fun vectorOf(x: Double, y: Double) = DVec2(x, y)
    override fun vectorOf(s: Double) = DVec2(s)
}
