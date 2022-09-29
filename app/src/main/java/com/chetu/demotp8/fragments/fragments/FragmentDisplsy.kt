package com.chetu.demotp8.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chetu.demotp8.databinding.FragmentDisplsyBinding

open class FragmentDisplsy : Fragment() {
    private lateinit var binding : FragmentDisplsyBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDisplsyBinding.inflate(layoutInflater)

        //TODO: Receiving data from FragmentInput(): -
        val bundle = arguments
        binding.tvDisplay.text = bundle?.getString("key")

        return binding.root
    }
}