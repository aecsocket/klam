plugins {
    id("parent-conventions")
    id("kotlin-conventions")
    id("publishing-conventions")
    id("me.champeau.jmh")
}

group = "io.github.aecsocket"
version = "0.1.0-SNAPSHOT"
description = "Linear algebra library"

dependencies {
    compileOnlyApi(libs.findBugs)

    testImplementation(libs.findBugs)
}
