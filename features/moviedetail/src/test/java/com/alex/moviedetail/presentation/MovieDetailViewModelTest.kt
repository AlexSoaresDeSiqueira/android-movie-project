package com.alex.moviedetail.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alex.moviedetail.domain.entity.MovieDetailEntity
import com.alex.moviedetail.domain.usecase.GetMovieDetailUseCase
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalCoroutinesApi
@ExperimentalTime
internal class MovieDetailViewModelTest {

    @get:Rule
    val instantTestExecutorRule = InstantTaskExecutorRule()

    private val testCoroutineDispatcher = TestCoroutineDispatcher()
    private val getMovieDetailUseCase: GetMovieDetailUseCase = mockk()
    private lateinit var movieDetailViewModel: MovieDetailViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testCoroutineDispatcher)
    }

    @After
    fun after() {
        Dispatchers.resetMain()
        testCoroutineDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `init should update state with movie data`() = runBlocking {
        // Given
        val movieId = 1L
        val expected = MovieDetailViewState(
            movieData = MovieView(
                title = "Title",
                description = "Description",
                backdropPath = "https://image.tmdb.org/t/p/w500/teste.png",
                votes = "0.0",
                genres = listOf("Teste"),
                productionCompaniesView = listOf()
            )
        )

        every { getMovieDetailUseCase.invoke(movieId) } returns flowOf(
            MovieDetailEntity(
                title = "Title",
                description = "Description",
                backdropPath = "https://image.tmdb.org/t/p/w500/teste.png",
                votes = 0.0f,
                genres = listOf("Teste"),
                productionCompanies = listOf()
            )
        )

        // When
        createViewModel()
        movieDetailViewModel.getMovieDetail(movieId)

        // Then
        assertEquals(expected, movieDetailViewModel.movieDetailState.value)
    }

    private fun createViewModel() {
        movieDetailViewModel = MovieDetailViewModel(
            getMovieDetailUseCase,
            testCoroutineDispatcher
        )
    }
}