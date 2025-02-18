import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import com.yongincompany.convention.util.libs

class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.google.devtools.ksp")
            dependencies {
                add("ksp", libs.findLibrary("hilt.compiler").get())
                add("implementation", libs.findLibrary("hilt.core").get())
            }

            /** 다음 plugin모두 com.android.base를 모두 내부적으로 상속받음
             *
             * com.android.application
             * com.android.library
             * com.android.test
             * */
            pluginManager.withPlugin("com.android.base") {
                pluginManager.apply("dagger.hilt.android.plugin")
                dependencies {
                    add("implementation", libs.findLibrary("hilt.android").get())
                }
            }
        }
    }
}