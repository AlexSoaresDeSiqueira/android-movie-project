package com.alex.navigation

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object MovieDetail : Screen("movieDetail?movieId={movieId}") {
        fun createRouter(movieId: String) = "movieDetail?movieId=$movieId"
    }
}