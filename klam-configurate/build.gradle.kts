plugins {
    id("kotlin-conventions")
    id("publishing-conventions")
}

dependencies {
    api(projects.klam)
    api(libs.configurate.core)
    implementation(libs.configurate.extra.kotlin)

    testImplementation(libs.configurate.yaml)
}
