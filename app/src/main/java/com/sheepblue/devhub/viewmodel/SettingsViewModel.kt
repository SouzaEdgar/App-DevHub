package com.sheepblue.devhub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sheepblue.devhub.data.local.datastore.SettingsDataStore
import kotlinx.coroutines.launch

class SettingsViewModel(private val settingsDataStore: SettingsDataStore): ViewModel() {
    var isDarkMode = settingsDataStore.isDarkMode

    fun updateDarkMode(enabled: Boolean) {
        viewModelScope.launch {
            settingsDataStore.saveDarkMode(enabled = enabled)
        }
    }
}
