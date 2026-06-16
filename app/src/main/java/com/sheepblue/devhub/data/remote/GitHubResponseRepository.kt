package com.sheepblue.devhub.data.remote

import com.sheepblue.devhub.data.remote.model.GitHubResponse

// montar para servir como um cache das infos do response, principalmente o rate limit
class GitHubResponseRepository {
    var myResponse: GitHubResponse?= null
        private set

    fun updateResponse(response: GitHubResponse) {
        myResponse = response
    }
}
