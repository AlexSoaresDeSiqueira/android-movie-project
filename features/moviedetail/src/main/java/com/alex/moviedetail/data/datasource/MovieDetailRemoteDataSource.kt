package com.alex.moviedetail.data.datasource

import com.alex.moviedetail.data.model.MovieResult
import kotlinx.coroutines.flow.Flow

internal interface MovieDetailRemoteDataSource {
    fun movieDetail(movieId: Long): Flow<MovieResult>
}