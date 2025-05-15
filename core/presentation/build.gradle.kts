plugins {
    id("manaLoan.convention.android.library")
    alias(tools.plugins.kotlin.serialisation)
    alias(tools.plugins.kotlin.compose)
}

android {
    namespace = "kiwi.manaLoan.presentation"

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
    implementation(project(":core:feature-contract"))
    implementation(project(":core:feature-flag"))
    implementation(project(":core:auth"))
//    libraries
    implementation(platform(libs.androidx.compose.bom))
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
//    test
    testImplementation(libs.junit)

//    android test
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}