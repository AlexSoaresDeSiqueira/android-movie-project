package com.alex.moviehome.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.alex.moviehome.StartMovieHomeScreen
import com.alex.navigation.MovieHomeNavigation
import com.alex.navigation.Screen

internal class MovieHomeNavigationImpl : MovieHomeNavigation {
    override fun createRouter(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.composable(Screen.Main.route) { StartMovieHomeScreen(navController) }
    }
}