package com.chetu.demotp8.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.FragmentTwoBinding

class FragmentTwo : Fragment() {
    private lateinit var binding : FragmentTwoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentTwoBinding.inflate(layoutInflater, container, false)



        return binding.root
    }
}