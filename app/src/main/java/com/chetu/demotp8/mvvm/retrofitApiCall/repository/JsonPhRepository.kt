package com.chetu.demotp8.mvvm.retrofitApiCall.repository

import androidx.lifecycle.MutableLiveData
import com.chetu.demotp8.mvvm.retrofitApiCall.model.Albums
import com.chetu.demotp8.mvvm.retrofitApiCall.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object JsonPhRepository {
    private var albums = MutableLiveData<Albums>()

    fun callAlbumsApi() : MutableLiveData<Albums> {
        val call = RetrofitClient.apiInterface.getAllAlbums()
        call.enqueue(object : Callback<Albums> {
            override fun onResponse(call: Call<Albums>, response: Response<Albums>) {
                if (response.isSuccessful) {
                    val album = response.body()
                    albums.value = album!!
                }
            }

            override fun onFailure(call: Call<Albums>, t: Throwable) {

            }

        })
        return albums
    }
}