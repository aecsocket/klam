package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.BVec4
import io.github.aecsocket.klam.DVec4
import io.github.aecsocket.klam.FVec4
import io.github.aecsocket.klam.IVec4
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.serialize.SerializationException
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

abstract class Vec4Serializer<V, E> : TypeSerializer<V> {
    protected abstract fun V.component(idx: Int): E
    protected abstract fun element(node: ConfigurationNode): E
    protected abstract fun vectorOf(x: E, y: E, z: E, w: E): V
    protected abstract fun vectorOf(s: E): V

    override fun serialize(type: Type, obj: V?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.appendListNode().set(obj.component(0))
            node.appendListNode().set(obj.component(1))
            node.appendListNode().set(obj.component(2))
            node.appendListNode().set(obj.component(3))
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): V {
        return if (node.isList) {
            val list = node.childrenList()
            if (list.size != 4)
                throw SerializationException(node, type, "$EXPECTED_LIST_OF [x, y, z, w]")
            vectorOf(element(list[0]), element(list[1]), element(list[2]), element(list[3]))
        } else {
            @Suppress("UNCHECKED_CAST")
            val num = node.raw() as? E
                ?: throw SerializationException(node, type, EXPECTED_SCALAR)
            vectorOf(num)
        }
    }
}

object BVec4Serializer : Vec4Serializer<BVec4, Boolean>() {
    override fun BVec4.component(idx: Int) = get(idx)
    override fun element(node: ConfigurationNode) = node.boolean
    override fun vectorOf(x: Boolean, y: Boolean, z: Boolean, w: Boolean) = BVec4(x, y, z, w)
    override fun vectorOf(s: Boolean) = BVec4(s)
}

object IVec4Serializer : Vec4Serializer<IVec4, Int>() {
    override fun IVec4.component(idx: Int) = get(idx)
    override fun element(node: ConfigurationNode) = node.int
    override fun vectorOf(x: Int, y: Int, z: Int, w: Int) = IVec4(x, y, z, w)
    override fun vectorOf(s: Int) = IVec4(s)
}

object FVec4Serializer : Vec4Serializer<FVec4, Float>() {
    override fun FVec4.component(idx: Int) = get(idx)
    override fun element(node: ConfigurationNode) = node.float
    override fun vectorOf(x: Float, y: Float, z: Float, w: Float) = FVec4(x, y, z, w)
    override fun vectorOf(s: Float) = FVec4(s)
}

object DVec4Serializer : Vec4Serializer<DVec4, Double>() {
    override fun DVec4.component(idx: Int) = get(idx)
    override fun element(node: ConfigurationNode) = node.double
    override fun vectorOf(x: Double, y: Double, z: Double, w: Double) = DVec4(x, y, z, w)
    override fun vectorOf(s: Double) = DVec4(s)
}
