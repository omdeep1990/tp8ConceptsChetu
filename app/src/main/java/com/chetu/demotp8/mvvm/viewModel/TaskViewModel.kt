package com.chetu.demotp8.mvvm.viewModel

import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    private var count : Int = 0;

    fun getRecentCount() : Int {
        return count
    }

    fun getUpdatedCount(input : Int) {
        count+=input
    }
}