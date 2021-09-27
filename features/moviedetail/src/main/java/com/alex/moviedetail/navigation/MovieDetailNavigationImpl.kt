package com.alex.moviedetail.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.alex.moviedetail.StartMovieDetailScreen
import com.alex.navigation.MovieDetailNavigation
import com.alex.navigation.Screen

internal class MovieDetailNavigationImpl : MovieDetailNavigation {
    override fun createRouter(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable(
            Screen.MovieDetail.route,
            arguments = listOf(
                navArgument("movieId") { defaultValue = "" })
        ) { backstack ->
            StartMovieDetailScreen(navController, backstack.arguments?.getString("movieId") ?: "0")
        }
    }
}