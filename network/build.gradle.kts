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

        buildConfigField("String", "API_BASEURL", "\"https://api.themoviedb.org/3/\"")
        buildConfigField("String", "API_KEY", "\"a4658479bb1148057cefb67dd42387f3\"")
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
}

dependencies {
    implementation(CoreDependencies.coreKtx)
    implementation(UiDependencies.appcompat)
    implementation(UiDependencies.material)

    implementation(NetworkDependencies.retrofit)
    implementation(NetworkDependencies.converterGson)
    implementation(platform(NetworkDependencies.okHttpBom))
    implementation(NetworkDependencies.okhttp)
    implementation(NetworkDependencies.loggingInterceptor)

    implementation(CoreDependencies.koin)

    testImplementation(TestDependencies.junit)

    androidTestImplementation(TestDependencies.androidxJunit)
    androidTestImplementation(TestDependencies.espressoCore)
}