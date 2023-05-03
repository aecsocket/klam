plugins {
    id("parent-conventions")
    id("kotlin-conventions")
    id("publishing-conventions")
    id("me.champeau.jmh")
}

group = "io.github.aecsocket"
version = "0.1.4"
description = "Linear algebra library for 2D/3D applications"

dependencies {
    compileOnlyApi(libs.findBugs)

    testImplementation(libs.findBugs)
}
