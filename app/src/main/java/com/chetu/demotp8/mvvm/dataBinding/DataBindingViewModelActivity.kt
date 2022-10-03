package com.chetu.demotp8.mvvm.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityDataBindingViewModelBinding
import com.chetu.demotp8.mvvm.model.User
import com.chetu.demotp8.mvvm.model.UserData

class DataBindingViewModelActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDataBindingViewModelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_view_model)

        binding.myViewModel = getUser()
    }
    private fun getUser() : UserData {
        return UserData("Omdeep", "Singh", "omdeep1990@gmai.com")
    }
}