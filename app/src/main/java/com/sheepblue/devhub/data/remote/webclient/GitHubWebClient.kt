package com.sheepblue.devhub.data.remote.webclient

import com.sheepblue.devhub.data.RetrofitInitializer
import com.sheepblue.devhub.data.remote.service.GitHubService
import com.sheepblue.devhub.ui.state.UserProfileUiState
import com.sheepblue.devhub.ui.state.UserRepositoryUiState

class GitHubWebClient (private val service: GitHubService = RetrofitInitializer().gitHubService) {

    suspend fun findProfileBy(user: String): UserProfileUiState {
        val profileResponse = service.findProfileBy(user)

        val reposResponse = service.findRepositoryBy(user)

        // retorna com a conversao ja feita (mapper)
        return UserProfileUiState(
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
