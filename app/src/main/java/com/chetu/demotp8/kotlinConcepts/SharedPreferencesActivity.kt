package com.chetu.demotp8.kotlinConcepts

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivitySharedPreferencesBinding

class SharedPreferencesActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivitySharedPreferencesBinding
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitBtn.setOnClickListener(this)
        binding.clearDataBtn.setOnClickListener(this)

        sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.submit_btn -> {
                    editor.putString("name", binding.name.text.toString())
                    editor.commit()
                    binding.showData.text = sharedPreferences.getString("name", "No Data")
                }
                R.id.clear_data_btn -> {
                    editor.clear()
                    editor.commit()
                    binding.showData.text = sharedPreferences.getString("name", "No Data")
                }
            }
        }
    }
}