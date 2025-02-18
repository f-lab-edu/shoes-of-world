import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import com.yongincompany.convention.util.libs

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("sow.android.library")
                apply("sow.hilt")
            }
            extensions.configure<LibraryExtension> {
                buildFeatures {
                    viewBinding = true
                    buildConfig = true
                }
            }

            dependencies {
                add("implementation", project(":core:ui"))
                add("implementation", project(":core:domain"))

                add("implementation", libs.findLibrary("androidx.core.ktx").get())
                add("implementation", libs.findLibrary("androidx.appcompat").get())
            }
        }
    }
}