package com.sheepblue.devhub.ui.components.user

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.sheepblue.devhub.R
import com.sheepblue.devhub.ui.components.common.BackButton
import com.sheepblue.devhub.ui.state.UserProfileUiState
import com.sheepblue.devhub.ui.state.UserRepositoryUiState
import com.sheepblue.devhub.ui.theme.BorderDark
import com.sheepblue.devhub.ui.theme.BorderLight
import com.sheepblue.devhub.ui.theme.DevHubTheme
import com.sheepblue.devhub.ui.theme.SurfaceHeaderDark
import com.sheepblue.devhub.ui.theme.SurfaceHeaderLight

@Composable
fun UserProfile(userInfos: UserProfileUiState, onClick: () -> Unit) {
    val avatarSize = 140.dp
    val avatarOffset = avatarSize / 2.5f

    val headerBackground: Color
    val headerBorder: Color

        if(isSystemInDarkTheme()) {
            headerBackground = SurfaceHeaderDark
            headerBorder = BorderDark
        }
        else {
            headerBackground = SurfaceHeaderLight
            headerBorder = BorderLight
        }
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box( // Efeito de contorno do background da header
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(
                        color = headerBorder,
                        shape = RoundedCornerShape(
                            bottomStart = 22.dp,
                            bottomEnd = 22.dp
                        )
                    )
            ) {
                // Background da header
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .background(
                            color = headerBackground,
                            shape = RoundedCornerShape(
                                bottomStart = 22.dp,
                                bottomEnd = 22.dp
                            )
                        )
                )
                // Contorno do avatar
                Box(
                    modifier = Modifier
                        .size(avatarSize + 20.dp)
                        .offset(y = avatarOffset + 10.dp)
                        .align(Alignment.BottomCenter)
                        .clip(CircleShape)
                        .background(color = headerBorder)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .offset(y = 70.dp)
                        .align(Alignment.BottomCenter)
                        .background(color = MaterialTheme.colorScheme.background)
                )
                AsyncImage(
                    model = userInfos.image,
                    placeholder = painterResource(
                        R.drawable.ic_sharp_account_circle_24
                    ),
                    contentDescription = "User Avatar",
                    modifier = Modifier
                        .size(size = avatarSize)
                        .align(Alignment.BottomCenter)
                        .offset(y = avatarOffset)
                        .clip(CircleShape)
                )
                BackButton{ onClick() }
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

@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
    DevHubTheme {
        UserProfile(
            userInfos = UserProfileUiState(
                login = "torvalds",
                name = "Linus Torvalds",
                bio = "~ sem bio ~",
                image = "https://avatars.githubusercontent.com/u/1024025?v=4",
                repositories = listOf(
                    UserRepositoryUiState(
                        name = "First repo",
                        description = "first commit"
                    ),
                    UserRepositoryUiState(
                        name = "Linux",
                        description = "Linux kernel source tree"
                    ),
                    UserRepositoryUiState(
                        name = "Git",
                        description = ""
                    )
                )
            ),
            onClick = {}
        )
    }
}
