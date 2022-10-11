package com.chetu.demotp8.mvvm.repository

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

const val MY_TABLE = "my_table"
const val USERNAME = "username"
const val PASSWORD = "password"
class SharedPreferenceRepository(private var context : Context) {
    private var sharedPreferences : SharedPreferences = context.getSharedPreferences(MY_TABLE, Context.MODE_PRIVATE)
    private var editor : Editor = sharedPreferences.edit()

    fun setUsername(username : String) {
        editor.putString(USERNAME, username)
        editor.commit()
    }

    fun setPassword(password : String) {
        editor.putString(PASSWORD, password)
        editor.commit()
    }

    fun getUsername() : String? {
        return sharedPreferences.getString(USERNAME, "")
    }
    fun getPassword() : String? {
        return sharedPreferences.getString(PASSWORD, "")
    }
    fun getBoolean() : Boolean {
        return sharedPreferences.getBoolean(USERNAME, false)
    }
}