package com.sheepblue.devhub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sheepblue.devhub.data.local.datastore.SettingsDataStore
import com.sheepblue.devhub.data.remote.GitHubResponseRepository
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val settingsDataStore: SettingsDataStore,
    private val response: GitHubResponseRepository
): ViewModel() {
    var isDarkMode = settingsDataStore.isDarkMode
    // TODO: Receber GitHubResponse do GitHubResponseRepository para trabalhar com a info do rate-limit
    //  nova preocupação: após a mudanças nos valores da ResponseRepository, como settings vai saber?
    //  montar algum mecanismo observavel stateflow, mutablestateflow da vida

    fun updateDarkMode(enabled: Boolean) {
        viewModelScope.launch {
            settingsDataStore.saveDarkMode(enabled = enabled)
        }
    }
}
