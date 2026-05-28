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
import okhttp3.internal.userAgent

@Composable
fun UserProfile(userInfos: UserProfileUiState) {
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
                    model = userInfos.image,
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
                userInfos.name,
                fontSize = 30.sp
            )
            Text(
                userInfos.login,
                fontWeight = FontWeight.Bold
            )
            Text(userInfos.bio)
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

// mapper para passar o valor de GitHubProfileWeb para UserProfileUiState
//  até pq o recebido da API é nullable e assim ja consigo tratar para utilizar no compose
fun convertToUI(userGitHub: GitHubProfileWeb): UserProfileUiState {
    return UserProfileUiState(
        login = userGitHub.login,
        name = userGitHub.name ?: "~ Sem Nome ~",
        bio = userGitHub.bio ?: "~ Sem Bio ~",
        image = userGitHub.avatar_url ?: ""
    )
}


@Composable
fun UserScreen(
    user: String,
    webClient: GitHubWebClient = GitHubWebClient()
) {
    val foundUser by webClient.findProfileById(user).collectAsState(initial = null)
    foundUser?.let { userInfos ->
        Log.d("API", "$userInfos")
        UserProfile(convertToUI(userInfos))
    }
}

// Aplicando a conversão de objetos para testar a mudança de texto
@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
    UserProfile(
        userInfos = convertToUI(
            userGitHub = GitHubProfileWeb(
                login = "torvalds",
                name = "Linus Torvalds",
                bio = null,
                avatar_url = "https://avatars.githubusercontent.com/u/1024025?v=4"
            )
        )
    )
}
