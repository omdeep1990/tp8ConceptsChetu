package com.chetu.demotp8.mvvm.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.chetu.demotp8.mvvm.repository.SharedPreferenceRepository

class SharedPreferenceViewModel(private val context: Context) : ViewModel() {

    private val spRepository : SharedPreferenceRepository = SharedPreferenceRepository(context)

    fun setUsername(username : String) {
        spRepository.setUsername(username)
    }
    fun setPassword(password : String) {
        spRepository.setPassword(password)
    }
    fun getUsername() : String? {
        return spRepository.getUsername()
    }
    fun getPassword() : String? {
        return spRepository.getPassword()
    }
}