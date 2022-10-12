package com.chetu.demotp8.mvvm.sqLite

import android.content.Context
import androidx.lifecycle.ViewModel

class SQLiteViewModel(private val context : Context) : ViewModel() {

    val repository : SQLiteRepository = SQLiteRepository(context)

    fun createData(fName : String, lName : String, mobile : String) {
        repository.createDb(fName, lName, mobile)
    }
}