package io.github.aecsocket.klam.configurate

import io.github.aecsocket.klam.FVec3
import org.spongepowered.configurate.ConfigurationOptions
import org.spongepowered.configurate.kotlin.extensions.get
import org.spongepowered.configurate.yaml.YamlConfigurationLoader
import kotlin.test.Test

class TestConfigurate {
    val configOptions = ConfigurationOptions.defaults()
        .serializers { serializers ->
            serializers.registerAll(klamSerializers)
        }

    @Test
    fun test() {
        val a = YamlConfigurationLoader.builder()
            .defaultOptions(configOptions)
            .buildAndLoadString("""
                vec: [ 1.5, 2.5, 3.5 ]
            """.trimIndent())
        println(a.node("vec").get<FVec3>())
    }
}
