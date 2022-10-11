package com.chetu.demotp8.mvvm.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.chetu.demotp8.mvvm.util.DBKeys.DB_NAME
import com.chetu.demotp8.mvvm.util.DBKeys.DB_VERSION
import com.chetu.demotp8.mvvm.util.DBKeys.createDb

class SQLiteRepository(private val context: Context) {

    private val dbHelper = MyDbHelper(context)

    inner class MyDbHelper(private val context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
        override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {
            sqLiteDatabase!!.execSQL(createDb)
        }

        override fun onUpgrade(sqLiteDatabase: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        }
    }
}