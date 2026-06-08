package com.sheepblue.devhub.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.sheepblue.devhub.ui.components.settings.SettingsLayout

@Composable
fun SettingsScreen(onBackClick: () -> Unit) {
    var checked by remember { mutableStateOf(true) }

    SettingsLayout(
        onBackClick = { onBackClick() },
        checked = checked,
        onCheck = { checked = it }
    )
}


@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(onBackClick = {})
}
