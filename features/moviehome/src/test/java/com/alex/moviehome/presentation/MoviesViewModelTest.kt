package com.alex.moviehome.presentation

import com.alex.moviehome.domain.usecase.GetNowPlayingMoviesUseCase
import io.mockk.mockk

class MoviesViewModelTest {

    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase = mockk()

    private val moviesViewModel = MoviesViewModel(
        getNowPlayingMoviesUseCase
    )
}