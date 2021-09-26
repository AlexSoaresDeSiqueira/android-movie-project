package com.alex.moviehome.data.repository

import com.alex.moviehome.data.datasource.MoviesRemoteDataSource
import com.alex.moviehome.data.model.MovieResult
import com.alex.moviehome.domain.entity.MovieEntity
import com.alex.moviehome.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class MovieRepositoryImpl(
    private val movieDataSource: MoviesRemoteDataSource
) : MovieRepository {
    override fun fetchNowPlayingMovies(page: Int): Flow<List<MovieEntity>> {
        return movieDataSource.fetchNowPlayingMovies(page).parseToEntity()
    }
}

private fun Flow<MovieResult>.parseToEntity(): Flow<List<MovieEntity>> {
    return map { result ->
        result.results.map { movie ->
            MovieEntity(
                id = movie.id,
                title = movie.title,
                posterPath = movie.posterPath.convertToImageUrl(),
                votes = movie.votes
            )
        }
    }
}

private fun String?.convertToImageUrl(): String {
    val baseImageUrl = "https://image.tmdb.org/t/p/w500"

    return if (isNullOrEmpty()) {
        "$baseImageUrl/wwemzKWzjKYJFfCeiB57q3r4Bcm.png"
    } else {
        "$baseImageUrl$this"
    }
}