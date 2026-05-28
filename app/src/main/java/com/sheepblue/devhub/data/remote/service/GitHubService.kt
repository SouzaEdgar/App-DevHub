package com.sheepblue.devhub.data.remote.service

import com.sheepblue.devhub.data.remote.model.GitHubProfileWeb
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("/users/{user}")
    suspend fun findProfileBy(@Path("user") user: String): GitHubProfileWeb
}