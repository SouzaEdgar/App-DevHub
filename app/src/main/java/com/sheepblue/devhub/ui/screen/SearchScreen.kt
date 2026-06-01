package com.sheepblue.devhub.ui.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.sheepblue.devhub.ui.components.search.SearchTextField

@Composable
fun SearchScreen() {
    var userName by remember { mutableStateOf("") }

    SearchTextField(
        text = userName,
        onTextChange = {
            userName = it
            Log.d("Search", "Buscou: $userName")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}

