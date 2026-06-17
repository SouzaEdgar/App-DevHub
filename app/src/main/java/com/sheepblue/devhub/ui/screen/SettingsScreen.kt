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
    // TODO: Começar a OBSERVAR a viewmodel (talvez collectAsState com null
    //  Trocar userRateLimit pelo objeto direto mesmo, passar o GitHubRateLimit? facilitando a leitura

    val currentRateLimit = viewModel.rateLimit

    // Valores sobre rate limit podendo ser nulo
    val limit = currentRateLimit?.limit
    val remaining = currentRateLimit?.remaining
    val reset = currentRateLimit?.reset
    val used = currentRateLimit?.used

    val userRateLimit = listOf(limit, remaining, reset, used)

    SettingsLayout(
        onBackClick = { onBackClick() },
        checked = isDarkMode,
        onCheck = { viewModel.updateDarkMode(enabled = it) },
        rateLimit = userRateLimit
    )
}


@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsLayout(
        onBackClick = { },
        checked = true,
        onCheck = { },
        rateLimit = emptyList()
    )
}
