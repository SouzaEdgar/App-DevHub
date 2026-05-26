package com.sheepblue.devhub

import retrofit2.http.GET
import retrofit2.http.Path

// TODO: montar a interface que representa o serviço do github e definir a caçamba do endpoint
interface GitHubService {
    @GET("/users/{user}")
    suspend fun findProfileBy(@Path("user") user: String): GitHubProfileWeb
}
