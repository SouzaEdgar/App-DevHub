package com.sheepblue.devhub.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sheepblue.devhub.data.remote.GitHubResponseRepository
import com.sheepblue.devhub.data.remote.model.GitHubError
import com.sheepblue.devhub.data.remote.webclient.GitHubWebClient
import com.sheepblue.devhub.ui.state.UserProfileUiState
import com.sheepblue.devhub.ui.state.UserRepositoryUiState
import kotlinx.coroutines.launch

class UserViewModel(
    private val webClient: GitHubWebClient,
    private val response: GitHubResponseRepository
): ViewModel() {
    // Deixar a responsabilidade de trocar o state no viewMoedl
    var uiState by mutableStateOf(value = UserProfileUiState())
        private set

    fun loadUser(user: String) {
        viewModelScope.launch {
            uiState = uiState.copy(
                isLoading = true,
                errorMessage = null
            )

            Log.d("API", "UserViewModel -> chama myClient")
            val myClient = webClient.findProfileBy(user)
            response.updateResponse(response = myClient)

            // opções de GitHubError
            val message = when(myClient.error) {
                GitHubError.NO_USER -> "Não foi possível encontrar o usuário"
                GitHubError.RATE_LIMIT -> "Atingiu o limite de requisições da API"
                GitHubError.UNKNOWN -> "Não foi possível realizar a busca"
                else -> null
            }
            if (message != null) {
                uiState = uiState.copy(
                    isLoading = false,
                    errorMessage = message
                )
            } else {
                // Dispara informações do usuario na tela (uiState)
                val myProfile = myClient.profile
                val myRepositories = myClient.repositories

                uiState = uiState.copy(
                    login = myProfile.login,
                    name = myProfile.name ?: "",
                    bio = myProfile.bio ?: "",
                    image = myProfile.avatar_url ?: "",
                    repositories = myRepositories.map { repo ->
                        UserRepositoryUiState(
                            name = repo.name ?: "",
                            description = repo.description ?: ""
                        )
                    },
                    isLoading = false,
                    errorMessage = null
                )
            }
        }
    }
}
