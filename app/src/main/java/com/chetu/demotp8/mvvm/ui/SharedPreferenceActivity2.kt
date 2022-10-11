package com.chetu.demotp8.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivitySharedPreference2Binding
import com.chetu.demotp8.mvvm.factory.SharedPreferenceFactory2
import com.chetu.demotp8.mvvm.viewModel.SharedPreferenceViewModel2

class SharedPreferenceActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivitySharedPreference2Binding
    private lateinit var factory : SharedPreferenceFactory2
    private lateinit var viewModel : SharedPreferenceViewModel2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shared_preference2)

        factory = SharedPreferenceFactory2(this)
        viewModel = ViewModelProvider(this, factory)[SharedPreferenceViewModel2::class.java]

        binding.btnSave.setOnClickListener {
            viewModel.setUsername(binding.username.text.toString())
            viewModel.setPassword(binding.password.text.toString())
            binding.showData.text = viewModel.getUsername()+", "+viewModel.getPassword()
        }
    }
}