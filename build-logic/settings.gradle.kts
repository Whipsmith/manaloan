dependencyResolutionManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }

        create("tools") {
            from(files("../gradle/tools.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"
include(":convention")