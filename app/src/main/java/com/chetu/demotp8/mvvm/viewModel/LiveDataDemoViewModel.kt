package com.chetu.demotp8.mvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataDemoViewModel(private val startingCount : Int) : ViewModel() {
    var count : MutableLiveData<Int> = MutableLiveData<Int>()

    init {
        count.value = startingCount
    }

    fun getUpdatedCount() {
        count.value = count.value!!.plus(1)
    }
}