package com.chetu.demotp8.mvvm.roomDb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserListViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserListActivityViewModel::class.java)){
            return UserListActivityViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}