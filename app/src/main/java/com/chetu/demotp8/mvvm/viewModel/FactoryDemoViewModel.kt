package com.chetu.demotp8.mvvm.viewModel

import androidx.lifecycle.ViewModel

class FactoryDemoViewModel(startIngCount : Int) : ViewModel() {
    private var count : Int = 0

    init {
        count = startIngCount
    }

    fun getRecentCount() : Int {
        return count
    }

    fun getUpdatedCount() : Int {
        return count++
    }
}