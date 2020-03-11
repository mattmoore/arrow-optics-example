/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin library project to get you started.
 */

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.3.61"

    // Apply the java-library plugin for API and implementation separation.
    `java-library`

    kotlin("kapt") version "1.3.61"
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

val arrowVersion = "0.10.4"

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Kotest
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")

    // Arrow
    implementation("io.arrow-kt:arrow-core:$arrowVersion")
    implementation("io.arrow-kt:arrow-syntax:$arrowVersion")
    implementation("io.arrow-kt:arrow-fx:$arrowVersion")
    implementation("io.arrow-kt:arrow-optics:$arrowVersion")
    implementation("io.arrow-kt:arrow-fx-rx2:$arrowVersion")
    implementation("io.arrow-kt:arrow-mtl:$arrowVersion")
    kapt("io.arrow-kt:arrow-meta:$arrowVersion")
    kaptTest("io.arrow-kt:arrow-meta:$arrowVersion")

    // SLF4J
    implementation("org.slf4j:slf4j-simple:1.7.30")
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.freeCompilerArgs += "-Xuse-experimental=kotlin.Experimental"
        kotlinOptions.jvmTarget = "1.8"
    }
}
