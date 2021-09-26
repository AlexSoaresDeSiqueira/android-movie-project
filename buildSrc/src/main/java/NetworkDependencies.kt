import versions.NetworkDependenciesVersions

object NetworkDependencies {
     val retrofit by lazy { "com.squareup.retrofit2:retrofit:${NetworkDependenciesVersions.retrofit}" }
     val converterGson by lazy { "com.squareup.retrofit2:converter-gson:${NetworkDependenciesVersions.retrofit}" }
     val okHttpBom by lazy { "com.squareup.okhttp3:okhttp-bom:${NetworkDependenciesVersions.okHttp}" }
     val okhttp by lazy { "com.squareup.okhttp3:okhttp" }
     val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor" }
}