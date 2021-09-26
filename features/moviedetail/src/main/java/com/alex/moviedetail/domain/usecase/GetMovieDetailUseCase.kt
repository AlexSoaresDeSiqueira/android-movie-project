package com.alex.moviedetail.domain.usecase

import com.alex.moviedetail.domain.entity.MovieDetailEntity
import com.alex.moviedetail.domain.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow

internal class GetMovieDetailUseCase(
    private val movieRepository: MovieDetailRepository
) {
    operator fun invoke(movieId: Long): Flow<MovieDetailEntity> {
        return movieRepository.movieDetail(movieId)
    }
}

