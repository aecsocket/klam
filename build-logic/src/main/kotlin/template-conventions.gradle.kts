import org.gradle.api.file.DuplicatesStrategy
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.register
import org.gradle.plugins.ide.idea.model.IdeaModel
import templating.GenerateTemplates
import templating.TypeVariant
import templating.TypeVariants

plugins {
    id("kotlin-conventions")
    id("idea")
}

val templatesExt = extensions.create("templates", TemplateExtension::class)

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

afterEvaluate {
    val extraContextProvider = templatesExt.extraContextProvider.getOrElse { emptyMap() }

    // needed so `sourcesJar` doesn't fail (it's stupid)
    tasks {
        sourcesJar {
            duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        }
    }

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
                    context.putAll(variant.context() + extraContextProvider(variant))
                }

                // this line causes task `sourcesJar` to have duplicates
                // considering there are literally no duplicated files, idk why this happens
                sourceSet.java.srcDir(generateTask.map { it.outputs })
                generateTask.get()
            }
        }

        tasks.register(sourceSet.getTaskName("generate", "templates")) {
            generateTasks.forEach { dependsOn(it) }
        }
    }
}
