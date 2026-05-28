package com.sheepblue.devhub.data

import com.sheepblue.devhub.data.remote.service.GitHubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    val gitHubService get() = retrofit.create(GitHubService::class.java)
}