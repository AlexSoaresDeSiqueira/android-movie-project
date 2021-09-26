package com.alex.moviedetail.data.repository

import com.alex.moviedetail.data.datasource.MovieDetailRemoteDataSource
import com.alex.moviedetail.data.model.MovieResult
import com.alex.moviedetail.domain.repository.MovieDetailRepository
import com.alex.moviedetail.domain.entity.MovieDetailEntity
import com.alex.moviedetail.domain.entity.ProductionCompanies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class MovieDetailRepositoryImpl(
    private val movieDataSource: MovieDetailRemoteDataSource
) : MovieDetailRepository {
    override fun  movieDetail(movieId: Long): Flow<MovieDetailEntity> {
        return movieDataSource.movieDetail(movieId).parseToEntity()
    }
}

private fun Flow<MovieResult>.parseToEntity(): Flow<MovieDetailEntity> {
    return map { result ->
        MovieDetailEntity(
            title = result.title,
            description = result.description,
            backdropPath = result.backdropPath.convertToImageUrl(),
            votes = result.votes,
            genres = result.genres.map { it.name },
            productionCompanies = result.productionCompanies.map {
                ProductionCompanies(
                    name = it.name, logoPath = it.logoPath.convertToImageUrl()
                )
            }
        )
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