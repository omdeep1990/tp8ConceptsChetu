package com.chetu.demotp8.mvvm.util

object DBKeys {
    const val DB_NAME = "contact_data"
    const val TABLE_NAME = "user_info"
    const val DB_VERSION = 1
    const val SR_NO = "SR_NO"
    const val FIRST_NAME = "FIRST_NAME"
    const val LAST_NAME = "LAST_NAME"
    const val MOBILE_NO = "MOBILE_NO"
    val createDb : String = "CREATE TABLE $TABLE_NAME ($SR_NO INTEGER AUTOINCREMENT PRIMARY KEY, $FIRST_NAME TEXT, $LAST_NAME TEXT, $MOBILE_NO TEXT)"
//    val createDb : String by lazy { "CREATE TABLE $TABLE_NAME ($SR_NO INTEGER AUTOINCREMENT PRIMARY KEY, $FIRST_NAME TEXT, $LAST_NAME TEXT, $MOBILE_NO TEXT)" }
}