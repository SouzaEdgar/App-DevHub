package com.sheepblue.devhub.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sheepblue.devhub.R

@Composable
fun BackButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Icon(
        painter = painterResource(R.drawable.outline_arrow_back_24),
        contentDescription = "Botão de voltar",
        tint = MaterialTheme.colorScheme.background,
        modifier = modifier
            .clickable(enabled = true, onClick = onClick, )
    )
}

@Preview(showBackground = true)
@Composable
fun BackButtonPreview() {
    Box(modifier = Modifier.size(60.dp).background(color = Color.DarkGray)) {
        BackButton(onClick = {})
    }
}
