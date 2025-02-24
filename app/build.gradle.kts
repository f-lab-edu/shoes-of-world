plugins {
    alias(libs.plugins.sow.android.application)
    alias(libs.plugins.sow.hilt)
    alias(libs.plugins.sow.android.application.firebase)
    alias(libs.plugins.sow.android.application.compose)
}

android {
    namespace = "com.yongjincompany.shoesofworld"

    defaultConfig {
        applicationId = "com.yongjincompany.shoesofworld"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
        }
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":feature:home"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}