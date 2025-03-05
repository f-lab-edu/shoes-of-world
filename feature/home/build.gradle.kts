plugins {
    alias(libs.plugins.sow.android.feature)
    alias(libs.plugins.sow.android.library.compose)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.yongjincompany.feature.home"
}

dependencies {
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.lifecycle.runtime)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}