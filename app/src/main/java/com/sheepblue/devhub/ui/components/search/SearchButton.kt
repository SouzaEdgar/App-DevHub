package com.sheepblue.devhub.ui.components.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchButton(onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(horizontal = 50.dp, vertical = 5.dp),
        onClick = { onClick() }
    ) {
        Text(
            text = "Buscar",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            )
    }
}


@Preview(showBackground = true)
@Composable
fun SearchButtonPreview() {
    SearchButton(
        onClick = {}
    )
}