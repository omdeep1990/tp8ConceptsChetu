package com.chetu.demotp8.mvvm.repository

import android.content.Context
import android.content.SharedPreferences

private const val USERNAME2 = "username2"
private const val PASSWORD2 = "password2"
private const val PREFS = "pref"

object SharedPreferenceRepository2 {
    //TODO: Use Of Singleton Object: -
    private fun getInstance(context: Context) : SharedPreferences {
        return context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
    }
    fun setUsername(username : String?, context: Context) {
        getInstance(context).edit().putString(USERNAME2, username).commit()
    }
    fun setPassword(password : String?, context: Context) {
        getInstance(context).edit().putString(PASSWORD2, password).commit()
    }
    fun getUsername(context: Context) : String? {
        return getInstance(context).getString(USERNAME2, "")
    }
    fun getPassword(context: Context) : String? {
        return getInstance(context).getString(PASSWORD2, "")
    }
}