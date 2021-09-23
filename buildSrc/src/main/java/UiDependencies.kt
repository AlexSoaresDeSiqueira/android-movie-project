import versions.UiVersions

object UiDependencies {
    val appcompat by lazy { "androidx.appcompat:appcompat:${UiVersions.appcompat}" }
    val material by lazy { "com.google.android.material:material:${UiVersions.material}" }
    val composeUi by lazy { "androidx.compose.ui:ui:${UiVersions.compose}" }
    val composeMaterial by lazy { "androidx.compose.material:material:${UiVersions.compose}" }
    val composeToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${UiVersions.compose}" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling:${UiVersions.compose}" }
    val coil_compose by lazy { "io.coil-kt:coil-compose:${UiVersions.coil}" }
}