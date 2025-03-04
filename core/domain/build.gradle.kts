plugins {
    alias(libs.plugins.sow.jvm.library)
    alias(libs.plugins.sow.hilt)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}
