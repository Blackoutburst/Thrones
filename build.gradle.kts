import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.DokkaConfiguration.Visibility
import org.jetbrains.dokka.base.DokkaBaseConfiguration

plugins {
    kotlin("jvm") version "1.9.21"
    id("org.jetbrains.dokka") version "1.9.10"
    `java-library`
    `maven-publish`
}

group = "dev.blackoutburst"
version = "1.1.2"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(11)
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}

buildscript {
    dependencies {
        classpath("org.jetbrains.dokka:dokka-base:1.9.10")
    }
}

tasks.withType<DokkaTask>().configureEach {
    pluginConfiguration<DokkaBase, DokkaBaseConfiguration> {
        customAssets = listOf(file("dokka/logo-icon.png"))
        customStyleSheets = listOf(file("dokka/logo-styles.css"))
        footerMessage = "(c) 2024 Florian \"Blackoutburst\" Chanson"
        separateInheritedMembers = true
        mergeImplicitExpectActualDeclarations = false
    }
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets.configureEach {
        documentedVisibilities.set(
            setOf(
                Visibility.PUBLIC,
                Visibility.PROTECTED,
                Visibility.PACKAGE,
            )
        )
    }
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])

            pom {
                name.set("Thrones")
                description.set("Lightweight logger api")
                url.set("https://github.com/Blackoutburst/Thrones")

                licenses {
                    license {
                        name.set("The Unlicense")
                        url.set("https://unlicense.org")
                    }
                }

                developers {
                    developer {
                        id.set("blackoutburst")
                        name.set("Florian \"Blackoutburst\" Chanson")
                        email.set("blackoutburst@hotmail.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/Blackoutburst/Thrones.git")
                    developerConnection.set("scm:git:ssh://github.com:Blackoutburst/Thrones.git")
                    url.set("https://github.com/Blackoutburst/Thrones/")
                }
            }
        }
    }
}