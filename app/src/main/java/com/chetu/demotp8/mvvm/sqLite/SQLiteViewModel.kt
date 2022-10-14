package com.chetu.demotp8.mvvm.sqLite

import android.content.Context
import androidx.lifecycle.ViewModel

class SQLiteViewModel(private val context : Context) : ViewModel() {

    private val repository : SQLiteRepository = SQLiteRepository(context)

    fun createData(fName : String, lName : String, mobile : String) {
        repository.createDb(fName, lName, mobile)
    }

    fun getDataList() : List<PersonalData> {
        return repository.getPersonalData()
    }

    fun updateDataList(srNo : String, fName : String, lName : String, mobile : String) {
        repository.updatePersonalData(srNo, fName, lName, mobile)
    }

    fun deleteSingleData(srNo : String) {
        repository.deleteSingleData(srNo)
    }

    fun deleteAllData() {
        repository.deleteAllData()
    }
}