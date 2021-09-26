import versions.CoreVersions

object CoreDependencies {
    val coreKtx by lazy { "androidx.core:core-ktx:${CoreVersions.coreKtx}" }
    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${CoreVersions.lifecycleRuntimeKtx}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${CoreVersions.activityCompose}" }
    val composeNavigation by lazy { "androidx.navigation:navigation-compose:${CoreVersions.composeNavigation}" }
    val koin by lazy { "io.insert-koin:koin-androidx-compose:${CoreVersions.koin}" }
    val roomRuntime by lazy { "androidx.room:room-runtime:${CoreVersions.room}" }
    val roomCompiler by lazy { "androidx.room:room-compiler:${CoreVersions.room}" }
    val roomKtx by lazy { "androidx.room:room-ktx:${CoreVersions.room}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${CoreVersions.coroutines}" }
    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${CoreVersions.coroutines}" }
}