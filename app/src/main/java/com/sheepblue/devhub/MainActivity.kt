package com.sheepblue.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sheepblue.devhub.data.remote.webclient.GitHubWebClient
import com.sheepblue.devhub.ui.screen.SearchScreen
import com.sheepblue.devhub.ui.screen.SettingsScreen
import com.sheepblue.devhub.ui.screen.UserScreen
import com.sheepblue.devhub.ui.theme.DevHubTheme
import com.sheepblue.devhub.viewmodel.SelectedUserViewModel
import com.sheepblue.devhub.viewmodel.SelectedUserViewModelFactory
import com.sheepblue.devhub.viewmodel.UserViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val factoryUser = UserViewModelFactory(GitHubWebClient())
        val factorySelected = SelectedUserViewModelFactory()

        setContent {
            DevHubTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        val selectedUserViewModel: SelectedUserViewModel = viewModel(factory = factorySelected)

                        val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = "Search_Screen", builder = {
                            composable("Search_Screen") {
                                SearchScreen(
                                    onSearchClick = { navController.navigate(route = "User_Screen") },
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
                                    onBackClick = { navController.popBackStack() }
                                )
                            }
                        })
                    }
                }
            }
        }
    }
}
