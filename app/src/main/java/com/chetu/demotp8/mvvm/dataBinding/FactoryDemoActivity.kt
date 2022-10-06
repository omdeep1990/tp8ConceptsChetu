package com.chetu.demotp8.mvvm.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityFactoryDemoBinding
import com.chetu.demotp8.mvvm.factory.FactoryDemo
import com.chetu.demotp8.mvvm.viewModel.FactoryDemoViewModel

class FactoryDemoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFactoryDemoBinding
    private lateinit var viewModel : FactoryDemoViewModel
    private lateinit var factory : FactoryDemo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_factory_demo)

        factory = FactoryDemo(0)
        viewModel = ViewModelProvider(this, factory)[FactoryDemoViewModel::class.java]

        //TODO: Using Scope Function for the below code: -
        binding.apply {
            getCount.text = viewModel.getRecentCount().toString()
            countBtn.setOnClickListener {
                getCount.text = viewModel.getUpdatedCount().toString()
        }
        }
    }
}