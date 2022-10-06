package com.chetu.demotp8.mvvm.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chetu.demotp8.mvvm.viewModel.SharedPreferenceViewModel

class SharedPreferenceFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SharedPreferenceViewModel::class.java)) {
            return SharedPreferenceViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}