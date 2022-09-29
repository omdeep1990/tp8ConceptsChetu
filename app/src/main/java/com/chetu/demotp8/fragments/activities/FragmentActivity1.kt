package com.chetu.demotp8.fragments.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityFragment1Binding
import com.chetu.demotp8.fragments.fragments.FragmentOne
import com.chetu.demotp8.fragments.fragments.FragmentTwo

class FragmentActivity1 : AppCompatActivity() {
    private lateinit var binding : ActivityFragment1Binding
    private lateinit var fragmentManager : FragmentManager
//    private lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragment1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentManager = supportFragmentManager
        //TODO: Adding fragments dynamically at run time: -
        addFragmentOne()
        addFragmentTwo()
    }

    //TODO: Adding fragment one: -
    private fun  addFragmentOne() {
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fl_1, FragmentOne())
        fragmentTransaction.commit()
    }

    //TODO: Adding fragment two: -
    private fun addFragmentTwo() {
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fl_2, FragmentTwo())
        fragmentTransaction.commit()
    }
}