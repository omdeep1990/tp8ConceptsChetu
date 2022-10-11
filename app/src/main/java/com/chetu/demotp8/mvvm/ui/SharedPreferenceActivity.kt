package com.chetu.demotp8.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivitySharedPreferenceBinding
import com.chetu.demotp8.mvvm.factory.SharedPreferenceFactory
import com.chetu.demotp8.mvvm.viewModel.SharedPreferenceViewModel

class SharedPreferenceActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySharedPreferenceBinding
    private lateinit var factory : SharedPreferenceFactory
    private lateinit var viewModel : SharedPreferenceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shared_preference)

        factory = SharedPreferenceFactory(this)
        viewModel = ViewModelProvider(this, factory)[SharedPreferenceViewModel::class.java]

        binding.btnSave.setOnClickListener {
            viewModel.setUsername(binding.username.text.toString())
            viewModel.setPassword(binding.password.text.toString())
            binding.showData.text = viewModel.getUsername()!!+","+viewModel.getPassword()!!
        }

    }
}