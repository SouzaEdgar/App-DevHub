package com.sheepblue.devhub.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sheepblue.devhub.ui.theme.DevHubTheme

@Composable
fun UserLoading() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box( // Background
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(
                    Color.DarkGray,
                    shape = RoundedCornerShape(
                        bottomStart = 22.dp,
                        bottomEnd = 22.dp
                    )
                )
        ) {
            Box(modifier = Modifier
                    .size(160.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = 120.dp/2)
                    .background(Color.LightGray, shape = CircleShape)
                    .clip(CircleShape)

            ) // Avatar
        }
        Spacer(modifier = Modifier.height(180.dp / 2))
        Box(modifier = Modifier
                .height(50.dp)
                .width(250.dp)
                .padding(bottom = 20.dp)
                .background(Color.Red, shape = RoundedCornerShape(8.dp))
                .clip(shape = RoundedCornerShape(8.dp))
        ) // Nome
        Box(modifier = Modifier
            .height(30.dp)
            .width(170.dp)
            .background(Color.Blue, shape = RoundedCornerShape(8.dp))
            .clip(shape = RoundedCornerShape(8.dp))
        ) // Login
        Box(modifier = Modifier
            .height(60.dp)
            .width(250.dp)
            .padding(top = 20.dp)
            .background(Color.Green, shape = RoundedCornerShape(8.dp))
            .clip(shape = RoundedCornerShape(8.dp))
        ) // Bio
        Spacer(modifier = Modifier.height(70.dp / 2))

        // TODO: Ao inves de 3 cards montados manualmente, passar apenas 1 no repeat
        repeat(3) {
            Card(
                modifier = Modifier.padding(16.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent)
            ) {
                Column {
                    Box(modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                        .background(Color.Magenta, shape = RoundedCornerShape(8.dp))
                        .clip(shape = RoundedCornerShape(8.dp))
                    ) // Titulo da repo
                    Box(modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(Color.Yellow, shape = RoundedCornerShape(8.dp))
                        .clip(shape = RoundedCornerShape(8.dp))) // Descrição da repo
                }
            }
        }
    }
}

@Preview(
    name = "Light",
    showBackground = true
)
@Composable
fun UserLoadingPreview() {
    DevHubTheme{
        UserLoading()
    }
}

@Preview(
    name = "Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun UserLoadingDarkPreview() {
    DevHubTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            UserLoading()
        }
    }
}

