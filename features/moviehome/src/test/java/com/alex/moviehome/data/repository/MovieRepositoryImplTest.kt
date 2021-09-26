package com.alex.moviehome.data.repository

import app.cash.turbine.test
import com.alex.moviehome.data.datasource.MoviesRemoteDataSource
import com.alex.moviehome.data.model.Movie
import com.alex.moviehome.data.model.MovieResult
import com.alex.moviehome.domain.entity.MovieEntity
import com.alex.moviehome.domain.repository.MovieRepository
import io.mockk.every
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
internal class MovieRepositoryImplTest {

    private val movieDataSource: MoviesRemoteDataSource = mockk()

    private val movieRepository: MovieRepository = MovieRepositoryImpl(
        movieDataSource
    )

    @Test
    fun `fetchNowPlayingMovies should return movie entity list with default posterPath`() = runBlocking {
        // Given
        val page = 0
        val expected = listOf(MovieEntity(
            id = 123,
            title = "Some Title",
            posterPath = "https://image.tmdb.org/t/p/w500/wwemzKWzjKYJFfCeiB57q3r4Bcm.png",
            votes = 0.0f
        ))
        every { movieDataSource.fetchNowPlayingMovies(page) } returns flowOf(
            MovieResult(
                id = 0, totalPages = 0, results = listOf(
                    Movie(
                        id = 123, title = "Some Title", posterPath = null, votes = 0.0f
                    )
                )
            )
        )

        // When
        val result = movieRepository.fetchNowPlayingMovies(page)

        // Then
        result.test {
            assertEquals(expected, expectItem())
            expectComplete()
        }
    }

    @Test
    fun `fetchNowPlayingMovies should return movie entity list`() = runBlocking {
        // Given
        val page = 0
        val expected = listOf(MovieEntity(
            id = 123,
            title = "Some Title",
            posterPath = "https://image.tmdb.org/t/p/w500/teste.png",
            votes = 0.0f
        ))
        every { movieDataSource.fetchNowPlayingMovies(page) } returns flowOf(
            MovieResult(
                id = 0, totalPages = 0, results = listOf(
                    Movie(
                        id = 123, title = "Some Title", posterPath = "/teste.png", votes = 0.0f
                    )
                )
            )
        )

        // When
        val result = movieRepository.fetchNowPlayingMovies(page)

        // Then
        result.test {
            assertEquals(expected, expectItem())
            expectComplete()
        }
    }
}