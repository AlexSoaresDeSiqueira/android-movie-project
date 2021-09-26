import versions.CoreVersions

object CoreDependencies {
    val coreKtx by lazy { "androidx.core:core-ktx:${CoreVersions.coreKtx}" }
    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${CoreVersions.lifecycleRuntimeKtx}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${CoreVersions.activityCompose}" }
    val composeNavigation by lazy { "androidx.navigation:navigation-compose:${CoreVersions.composeNavigation}" }
}