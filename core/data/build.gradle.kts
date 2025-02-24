plugins {
    alias(libs.plugins.sow.android.library)
    alias(libs.plugins.sow.hilt)
}

android {
    namespace = "com.yongjincompany.core.data"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)

    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)

    implementation(project(":core:domain"))
}