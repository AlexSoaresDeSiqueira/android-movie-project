package com.alex.moviedetail.data.datasource

import com.alex.moviedetail.data.model.MovieResult
import com.alex.moviedetail.data.service.MovieDetailService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class MovieDetailRemoteDataSourceImpl(
    private val movieService: MovieDetailService
) : MovieDetailRemoteDataSource {
    override fun movieDetail(movieId: Long): Flow<MovieResult> = flow {
        emit(movieService.movieDetail(movieId))
    }
}