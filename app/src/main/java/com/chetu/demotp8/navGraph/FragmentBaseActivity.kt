package com.chetu.demotp8.navGraph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivityFragmentBaseBinding

class FragmentBaseActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFragmentBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fragment_base)


    }
}