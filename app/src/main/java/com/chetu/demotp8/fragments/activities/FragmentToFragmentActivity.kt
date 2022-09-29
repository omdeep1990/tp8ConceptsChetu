package com.chetu.demotp8.fragments.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityFragmentToFragmentBinding
import com.chetu.demotp8.fragments.fragments.FragmentDisplsy
import com.chetu.demotp8.fragments.fragments.FragmentInput
import com.chetu.demotp8.fragments.interfaces.OnInputTextListener

class FragmentToFragmentActivity : AppCompatActivity(), OnInputTextListener {
    private lateinit var binding : ActivityFragmentToFragmentBinding
    private lateinit var fgManager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentToFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fgManager = supportFragmentManager
        openFragmentInput(FragmentInput())
    }
    private fun openFragmentInput(fragmentInput : FragmentInput) {
        val fgTransaction = fgManager.beginTransaction()
        fgTransaction.add(R.id.fm_l1, fragmentInput)
        fgTransaction.commit()
    }

    override fun onTextInput(input: String) {
        val fragmentDisplay = FragmentDisplsy()
        val bundle = Bundle()
        bundle.putString("key", input)
        fragmentDisplay.arguments = bundle
        val fgTransaction = fgManager.beginTransaction()
        fgTransaction.add(R.id.fm_l2, fragmentDisplay)
        fgTransaction.commit()
    }
}