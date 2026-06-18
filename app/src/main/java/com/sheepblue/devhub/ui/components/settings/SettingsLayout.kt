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
import com.sheepblue.devhub.data.remote.model.GitHubRateLimit
import com.sheepblue.devhub.ui.components.common.BackButton
import com.sheepblue.devhub.ui.theme.DevHubTheme

@Composable
fun SettingsLayout(
    onBackClick: () -> Unit,
    checked: Boolean,
    onCheck: (Boolean) -> Unit,
    rateLimit: GitHubRateLimit?
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
            Text(text = "Limite: ${rateLimit?.limit ?: "vazio"}")
            Text(text = "Restantes: ${rateLimit?.remaining ?: "vazio"}")
            Text(text = "Reset: ${rateLimit?.reset ?: "vazio"}")
            Text(text = "Utilizado: ${rateLimit?.used ?: "vazio"}")
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
        rateLimit = null
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
                rateLimit = GitHubRateLimit(
                    limit = null,
                    remaining = 0,
                    reset = 172390.toLong(),
                    used = null
                )
            )

        }
    }
}
