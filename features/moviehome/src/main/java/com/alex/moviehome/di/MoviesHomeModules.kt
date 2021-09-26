package com.alex.moviehome.di

import com.alex.moviehome.data.datasource.MoviesRemoteDataSourceImpl
import com.alex.moviehome.data.repository.MovieRepositoryImpl
import com.alex.moviehome.data.service.MovieService
import com.alex.moviehome.domain.usecase.GetNowPlayingMoviesUseCase
import com.alex.moviehome.presentation.MoviesViewModel
import com.alex.network.ServiceFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class MoviesHomeModules {
    private val presentationModules = module {
        viewModel {
            MoviesViewModel(
                getNowPlayingMoviesUseCase = GetNowPlayingMoviesUseCase(
                    movieRepository = MovieRepositoryImpl(
                        movieDataSource = MoviesRemoteDataSourceImpl(
                            movieService = get<ServiceFactory>().create(MovieService::class.java)
                        )
                    )
                )
            )
        }
    }

    fun loadModules() {
        loadKoinModules(
            presentationModules
        )
    }
}