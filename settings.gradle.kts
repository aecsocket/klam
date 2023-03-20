enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    includeBuild("build-logic")
}

plugins {
    id("ca.stellardrift.polyglot-version-catalogs") version "6.0.1"
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
}

rootProject.name = "klam"
