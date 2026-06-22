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
        Log.d("Teste", "user: $user")
        val profileInfos = profileResponse.body()

        val currentLimit = GitHubRateLimit(
            limit = profileResponse.headers()["x-ratelimit-limit"]?.toLongOrNull(),
            remaining = profileResponse.headers()["x-ratelimit-remaining"]?.toLongOrNull(),
            reset = profileResponse.headers()["x-ratelimit-reset"]?.toLongOrNull(),
            used = profileResponse.headers()["x-ratelimit-used"]?.toLongOrNull()
        )
        Log.d("Teste", "limit: $currentLimit")

        try {
            val reposResponse = service.findRepositoryBy(user)
            val profileRepos: List<GitHubRepository> = reposResponse.map { repo ->
                GitHubRepository(
                    name = repo.name,
                    description = repo.description
                )
            }
            // Se passar retornar GitHubResponse completo
            return GitHubResponse(
                profile = profileInfos?: nullGitHubProfile,
                repositories = profileRepos,
                rateLimit = currentLimit
            )
        } catch (e: Exception) {
            Log.d("Teste", "reposResponse(): $e")
            Log.d("Teste", "reposResponse(): $currentLimit")
            // entregar um Response vazio
            return GitHubResponse(
                profile = nullGitHubProfile,
                repositories = emptyList(),
                rateLimit = currentLimit
            )
        }
    }
}
