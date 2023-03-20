plugins {
    id("base-conventions")
    id("java-library")
    id("net.kyori.indra")
}

indra {
    javaVersions {
        target(11)
    }
}

repositories {
    mavenCentral()
}
