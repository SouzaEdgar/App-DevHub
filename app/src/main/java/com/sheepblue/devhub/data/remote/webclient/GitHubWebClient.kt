package com.sheepblue.devhub.data.remote.webclient

import android.util.Log
import com.sheepblue.devhub.data.RetrofitInitializer
import com.sheepblue.devhub.data.remote.model.GitHubError
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
    private val nullGitHubRateLimit = GitHubRateLimit(
        used = null,
        reset = null,
        remaining = null,
        limit = null
    )

    suspend fun findProfileBy(user: String): GitHubResponse {
        try {
            val profileResponse = service.findProfileBy(user)
            Log.d("API", "findProfileBy($user)")
            val profileInfos = profileResponse.body()

            val currentLimit = GitHubRateLimit(
                limit = profileResponse.headers()["x-ratelimit-limit"]?.toLongOrNull(),
                remaining = profileResponse.headers()["x-ratelimit-remaining"]?.toLongOrNull(),
                reset = profileResponse.headers()["x-ratelimit-reset"]?.toLongOrNull(),
                used = profileResponse.headers()["x-ratelimit-used"]?.toLongOrNull()
            )
            Log.d("API", "limit: $currentLimit")

            if (currentLimit.used != null && currentLimit.limit != null && currentLimit.used >= currentLimit.limit) {
                return GitHubResponse(
                    profile = profileInfos?: nullGitHubProfile,
                    repositories = emptyList(),
                    rateLimit = currentLimit,
                    error = GitHubError.RATE_LIMIT
                )
            }
            // TODO: Criar uma verificação para usuario vazio (NO_USER)
            //  e novo tratamento para o erro na busca dos repositorios
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
                    rateLimit = currentLimit,
                    error = GitHubError.NONE
                )
            } catch (e: Exception) {
                Log.d("API", "findRepositoryBy error: $e")
                // entregar um Response vazio
                return GitHubResponse(
                    profile = nullGitHubProfile,
                    repositories = emptyList(),
                    rateLimit = currentLimit,
                    error = GitHubError.NO_USER
                )
            }
        } catch (e: Exception) {
            Log.d("API", "service.findProfileBy(user): $e")
            return GitHubResponse(
                profile = nullGitHubProfile,
                repositories = emptyList(),
                rateLimit = nullGitHubRateLimit,
                error = GitHubError.UNKNOWN
            )
        }
    }
}
