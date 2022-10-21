package com.chetu.demotp8.mvvm.retrofitApiCall.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityJsonPhBinding
import com.chetu.demotp8.mvvm.retrofitApiCall.adapter.JsonAdapter
import com.chetu.demotp8.mvvm.retrofitApiCall.viewModel.JsonPhViewModel

class JsonPhActivity : AppCompatActivity() {
    private lateinit var binding : ActivityJsonPhBinding
    private lateinit var viewModel : JsonPhViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_json_ph)

        viewModel = ViewModelProvider(this)[JsonPhViewModel::class.java]

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.getAlbums().observe(this, Observer {
            for (album in it) {
                val adapter = JsonAdapter(it)
                binding.recyclerView.adapter = adapter
                Log.d("ALBUM", album.title+","+album.userId+","+album.id)
            }
        })
    }
}