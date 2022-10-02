package com.chetu.demotp8.fragments.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityLoginSignUpTabBinding
import com.chetu.demotp8.fragments.adapter.LoginSignUpPageAdapter
import com.google.android.material.tabs.TabLayoutMediator

class LoginSignUpTabActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginSignUpTabBinding
    private val tabList = arrayOf("Login", "Sign Up")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginSignUpTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = LoginSignUpPageAdapter(this)
        binding.viewPager.adapter = adapter

        //TODO: TabLayoutMediator for interaction between TabLayout and ViewPager: -
        TabLayoutMediator(binding.tabLayout, binding.viewPager, ) {tab, position ->
            tab.text = tabList[position]
        }.attach()
    }
}