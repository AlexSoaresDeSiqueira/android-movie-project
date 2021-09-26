package com.alex.moviedetail.data.repository

import app.cash.turbine.test
import com.alex.moviedetail.data.datasource.MovieDetailRemoteDataSource
import com.alex.moviedetail.data.model.Genre
import com.alex.moviedetail.data.model.MovieResult
import com.alex.moviedetail.domain.entity.MovieDetailEntity
import com.alex.moviedetail.domain.repository.MovieDetailRepository
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
internal class MovieRepositoryImplTest {

    private val movieDataSource: MovieDetailRemoteDataSource = mockk()
    private val movieRepository: MovieDetailRepository = MovieDetailRepositoryImpl(
        movieDataSource = movieDataSource
    )

    @Test
    fun `movieDetail should return MovieDetailEntity`() = runBlocking {
        // Given
        val movieId = 0L
        val expected = MovieDetailEntity(
            title = "Title",
            description = "Description",
            backdropPath = "https://image.tmdb.org/t/p/w500/teste.png",
            votes = 0.0f,
            genres = listOf("Teste"),
            productionCompanies = listOf()
        )

        every { movieDataSource.movieDetail(movieId) } returns flowOf(
            MovieResult(
                title = "Title",
                description = "Description",
                backdropPath = "/teste.png",
                votes = 0.0f,
                genres = listOf(
                    Genre(
                        id = 0, name = "Teste"
                    )
                ),
                productionCompanies = listOf()
            )
        )

        // When
        val result = movieRepository.movieDetail(movieId)

        // Then
        result.test {
            assertEquals(expected, expectItem())
            expectComplete()
        }
    }
}