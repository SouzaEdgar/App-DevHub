package com.sheepblue.devhub.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.sheepblue.devhub.GitHubProfileWeb
import com.sheepblue.devhub.GitHubWebClient
import com.sheepblue.devhub.R


fun naoNulo(text: String?): String {
    return text ?: "-"
}

@Composable
fun UserProfile(userInfos: GitHubProfileWeb) {
    Row {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .background(
                    Color.DarkGray,
                    shape = RoundedCornerShape(bottomStart = 22.dp, bottomEnd = 22.dp)
                )
            ) {
                AsyncImage(
                    model = naoNulo(userInfos.avatar_url),
                    placeholder = painterResource(R.drawable.ic_sharp_account_circle_24),
                    contentDescription = "User Avatar",
                    modifier = Modifier
                        .size(140.dp)
                        .align(Alignment.BottomCenter)
                        .offset(y = 120.dp/2)
                        .clip(CircleShape)
                )
            }
            Spacer(modifier = Modifier.height(120.dp/2))
            Text(
                naoNulo(userInfos.name),
                fontSize = 30.sp
            )
            Text(
                naoNulo(userInfos.login),
                fontWeight = FontWeight.Bold
            )
            Text(naoNulo(userInfos.bio))
        }
    }
}
// Classe exclusiva para receber tudo que o composable precisa
data class UserProfileUiState(
    val login: String,
    val name: String,
    val bio: String,
    val image: String
)


@Composable
fun UserScreen(
    user: String,
    webClient: GitHubWebClient = GitHubWebClient()
) {
    val foundUser by webClient.findProfileById(user).collectAsState(initial = null)
    foundUser?.let { userInfos ->
        // TODO: converter o objeto GitHubProfileWeb para ProfileUiState
        UserProfile(userInfos)
    }
    Log.d("API", "Name: ${naoNulo(foundUser?.name)}")
    Log.d("API", "Login: ${naoNulo(foundUser?.login)}")
    Log.d("API", "BIO: ${naoNulo(foundUser?.bio)}")
    Log.d("API", "Avatar: ${naoNulo(foundUser?.avatar_url)}")
}

@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
    UserProfile(
        userInfos = GitHubProfileWeb(
            login = "torvalds",
            name = "Linus Torvalds",
            bio = "Teste teste",
            avatar_url = "https://avatars.githubusercontent.com/u/1024025?v=4"
        )
    )
}
