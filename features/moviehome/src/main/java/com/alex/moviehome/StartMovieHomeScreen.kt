package com.alex.moviehome

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.alex.moviehome.presentation.MoviesViewModel
import com.alex.navigation.Screen
import org.koin.androidx.compose.getViewModel

@Composable
internal fun StartMovieHomeScreen(
    navController: NavController
) {
    val viewModel = getViewModel<MoviesViewModel>()
    val state = viewModel.moviesState.value

    MainMovieScreen(
        movieList = state.movieList,
        selectedItem = {
            navController.navigate(Screen.MovieDetail.createRouter(it.toString()))
        },
        onSearch = {
            viewModel.search(it)
        }
    )
}