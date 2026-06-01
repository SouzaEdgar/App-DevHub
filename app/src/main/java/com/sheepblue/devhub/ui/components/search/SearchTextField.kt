package com.sheepblue.devhub.ui.components.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchTextField(
    text: String,
    onTextChange: (String) -> Unit
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,

            label = {
                Text("Github User")
            },

            placeholder = {
                Text("Digite um usuário")
            },

            singleLine = true,

            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(40.dp))
        SearchButton() { run {} }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    var userName by remember { mutableStateOf("") }
    SearchTextField(
        text = userName,
        onTextChange = {
            userName = it
        }
    )
}
