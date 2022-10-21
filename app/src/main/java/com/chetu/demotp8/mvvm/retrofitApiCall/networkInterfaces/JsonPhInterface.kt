package com.chetu.demotp8.mvvm.retrofitApiCall.networkInterfaces

import com.chetu.demotp8.mvvm.retrofitApiCall.model.Albums
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface JsonPhInterface {

    @GET("/albums")
    fun getAllAlbums() : Call<Albums>
}