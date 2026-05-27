package com.sheepblue.devhub

import kotlinx.coroutines.flow.flow

class GitHubWebClient (private val service: GitHubService = RetrofitInitializer().gitHubService) {
    fun findProfileById(user: String) = flow{
        emit(service.findProfileBy(user))
    }
}
