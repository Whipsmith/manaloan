plugins {
    id("spahr.convention.android.application")
    alias(tools.plugins.kotlin.compose)
}

android {
    namespace = "nz.spahr"

    defaultConfig {
        applicationId = "nz.spahr"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
//    Modules
    implementation(project(":core:feature"))
    implementation(project(":core:theme"))
    implementation(project(":feature:future-expense"))

//    libraries
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)

//    Debug
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

//    Test
    testImplementation(libs.junit)
    testImplementation(libs.koin.test)

//    AndroidTest
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
}