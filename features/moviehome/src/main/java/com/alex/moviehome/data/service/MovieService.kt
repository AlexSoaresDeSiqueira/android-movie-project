package com.alex.moviehome.data.service

import com.alex.moviehome.data.model.MovieResult
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MovieService {
    @GET("movie/now_playing")
    suspend fun fetchNowPlayingMovies(
        @Query("page") page: Int,
    ): MovieResult
}