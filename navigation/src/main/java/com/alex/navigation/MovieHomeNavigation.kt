package com.alex.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface MovieHomeNavigation {
    fun createRouter(navController: NavHostController, navGraphBuilder: NavGraphBuilder)
}