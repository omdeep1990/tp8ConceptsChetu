package com.chetu.demotp8.fragments.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityFragmentToBinding
import com.chetu.demotp8.fragments.fragments.FragmentInput
import com.chetu.demotp8.fragments.interfaces.OnInputTextListener

class FragmentToActivity : AppCompatActivity(), OnInputTextListener {
    private lateinit var binding : ActivityFragmentToBinding
    private lateinit var fgManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentToBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fgManager = supportFragmentManager
        val fgTransaction = fgManager.beginTransaction()
        fgTransaction.add(R.id.frame_layout, FragmentInput())
        fgTransaction.commit()
    }

    //TODO: Sending data from Fragment To Activity, Here we are receiving data from FragmentInput(): -
    override fun onTextInput(input: String) {
        binding.tvDisplay.text = input
    }
}