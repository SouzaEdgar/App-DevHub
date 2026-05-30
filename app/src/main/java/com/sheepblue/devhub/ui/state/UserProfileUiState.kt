package com.sheepblue.devhub.ui.state

// Classe exclusiva para receber tudo que o UserProfile precisa
data class UserProfileUiState(
    val login: String = "",
    val name: String = "",
    val bio: String = "",
    val image: String = "",
    val repositories: List<UserRepositoryUiState> = emptyList(),

    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
