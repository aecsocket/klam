package io.github.aecsocket.klam.configurate

import io.leangen.geantyref.TypeToken
import org.spongepowered.configurate.ConfigurationNode
import org.spongepowered.configurate.serialize.SerializationException
import org.spongepowered.configurate.serialize.TypeSerializer
import org.spongepowered.configurate.serialize.TypeSerializerCollection
import java.lang.reflect.Type
import kotlin.reflect.KClass

internal inline fun <reified T> typeToken() = object : TypeToken<T>() {}

internal fun ConfigurationNode.force(type: Type) = get(type)
    ?: throw SerializationException(this, type, "A value is required for this field")

internal fun <V : Any> ConfigurationNode.force(type: KClass<V>) = get(type.java)
    ?: throw SerializationException(this, type.java, "A value is required for this field")

internal fun <V : Any> ConfigurationNode.force(type: TypeToken<V>) = get(type)
    ?: throw SerializationException(this, type.type, "A value is required for this field")

internal inline fun <reified V : Any> ConfigurationNode.force() = force(typeToken<V>())

inline fun <reified T> TypeSerializerCollection.Builder.registerExact(serializer: TypeSerializer<T>): TypeSerializerCollection.Builder =
    registerExact(T::class.java, serializer)
