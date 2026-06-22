package com.sheepblue.devhub.data.remote.model

data class GitHubRateLimit(
    val limit: Long?,
    val remaining: Long?,
    val reset: Long?,
    val used: Long?
)
