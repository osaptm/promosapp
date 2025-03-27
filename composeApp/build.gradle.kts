import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    //Ktor para consumo de APIS Serializacion
    alias(libs.plugins.kotlinxSerialization)
    //ROOM
    alias(libs.plugins.room)
    alias(libs.plugins.ksp)
    //login passage
    id("com.google.gms.google-services")

}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            //Ktor para consumo de APIS
            implementation(libs.ktor.client.okhttp)
            //KOIN
            implementation(libs.koin.android)
            //Splash Screen
            implementation(libs.core.splashscreen)

            //login passage
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")
            implementation("com.google.firebase:firebase-auth:23.2.0")
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)

            //WEBVIEW PARA VIDEOS
            api(libs.compose.webview.multiplatform)
            //Coil para cargar Imagenes de URL
            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor3)
            //Ktor para consumo de APIS
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.negotiation)
            implementation(libs.kotlin.serialization)
            //Koin
            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            //ROOM
            implementation(libs.androidx.room.runtime)
            implementation(libs.sqlite.bundled)
            //NAVIGATION COMPOSE
            implementation(libs.navigation.compose)
            //LOGIN PASSAGE
            implementation(libs.kmpkit)
            implementation(libs.passage)
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
            implementation(project.dependencies.platform("com.google.firebase:firebase-bom:33.10.0"))
        }
        iosMain.dependencies {
            //Ktor para consumo de APIS
            implementation(libs.ktor.client.darwin)
            //LOGIN PASSAGE
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
        }
    }
}

android {
    namespace = "com.gonzapolleria.promosapp"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.gonzapolleria.promosapp"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    //Login Passage - Tener los 3 siguientes
    implementation(libs.androidx.startup.runtime)
    debugImplementation(compose.uiTooling)
    implementation(libs.passage)
    //ROOM KSP
    add("kspAndroid", libs.androidx.room.compiler)
    add("kspIosSimulatorArm64", libs.androidx.room.compiler)
    add("kspIosX64", libs.androidx.room.compiler)
    add("kspIosArm64", libs.androidx.room.compiler)

}

room { schemaDirectory("$projectDir/schemas") }

