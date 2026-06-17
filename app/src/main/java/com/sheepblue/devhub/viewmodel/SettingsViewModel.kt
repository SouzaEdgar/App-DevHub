package com.sheepblue.devhub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sheepblue.devhub.data.local.datastore.SettingsDataStore
import com.sheepblue.devhub.data.remote.GitHubResponseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val settingsDataStore: SettingsDataStore,
    private val response: GitHubResponseRepository
): ViewModel() {
    var isDarkMode = settingsDataStore.isDarkMode
    // TODO: (1°) preparar rateLimit para OBSERVAR o valor de .value?.rateLimit ao inves de apenas ler
    //     algo como StateFlow<GitHubResponse?>, Flow<...> (
    val rateLimit = response.currentResponse.value?.rateLimit


    fun updateDarkMode(enabled: Boolean) {
        viewModelScope.launch {
            settingsDataStore.saveDarkMode(enabled = enabled)
        }
    }
}
