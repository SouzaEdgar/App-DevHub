package com.sheepblue.devhub.ui.components.settings

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        // HEADER
        Box(
            modifier = Modifier.fillMaxWidth()
        ){
            BackButton { onBackClick() }
            Box(
                modifier = Modifier.align(Alignment.Center),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    modifier = Modifier.padding(top = 14.dp),
                    text = "Opções",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
        HorizontalDivider(modifier = Modifier.fillMaxWidth(), thickness = 0.5.dp)
        Spacer(modifier = Modifier.height(42.dp))
        // ESCOLHA DO TEMA
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, end = 14.dp)
        ) {
            Text(
                modifier = Modifier.padding(start = 18.dp),
                text = "Tema",
                color = Color.Gray,
                fontSize = 14.sp,
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(size = 24.dp))
                    .background(Color(0xFF474747))
                    .padding(horizontal = 20.dp)
            ) {
                ThemeSelector(
                    checked = checked,
                    onCheck = { onCheck(it) }
                )
            }
        }
        Spacer(modifier = Modifier.height(22.dp))
        // INFO API
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, end = 14.dp)
        ) {
            Text(
                modifier = Modifier.padding(start = 18.dp),
                text = "Requisições da API",
                color = Color.Gray,
                fontSize = 14.sp,
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(size = 24.dp))
                    .background(Color(0xFF474747))
                    .padding(horizontal = 20.dp, vertical = 18.dp)
            ) {
                Column {
                    SettingsInfoRowAPI(
                        info = "Limite:",
                        result = "${rateLimit?.limit ?: "vazio"}",
                    )
                    SettingsInfoRowAPI(
                        info = "Restantes:",
                        result = "${rateLimit?.remaining ?: "vazio"}",
                    )
                    SettingsInfoRowAPI(
                        info = "Reset:",
                        result = "${rateLimit?.reset ?: "vazio"}",
                    )
                    SettingsInfoRowAPI(
                        info = "Utilizado:",
                        result = "${rateLimit?.used ?: "vazio"}",
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsLayoutPreview() {
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
