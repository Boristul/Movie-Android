plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        versionCode = 1
        versionName = "0.0.0"

        minSdkVersion(21)
        targetSdkVersion(29)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    viewBinding {
        isEnabled = true
    }
}

dependencies {
    // region Kotlin
    val kotlinVersion: String by project
    implementation(kotlin("stdlib-jdk8", kotlinVersion))
    // endregion

    // region Local
    implementation(project(":uikit"))
    implementation(project(":repository"))
    implementation(project(":core"))
    // endregion

    // region Navigation
    val navigationVersion: String by project
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationVersion")
    // endregion

    // region Core
    val kodeinVersion: String by project
    implementation("org.kodein.di:kodein-di-generic-jvm:$kodeinVersion")
    implementation("org.kodein.di:kodein-di-framework-android-x:$kodeinVersion")

    val daggerVersion: String by project
    implementation("com.google.dagger:dagger:$daggerVersion")
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")
    // endregion

    // region AndroidX and material components
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.core:core-ktx:1.2.0")
    api("com.google.android.material:material:1.2.0-alpha05")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    // endregion
}
