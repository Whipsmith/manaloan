plugins {
    `kotlin-dsl` // Enables writing Gradle scripts in Kotlin
}

group = "nz.spahr.buildlogic"

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(tools.android.gradle.dependency)
    implementation(tools.kotlin.gradle.dependency)
}

gradlePlugin {
    plugins {
        create("androidLibraryPlugin") {
            id = "spahr.convention.android.library" // This is your plugin ID
            implementationClass = "AndroidLibraryPlugin" // Fully qualified class name
        }
        create("androidApplicationPlugin") {
            id = "spahr.convention.android.application" // This is your plugin ID
            implementationClass = "AndroidApplicationPlugin" // Fully qualified class name
        }
    }
}