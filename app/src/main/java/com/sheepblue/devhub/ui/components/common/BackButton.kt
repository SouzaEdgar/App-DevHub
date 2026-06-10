package com.sheepblue.devhub.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sheepblue.devhub.R

@Composable
fun BackButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(top = 15.dp, start = 12.dp)
            .size(58.dp)
            .clip(CircleShape)
            .clickable(enabled = true, onClick = onClick)
    ) {
        Icon(
            painter = painterResource(R.drawable.outline_arrow_back_24),
            contentDescription = "Botão de voltar",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .size(size = 40.dp)
                .align(alignment = Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BackButtonPreview() {
    Box(modifier = Modifier.fillMaxSize().background(color = Color.DarkGray)) {
        BackButton(onClick = {})
    }
}
