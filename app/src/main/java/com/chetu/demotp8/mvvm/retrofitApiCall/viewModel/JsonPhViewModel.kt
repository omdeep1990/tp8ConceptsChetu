package com.chetu.demotp8.mvvm.retrofitApiCall.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chetu.demotp8.mvvm.retrofitApiCall.model.Albums
import com.chetu.demotp8.mvvm.retrofitApiCall.repository.JsonPhRepository

class JsonPhViewModel : ViewModel() {
    private var albums : MutableLiveData<Albums>? = null

    fun getAlbums() : LiveData<Albums> {
        albums = JsonPhRepository.callAlbumsApi()
        return albums!!
    }
}