package com.chetu.demotp8.fragments.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.FragmentInputBinding
import com.chetu.demotp8.fragments.interfaces.OnInputTextListener

class FragmentInput : Fragment() {
    private lateinit var binding : FragmentInputBinding
    private lateinit var onInputTextListener: OnInputTextListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //TODO: TypeCasting context as Activity and activity as Interface: -
        var activity : Activity = context as Activity
        onInputTextListener = activity as OnInputTextListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentInputBinding.inflate(layoutInflater, container, false)

        //TODO: Sending data from fragment to fragment and fragment i.e. FragmentDisplay() using
        // FragmentToFragmentActivity() to activity i.e. FragmentToActivity() using interface: -
        binding.sendToActivity.setOnClickListener{
            onInputTextListener.onTextInput(binding.etInput.text.toString())
        }

        return binding.root
    }
}