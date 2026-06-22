package com.sheepblue.devhub.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sheepblue.devhub.data.remote.GitHubResponseRepository
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

            val myClient = webClient.findProfileBy(user)
            response.updateResponse(response = myClient)

            // TODO: Dispara tela de erro por LIMITE de request da API (rate-limit bateu 60)
            // Dispara tela de erro por login vazio
            if (myClient.profile.login.isEmpty()) {
                uiState = uiState.copy(
                    isLoading = false,
                    errorMessage = "Não foi possível localizar usuário"
                )
            } else { // Dispara informações do usuario na tela (uiState)
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
