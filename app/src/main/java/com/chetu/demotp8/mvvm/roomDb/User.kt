package com.chetu.demotp8.mvvm.roomDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "User_id") val userId : Int,
    @ColumnInfo(name = "First_Name") var fistName : String,
    @ColumnInfo(name = "Last_NAME") var lastName : String,
    @ColumnInfo(name = "Mobile_No") var mobilNo : String
)