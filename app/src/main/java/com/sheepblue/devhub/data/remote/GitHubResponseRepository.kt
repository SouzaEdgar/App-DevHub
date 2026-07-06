package com.sheepblue.devhub.data.remote

import android.util.Log
import com.sheepblue.devhub.data.remote.model.GitHubError
import com.sheepblue.devhub.data.remote.model.GitHubProfileWeb
import com.sheepblue.devhub.data.remote.model.GitHubRateLimit
import com.sheepblue.devhub.data.remote.model.GitHubResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// montar para servir como um cache das infos do response, principalmente o rate limit
class GitHubResponseRepository {
    private val mockResponse = GitHubResponse(
        profile = GitHubProfileWeb(login = "", name = "", bio = "", avatar_url = ""),
        repositories = emptyList(),
        rateLimit = GitHubRateLimit(used = null, reset = null, remaining = null, limit = null),
        error = GitHubError.NONE
    )

    //private val _currentResponse = MutableStateFlow<GitHubResponse?>(value = null)
    private val _currentResponse = MutableStateFlow(value = mockResponse)
    val currentResponse: StateFlow<GitHubResponse> = _currentResponse.asStateFlow()

    fun updateResponse(response: GitHubResponse) {
        _currentResponse.update { resp ->
            resp.copy(
                profile = response.profile,
                repositories = response.repositories,
                rateLimit = response.rateLimit
            )
        }
        Log.d("API", "rateLimit com stateFlow: " +
                "\n>> Profile: ${currentResponse.value.profile}" +
                "\n>> Repositorios: ${currentResponse.value.repositories}" +
                "\n>> Rate-limit: ${currentResponse.value.rateLimit}"
        )
    }
}
