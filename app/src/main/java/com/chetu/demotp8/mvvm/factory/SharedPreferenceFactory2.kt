package com.chetu.demotp8.mvvm.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chetu.demotp8.mvvm.viewModel.SharedPreferenceViewModel2

class SharedPreferenceFactory2(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SharedPreferenceViewModel2::class.java)) {
            return SharedPreferenceViewModel2(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}