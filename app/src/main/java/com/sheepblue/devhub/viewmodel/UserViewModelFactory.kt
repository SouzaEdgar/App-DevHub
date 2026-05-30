package com.sheepblue.devhub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sheepblue.devhub.data.remote.webclient.GitHubWebClient

// O tal do boilerplate do factory de ViewModel
class UserViewModelFactory(private val repository: GitHubWebClient): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(
                UserViewModel::class.java
        )
            ) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "Classe ViewModel desconhecida"
        )
    }
}
