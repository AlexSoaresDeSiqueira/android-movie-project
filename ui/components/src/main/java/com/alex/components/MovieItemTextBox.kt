package com.alex.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieItemTextBox(name: String) {
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