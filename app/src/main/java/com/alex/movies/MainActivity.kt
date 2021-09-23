package com.alex.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.alex.movies.ui.theme.MoviescomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviescomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        SearchView(
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
        MovieList(name)
    }
}

@Composable
private fun MovieList(name: String) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(10) {
            MovieListItem(name)
        }
    }
}

@Composable
private fun MovieListItem(name: String) {
    Card(
        modifier = Modifier
            .width(320.dp)
            .padding(14.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier.height(500.dp)
        ) {
            MovieListItemImage()
            MovieListItemGradientBackground()
            MovieListItemTextBox(name)
        }
    }
}

@Composable
private fun MovieListItemTextBox(name: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, bottom = 18.dp, end = 36.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = "Hello $name!",
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row {
            Icon(Icons.Rounded.Star, contentDescription = null, tint = Color.Yellow)
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "8.9",
                color = Color.Yellow,
                fontSize = 24.sp
            )
        }
    }
}

@Composable
private fun MovieListItemGradientBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black),
                    startY = 60f
                )
            )
    )
}

@Composable
private fun MovieListItemImage() {
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

@Composable
private fun SearchView(
    modifier: Modifier,
    onSearch: (String) -> Unit
) {
    val searchCounter = remember { mutableStateOf("") }

    Box(modifier = modifier) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    AbsoluteRoundedCornerShape(14.dp)
                ),
            value = searchCounter.value,
            onValueChange = {
                searchCounter.value = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Gray.copy(alpha = 0.1f),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            label = {
                Text(text = "Search")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null,
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoviescomposeTheme {
        Greeting("Android")
    }
}