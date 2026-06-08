package com.sheepblue.devhub.ui.components.settings

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sheepblue.devhub.ui.components.common.BackButton
import com.sheepblue.devhub.ui.theme.DevHubTheme

@Composable
fun SettingsLayout(onBackClick: () -> Unit, checked: Boolean, onCheck: (Boolean) -> Unit) {
    Column() {
        BackButton { onBackClick() }
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            ThemeSelector(
                checked = checked,
                onCheck = { onCheck(it) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsLayoutPreview() {
    SettingsLayout(
        onBackClick = {},
        checked = false,
        onCheck = {}
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
                checked = false,
                onCheck = {}
            )

        }
    }
}
