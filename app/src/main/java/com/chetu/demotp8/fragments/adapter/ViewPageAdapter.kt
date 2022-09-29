package com.chetu.demotp8.fragments.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.chetu.demotp8.fragments.fragments.FragmentDisplsy
import com.chetu.demotp8.fragments.fragments.FragmentInput
import com.chetu.demotp8.fragments.fragments.FragmentOne
import com.chetu.demotp8.fragments.fragments.FragmentTwo

const val FG_COUNT = 4
class ViewPageAdapter(private val fragment : FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return FG_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                FragmentOne()
            }
            1 -> {
                FragmentTwo()
            }
            2 -> {
                FragmentInput()
            }
            else -> {
                FragmentDisplsy()
            }
        }
    }

}