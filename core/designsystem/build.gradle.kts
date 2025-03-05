plugins {
    alias(libs.plugins.sow.android.library)
    alias(libs.plugins.sow.android.library.compose)
}

android {
    namespace = "com.yongjincompany.core.designsystem"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.material3)
}