package com.sheepblue.devhub.viewmodel

import android.util.Log
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
    var uiState by mutableStateOf(UserProfileUiState())
        private set

    fun loadUser(user: String) {
        viewModelScope.launch {
            uiState = uiState.copy(
                isLoading = true,
                errorMessage = null
            )

            // TODO: Ajustar UserViewModel para utilizar a entrega de WebClient => GitHubResponse
            //    >> UserViewModel chama WebClient que entrega GitHubResponse
            //    >> pega esse response e usa os valores, mandando eles para UiState
            //    >> utiliza os valores tbm para ResponseRepository.setResponse(valores)
            try {
                //uiState = repository.findProfileBy(user)
//                ResponseRepository.settResponse(webClient.findProfileBy(user = user))
//                val profileInfo = ResponseRepository.gettResponse()
//                val user = profileInfo.profile
//                val repos = profileInfo.repos
//
//                uiState = UserProfileUiState(
//                    login = user.login,
//                    name = user.name,
//                    bio = user.bio,
//                    image = user,
//                    repositories = repos.map { repo ->
//                        UserRepositoryUiState(
//                            name = repo.name?: "",
//                            description = repo.description?: ""
//                        )
//                    }
//                )
            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    errorMessage = "Usuário não encontrado"
                )
                Log.d("API", "UserViewModel: $e")
            }
        }
    }
}
