plugins {
    alias(libs.plugins.sow.android.library)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.yongjincompany.core.navigation"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}