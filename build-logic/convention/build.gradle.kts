import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.yongjincompany.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

//build-logic 모듈에서 생성하는 모든 플러그인은 컴파일에만 관련이 있고 런타임 중에는
// 아무것도 하지 않기 때문에 implementation이 아닌 compileOnly를 사용했습니다.
dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.hilt.gradlePlugin)
    compileOnly(libs.firebase.crashlytics.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "sow.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "sow.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "sow.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("hilt") {
            id = "sow.hilt"
            implementationClass = "HiltConventionPlugin"
        }
        register("androidFirebase") {
            id = "sow.android.application.firebase"
            implementationClass = "AndroidApplicationFirebaseConventionPlugin"
        }
        register("androidTest") {
            id = "sow.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("jvmLibrary") {
            id = "sow.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}