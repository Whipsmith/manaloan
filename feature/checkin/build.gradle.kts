plugins {
    id("manaLoan.convention.android.library")
    alias(tools.plugins.kotlin.serialisation)
    alias(tools.plugins.kotlin.compose)
}

android {
    namespace = "kiwi.manaloan.checkin"

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
    //    modules
    implementation(project(":shared:theme"))

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

//    test
    testImplementation(libs.junit)

//    android test
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}