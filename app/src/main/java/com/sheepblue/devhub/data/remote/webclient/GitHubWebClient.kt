package com.sheepblue.devhub.data.remote.webclient

import android.util.Log
import com.sheepblue.devhub.data.RetrofitInitializer
import com.sheepblue.devhub.data.remote.model.GitHubProfileWeb
import com.sheepblue.devhub.data.remote.model.GitHubRateLimit
import com.sheepblue.devhub.data.remote.model.GitHubRepository
import com.sheepblue.devhub.data.remote.model.GitHubResponse
import com.sheepblue.devhub.data.remote.service.GitHubService

class GitHubWebClient (private val service: GitHubService = RetrofitInitializer().gitHubService) {
    private val nullGitHubProfile = GitHubProfileWeb(
        login = "",
        name = "",
        bio = "",
        avatar_url = ""
    )

    suspend fun findProfileBy(user: String): GitHubResponse {
        val profileResponse = service.findProfileBy(user)
        val profileInfos = profileResponse.body()

        val currentLimit = GitHubRateLimit(
            limit = profileResponse.headers()["x-ratelimit-limit"]?.toLongOrNull(),
            remaining = profileResponse.headers()["x-ratelimit-remaining"]?.toLongOrNull(),
            reset = profileResponse.headers()["x-ratelimit-reset"]?.toLongOrNull(),
            used = profileResponse.headers()["x-ratelimit-used"]?.toLongOrNull()
        )

        val reposResponse = service.findRepositoryBy(user)
        val profileRepos: List<GitHubRepository> = reposResponse.map { repo ->
            GitHubRepository(
                name = repo.name,
                description = repo.description
            )
        }

        Log.d("DEBUG",
            "Restantes: ${profileResponse.headers()["x-ratelimit-remaining"]}" +
                    "\n+1 em: ${profileResponse.headers()["x-ratelimit-reset"]}" +
                    "\nreposResponse: $reposResponse")

        return GitHubResponse(
            profile = profileInfos?: nullGitHubProfile,
            repositories = profileRepos,
            rateLimit = currentLimit
        )
    }
}

//                return UserProfileUiState(
//                    login = profileResponseBody?.login ?: "",
//                    name = profileResponseBody?.name?: "~ sem nome ~",
//                    bio = profileResponseBody?.bio?: "~ sem bio ~",
//                    image = profileResponseBody?.avatar_url?: "",
//                    repositories = reposResponse.map { repo ->
//                        UserRepositoryUiState(
//                            name = repo.name?: "",
//                            description = repo.description?: ""
//                        )
//                    }
////            login = "login_teste",
////            name = "name_teste",
////            bio = "bio_teste",
////            image = "",
////            repositories = emptyList()
//                )