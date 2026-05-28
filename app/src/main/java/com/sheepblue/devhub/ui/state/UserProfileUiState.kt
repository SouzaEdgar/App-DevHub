package com.sheepblue.devhub.ui.state

import com.sheepblue.devhub.data.remote.model.GitHubRepository

// Classe exclusiva para receber tudo que o UserProfile precisa
data class UserProfileUiState(
    val login: String = "",
    val name: String = "",
    val bio: String = "",
    val image: String = "",
    val repositories: List<UserRepositoryUiState> = emptyList()
)
