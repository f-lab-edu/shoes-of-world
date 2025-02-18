plugins {
    alias(libs.plugins.sow.android.feature)
}

android {
    namespace = "com.yongjincompany.feature.home"
}

dependencies {
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.glide)

    implementation(libs.androidx.recyclerview)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}