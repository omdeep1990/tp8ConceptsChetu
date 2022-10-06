package com.chetu.demotp8.mvvm.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chetu.demotp8.mvvm.viewModel.OnWayViewModel

class OneWayFactory(private val startingCount : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OnWayViewModel::class.java)) {
            return OnWayViewModel(startingCount) as T
        }
        throw IllegalArgumentException("Unknown View Model")
    }
}