package modules

internal object FeatureModules {
    private const val movieDetail = ":features:moviedetail"
    private const val movieHome = ":features:moviehome"

    fun getAllFeatureModules() = arrayOf(movieDetail, movieHome)
}

