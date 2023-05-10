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

sealed interface TypeVariant {
    val name: String
    val code: String
    val zero: String
    val one: String
    val zeroField: String
    val oneField: String
    val arrayOf: String
    val nextRandom: String
    val toStringFormat: String
    val isNumber: Boolean
    val isDecimal: Boolean

    fun context(): Map<String, Any> = mapOf(
        "Type" to name,
        "T" to code,
        "zero" to zero,
        "one" to one,
        "Zero" to zeroField,
        "One" to oneField,
        "arrayOf" to arrayOf,
        "nextRandom" to nextRandom,
        "toStringFormat" to toStringFormat,
        "isNumber" to isNumber,
        "isDecimal" to isDecimal,
    )

    object Bool : TypeVariant {
        override val name get() = "Boolean"
        override val code get() = "B"
        override val zero get() = "false"
        override val one get() = "true"
        override val zeroField get() = "False"
        override val oneField get() = "True"
        override val arrayOf get() = "booleanArrayOf"
        override val nextRandom get() = "nextBoolean"
        override val toStringFormat get() = "%s"
        override val isNumber get() = false
        override val isDecimal get() = false
    }

    sealed interface Number : TypeVariant {
        override val zeroField get() = "Zero"
        override val oneField get() = "One"
        override val isNumber get() = true
    }

    data class Integer(
        override val name: String,
        override val code: String,
        override val zero: String,
        override val one: String,
        override val arrayOf: String,
        override val nextRandom: String,
    ) : Number {
        override val toStringFormat get() = "%d"
        override val isDecimal get() = false
    }

    data class Decimal(
        override val name: String,
        override val code: String,
        override val zero: String,
        val quarter: String,
        val half: String,
        override val one: String,
        val two: String,
        override val arrayOf: String,
        override val nextRandom: String,
        val pi: String,
        val oneEighty: String,
        val epsilon: String,
        val oneEpsilon: String,
    ) : Number {
        override val toStringFormat get() = "%f"
        override val isDecimal get() = true

        override fun context() = super.context() + mapOf(
            "quarter" to quarter,
            "half" to half,
            "two" to two,
            "pi" to pi,
            "oneEighty" to oneEighty,
            "epsilon" to epsilon,
            "oneEpsilon" to oneEpsilon,
        )
    }
}

object Variants {
    val Boolean = TypeVariant.Bool

    val Int = TypeVariant.Integer(
        name = "Int", code = "I",
        zero = "0", one = "1",
        arrayOf = "intArrayOf", nextRandom = "nextInt",
    )

    val Long = TypeVariant.Integer(
        name = "Long", code = "L",
        zero = "0L", one = "1L",
        arrayOf = "longArrayOf", nextRandom = "nextLong",
    )

    val Float = TypeVariant.Decimal(
        name = "Float", code = "F",
        zero = "0.0f", quarter = "0.25f", half = "0.5f", one = "1.0f", two = "2.0f",
        arrayOf = "floatArrayOf", nextRandom = "nextFloat",
        pi = "kotlin.math.PI.toFloat()", oneEighty = "180.0f",
        epsilon = "0.000001f", oneEpsilon = "0.999999f",
    )

    val Double = TypeVariant.Decimal(
        name = "Double", code = "D",
        zero = "0.0", quarter = "0.25", half = "0.5", one = "1.0", two = "2.0",
        arrayOf = "doubleArrayOf", nextRandom = "nextDouble",
        pi = "kotlin.math.PI", oneEighty = "180.0",
        epsilon = "0.000001", oneEpsilon = "0.999999",
    )
}

data class TemplateSet(
    val name: String,
    val types: List<TypeVariant>,
)

val templateSets = listOf(
    TemplateSet(
        name = "common",
        types = listOf(
            Variants.Boolean,
            Variants.Int,
            Variants.Long,
            Variants.Float,
            Variants.Double,
        ),
    ),
    TemplateSet(
        name = "numbers",
        types = listOf(
            Variants.Int,
            Variants.Long,
            Variants.Float,
            Variants.Double,
        ),
    ),
    TemplateSet(
        name = "decimals",
        types = listOf(
            Variants.Float,
            Variants.Double,
        ),
    ),
)

// for IDE autocompletion
//extensions.configure<IdeaModel> {
//    module {
//        sourceSets.forEach { sourceSet ->
//            templateSets.forEach { templateSet ->
//                val file = projectDir.resolve("src/${sourceSet.name}/templates/${templateSet.name}")
//                if (file.exists()) {
//                    sourceDirs.add(file)
//                }
//            }
//        }
//    }
//}

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
            sourceSet.java.srcDir(generateTask.map { it.outputs })
            generateTask.get()
        }
    }

    tasks.register(sourceSet.getTaskName("generate", "templates")) {
        generateTasks.forEach { dependsOn(it) }
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
    return (2..4).map { size ->
        "vecSwizzles$size" to accessorFields.joinToString("\n") { fieldSet ->
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
