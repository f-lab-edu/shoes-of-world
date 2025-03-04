plugins {
    alias(libs.plugins.sow.android.library)
    alias(libs.plugins.sow.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.yongjincompany.core.data"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)

    implementation(project(":core:domain"))
}