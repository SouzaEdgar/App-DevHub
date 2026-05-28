package com.sheepblue.devhub.data.remote.webclient

import com.sheepblue.devhub.data.RetrofitInitializer
import com.sheepblue.devhub.data.remote.service.GitHubService
import kotlinx.coroutines.flow.flow

class GitHubWebClient (private val service: GitHubService = RetrofitInitializer().gitHubService) {
    fun findProfileById(user: String) = flow {
        emit(service.findProfileBy(user))
    }
}