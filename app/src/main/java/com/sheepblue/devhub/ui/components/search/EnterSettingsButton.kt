package com.sheepblue.devhub.ui.components.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sheepblue.devhub.R
import com.sheepblue.devhub.ui.theme.DevHubTheme

@Composable
fun EnterSettingsButton(onClick: () -> Unit) {
        Box(
            modifier = Modifier
                .padding(top = 15.dp, end = 15.dp)
                .clip(CircleShape)
                .clickable(enabled = true, onClick = onClick)
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_settings_24),
                contentDescription = "Botão de opções",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(size = 50.dp)
                    .align(alignment = Alignment.Center)
            )
        }
}

@Preview(showBackground = true)
@Composable
fun EnterSettingsButtonPreview() {
    DevHubTheme{
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            EnterSettingsButton(onClick = {})
        }
    }
}

