plugins {
    id("kotlin-conventions")
    id("publishing-conventions")
}

dependencies {
    implementation(projects.klam)
    implementation(libs.configurateCore)
    implementation(libs.configurateExtraKotlin)

    testImplementation(libs.configurateYaml)
}
