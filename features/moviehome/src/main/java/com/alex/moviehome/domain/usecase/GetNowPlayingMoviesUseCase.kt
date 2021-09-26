package com.alex.moviehome.domain.usecase

import com.alex.moviehome.domain.entity.MovieEntity
import com.alex.moviehome.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

internal class GetNowPlayingMoviesUseCase(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(page: Int): Flow<List<MovieEntity>> {
        return movieRepository.fetchNowPlayingMovies(page)
    }
}

