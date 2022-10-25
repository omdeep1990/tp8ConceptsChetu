package com.chetu.demotp8.mvvm.roomDb

class UserRepository(private val userDao: UserDao) {
    val users = userDao.getAllUsers()

    suspend fun insert(user: User){
        userDao.insertUser(user)
    }

    suspend fun update(user: User){
        userDao.updateUser(user)
    }

    suspend fun delete(user: User){
        userDao.delete(user)
    }

    suspend fun deleteAllUser(){
        userDao.deleteAllUser()
    }
}