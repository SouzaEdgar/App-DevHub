package com.sheepblue.devhub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SelectedUserViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(
                SelectedUserViewModel::class.java
            )
        ) {
            @Suppress("UNCHECKED_CAST")
            return SelectedUserViewModel() as T
        }

        throw IllegalArgumentException(
            "Classe SelectedUserViewModelFactory desconhecida"
        )
    }
}
