package com.chetu.demotp8.mvvm.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityMvvmDemoBinding
import com.chetu.demotp8.mvvm.viewModel.MyViewModel

class MvvmDemoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMvvmDemoBinding
    private lateinit var viewModel : MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_demo)


        viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        binding.myViewModel = viewModel
        binding.getCount.text = viewModel.getRecentCount().toString()

        binding.countBtn.setOnClickListener {
            binding.getCount.text = viewModel.getUpdatedCount().toString()
        }
    }
}