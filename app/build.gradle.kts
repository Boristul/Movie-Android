plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "com.redmadrobot.movieandroid"
        versionCode = 1
        versionName = "0.0.0"

        minSdkVersion(21)
        targetSdkVersion(29)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    val kotlinVersion: String by project
    implementation(kotlin("stdlib-jdk8", kotlinVersion))
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
}
