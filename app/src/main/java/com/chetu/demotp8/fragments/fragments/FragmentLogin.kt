package com.chetu.demotp8.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.FragmentLoginBinding

class FragmentLogin : Fragment() {
    private lateinit var binding : FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)


        return binding.root
    }
//    private fun validateData() : Boolean {
//        return true
//    }
}