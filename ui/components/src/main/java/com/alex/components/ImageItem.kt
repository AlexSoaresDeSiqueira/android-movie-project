package com.alex.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ImageItemComponent() {
    val painter = rememberImagePainter(
        data = "https://i.ytimg.com/vi/ePpJDKfRAyM/movieposter.jpg",
        builder = {
            crossfade(1000)
        }
    )
    val painterState = painter.state
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painter,
        contentDescription = "Movie Poster",
        contentScale = ContentScale.Crop
    )
    if (painterState is ImagePainter.State.Loading) {
        CircularProgressIndicator()
    }
}
