package com.sheepblue.devhub.data.remote.webclient

import android.util.Log
import com.sheepblue.devhub.data.RetrofitInitializer
import com.sheepblue.devhub.data.remote.service.GitHubService
import com.sheepblue.devhub.ui.state.UserProfileUiState
import com.sheepblue.devhub.ui.state.UserRepositoryUiState

class GitHubWebClient (private val service: GitHubService = RetrofitInitializer().gitHubService) {

    suspend fun findProfileBy(user: String): UserProfileUiState {
        val profileResponse = service.findProfileBy(user)
        val profileResponseBody = profileResponse.body()
        val profileResponseHeader = profileResponse.headers()

        val reposResponse = service.findRepositoryBy(user)

        Log.d("DEBUG", "Restantes: ${profileResponseHeader.get("x-ratelimit-remaining")}\n+1 em: ${profileResponseHeader["x-ratelimit-reset"]}\nreposResponse: $reposResponse")

        // retorna com a conversao ja feita (mapper)
        return UserProfileUiState(
            login = profileResponseBody?.login ?: "",
            name = profileResponseBody?.name?: "~ sem nome ~",
            bio = profileResponseBody?.bio?: "~ sem bio ~",
            image = profileResponseBody?.avatar_url?: "",
            repositories = reposResponse.map { repo ->
                UserRepositoryUiState(
                    name = repo.name?: "",
                    description = repo.description?: ""
                )
            }
//            login = "login_teste",
//            name = "name_teste",
//            bio = "bio_teste",
//            image = "",
//            repositories = emptyList()
        )
    }
}
