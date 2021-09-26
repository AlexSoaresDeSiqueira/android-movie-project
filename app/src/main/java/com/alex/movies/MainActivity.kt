package com.alex.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.alex.moviedetail.DetailMovieScreen
import com.alex.moviehome.MainMovieScreen
import com.alex.movies.ui.theme.MoviescomposeTheme
import com.alex.navigation.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviescomposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CreateNavigation()
                }
            }
        }
    }
}

@Composable
fun CreateNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        mainRouterComposable(navController)
        movieDetailComposable(navController)
    }
}

private fun NavGraphBuilder.movieDetailComposable(navController: NavHostController) {
    composable(
        Screen.MovieDetail.route,
        arguments = listOf(
            navArgument("movieId") { defaultValue = "" })
    ) { backstack ->
        DetailMovieScreen(navController, backstack.arguments?.getString("movieId").toString())
    }
}

private fun NavGraphBuilder.mainRouterComposable(navController: NavHostController) {
    composable(Screen.Main.route) { MainMovieScreen("", navController) }
}