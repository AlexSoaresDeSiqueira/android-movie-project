package com.alex.moviehome.domain.repository

import com.alex.moviehome.domain.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

internal interface MovieRepository {
    fun fetchNowPlayingMovies(page: Int): Flow<List<MovieEntity>>
}