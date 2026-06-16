package com.sheepblue.devhub.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.sheepblue.devhub.ui.components.settings.SettingsLayout
import com.sheepblue.devhub.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(onBackClick: () -> Unit, viewModel: SettingsViewModel) {
    val isDarkMode by viewModel.isDarkMode.collectAsState(initial = false)
    // TODO: Preparar tela Settings para obter informações de rate-limit
    //  passando rate limit, rate reaming e etc
    val rateLimit by viewModel.rateLimit?.rateLimit

    SettingsLayout(
        onBackClick = { onBackClick() },
        checked = isDarkMode,
        onCheck = { viewModel.updateDarkMode(enabled = it) }
    )
}


@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsLayout(
        onBackClick = { },
        checked = true,
        onCheck = { }
    )
}
