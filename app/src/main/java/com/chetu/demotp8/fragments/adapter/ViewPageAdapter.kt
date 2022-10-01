package com.chetu.demotp8.fragments.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.chetu.demotp8.fragments.fragments.*

const val FG_COUNT = 6
class ViewPageAdapter(fragmentActivity : FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

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
                FragmentThree()
            }
            3 -> {
                FragmentFour()
            }
            4 -> {
                FragmentDemo()
            }
            else -> {
                FragmentDisplsy()
            }
        }
    }

}