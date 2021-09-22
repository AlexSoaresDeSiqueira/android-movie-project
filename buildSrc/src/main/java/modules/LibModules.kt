package modules

internal object LibModules {
    private const val network = ":network"
    private const val navigation = ":navigation"
    private const val uiComponents = ":ui:components"

    fun getAllLibModules() = arrayOf(network, navigation, uiComponents)
}