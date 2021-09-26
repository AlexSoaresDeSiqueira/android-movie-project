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
import androidx.navigation.NavController
import com.alex.components.AppBar
import com.alex.components.ImageItemComponent
import com.alex.components.MoviePosterBox
import com.alex.navigation.Screen

@Composable
fun DetailMovieScreen(navController: NavController, name: String) {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(bottom = 24.dp)
    ) {
        Box {
            MoviePosterBox(modifier = Modifier.height(500.dp), movieName = name)
            AppBar {
                navController.navigate(Screen.Main.route) {
                    popUpTo(Screen.Main.route) {
                        inclusive = true
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
        Column(
            modifier = Modifier.padding(start = 24.dp, bottom = 18.dp, end = 36.dp),
        ) {
            GenderList()
            MovieCastComponent()
            MovieSynopsisComponent()
        }
    }

}

@Composable
private fun MovieCastComponent() {
    Spacer(modifier = Modifier.height(34.dp))
    Text(text = "CAST", fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(18.dp))
    CastList()
}

@Composable
private fun CastList() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(4) {
            CastListItem()
        }
    }
}

@Composable
private fun CastListItem() {
    Column {
        Box(modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)) {
            ImageItemComponent()
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp).size(80.dp),
            text = "Hello Compose",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
private fun MovieSynopsisComponent() {
    Spacer(modifier = Modifier.height(34.dp))
    Text(text = "SYNOPSIS", fontWeight = FontWeight.Bold)
    Spacer(modifier = Modifier.height(18.dp))
    Text("Hello Compose ".repeat(50), maxLines = 6, overflow = TextOverflow.Ellipsis)
}

@Composable
private fun GenderList() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(4) {
            GenderListItem()
        }
    }
}

@Composable
private fun GenderListItem() {
    Surface(
        modifier = Modifier.padding(end = 8.dp, bottom = 8.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
    ) {
        Row {
            Text(
                text = "Action",
                style = MaterialTheme.typography.body2,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}