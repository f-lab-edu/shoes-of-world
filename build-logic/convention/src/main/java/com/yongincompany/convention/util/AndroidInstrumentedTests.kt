package com.yongincompany.convention.util

import com.android.build.api.variant.LibraryAndroidComponentsExtension
import org.gradle.api.Project


/**'androidTest' 폴더가 없는 경우 [project]에 대해 불필요한 Android instrumented test를 비활성화합니다.
 * 그렇지 않으면 이러한 프로젝트는 다음 메시지와 함께 컴파일, 패키지화, 설치 및 실행됩니다:
 *
 * > Starting 0 tests on AVD
 *
 * Note: this could be improved by checking other potential sourceSets based on buildTypes and flavors.
 * */
internal fun LibraryAndroidComponentsExtension.disableUnnecessaryAndroidTests(
    project: Project,
) = beforeVariants {
    it.enableAndroidTest = it.enableAndroidTest
            && project.projectDir.resolve("src/androidTest").exists()
}