import modules.FeatureModules
import modules.LibModules

object AppModules {
    private const val app = ":app"

    private fun getAllAppModules() = arrayOf(app)

    fun getAllProjectModules(): Array<String> = FeatureModules.getAllFeatureModules() + LibModules.getAllLibModules() + getAllAppModules()
}

