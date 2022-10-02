package com.chetu.demotp8.fragments.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.chetu.demotp8.fragments.fragments.FragmentLogin
import com.chetu.demotp8.fragments.fragments.FragmentSignUp

const val FRG_COUNT = 2
class LoginSignUpPageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return FRG_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                FragmentLogin()
            }
            else -> {
                FragmentSignUp()
            }
        }
    }
}