package com.sheepblue.devhub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sheepblue.devhub.data.local.datastore.SettingsDataStore

class SettingsViewModelFactory(private val dataStore: SettingsDataStore): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(
                SettingsViewModel::class.java
            )
        ) {
            @Suppress("UNCHECKED_CAST")
            return SettingsViewModel(settingsDataStore = dataStore) as T
        }

        throw IllegalArgumentException(
            "Classe SettingsViewModelFactory desconhecida"
        )
    }
}
