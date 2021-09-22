import versions.ProjectConfigVersions

object ProjectConfigDependencies {
    const val gradle = "com.android.tools.build:gradle:${ProjectConfigVersions.gradlePlugin}"
    const val kotlin = "org.jetbrains.java:java-gradle-plugin:${ProjectConfigVersions.kotlin}"
}