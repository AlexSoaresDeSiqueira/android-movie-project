package com.alex.moviehome

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.alex.moviehome.presentation.MoviesView
import org.junit.Rule
import org.junit.Test

class MovieHomeScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun openMovieHomeScreen_shouldShowMovieList() {
        composeTestRule.setContent {
            MainMovieScreen(
                movieList = listOf(MoviesView(
                    id = 0, title = "Title", posterPath = "", votes = "6,9"
                )),
                selectedItem = {},
                onSearch = {}
            )
        }

        composeTestRule.onNodeWithText("Title").assertIsDisplayed()
        composeTestRule.onNodeWithText("6,9").assertIsDisplayed()
    }
}