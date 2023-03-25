package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.BVec3
import io.github.aecsocket.klam.DVec3
import io.github.aecsocket.klam.FVec3
import io.github.aecsocket.klam.IVec3
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.serialize.SerializationException
import org.spongepowered.configurate.serialize.TypeSerializer
import java.lang.reflect.Type

abstract class Vec3Serializer<V, E> : TypeSerializer<V> {
    protected abstract fun V.component(idx: Int): E
    protected abstract fun element(node: ConfigurationNode): E
    protected abstract fun vectorOf(x: E, y: E, z: E): V
    protected abstract fun vectorOf(s: E): V

    override fun serialize(type: Type, obj: V?, node: ConfigurationNode) {
        if (obj == null) node.set(null)
        else {
            node.appendListNode().set(obj.component(0))
            node.appendListNode().set(obj.component(1))
            node.appendListNode().set(obj.component(2))
        }
    }

    override fun deserialize(type: Type, node: ConfigurationNode): V {
        return if (node.isList) {
            val list = node.childrenList()
            if (list.size != 3)
                throw SerializationException(node, type, "$EXPECTED_LIST_OF [x, y, z]")
            vectorOf(element(list[0]), element(list[1]), element(list[2]))
        } else {
            @Suppress("UNCHECKED_CAST")
            val num = node.raw() as? E
                ?: throw SerializationException(node, type, EXPECTED_SCALAR)
            vectorOf(num)
        }
    }
}

object BVec3Serializer : Vec3Serializer<BVec3, Boolean>() {
    override fun BVec3.component(idx: Int) = get(idx)
    override fun element(node: ConfigurationNode) = node.boolean
    override fun vectorOf(x: Boolean, y: Boolean, z: Boolean) = BVec3(x, y, z)
    override fun vectorOf(s: Boolean) = BVec3(s)
}

object IVec3Serializer : Vec3Serializer<IVec3, Int>() {
    override fun IVec3.component(idx: Int) = get(idx)
    override fun element(node: ConfigurationNode) = node.int
    override fun vectorOf(x: Int, y: Int, z: Int) = IVec3(x, y, z)
    override fun vectorOf(s: Int) = IVec3(s)
}

object FVec3Serializer : Vec3Serializer<FVec3, Float>() {
    override fun FVec3.component(idx: Int) = get(idx)
    override fun element(node: ConfigurationNode) = node.float
    override fun vectorOf(x: Float, y: Float, z: Float) = FVec3(x, y, z)
    override fun vectorOf(s: Float) = FVec3(s)
}

object DVec3Serializer : Vec3Serializer<DVec3, Double>() {
    override fun DVec3.component(idx: Int) = get(idx)
    override fun element(node: ConfigurationNode) = node.double
    override fun vectorOf(x: Double, y: Double, z: Double) = DVec3(x, y, z)
    override fun vectorOf(s: Double) = DVec3(s)
}
