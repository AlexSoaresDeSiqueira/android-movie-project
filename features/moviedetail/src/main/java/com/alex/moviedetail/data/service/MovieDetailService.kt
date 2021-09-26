package com.alex.moviedetail.data.service

import com.alex.moviedetail.data.model.MovieResult
import retrofit2.http.GET
import retrofit2.http.Path

internal interface MovieDetailService {
    @GET("movie/{movie_id}")
    suspend fun movieDetail(
        @Path("movie_id") movieId: Long
    ): MovieResult
}