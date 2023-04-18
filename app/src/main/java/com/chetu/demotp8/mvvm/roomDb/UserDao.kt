package com.chetu.demotp8.mvvm.roomDb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertUser(vararg user : User)

    @Query("SELECT * FROM User")
    fun getAllUsers() : LiveData<List<User>>

    @Delete
    suspend fun delete(user: User)

    @Query("DELETE FROM User")
    suspend fun deleteAllUser()

    @Update
    suspend fun updateUser(user: User)

}