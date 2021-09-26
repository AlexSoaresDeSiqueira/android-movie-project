object LibModules {
    const val network = ":network"
    const val navigation = ":navigation"
    const val uiComponents = ":ui:components"

    fun getAllLibModules() = arrayOf(network, navigation, uiComponents)
}