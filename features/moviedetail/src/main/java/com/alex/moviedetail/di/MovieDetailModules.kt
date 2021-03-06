package com.alex.moviedetail.di

import com.alex.moviedetail.data.datasource.MovieDetailRemoteDataSourceImpl
import com.alex.moviedetail.data.repository.MovieDetailRepositoryImpl
import com.alex.moviedetail.data.service.MovieDetailService
import com.alex.moviedetail.domain.usecase.GetMovieDetailUseCase
import com.alex.moviedetail.navigation.MovieDetailNavigationImpl
import com.alex.moviedetail.presentation.MovieDetailViewModel
import com.alex.navigation.MovieDetailNavigation
import com.alex.network.ServiceFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class MovieDetailModules {

    private val dataModules = module {
        factory { get<ServiceFactory>().create(MovieDetailService::class.java) }
    }

    private val presentationModules = module {
        viewModel {
            MovieDetailViewModel(
                getMovieDetailUseCase = GetMovieDetailUseCase(
                    movieRepository = MovieDetailRepositoryImpl(
                        movieDataSource = MovieDetailRemoteDataSourceImpl(
                            movieService = get()
                        )
                    )
                )
            )
        }

        factory<MovieDetailNavigation>{
            MovieDetailNavigationImpl()
        }
    }

    fun loadModules() {
        loadKoinModules(
            dataModules + presentationModules
        )
    }
}