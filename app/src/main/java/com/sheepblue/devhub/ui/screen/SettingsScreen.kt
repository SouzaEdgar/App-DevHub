package com.sheepblue.devhub.ui.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.sheepblue.devhub.ui.components.settings.SettingsLayout
import com.sheepblue.devhub.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(onBackClick: () -> Unit, viewModel: SettingsViewModel) {
    val isDarkMode by viewModel.isDarkMode.collectAsState(initial = false)

    val userResponse by viewModel.currentResponse.collectAsState(initial = null)
    Log.d("API", "SettingsScreen: userRateLimit >> ${userResponse?.rateLimit}")


    SettingsLayout(
        onBackClick = { onBackClick() },
        checked = isDarkMode,
        onCheck = { viewModel.updateDarkMode(enabled = it) },
        rateLimit = userResponse?.rateLimit
    )
}


@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsLayout(
        onBackClick = { },
        checked = true,
        onCheck = { },
        rateLimit = null
    )
}
