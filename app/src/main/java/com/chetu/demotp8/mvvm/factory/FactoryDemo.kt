package com.chetu.demotp8.mvvm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chetu.demotp8.mvvm.viewModel.FactoryDemoViewModel

class FactoryDemo(private val startingCount: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FactoryDemoViewModel::class.java)) {
            return FactoryDemoViewModel(startingCount) as T
        }
        throw IllegalArgumentException("UnKnown ViewModel")
    }
}