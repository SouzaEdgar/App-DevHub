package com.sheepblue.devhub.ui.components.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max

@Composable
fun SettingsInfoRowAPI(
    info: String,
    result: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = info,
            maxLines = 1
        )
        Text(
            text = result,
            textAlign = TextAlign.End,
            maxLines = 1
        )
    }
    HorizontalDivider(
        modifier = Modifier
            .padding(bottom = 8.dp),
        color = MaterialTheme.colorScheme.onBackground,
        thickness = 1.dp
    )
    Spacer(modifier = Modifier.height(10.dp))
}

@Preview
@Composable
fun InfoRowPreview() {
    Column {
        SettingsInfoRowAPI(
            info = "Limite",
            result = "128397"
        )
        SettingsInfoRowAPI(
            info = "Reset",
            result = "vazio"
        )
        SettingsInfoRowAPI(
            info = "Restantes",
            result = "12"
        )
    }
}
