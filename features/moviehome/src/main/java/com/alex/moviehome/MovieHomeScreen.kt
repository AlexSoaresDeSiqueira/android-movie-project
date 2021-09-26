package com.alex.moviehome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alex.components.MoviePosterBox
import com.alex.components.SearchViewComponent
import com.alex.moviehome.presentation.MoviesView
import com.alex.navigation.Screen

@Composable
internal fun MainMovieScreen(
    movieList: List<MoviesView>,
    selectedItem: (Long) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        SearchViewComponent(
            modifier = Modifier.padding(end = 20.dp, start = 20.dp),
            onSearch = { }
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Now Playing",
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            textAlign = TextAlign.Start,
            fontSize = 34.sp
        )
        MovieList(movieList, selectedItem)
    }
}

@Composable
private fun MovieList(
    movieList: List<MoviesView>,
    selectedItem: (Long) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items = movieList) { movie ->
            MovieListItem(movie, selectedItem)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun MovieListItem(movieView: MoviesView, selectedItem: (Long) -> Unit) {
    Card(
        modifier = Modifier
            .width(320.dp)
            .padding(14.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp,
        onClick = { selectedItem(movieView.id) }
    ) {
        MoviePosterBox(
            movieName = movieView.title,
            movieRating = movieView.votes,
            movieImage = movieView.posterPath
        )
    }
}