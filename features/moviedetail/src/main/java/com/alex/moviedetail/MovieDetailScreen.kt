package com.alex.moviedetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.alex.components.AppBar
import com.alex.components.ImageItemComponent
import com.alex.components.MoviePosterBox
import com.alex.moviedetail.presentation.MovieView
import com.alex.moviedetail.presentation.ProductionCompaniesView

@Composable
internal fun DetailMovieScreen(
    movie: MovieView,
    navigateBack: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(bottom = 24.dp)
    ) {
        Box {
            MoviePosterBox(
                modifier = Modifier.height(500.dp),
                movieName = movie.title,
                movieImage = movie.backdropPath,
                movieRating = movie.votes
            )
            AppBar { navigateBack() }
        }
        Spacer(modifier = Modifier.height(18.dp))
        Column(
            modifier = Modifier.padding(start = 24.dp, bottom = 18.dp, end = 36.dp),
        ) {
            GenderList(movie.genres)
            MovieCastComponent(movie.productionCompaniesView)
            MovieSynopsisComponent(movie.description)
        }
    }

}

@Composable
private fun MovieCastComponent(
    productionCompaniesView: List<ProductionCompaniesView>
) {
    Spacer(modifier = Modifier.height(34.dp))
    Text(text = "PRODUCTION COMPANIES", fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(18.dp))
    CastList(productionCompaniesView)
}

@Composable
private fun CastList(
    productionCompaniesView: List<ProductionCompaniesView>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items = productionCompaniesView) {
            CastListItem(it)
        }
    }
}

@Composable
private fun CastListItem(
    productionCompaniesView: ProductionCompaniesView
) {
    Column {
        Box(modifier = Modifier
            .size(70.dp)
            .clip(CircleShape)) {
            ImageItemComponent(image = productionCompaniesView.logoPath)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp).size(60.dp),
            text = productionCompaniesView.name,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun MovieSynopsisComponent(synopsis: String) {
    Spacer(modifier = Modifier.height(34.dp))
    Text(text = "SYNOPSIS", fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(18.dp))
    Text(synopsis, maxLines = 6, overflow = TextOverflow.Ellipsis)
}

@Composable
private fun GenderList(genres: List<String>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items = genres) { genre ->
            GenderListItem(genre)
        }
    }
}

@Composable
private fun GenderListItem(genre: String) {
    Surface(
        modifier = Modifier.padding(end = 8.dp, bottom = 8.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
    ) {
        Row {
            Text(
                text = genre,
                style = MaterialTheme.typography.body2,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}