package com.chetu.demotp8.mvvm.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityDataBindingScopeFnBinding
import com.chetu.demotp8.mvvm.model.User
import com.chetu.demotp8.mvvm.model.UserData

class DataBindingScopeFnActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDataBindingScopeFnBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_scope_fn)

        //TODO: 2. Second method to print using data class and scope function: -
        /*val user = User()*/ /*OR*/ val user : User = getUser()
        binding.apply {
            tvName.text = user.fName+" "+user.lName
            tvEmail.text = user.email
        }


        //TODO: 1. First method to print using scope function: -
        binding.submitBtn.setOnClickListener {
            binding.apply {
                tvName.text = binding.firstName.text.toString()+" "+binding.lastName.text.toString()
                tvEmail.text = binding.emailId.text.toString()
            }
        }
    }
    private fun getUser() : User {
        return User()
    }
}