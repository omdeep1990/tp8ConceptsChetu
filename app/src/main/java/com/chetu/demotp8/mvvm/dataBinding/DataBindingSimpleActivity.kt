package com.chetu.demotp8.mvvm.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityDataBindingSimpleBinding

class DataBindingSimpleActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDataBindingSimpleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_simple)

        //TODO: Simple dataBinding use: -
        binding.submitBtn.setOnClickListener {
            binding.tvName.text = binding.firstName.text.toString()+" "+binding.lastName.text.toString()
            binding.tvEmail.text = binding.emailId.text.toString()
        }
    }
}