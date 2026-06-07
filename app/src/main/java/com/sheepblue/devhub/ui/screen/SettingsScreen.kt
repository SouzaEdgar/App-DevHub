package com.sheepblue.devhub.ui.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sheepblue.devhub.ui.components.settings.ThemeSelector

@Composable
fun SettingsScreen() {
    var checked by remember { mutableStateOf(true) }

    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        ThemeSelector(
            checked = checked,
            onCheck = {checked = it}
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}
