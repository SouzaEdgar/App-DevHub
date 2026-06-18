package com.sheepblue.devhub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sheepblue.devhub.data.local.datastore.SettingsDataStore
import com.sheepblue.devhub.data.remote.GitHubResponseRepository
import com.sheepblue.devhub.data.remote.model.GitHubResponse
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val settingsDataStore: SettingsDataStore,
    private val response: GitHubResponseRepository
): ViewModel() {
    var isDarkMode = settingsDataStore.isDarkMode
    // TODO: (1°) preparar rateLimit para OBSERVAR o valor de .value?.rateLimit ao inves de apenas ler
    //     algo como StateFlow<GitHubResponse?>, Flow<...> (

    val currentResponse: StateFlow<GitHubResponse?> = response.currentResponse

    fun updateDarkMode(enabled: Boolean) {
        viewModelScope.launch {
            settingsDataStore.saveDarkMode(enabled = enabled)
        }
    }
}
