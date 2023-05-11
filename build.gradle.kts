import org.gradle.plugins.ide.idea.model.IdeaModel
import templating.*

plugins {
    id("parent-conventions")
    id("kotlin-conventions")
    id("publishing-conventions")
    id("idea")
    alias(libs.plugins.jmh)
}

group = "io.github.aecsocket"
version = "0.2.0-SNAPSHOT"
description = "Linear algebra library for 2D/3D applications"

// needed so `sourcesJar` doesn't fail (it's stupid)
tasks {
    sourcesJar {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
}

data class TemplateSet(
    val name: String,
    val types: List<TypeVariant>,
)

val templateSets = listOf(
    TemplateSet(
        name = "common",
        types = listOf(
            TypeVariants.Boolean,
            TypeVariants.Int,
            TypeVariants.Long,
            TypeVariants.Float,
            TypeVariants.Double,
        ),
    ),
    TemplateSet(
        name = "numbers",
        types = listOf(
            TypeVariants.Int,
            TypeVariants.Long,
            TypeVariants.Float,
            TypeVariants.Double,
        ),
    ),
    TemplateSet(
        name = "decimals",
        types = listOf(
            TypeVariants.Float,
            TypeVariants.Double,
        ),
    ),
)

// for IDE autocompletion
extensions.configure<IdeaModel> {
    module {
        sourceSets.forEach { sourceSet ->
            templateSets.forEach { templateSet ->
                val file = projectDir.resolve("src/${sourceSet.name}/templates/${templateSet.name}")
                if (file.exists()) {
                    sourceDirs.add(file)
                }
            }
        }
    }
}

val realFields = listOf("x", "y", "z", "w")
val proxyFields = listOf(
    listOf("r", "g", "b", "a"),
    listOf("s", "t", "p", "q"),
)
val accessorFields = listOf(realFields) + proxyFields

sourceSets.forEach { sourceSet ->
    val generateTasks = templateSets.flatMap { templateSet ->
        val source = projectDir.resolve("src/${sourceSet.name}/templates/${templateSet.name}")
        if (!source.exists()) return@flatMap emptyList()
        val output = buildDir.resolve("generated/sources/${sourceSet.name}-templates-${templateSet.name}")

        templateSet.types.map { variant ->
            val taskName = sourceSet.getTaskName("generate", "${templateSet.name}${variant.name}Templates")
            val generateTask = tasks.register<GenerateTemplates>(taskName) {
                sourceDir.set(source)
                outputDir.set(output)
                fileNamePrefix.set(variant.code)
                context.putAll(variant.context() + alternateAccessors(variant) + swizzles(variant))
            }

            // this line causes task `sourcesJar` to have duplicates
            // considering there are literally no duplicated files, idk why this happens
            sourceSet.java.srcDir(generateTask.map { it.outputs })
            generateTask.get()
        }
    }
}

@OptIn(ExperimentalStdlibApi::class)
fun alternateAccessors(variant: TypeVariant): Map<String, String> {
    return (2..4).map { size ->
        "vecAlternateAccessors$size" to proxyFields.joinToString("\n") { fieldSet ->
            (0..<size).joinToString("\n") { fieldIdx ->
                val realField = realFields[fieldIdx]
                val proxyField = fieldSet[fieldIdx]
                "inline val ${variant.code}Vec${size}.$proxyField get() = $realField"
            } + "\n"
        }
    }.associate { it }
}

@OptIn(ExperimentalStdlibApi::class)
fun swizzles(variant: TypeVariant): Map<String, String> {
    fun swizzle(vararg fields: String): String {
        val size = fields.size
        val swizzle = listOf(*fields)
        val swizzleField = swizzle.joinToString("")
        val swizzleArgs = swizzle.joinToString(", ")
        return "inline val ${variant.code}Vec${size}.${swizzleField} get() = ${variant.code}Vec${size}(${swizzleArgs})"
    }

    return mapOf(
        "vecSwizzles2" to accessorFields.joinToString("\n\n") { fields ->
            (0..<2).flatMap { i ->
                (0..<2).map { j ->
                    swizzle(fields[i], fields[j])
                }
            }.joinToString("\n")
        } + "\n",

        "vecSwizzles3" to accessorFields.joinToString("\n\n") { fields ->
            (0..<3).flatMap { i ->
                (0..<3).flatMap { j ->
                    (0..<3).map { k ->
                        swizzle(fields[i], fields[j], fields[k])
                    }
                }
            }.joinToString("\n")
        } + "\n",

        "vecSwizzles4" to accessorFields.joinToString("\n\n") { fields ->
            (0..<4).flatMap { i ->
                (0..<4).flatMap { j ->
                    (0..<4).flatMap { k ->
                        (0..<4).map { l ->
                            swizzle(fields[i], fields[j], fields[k], fields[l])
                        }
                    }
                }
            }.joinToString("\n")
        } + "\n",
    )
}
