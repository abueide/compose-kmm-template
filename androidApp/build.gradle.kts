plugins {
    id("com.android.application")
    kotlin("android")
    id(Plugin.Id.junit5)
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.dialexa.mnp.android"
        minSdk = 24
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["runnerBuilder"] = "de.mannodermaus.junit5.AndroidJUnit5Builder"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":sharedCompose"))
    implementation("androidx.activity:activity-compose:1.5.0")
    implementation(Deps.Koin.compose)

    with(Deps.Compose) {
        implementation(uiGraphics)
        implementation(foundationLayout)
        implementation(navigation)
        implementation(coilCompose)
        implementation(accompanistNavigationAnimation)
        implementation(accompanistSwipeRefresh)
        implementation(uiTooling)
        implementation(material)
        implementation(ui)
    }

    // Tests
    testImplementation(Deps.Test.junitApi)
    testRuntimeOnly(Deps.Test.junitEngine)
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation(Deps.Test.junitApi)
    androidTestImplementation("de.mannodermaus.junit5:android-test-core:1.3.0")
    androidTestRuntimeOnly("de.mannodermaus.junit5:android-test-runner:1.3.0")
}