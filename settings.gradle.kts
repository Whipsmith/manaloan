
pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("build-logic") // Include the convention plugins project
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }


    versionCatalogs {
        create("tools") {
            from(files("gradle/tools.versions.toml"))
        }
    }
}

rootProject.name = "Spahr"
include(":app")
include(":core:feature")
include(":core:theme")
include(":feature:about")
include(":feature:future-expense")
