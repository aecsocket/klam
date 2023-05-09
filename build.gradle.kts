plugins {
    id("parent-conventions")
    id("kotlin-conventions")
    id("publishing-conventions")
    alias(libs.plugins.jmh)
}

group = "io.github.aecsocket"
version = "0.2.0-SNAPSHOT"
description = "Linear algebra library for 2D/3D applications"
