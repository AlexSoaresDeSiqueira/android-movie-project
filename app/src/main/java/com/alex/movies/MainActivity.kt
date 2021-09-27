package com.alex.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.alex.movies.ui.theme.MoviescomposeTheme
import com.alex.navigation.MovieDetailNavigation
import com.alex.navigation.MovieHomeNavigation
import com.alex.navigation.Screen
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val movieHomeNavigation: MovieHomeNavigation by inject()
    private val movieDetailNavigation: MovieDetailNavigation by inject()

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

    @Composable
    fun CreateNavigation() {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screen.Main.route
        ) {
            movieHomeNavigation.createRouter(navController, this)
            movieDetailNavigation.createRouter(navController, this)
        }
    }
}