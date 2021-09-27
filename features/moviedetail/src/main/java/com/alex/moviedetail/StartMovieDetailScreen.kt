package com.alex.moviedetail

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.alex.moviedetail.presentation.MovieDetailViewModel
import com.alex.navigation.Screen
import org.koin.androidx.compose.getViewModel

@Composable
internal fun StartMovieDetailScreen(navController: NavController, movieId: String) {
    val viewModel = getViewModel<MovieDetailViewModel>()
    val state = viewModel.movieDetailState.value

    viewModel.getMovieDetail(movieId.toLong())

    DetailMovieScreen(
        movie = state.movieData,
        navigateBack = {
            navController.navigate(Screen.Main.route) {
                popUpTo(Screen.Main.route) {
                    inclusive = true
                }
            }
        }
    )
}