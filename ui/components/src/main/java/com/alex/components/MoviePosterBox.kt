package com.alex.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MoviePosterBox(
    modifier: Modifier = Modifier.height(500.dp),
    movieName: String
) {
    Box(
        modifier = modifier
    ) {
        ImageItemComponent()
        ItemGradientBackground()
        MovieItemTextBox(movieName)
    }
}