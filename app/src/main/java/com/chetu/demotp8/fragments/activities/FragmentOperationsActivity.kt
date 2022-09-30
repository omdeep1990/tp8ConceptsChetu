package com.chetu.demotp8.fragments.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityFragmentOperationsBinding
import com.chetu.demotp8.fragments.fragments.FragmentOne
import com.chetu.demotp8.fragments.fragments.FragmentTwo

class FragmentOperationsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityFragmentOperationsBinding
    private lateinit var fgManager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentOperationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fgManager = supportFragmentManager

        binding.addFragment.setOnClickListener(this)
        binding.replaceFragment.setOnClickListener(this)
        binding.removeFragment.setOnClickListener(this)
        binding.popFragment.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.add_fragment -> {
                val fgTransaction = fgManager.beginTransaction()
                fgTransaction.add(binding.flOperations.id, FragmentOne())
                fgTransaction.addToBackStack(null)
                fgTransaction.commit()
            }
            R.id.replace_fragment -> {
                val fgTransaction = fgManager.beginTransaction()
                fgTransaction.replace(binding.flOperations.id, FragmentTwo())
                fgTransaction.addToBackStack(null)
                fgTransaction.commit()
            }
            R.id.remove_fragment -> {
                val fgTransaction = fgManager.beginTransaction()
                for (fragment in fgManager.fragments) {
                    fgTransaction.remove(fragment)
                }
                fgTransaction.commit()
            }
            R.id.pop_fragment -> {
                fgManager.popBackStack()
            }
        }
    }
}