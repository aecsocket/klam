import org.gradle.plugins.ide.idea.model.IdeaModel
import templating.GenerateTemplates

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

// for IDE autocompletion
extensions.configure<IdeaModel> {
    module {
        sourceDirs.add(file("$projectDir/src/main/templates"))
    }
}

enum class TypeKind(val isNumber: Boolean) {
    BOOLEAN (false),
    INTEGER (true),
    DECIMAL (true),
}

data class TypeVariant(
    val name: String,
    val code: String,
    val kind: TypeKind,
    val zero: String,
    val one: String,
    val arrayOf: String,
    val toStringFormat: String,
    val zeroField: String = "Zero",
    val oneField: String = "One",
)

val realFields = listOf("x", "y", "z", "w")
val proxyFields = listOf(
    listOf("r", "g", "b", "a"),
    listOf("s", "t", "p", "q"),
)
val accessorFields = listOf(
    realFields
) + proxyFields

sourceSets.forEach { sourceSet ->
    val source = file("$projectDir/src/${sourceSet.name}/templates")
    if (!source.exists()) return@forEach

    val output = buildDir.resolve("generated/sources/${sourceSet.name}-templates")

    val generateTasks = listOf(
        TypeVariant(
            name = "Boolean", code = "B", kind = TypeKind.BOOLEAN,
            zero = "false", one = "true",
            arrayOf = "booleanArrayOf", toStringFormat = "%s",
            zeroField = "False", oneField = "True",
        ),
        TypeVariant(
            name = "Int", code = "I", kind = TypeKind.INTEGER,
            zero = "0", one = "1",
            arrayOf = "intArrayOf", toStringFormat = "%d",
        ),
        TypeVariant(
            name = "Long", code = "L", kind = TypeKind.INTEGER,
            zero = "0L", one = "1L",
            arrayOf = "longArrayOf", toStringFormat = "%d",
        ),
        TypeVariant(
            name = "Float", code = "F", kind = TypeKind.DECIMAL,
            zero = "0.0f", one = "1.0f",
            arrayOf = "floatArrayOf", toStringFormat = "%f",
        ),
        TypeVariant(
            name = "Double", code = "D", kind = TypeKind.DECIMAL,
            zero = "0.0", one = "1.0",
            arrayOf = "doubleArrayOf", toStringFormat = "%f",
        ),
    ).map { variant ->
        val taskName = sourceSet.getTaskName("generate", "${variant.name}Templates")
        val generateTask = tasks.register<GenerateTemplates>(taskName) {
            sourceDir.set(source)
            outputDir.set(output)

            fileNamePrefix.set(variant.code)
            
            context.putAll(mapOf(
                "T" to variant.code,
                "Type" to variant.name,
                "isNumber" to variant.kind.isNumber,
                "isDecimal" to (variant.kind == TypeKind.DECIMAL).toString(),
                "zero" to variant.zero,
                "one" to variant.one,
                "Zero" to variant.zeroField,
                "One" to variant.oneField,
                "arrayOf" to variant.arrayOf,
                "toStringFormat" to variant.toStringFormat,
            ) + alternateAccessors(variant) + swizzles(variant))
        }
        sourceSet.java.srcDir(generateTask.map { it.outputs })
        generateTask
    }

    tasks.register(sourceSet.getTaskName("generate", "templates")) {
        generateTasks.forEach { dependsOn(it) }
    }
}

@OptIn(ExperimentalStdlibApi::class)
fun alternateAccessors(variant: TypeVariant): Map<String, String> {
    return (2..4).map { size ->
        "alternateAccessors$size" to proxyFields.joinToString("\n") { fieldSet ->
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
    return (2..4).map { size ->
        "swizzles$size" to accessorFields.joinToString("\n") { fieldSet ->
            (0..<size).map { fieldSet[it] }.permutations().joinToString("\n") { swizzle ->
                val swizzleField = swizzle.joinToString("")
                val swizzleArgs = swizzle.joinToString(", ")
                "inline val ${variant.code}Vec${size}.$swizzleField get() = ${variant.code}Vec${size}($swizzleArgs)"
            } + "\n"
        }
    }.associate { it }
}

fun <T> List<T>.permutations(): List<List<T>> {
    if (size == 1) return listOf(this)
    val result = ArrayList<List<T>>()
    indices.forEach { i ->
        (this - this[i]).permutations().forEach { item ->
            result += item + this[i]
        }
    }
    return result
}
