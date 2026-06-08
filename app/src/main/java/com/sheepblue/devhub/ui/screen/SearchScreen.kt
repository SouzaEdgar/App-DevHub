package com.sheepblue.devhub.ui.screen

import android.content.res.Configuration
import android.util.Log
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.sheepblue.devhub.ui.components.search.SearchTextField
import com.sheepblue.devhub.ui.theme.DevHubTheme
import com.sheepblue.devhub.viewmodel.SelectedUserViewModel

@Composable
fun SearchScreen(onSearchClick: () -> Unit, viewModel: SelectedUserViewModel) {
    var userName by remember { mutableStateOf("") }

    SearchTextField(
        text = userName,
        onTextChange = {
            userName = it
            Log.d("Search", "Buscou: $userName")
        },
        onClick = {
            viewModel.settSearchUser(search = userName)
            onSearchClick()
            Log.d("Search", "usuario encontrado: ${viewModel.searchUser}")
        }
    )
}


@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    DevHubTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            SearchScreen(
                onSearchClick = {},
                viewModel = SelectedUserViewModel()
            )
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SearchSceenDarkPreview() {
    DevHubTheme{
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            SearchScreen(
                onSearchClick = {},
                viewModel = SelectedUserViewModel()
            )
        }
    }
}
