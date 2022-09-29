package com.chetu.demotp8.fragments.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityToFragmentBinding
import com.chetu.demotp8.fragments.fragments.FragmentDisplsy
import com.chetu.demotp8.fragments.fragments.FragmentInput
import com.chetu.demotp8.fragments.interfaces.OnInputTextListener

class ActivityToFragment : AppCompatActivity() {
    private lateinit var binding : ActivityToFragmentBinding
    private lateinit var fgManager : FragmentManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fgManager = supportFragmentManager

        //TODO: Sending data from activity to fragment i.e. FragmentDisplay(): -
        binding.sendToFragment.setOnClickListener {
            val fragmentDisplay = FragmentDisplsy()
            val bundle = Bundle()
            bundle.putString("key", binding.etInput.text.toString())
            fragmentDisplay.arguments = bundle
            val fgTransaction = fgManager.beginTransaction()
            fgTransaction.add(R.id.frame_layout1, fragmentDisplay)
            fgTransaction.commit()
        }
    }
}