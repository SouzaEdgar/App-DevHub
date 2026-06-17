package com.sheepblue.devhub.ui.components.settings

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sheepblue.devhub.ui.components.common.BackButton
import com.sheepblue.devhub.ui.theme.DevHubTheme

@Composable
fun SettingsLayout(
    onBackClick: () -> Unit,
    checked: Boolean,
    onCheck: (Boolean) -> Unit,
    rateLimit: List<Long?> // TODO: preparar para trabalhar com objeto GitHubRateLimit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        BackButton { onBackClick() }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            ThemeSelector(
                checked = checked,
                onCheck = { onCheck(it) }
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Requisição da API")
            Text(text = "Limite: ${rateLimit[0] ?: "vazio"}")
            Text(text = "Restantes: ${rateLimit[1] ?: "vazio"}")
            Text(text = "Reset: ${rateLimit[2] ?: "vazio"}")
            Text(text = "Utilizado: ${rateLimit[3] ?: "vazio"}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsLayoutPreview() {
    SettingsLayout(
        onBackClick = {},
        checked = false,
        onCheck = {},
        rateLimit = listOf(10.toLong(), null, 3.toLong(), 7.toLong())
    )
}
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SettingsLayoutDarkPreview() {
    DevHubTheme{
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            SettingsLayout(
                onBackClick = {},
                checked = true,
                onCheck = {},
                rateLimit = listOf(null, null, 3.toLong(), 7.toLong())
            )

        }
    }
}
