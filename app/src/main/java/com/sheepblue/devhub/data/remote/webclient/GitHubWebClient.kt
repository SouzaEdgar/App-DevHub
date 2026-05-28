package com.sheepblue.devhub.data.remote.webclient

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.sheepblue.devhub.data.RetrofitInitializer
import com.sheepblue.devhub.data.remote.model.GitHubRepository
import com.sheepblue.devhub.data.remote.service.GitHubService
import com.sheepblue.devhub.ui.state.UserProfileUiState
import com.sheepblue.devhub.ui.state.UserRepositoryUiState

class GitHubWebClient (private val service: GitHubService = RetrofitInitializer().gitHubService) {

    // Deixar somente o GitHubWebClient responsavel por alterar o state de UserProfileUiState
    var uiState by mutableStateOf(UserProfileUiState())
        private set

    suspend fun findProfileBy(user: String) {
        val profileResponse = service.findProfileBy(user)

        val reposResponse = service.findRepositoryBy(user)

        // tira a necessidade do convertToUI e aplica o mapper diretamente na mudança de state
        //  tanto para o profile quanto para o repository
        uiState = UserProfileUiState(
            login = profileResponse.login,
            name = profileResponse.name?: "~ sem nome ~",
            bio = profileResponse.bio?: "~ sem bio ~",
            image = profileResponse.avatar_url?: "",
            repositories = reposResponse.map { repo ->
                UserRepositoryUiState(
                    name = repo.name?: "",
                    description = repo.description?: ""
                )
            }
        )
    }
}
