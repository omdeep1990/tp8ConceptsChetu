package com.chetu.demotp8.fragments.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityTabLayoutViewPagerBinding
import com.chetu.demotp8.fragments.adapter.ViewPageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutViewPagerActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTabLayoutViewPagerBinding
    private val tabList = arrayOf("Chat", "Call", "Status", "Web", "Camera", "Demo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewPageAdapter(this)
        binding.viewPager.adapter = adapter

        //TODO: TabLayoutMediator for interaction between TabLayout and ViewPager: -
        TabLayoutMediator(binding.tabLayout, binding.viewPager,) {tab, position ->
            tab.text = tabList[position]

        }.attach()
    }
}