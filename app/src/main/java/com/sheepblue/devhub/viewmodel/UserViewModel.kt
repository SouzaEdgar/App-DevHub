package com.sheepblue.devhub.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sheepblue.devhub.data.remote.webclient.GitHubWebClient
import com.sheepblue.devhub.ui.state.UserProfileUiState
import com.sheepblue.devhub.ui.state.UserRepositoryUiState
import kotlinx.coroutines.launch

class UserViewModel(private val repository: GitHubWebClient): ViewModel() {
    // Deixar a responsabilidade de trocar o state no viewMoedl
    var uiState by mutableStateOf(UserProfileUiState())
        private set

    fun loadUser(user: String) {
        viewModelScope.launch {
            uiState = uiState.copy(
                isLoading = true,
                errorMessage = null
            )

            try {
                //uiState = repository.findProfileBy(user)
                uiState = repository.findProfileBy(user = user).profile
            // montar a uistate com os valores de profile
                // retorna com a conversao ja feita (mapper)
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
