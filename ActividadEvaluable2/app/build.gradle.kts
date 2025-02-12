plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("plugin.serialization") version "1.9.0"
}

android {
    namespace = "com.example.actividadevaluable2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.actividadevaluable2"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding{
        enable = true;
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.ui.tooling.preview.android)
    implementation(libs.androidx.foundation.layout.android)
    implementation(libs.androidx.foundation.layout.android)
    implementation(libs.androidx.foundation.layout.android)
    implementation(libs.androidx.monitor)
    implementation(libs.androidx.junit.ktx)
    dependencies {
        implementation("androidx.core:core-ktx:1.12.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.9.0")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
        implementation("androidx.activity:activity-compose:1.7.2")
        implementation("com.android.volley:volley:1.2.1")
        implementation("com.github.bumptech.glide:glide:4.16.0")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
        implementation("io.ktor:ktor-client-core:2.0.3")
        implementation("io.ktor:ktor-client-cio:2.0.3")
        implementation("androidx.compose.foundation:foundation:1.7.0")
        implementation("androidx.compose.material3:material3:1.1.2")
        implementation("androidx.compose.ui:ui:1.7.0")
        implementation("io.coil-kt:coil-compose:2.2.2")
        implementation("androidx.compose.material3:material3:1.1.2")
        implementation("androidx.compose.material:material:1.4.3")
        implementation("androidx.compose.material3:material3:1.2.0")
        implementation("androidx.compose.material:material:1.4.3")
        implementation("androidx.compose.ui:ui:1.5.0")
        implementation("androidx.compose.foundation:foundation-layout:1.7.0")
        implementation("io.ktor:ktor-client-core:2.0.3")
        implementation("io.ktor:ktor-client-cio:2.0.3")
        implementation("io.ktor:ktor-client-content-negotiation:2.0.3")
        implementation("io.ktor:ktor-serialization-kotlinx-json:2.0.3")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
    }

}