package com.chetu.demotp8.mvvm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chetu.demotp8.mvvm.viewModel.LiveDataDemoViewModel

class LiveDataDemoFactory(private val startingCount : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LiveDataDemoViewModel::class.java)) {
            return LiveDataDemoViewModel(startingCount) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}