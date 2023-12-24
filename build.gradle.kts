plugins {
    kotlin("jvm") version "1.9.21"
}

group = "dev.blackoutburst"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(11)
}