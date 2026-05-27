package com.sheepblue.devhub

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import com.sheepblue.devhub.ui.theme.DevHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            DevHubTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        UserScreen("torvalds")
                    }
                }
            }
        }
    }
}

fun naoNulo(text: String?): String {
    return text ?: "-"
}


@Composable
fun UserScreen(
    user: String,
    webClient: GitHubWebClient = GitHubWebClient()
) {
    val foundUser by webClient.findProfileById(user).collectAsState(initial = null)
    foundUser?.let { userProfile ->
        userProfile.login
        userProfile.name
        userProfile.bio
        userProfile.avatar_url
    }
    Log.d("API", "Name: ${naoNulo(foundUser?.name)}")
    Log.d("API", "Login: ${naoNulo(foundUser?.login)}")
    Log.d("API", "BIO: ${naoNulo(foundUser?.bio)}")
    Log.d("API", "Avatar: ${naoNulo(foundUser?.avatar_url)}")

    Row {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(
                    Color.DarkGray,
                    shape = RoundedCornerShape(bottomStart = 22.dp, bottomEnd = 22.dp)
                )
            ) {
                AsyncImage(
                    model = naoNulo(foundUser?.avatar_url),
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
                naoNulo(foundUser?.name),
                fontSize = 30.sp
            )
            Text(
                naoNulo(foundUser?.login),
                fontWeight = FontWeight.Bold
            )
            Text(naoNulo(foundUser?.bio))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
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
                    model = "https://avatars.githubusercontent.com/u/1024025?v=4",
                    placeholder = painterResource(R.drawable.ic_sharp_account_circle_24),
                    contentDescription = "User Avatar",
                    modifier = Modifier
                        .size(120.dp)
                        .align(Alignment.BottomCenter)
                        .offset(y = 120.dp/2)
                        .clip(CircleShape)
                )
            }
            Spacer(modifier = Modifier.height(120.dp/2))
            Text(
                "Apelido do usuario",
                fontSize = 30.sp
            )
            Text(
                "Nome do usuario",
                fontWeight = FontWeight.Bold
            )
            Text("Descrição do usuario (BIO)")
        }
    }
}
