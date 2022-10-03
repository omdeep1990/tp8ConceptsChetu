package com.chetu.demotp8.mvvm.viewModel

import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private var count : Int = 0;

    fun getRecentCount() : Int {
        return count
    }

    fun getUpdatedCount() : Int {
        return count++
    }
}