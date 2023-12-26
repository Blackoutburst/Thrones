plugins {
    kotlin("jvm") version "1.9.21"
    `java-library`
    `maven-publish`
}

group = "dev.blackoutburst"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(11)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Blackoutburst/Thrones")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}