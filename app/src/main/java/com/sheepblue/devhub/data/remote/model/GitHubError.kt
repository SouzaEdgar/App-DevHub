package com.sheepblue.devhub.data.remote.model

// transformar em data class na necessidade de outras informações - como mensagem de erro direta
enum class GitHubError {
    NONE,
    NO_USER,
    RATE_LIMIT,
    UNKNOW
}