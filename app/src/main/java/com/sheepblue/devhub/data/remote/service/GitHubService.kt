package com.sheepblue.devhub.data.remote.service

import com.sheepblue.devhub.data.remote.model.GitHubProfileWeb
import com.sheepblue.devhub.data.remote.model.GitHubRepository
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    // informações do perfil de usuario
    @GET("/users/{user}")
    suspend fun findProfileBy(@Path("user") user: String): Response<GitHubProfileWeb>

    // repositorios do usuario
    @GET("/users/{user}/repos")
    suspend fun findRepositoryBy(@Path("user") user: String): List<GitHubRepository>
}
