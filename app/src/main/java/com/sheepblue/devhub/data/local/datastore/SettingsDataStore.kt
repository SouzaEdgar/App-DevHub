package com.sheepblue.devhub.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.map

class SettingsDataStore(private val dataStore: DataStore<Preferences>) {
    private val isDarkModePreferences = booleanPreferencesKey(name = "is_dark_mode")

    val isDarkMode = dataStore.data.map { preferences ->
        preferences[isDarkModePreferences] ?: false
    }

    suspend fun saveDarkMode(enabled: Boolean) {
        dataStore.edit { preferences ->
            preferences[isDarkModePreferences] = enabled
        }
    }
}
