plugins {
    kotlin("jvm") version "1.9.21"
}

group = "com.blackoutburst"
version = "1.0"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(11)
}