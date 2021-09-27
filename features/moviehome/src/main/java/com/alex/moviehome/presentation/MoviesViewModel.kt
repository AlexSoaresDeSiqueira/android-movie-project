package com.alex.moviehome.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.moviehome.domain.entity.MovieEntity
import com.alex.moviehome.domain.usecase.GetNowPlayingMoviesUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

private const val FIRST_PAGE_INDEX = 1

internal class MoviesViewModel(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val originalMovieListView = mutableListOf<MoviesView>()

    var moviesState = mutableStateOf(MoviesViewState())
        private set

    var moviesAction = mutableStateOf<MoviesViewAction>(MoviesViewAction.Default)
        private set

    init {
        getNowPlayingMovies()
    }

    fun getNowPlayingMovies() {
        viewModelScope.launch {
            getNowPlayingMoviesUseCase(FIRST_PAGE_INDEX)
                .flowOn(dispatcher)
                .onStart { moviesAction.value = MoviesViewAction.ShowLoading }
                .catch {  }
                .onCompletion { moviesAction.value = MoviesViewAction.HideLoading }
                .collect { moviesEntity ->
                    val moviesView = mapMovieEntityToView(moviesEntity)
                    updateControlMovieListView(moviesView)
                    updateMovieListState(moviesView)
                }
        }
    }

    fun search(movieName: String) {
        val findMovies: List<MoviesView> = originalMovieListView.filter {
            it.title.contains(movieName, ignoreCase = true)
        }
        updateMovieListState(
            if (movieName.isEmpty() && findMovies.isEmpty()) originalMovieListView
            else findMovies
        )
    }

    private fun updateMovieListState(moviesView: List<MoviesView>) {
        moviesState.value = moviesState.value.copy(movieList = moviesView)
    }

    private fun mapMovieEntityToView(moviesEntity: List<MovieEntity>): List<MoviesView> {
        val moviesView = moviesEntity.map {
            MoviesView(
                id = it.id,
                title = it.title,
                posterPath = it.posterPath,
                votes = it.votes.toString()
            )
        }
        return moviesView
    }

    private fun updateControlMovieListView(moviesView: List<MoviesView>) {
        originalMovieListView.clear()
        originalMovieListView.addAll(moviesView)
    }
}