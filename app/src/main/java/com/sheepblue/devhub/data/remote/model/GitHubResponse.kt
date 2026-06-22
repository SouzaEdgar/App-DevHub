package com.sheepblue.devhub.data.remote.model

// vai servir como um wrapper para Profile, Repositorys e RateLimit
data class GitHubResponse(
    val profile: GitHubProfileWeb,
    val repositories: List<GitHubRepository>,
    val rateLimit: GitHubRateLimit
)
