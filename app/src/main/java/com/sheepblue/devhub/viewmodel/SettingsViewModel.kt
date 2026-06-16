package com.sheepblue.devhub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sheepblue.devhub.data.local.datastore.SettingsDataStore
import kotlinx.coroutines.launch

class SettingsViewModel(private val settingsDataStore: SettingsDataStore): ViewModel() {
    var isDarkMode = settingsDataStore.isDarkMode
    // TODO: Receber GitHubResponse do GitHubResponseRepository para trabalhar com a info do rate-limit

    fun updateDarkMode(enabled: Boolean) {
        viewModelScope.launch {
            settingsDataStore.saveDarkMode(enabled = enabled)
        }
    }
}
