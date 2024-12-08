package internal

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import ext.tools
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

abstract class AndroidBasePlugin(private val moduleTypePluginId: String) : Plugin<Project> {

    override fun apply(project: Project) {
        with(project) {
            // Apply the Android plugins if not already applied
            plugins.apply(moduleTypePluginId)
            plugins.apply("org.jetbrains.kotlin.android")

            // Access the appropriate Android extension (Library or Application)
            val androidExtension = extensions.findByType(LibraryExtension::class.java)
                ?: extensions.findByType(AppExtension::class.java)
                ?: throw IllegalStateException("Android plugin must be applied first!")

            // Access values from the version catalog
            val targetSdk = tools.findVersion("targetSdk").get().toString().toInt()
            val compileSdk = tools.findVersion("compileSdk").get().toString().toInt()
            val minSdk = tools.findVersion("minSdk").get().toString().toInt()

            // Configure the Android extension
            androidExtension.apply {
                compileSdkVersion(compileSdk)

                defaultConfig {
                    targetSdkVersion(targetSdk)
                    minSdkVersion(minSdk)
                    testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_11
                    targetCompatibility = JavaVersion.VERSION_11
                }
            }
        }
    }

}