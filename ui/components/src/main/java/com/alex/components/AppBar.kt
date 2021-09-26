package com.alex.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    backPressed: () -> Unit
) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { backPressed() }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
            }
        },
        title = {
            Text(text = "")
        },
        backgroundColor = Color.Transparent
    )
}