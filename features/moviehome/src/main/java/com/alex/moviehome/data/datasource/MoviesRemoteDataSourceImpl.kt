package com.alex.moviehome.data.datasource

import com.alex.moviehome.data.model.MovieResult
import com.alex.moviehome.data.service.MovieService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class MoviesRemoteDataSourceImpl(
    private val movieService: MovieService
) : MoviesRemoteDataSource {
    override fun fetchNowPlayingMovies(page: Int): Flow<MovieResult> = flow {
        emit(movieService.fetchNowPlayingMovies(page))
    }
}