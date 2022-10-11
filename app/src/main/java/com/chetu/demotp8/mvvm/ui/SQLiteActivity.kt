package com.chetu.demotp8.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.chetu.demotp8.R
import com.chetu.demotp8.databinding.ActivitySqliteBinding

class SQLiteActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySqliteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sqlite)
    }
}