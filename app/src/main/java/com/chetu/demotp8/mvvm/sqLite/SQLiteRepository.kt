package com.chetu.demotp8.mvvm.sqLite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.chetu.demotp8.mvvm.sqLite.DBKeys.DB_NAME
import com.chetu.demotp8.mvvm.sqLite.DBKeys.DB_VERSION
import com.chetu.demotp8.mvvm.sqLite.DBKeys.FIRST_NAME
import com.chetu.demotp8.mvvm.sqLite.DBKeys.LAST_NAME
import com.chetu.demotp8.mvvm.sqLite.DBKeys.MOBILE_NO
import com.chetu.demotp8.mvvm.sqLite.DBKeys.SR_NO
import com.chetu.demotp8.mvvm.sqLite.DBKeys.TABLE_NAME
import com.chetu.demotp8.mvvm.sqLite.DBKeys.createDb

class SQLiteRepository(private val context: Context) {

    private val dbHelper = MyDbHelper(context)
    private val sqLiteDb : SQLiteDatabase = dbHelper.writableDatabase

    fun createDb(fName: String, lName : String, mobile : String) {
        val contentValues = ContentValues()
        contentValues.put(FIRST_NAME, fName)
        contentValues.put(LAST_NAME, lName)
        contentValues.put(MOBILE_NO, mobile)

        val id : Long = sqLiteDb.insert(TABLE_NAME, null, contentValues)
        if (id > 0) {
            Toast.makeText(context, "Data Added Successfully.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Something Went Wrong. Please Try Again Later....", Toast.LENGTH_SHORT).show()
        }
    }

    fun getPersonalData() : List<PersonalData> {
        var personDataList : MutableList<PersonalData> = ArrayList<PersonalData>()

        val columnList = arrayOf(SR_NO, FIRST_NAME, LAST_NAME, MOBILE_NO)
        val cursor : Cursor = sqLiteDb.query(TABLE_NAME, columnList, null, null, null, null, null)
            if (cursor.moveToFirst()) {
                do {
                    val srNo : String = cursor.getString(0)
                    val fName : String = cursor.getString(1)
                    val lName : String = cursor.getString(2)
                    val mobile : String = cursor.getString(3)
                    val personalData = PersonalData(srNo, fName, lName, mobile)
                    personDataList.add(personalData)
                } while (cursor.moveToNext())
            }
        return personDataList
    }

    fun updatePersonalData(srNo : String, fName: String, lName : String, mobile : String) {
        val contentValues = ContentValues()
        contentValues.put(FIRST_NAME, fName)
        contentValues.put(LAST_NAME, lName)
        contentValues.put(MOBILE_NO, mobile)

        val id : Int = sqLiteDb.update(TABLE_NAME, contentValues, "$SR_NO=$srNo", null)
        if (id > 0) {
            Toast.makeText(context, "Data Updated Successfully.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Something Went Wrong. Please Try Again Later....", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteSingleData(srNo : String) {
        var total = sqLiteDb.delete(TABLE_NAME, "$SR_NO=$srNo",  null)
        if (total > 0) {
            Toast.makeText(context, "One data Deleted Successfully..", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Something Went Wrong. Please Try Again Later....", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteAllData() {
        var total = sqLiteDb.delete(TABLE_NAME, null,  null)
        if (total > 0) {
            Toast.makeText(context, "Whole data Deleted Successfully..", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Something Went Wrong. Please Try Again Later....", Toast.LENGTH_SHORT).show()
        }
    }

    inner class MyDbHelper(private val context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
        override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {
            sqLiteDatabase!!.execSQL(createDb)
        }

        override fun onUpgrade(sqLiteDatabase: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        }
    }
}