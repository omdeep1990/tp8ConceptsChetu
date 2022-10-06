package com.chetu.demotp8.mvvm.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityOneWayDataBindingBinding
import com.chetu.demotp8.mvvm.model.OneWayFactory
import com.chetu.demotp8.mvvm.viewModel.OnWayViewModel

class OneWayDataBindingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOneWayDataBindingBinding
    private lateinit var factory : OneWayFactory
    private lateinit var viewModel : OnWayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_one_way_data_binding)

        factory = OneWayFactory(0)
        viewModel = ViewModelProvider(this, factory)[OnWayViewModel::class.java]
        binding.lifecycleOwner = this
        binding.myViewModel = viewModel
    }
}