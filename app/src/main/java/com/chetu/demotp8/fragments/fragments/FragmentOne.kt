package com.chetu.demotp8.fragments.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.FragmentOneBinding
import com.chetu.demotp8.fragments.interfaces.OnInputTextListener

class FragmentOne : Fragment() {
    private lateinit var binding : FragmentOneBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentOneBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
}