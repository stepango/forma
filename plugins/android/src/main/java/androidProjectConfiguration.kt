@file:Suppress("ObjectPropertyName")

import tools.forma.android.config.FormaConfiguration
import tools.forma.android.utils.register
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.tasks.Delete

fun Project.androidProjectConfiguration(
    minSdk: Int,
    targetSdk: Int,
    compileSdk: Int,
    kotlinVersion: String,
    agpVersion: String,
    versionCode: Int,
    versionName: String,
    repositories: RepositoryHandler.() -> Unit = {},
    dataBinding: Boolean = false,
    javaVersionCompatibility: JavaVersion = JavaVersion.VERSION_1_8, // Java/Kotlin configuration
    mandatoryOwners: Boolean = false
) {

    /**
     * Default Android project clean task implementation
     */
    tasks.register("clean", Delete::class) {
        delete(project.buildDir)
    }

    val configuration = FormaConfiguration(
        minSdk = minSdk,
        targetSdk = targetSdk,
        compileSdk = compileSdk,
        kotlinVersion = kotlinVersion,
        agpVersion = agpVersion,
        versionCode = versionCode,
        versionName = versionName,
        repositories = repositories,
        dataBinding = dataBinding,
        javaVersionCompatibility = javaVersionCompatibility,
        mandatoryOwners = mandatoryOwners
    )

    Forma.store(configuration)

}

/**
 * Singleton project configuration store
 */
object Forma {

    private lateinit var _configuration: FormaConfiguration
    val configuration: FormaConfiguration get() = _configuration

    fun store(configuration: FormaConfiguration) {
        _configuration = configuration
    }
}
