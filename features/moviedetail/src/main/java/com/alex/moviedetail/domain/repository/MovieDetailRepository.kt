package com.alex.moviedetail.domain.repository

import com.alex.moviedetail.domain.entity.MovieDetailEntity
import kotlinx.coroutines.flow.Flow

internal interface MovieDetailRepository {
    fun  movieDetail(movieId: Long): Flow<MovieDetailEntity>
}