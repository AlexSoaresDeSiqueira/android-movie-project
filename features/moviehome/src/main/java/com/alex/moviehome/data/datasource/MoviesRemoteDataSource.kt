package com.alex.moviehome.data.datasource

import com.alex.moviehome.data.model.MovieResult
import kotlinx.coroutines.flow.Flow

internal interface MoviesRemoteDataSource {
    fun fetchNowPlayingMovies(page: Int): Flow<MovieResult>
}