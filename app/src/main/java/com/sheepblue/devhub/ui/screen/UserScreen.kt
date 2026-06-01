package com.sheepblue.devhub.ui.screen

import android.util.Log
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sheepblue.devhub.ui.components.UserError
import com.sheepblue.devhub.ui.components.UserLoading
import com.sheepblue.devhub.ui.components.UserProfile
import com.sheepblue.devhub.ui.state.UserProfileUiState
import com.sheepblue.devhub.ui.state.UserRepositoryUiState
import com.sheepblue.devhub.viewmodel.UserViewModel
import com.sheepblue.devhub.viewmodel.UserViewModelFactory

@Composable
fun UserScreen(
    user: String,
    factory: UserViewModelFactory
) {
    val viewModel: UserViewModel = viewModel(factory = factory)

    val uiState = viewModel.uiState

    LaunchedEffect(user) {
        viewModel.loadUser(user)
    }
    Log.d("API", "uiState -> $uiState")
    Log.d("API","repoLenght: ${uiState.repositories.size}")

    // TODO: implementar outras telas
    //  -> UserLoading (Shimmer Loading ???)
    when {
        uiState.isLoading -> {
            UserLoading()
        }

        uiState.errorMessage != null -> {
            Log.d("API", "errorMessage: ${uiState.errorMessage}")
            UserError()
        }

        else -> {
            UserProfile(uiState)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
    UserProfile(
        userInfos = UserProfileUiState(
            login = "torvalds",
            name = "Linus Torvalds",
            bio = "~ sem bio ~",
            image = "https://avatars.githubusercontent.com/u/1024025?v=4",
            repositories = listOf(
                UserRepositoryUiState(
                    name = "First repo",
                    description = "first commit"
                ),
                UserRepositoryUiState(
                    name = "Linux",
                    description = "Linux kernel source tree"
                ),
                UserRepositoryUiState(
                    name = "Git",
                    description = ""
                )
            )
        )
    )
}
