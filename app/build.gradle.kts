plugins {
    id("autopocket.convention.android.application")
    alias(tools.plugins.kotlin.serialisation)
    alias(tools.plugins.kotlin.compose)
}

android {
    namespace = "kiwi.autopocket"

    defaultConfig {
        applicationId = "kiwi.autopocket"
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
    implementation(project(":core:presentation"))
    implementation(project(":theme"))
    implementation(project(":feature:future-expense"))
    implementation(project(":feature:about"))
    implementation(project(":feature:fake-auth"))

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
    implementation(libs.androidx.material3.adaptive.navigation)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.kotlin.serialisation)
    implementation(libs.kotlin.immutable.collections)
    implementation(libs.androidx.splash)

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