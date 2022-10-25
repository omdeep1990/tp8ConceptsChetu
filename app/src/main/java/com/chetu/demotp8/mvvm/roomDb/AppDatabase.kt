package com.chetu.demotp8.mvvm.roomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract val userDao : UserDao
    companion object{
        // TODO: MIGRATION CODE
        val migration = object : Migration(1, 2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE User ADD COLUMN Middle_Name TEXT")
            }
        }

        @Volatile
        private var INSTANCE : AppDatabase? = null
        fun getInstance(context : Context) : AppDatabase {
            var instance = INSTANCE
            synchronized(this){
                if (instance == null){
                    instance = Room.databaseBuilder(context, AppDatabase::class.java, "userDatabase").build()
                    INSTANCE = instance
                }
                return instance!!
            }
        }
    }
}