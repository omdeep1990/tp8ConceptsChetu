package com.chetu.demotp8.mvvm.dataBinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityDataBindingTaskBinding
import com.chetu.demotp8.mvvm.viewModel.TaskViewModel

class DataBindingTaskActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDataBindingTaskBinding
    private lateinit var viewModel : TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_task)

        viewModel = ViewModelProvider(this)[TaskViewModel::class.java]
        binding.myViewModel = viewModel
        binding.tvDisplay.text = viewModel.getRecentCount().toString()

        binding.addBtn.setOnClickListener {
            viewModel.getUpdatedCount(binding.input.text.toString().toInt())
            var data : Int = viewModel.getRecentCount()
            binding.tvDisplay.text = data.toString()
        }
    }
}