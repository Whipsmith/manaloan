plugins {
    id("autopocket.convention.android.library")
    alias(tools.plugins.kotlin.serialisation)
    alias(tools.plugins.kotlin.compose)
    alias(tools.plugins.ksp)
}

android {
    namespace = "kiwi.autopocket.fake_auth"

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

ksp {
    arg("lyricist.internalVisibility", "true")
}

dependencies {

    //    modules
    implementation(project(":shared:theme"))
    implementation(project(":core:feature-contract"))
    implementation(project(":core:auth"))
    implementation(project(":core:content"))

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
    implementation(libs.lyricist)
    ksp(libs.lyricist.processor)

//    test
    testImplementation(libs.junit)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.google.truth)

//    android test
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}