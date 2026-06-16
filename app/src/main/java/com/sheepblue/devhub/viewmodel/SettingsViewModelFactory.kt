package com.sheepblue.devhub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sheepblue.devhub.data.local.datastore.SettingsDataStore
import com.sheepblue.devhub.data.remote.GitHubResponseRepository

class SettingsViewModelFactory(
    private val dataStore: SettingsDataStore,
    private val response: GitHubResponseRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(
                SettingsViewModel::class.java
            )
        ) {
            @Suppress("UNCHECKED_CAST")
            return SettingsViewModel(settingsDataStore = dataStore, response = response) as T
        }

        throw IllegalArgumentException(
            "Classe SettingsViewModelFactory desconhecida"
        )
    }
}
