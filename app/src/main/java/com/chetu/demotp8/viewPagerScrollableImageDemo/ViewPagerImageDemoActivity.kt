package com.chetu.demotp8.viewPagerScrollableImageDemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityViewPagerImageDemoBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerImageDemoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityViewPagerImageDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_pager_image_demo)

        setUpViewPager2()
    }

    private fun setUpViewPager2() {
        val list : MutableList<PagerImages> = ArrayList()
        list.add(PagerImages(R.drawable.movie1))
        list.add(PagerImages(R.drawable.img))
        list.add(PagerImages(R.drawable.butterfly))
        list.add(PagerImages(R.drawable.krishna))
        list.add(PagerImages(R.drawable.bike))
        list.add(PagerImages(R.drawable.movie6))

        binding.Pager2.adapter = ViewPager2Adapter(list, this)

        TabLayoutMediator(binding.tabLayout, binding.Pager2) {
            tab, position ->

        }.attach()
    }
}