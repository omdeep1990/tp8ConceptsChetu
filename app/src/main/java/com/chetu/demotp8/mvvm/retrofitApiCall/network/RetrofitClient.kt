package com.chetu.demotp8.mvvm.retrofitApiCall.network

import com.chetu.demotp8.mvvm.retrofitApiCall.networkInterfaces.JsonPhInterface
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"

        private var httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        var okHttp : OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()
        private val retrofitClient : Retrofit.Builder by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttp)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        }

        val apiInterface : JsonPhInterface by lazy {
            retrofitClient.build().create(JsonPhInterface::class.java)
        }
}