package com.alex.moviedetail.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.moviedetail.domain.usecase.GetMovieDetailUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

internal class MovieDetailViewModel(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    var movieDetailState = mutableStateOf(MovieDetailViewState())
        private set

    var movieDetailAction = mutableStateOf<MovieDetailViewAction>(MovieDetailViewAction.Default)
        private set

    fun getMovieDetail(movieId: Long) {
        viewModelScope.launch {
            getMovieDetailUseCase(movieId)
                .flowOn(dispatcher)
                .onStart { movieDetailAction.value = MovieDetailViewAction.ShowLoading }
                .catch {  }
                .onCompletion { movieDetailAction.value = MovieDetailViewAction.HideLoading }
                .collect { entity ->
                    val movieView = MovieView(
                        title = entity.title,
                        description = entity.description,
                        backdropPath = entity.backdropPath,
                        votes = entity.votes.toString(),
                        genres = entity.genres,
                        productionCompaniesView = entity.productionCompanies.map {
                            ProductionCompaniesView(
                                name = it.name, logoPath = it.logoPath
                            )
                        }
                    )
                    movieDetailState.value = movieDetailState.value.copy(
                        movieData = movieView
                    )
                }
        }
    }
}