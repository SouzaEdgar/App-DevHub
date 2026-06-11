package com.sheepblue.devhub

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sheepblue.devhub.data.local.datastore.SettingsDataStore
import com.sheepblue.devhub.data.remote.webclient.GitHubWebClient
import com.sheepblue.devhub.ui.screen.SearchScreen
import com.sheepblue.devhub.ui.screen.SettingsScreen
import com.sheepblue.devhub.ui.screen.UserScreen
import com.sheepblue.devhub.ui.theme.DevHubTheme
import com.sheepblue.devhub.viewmodel.SelectedUserViewModel
import com.sheepblue.devhub.viewmodel.SelectedUserViewModelFactory
import com.sheepblue.devhub.viewmodel.SettingsViewModel
import com.sheepblue.devhub.viewmodel.SettingsViewModelFactory
import com.sheepblue.devhub.viewmodel.UserViewModelFactory

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings_preferences")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val factoryUser = UserViewModelFactory(repository = GitHubWebClient())
        val factorySelected = SelectedUserViewModelFactory()
        val factorySettings = SettingsViewModelFactory(dataStore = SettingsDataStore(applicationContext.dataStore))

        setContent {
            val selectedUserViewModel: SelectedUserViewModel = viewModel(factory = factorySelected)
            val settingsViewModel: SettingsViewModel = viewModel(factory = factorySettings)

            // observar tbm o flow do valro na viewModel
            val isDarkMode by settingsViewModel.isDarkMode.collectAsState(initial = false)

            DevHubTheme(darkTheme = isDarkMode) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = "Search_Screen", builder = {
                            composable("Search_Screen") {
                                SearchScreen(
                                    onSearchClick = { navController.navigate(route = "User_Screen") },
                                    onSettingsClick = { navController.navigate(route = "Settings_Screen") },
                                    viewModel = selectedUserViewModel
                                )
                            }
                            composable("User_Screen") {
                                UserScreen(
                                    user = selectedUserViewModel.searchUser,
                                    factory = factoryUser,
                                    onBackClick = { navController.popBackStack() }
                                )
                            }
                            composable("Settings_Screen") {
                                SettingsScreen(
                                    onBackClick = { navController.popBackStack() },
                                    viewModel = settingsViewModel
                                )
                            }
                        })
                    }
                }
            }
        }
    }
}
