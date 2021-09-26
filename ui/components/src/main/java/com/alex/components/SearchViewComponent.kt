package com.alex.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchViewComponent(
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