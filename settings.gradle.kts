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

rootProject.name = "ManaLoan"
include(":app")
include(":core:presentation")

include(":core:feature-contract")
include(":core:feature-flag")
include(":core:auth")
include(":core:content")

include(":shared:theme")
include(":shared:domain")

include(":feature:about")
include(":feature:future-expense")
include(":feature:fake-auth")
include(":core:analytics")
include(":feature:checkin")
