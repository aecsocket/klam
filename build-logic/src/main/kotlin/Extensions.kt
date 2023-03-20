import org.gradle.api.Project
import org.gradle.api.provider.Provider
import java.io.File

val Project.ci: Provider<Boolean>
    get() = providers.environmentVariable("CI").map { it.toBoolean() }.orElse(false)

val Project.ciPublishApi: Provider<Boolean>
    get() = providers.environmentVariable("CI_PUBLISH_API").map { it.toBoolean() }.orElse(false)

fun Project.publishIfNeeded() {
    if (!ci.get() || ciPublishApi.get()) {
        plugins.apply("publishing-conventions")
    }
}

val Project.libDir: File
    get() = rootDir.resolve("punt")
