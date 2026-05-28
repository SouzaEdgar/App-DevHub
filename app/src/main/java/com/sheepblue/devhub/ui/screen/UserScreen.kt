package com.sheepblue.devhub.ui.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.sheepblue.devhub.data.remote.model.GitHubProfileWeb
import com.sheepblue.devhub.data.remote.webclient.GitHubWebClient
import com.sheepblue.devhub.ui.components.UserProfile
import com.sheepblue.devhub.ui.state.convertToUI

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
