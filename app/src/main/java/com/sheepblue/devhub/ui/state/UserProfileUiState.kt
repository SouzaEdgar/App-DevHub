package com.sheepblue.devhub.ui.state

import com.sheepblue.devhub.data.remote.model.GitHubProfileWeb

// Classe exclusiva para receber tudo que o UserProfile precisa
data class UserProfileUiState(
    val login: String,
    val name: String,
    val bio: String,
    val image: String
)

// mapper para passar o valor de GitHubProfileWeb para UserProfileUiState
//  até pq o recebido da API é nullable e assim ja consigo tratar para utilizar no compose
fun convertToUI(userGitHub: GitHubProfileWeb): UserProfileUiState {
    return UserProfileUiState(
        login = userGitHub.login,
        name = userGitHub.name ?: "~ Sem Nome ~",
        bio = userGitHub.bio ?: "~ Sem Bio ~",
        image = userGitHub.avatar_url ?: ""
    )
}
