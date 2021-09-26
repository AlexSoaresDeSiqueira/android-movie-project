import versions.TestVersions
import versions.UiVersions
import versions.CoreVersions

object TestDependencies {
    val junit by lazy { "junit:junit:${TestVersions.junit}" }
    val androidxJunit by lazy { "androidx.test.ext:junit:${TestVersions.androidxJunit}" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:${TestVersions.espressoCore}" }

    val composeJunit by lazy { "androidx.compose.ui:ui-test-junit4:${UiVersions.compose}" }
    val composeUiTest by lazy { "androidx.compose.ui:ui-test:${UiVersions.compose}" }
    val composeUiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest:${UiVersions.compose}" }

    val turbine by lazy { "app.cash.turbine:turbine:${TestVersions.turbine}" }
    val coroutinesTest by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${CoreVersions.coroutines}" }
}