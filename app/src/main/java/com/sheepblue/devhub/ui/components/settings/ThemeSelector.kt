package com.sheepblue.devhub.ui.components.settings

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.sheepblue.devhub.R
import com.sheepblue.devhub.ui.theme.DevHubTheme

@Composable
fun ThemeSelector(checked: Boolean, onCheck: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Modo Escuro",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Switch(

            checked = checked,
            onCheckedChange = { onCheck(it) },
//            colors = SwitchDefaults.colors(
//                checkedThumbColor = MaterialTheme.colorScheme.primaryContainer,
//                checkedTrackColor = MaterialTheme.colorScheme.primary,
//                uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
//                uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer
//            ),
            thumbContent = if (checked) {
                {
                    Icon(
                        painter = painterResource(R.drawable.outline_moon_stars_24),
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize)
                    )
                }
            } else {
                {
                    Icon(
                        painter = painterResource(R.drawable.outline_wb_sunny_24),
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize)
                    )
                }
            }
        )
    }
}




@Preview(showBackground = true)
@Composable
fun ThemeSelectorPreview() {
    DevHubTheme {
        ThemeSelector(
            checked = true,
            onCheck = {}
        )
    }
}

@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ThemeSelectorDarkPreview() {
    DevHubTheme {
        Surface(
            //modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ThemeSelector(
                checked = false,
                onCheck = {}
            )
        }
    }
}
