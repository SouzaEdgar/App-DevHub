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
import androidx.compose.ui.draw.alpha
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
        Spacer(modifier = Modifier.height(52.dp))
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
                    .background(color = MaterialTheme.colorScheme.surface)
                    .padding(horizontal = 20.dp)
            ) {
                ThemeSelector(
                    checked = checked,
                    onCheck = { onCheck(it) }
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
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

            if(rateLimit?.used != null) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(size = 24.dp))
                        .background(color = MaterialTheme.colorScheme.surface)
                        .padding(horizontal = 20.dp, vertical = 18.dp)
                ) {
                    Column {
                        SettingsInfoRowAPI(
                            info = "Limite:",
                            result = "${rateLimit.limit ?: "-"}",
                        )
                        SettingsInfoRowAPI(
                            info = "Restantes:",
                            result = "${rateLimit.remaining ?: "-"}",
                        )
                        SettingsInfoRowAPI(
                            info = "Utilizado:",
                            result = "${rateLimit.used ?: "-"}",
                        )
                        SettingsInfoRowAPI(
                            info = "Reset:",
                            result = convertToMinute(rateLimit.reset),
                        )
                    }
                }
                Text(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    text = "• Valores atualizados a cada busca realizada\n" +
                            "• Cada busca utiliza 2 requisições",
                    color = Color.Gray,
                    fontSize = 12.sp,
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(size = 24.dp))
                        .background(color = MaterialTheme.colorScheme.surface)
                        .padding(horizontal = 20.dp, vertical = 18.dp)
                ) {
                    Column {
                        Text(
                            text = "Faça uma busca para obter resultados",
                            modifier = Modifier.alpha(0.6f)
                        )
                    }
                }
            }
        }
    }
}

fun convertToMinute(num: Long?): String {
    if (num != null) {
        // Joga os dois para segundos (api ja retorna em segundso) e depois converte para minuto
        val minutes = (num - System.currentTimeMillis()/1000) / 60
        return "$minutes minutos"
    }
    return "-"
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
                    reset = 1782524476.toLong(),
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
                rateLimit = null
            )

        }
    }
}
