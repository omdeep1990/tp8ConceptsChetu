package com.chetu.demotp8.mvvm.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityLiveDataDemoBinding
import com.chetu.demotp8.mvvm.factory.LiveDataDemoFactory
import com.chetu.demotp8.mvvm.viewModel.LiveDataDemoViewModel

class LiveDataDemoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLiveDataDemoBinding
    private lateinit var factory : LiveDataDemoFactory
    private lateinit var viewModel : LiveDataDemoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data_demo)

        factory = LiveDataDemoFactory(0)
        viewModel = ViewModelProvider(this, factory)[LiveDataDemoViewModel::class.java]
        binding.myViewModel = viewModel
        viewModel.count.observe(this, Observer {
            binding.getCount.text = it.toString()
        })

        binding.countBtn.setOnClickListener {
            viewModel.getUpdatedCount()
        }
    }
}