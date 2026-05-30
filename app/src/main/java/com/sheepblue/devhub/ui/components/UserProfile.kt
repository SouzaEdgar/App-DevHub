package com.sheepblue.devhub.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.sheepblue.devhub.R
import com.sheepblue.devhub.ui.state.UserProfileUiState

@Composable
fun UserProfile(userInfos: UserProfileUiState) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box(
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
                AsyncImage(
                    model = userInfos.image,
                    placeholder = painterResource(
                        R.drawable.ic_sharp_account_circle_24
                    ),
                    contentDescription = "User Avatar",
                    modifier = Modifier
                        .size(160.dp)
                        .align(Alignment.BottomCenter)
                        .offset(y = 120.dp / 2)
                        .clip(CircleShape)
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(160.dp / 2))
        }

        item {
            Text(
                userInfos.name,
                fontSize = 30.sp
            )
            Text(
                userInfos.login,
                fontWeight = FontWeight.Bold
            )
            Text(userInfos.bio)
            Spacer(modifier = Modifier.height(40.dp / 2))
        }

        items(userInfos.repositories) { repo ->
            RepositoryItem(repo)
        }

        item {
            Spacer(modifier = Modifier.height(100.dp / 2))
        }
    }
}
