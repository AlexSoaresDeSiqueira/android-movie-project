plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    defaultConfig {
        minSdk = AndroidConfigVersions.minSdkVersion
        targetSdk = AndroidConfigVersions.targetSdkVersion

        compileSdk = AndroidConfigVersions.compileSdkVersion
        buildToolsVersion = AndroidConfigVersions.buildToolsVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
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
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = versions.UiVersions.compose
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(CoreDependencies.coreKtx)
    implementation(CoreDependencies.composeNavigation)
    implementation(CoreDependencies.lifecycleRuntimeKtx)
    implementation(CoreDependencies.activityCompose)

    implementation(UiDependencies.appcompat)
    implementation(UiDependencies.material)
    implementation(UiDependencies.composeUi)
    implementation(UiDependencies.composeMaterial)
    implementation(UiDependencies.composeToolingPreview)
    implementation(UiDependencies.coil_compose)

    testImplementation(TestDependencies.junit)

    androidTestImplementation(TestDependencies.androidxJunit)
    androidTestImplementation(TestDependencies.espressoCore)
    androidTestImplementation(TestDependencies.composeJunit)

    debugImplementation(UiDependencies.composeUiTooling)
}