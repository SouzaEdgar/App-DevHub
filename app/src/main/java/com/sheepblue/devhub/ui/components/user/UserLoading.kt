package com.sheepblue.devhub.ui.components.user

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sheepblue.devhub.ui.theme.DevHubTheme

@Composable
fun UserLoading() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val infiniteTransition = rememberInfiniteTransition(label = "infiniteTransition")

        val localConfig = LocalConfiguration.current
        val target = (localConfig.screenWidthDp * 4).toFloat()
        val scale by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = target,
            animationSpec = infiniteRepeatable(
                animation = tween(1000)
            ), label = "shimmer"
        )

        val skeletonColor = Brush.linearGradient(
            colors = listOf(
                Color.Gray.copy(alpha = 0.6f),
                Color.Gray.copy(alpha = 0.3f),
                Color.Gray.copy(alpha = 0.6f)
            ),
            end = Offset(x = scale, y = scale)
        )


        Box( // Background
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
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
                .background(MaterialTheme.colorScheme.background, shape = CircleShape)
                .clip(CircleShape)
            ) // Avatar background
            Box(modifier = Modifier
                    .size(160.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = 120.dp/2)
                    .background(skeletonColor, shape = CircleShape)
                    .clip(CircleShape)
            ) // Avatar
        }
        Spacer(modifier = Modifier.height(180.dp / 2))
        Box(modifier = Modifier
                .height(50.dp)
                .width(250.dp)
                .padding(bottom = 20.dp)
                .background(skeletonColor, shape = RoundedCornerShape(8.dp))
                .clip(shape = RoundedCornerShape(8.dp))
        ) // Nome
        Box(modifier = Modifier
            .height(30.dp)
            .width(170.dp)
            .background(skeletonColor, shape = RoundedCornerShape(8.dp))
            .clip(shape = RoundedCornerShape(8.dp))
        ) // Login
        Box(modifier = Modifier
            .height(60.dp)
            .width(250.dp)
            .padding(top = 20.dp)
            .background(skeletonColor, shape = RoundedCornerShape(8.dp))
            .clip(shape = RoundedCornerShape(8.dp))
        ) // Bio
        Spacer(modifier = Modifier.height(70.dp / 2))

        repeat(3) {
            Card(
                modifier = Modifier.padding(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent)
            ) {
                Column {
                    Box(modifier = Modifier
                        .height(35.dp)
                        .fillMaxWidth()
                        .background(skeletonColor, shape = RoundedCornerShape(8.dp))
                        .clip(shape = RoundedCornerShape(8.dp))
                    ) // Titulo da repo
                    Box(modifier = Modifier
                        .height(60.dp)
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                        .background(skeletonColor, shape = RoundedCornerShape(8.dp))
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

