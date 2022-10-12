package com.chetu.demotp8.mvvm.sqLite

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SQLiteFactory(private val context : Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SQLiteViewModel::class.java)) {
            return SQLiteViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}