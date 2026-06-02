package com.sheepblue.devhub.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SelectedUserViewModel(): ViewModel() {
    var searchUser by mutableStateOf(value = "")
        private set

    fun settSearchUser(search: String) {
        searchUser = search
        Log.d("Search", "CHAMOU setSearchUser com: $searchUser")
    }
}
