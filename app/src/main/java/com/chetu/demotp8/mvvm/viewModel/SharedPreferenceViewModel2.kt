package com.chetu.demotp8.mvvm.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.chetu.demotp8.mvvm.repository.SharedPreferenceRepository2

class SharedPreferenceViewModel2(private val context: Context) : ViewModel() {

    fun setUsername(username : String) {
        SharedPreferenceRepository2.setUsername(username, context)
    }

    fun setPassword(password: String) {
        SharedPreferenceRepository2.setPassword(password, context)
    }

    fun getUsername() : String? {
        return SharedPreferenceRepository2.getUsername(context)
    }

    fun getPassword() : String? {
        return SharedPreferenceRepository2.getPassword(context)
    }
}