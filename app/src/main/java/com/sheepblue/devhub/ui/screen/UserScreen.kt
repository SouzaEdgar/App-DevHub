package com.sheepblue.devhub.ui.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import com.sheepblue.devhub.data.remote.webclient.GitHubWebClient
import com.sheepblue.devhub.ui.components.UserProfile
import com.sheepblue.devhub.ui.state.UserProfileUiState

@Composable
fun UserScreen(
    user: String,
    webClient: GitHubWebClient = GitHubWebClient()
) {
    val uiState = webClient.uiState
    LaunchedEffect(user) {
        webClient.findProfileBy(user)
    }
    Log.d("API", "uiState -> $uiState")
    Log.d("API","repoLenght: ${uiState.repositories.size}")
    UserProfile(uiState)
}

// Aplicando a conversão de objetos para testar a mudança de texto
@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
    UserProfile(
        userInfos = UserProfileUiState(
                login = "torvalds",
                name = "Linus Torvalds",
                bio = "~ sem bio ~",
                image = "https://avatars.githubusercontent.com/u/1024025?v=4"
        )
    )
}
