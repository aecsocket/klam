import org.gradle.api.provider.Property
import templating.TypeVariant

abstract class TemplateExtension {
    abstract val extraContextProvider: Property<(TypeVariant) -> Map<String, Any>>
}
