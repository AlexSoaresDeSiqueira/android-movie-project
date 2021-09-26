package com.alex.moviedetail

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.alex.moviedetail.presentation.MovieView
import org.junit.Rule
import org.junit.Test

class MovieDetailScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun openMovieDetailScreen_shouldShowMovieData() {
        composeTestRule.setContent {
            DetailMovieScreen(
                movie = MovieView(
                    title = "Kate",
                    description = "Some Synopsis here",
                    backdropPath = "",
                    votes = "6,8",
                    genres = listOf("Action", "Thriller"),
                    productionCompaniesView = listOf()
                ),
                navigateBack = { }
            )
        }

        composeTestRule.onNodeWithText("Kate").assertIsDisplayed()
        composeTestRule.onNodeWithText("6,8").assertIsDisplayed()
        composeTestRule.onNodeWithText("Action").assertIsDisplayed()
        composeTestRule.onNodeWithText("Thriller").assertIsDisplayed()
        composeTestRule.onNodeWithText("Some Synopsis here").assertIsDisplayed()
    }
}