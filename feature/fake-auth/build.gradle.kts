plugins {
    id("spahr.convention.android.library")
    alias(tools.plugins.kotlin.serialisation)
    alias(tools.plugins.kotlin.compose)
}

android {
    namespace = "nz.spahr.fake_auth"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    //    modules
    implementation(project(":core:theme"))
    implementation(project(":core:feature-contract"))
    implementation(project(":core:auth"))

//    libraries
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.kotlin.serialisation)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.koin.compose.navigation)
    implementation(libs.androidx.material.icons.extended)

//    test
    testImplementation(libs.junit)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.google.truth)

//    android test
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}