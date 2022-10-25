package com.chetu.demotp8.mvvm.roomDb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserListActivityViewModel(private val repository: UserRepository) : ViewModel() {
    val firstName  = MutableLiveData<String>()
    val lastName  = MutableLiveData<String>()
    val mobileNo = MutableLiveData<String>()
    val saveOrUpdateButtonText = MutableLiveData<String>()
    val clearAllOrDeleteButtonText = MutableLiveData<String>()


    val userList = repository.users // LiveData List from DB
    private var isUpdateOrDelete : Boolean = false
    private lateinit var userTOUpdateOrDelete : User
    private val statusMessage = MutableLiveData<Event<String>>()

    val message : LiveData<Event<String>>
    get() = statusMessage

    init {
        saveOrUpdateButtonText.value = "SAVE"
        clearAllOrDeleteButtonText.value = "CLEAR ALL"
    }


    fun saveOrUpdate(){
        if (isUpdateOrDelete){
            userTOUpdateOrDelete.fistName = firstName.value!!
            userTOUpdateOrDelete.lastName = lastName.value!!
            userTOUpdateOrDelete.mobilNo = mobileNo.value!!
            update(userTOUpdateOrDelete)
        }else {
            val fName = firstName.value!!
            val lName = lastName.value!!
            val mobile = mobileNo.value!!
            insert(User(0, fName, lName, mobile))
            firstName.value = ""
            lastName.value = ""
            mobileNo.value = ""
        }
    }

    fun  clearAllOrDelete(){
        if (isUpdateOrDelete){
            delete(userTOUpdateOrDelete)
        }else {
            deleteAll()
        }
    }

    fun insert(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(user)

            withContext(Dispatchers.Main){
                statusMessage.value = Event("User inserted successfully")
            }
        }
    }

    fun update(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(user)

            withContext(Dispatchers.Main){
                firstName.value = ""
                lastName.value = ""
                mobileNo.value = ""

                isUpdateOrDelete = false
                saveOrUpdateButtonText.value = "SAVE"
                clearAllOrDeleteButtonText.value = "Delete All"

                statusMessage.value = Event("User updated successfully")
            }

        }
    }

    fun delete(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.delete(user)

            withContext(Dispatchers.Main){
                firstName.value = ""
                lastName.value = ""
                mobileNo.value = ""

                isUpdateOrDelete = false
                saveOrUpdateButtonText.value = "SAVE"
                clearAllOrDeleteButtonText.value = "Delete All"
                statusMessage.value = Event("User deleted successfully")
            }
        }
    }

    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllUser()
            withContext(Dispatchers.Main){
                statusMessage.value = Event("All User deleted successfully")
            }
        }
    }

    fun initUpdateOrDelete(user: User){
        firstName.value = user.fistName
        lastName.value = user.lastName
        mobileNo.value = user.mobilNo

        isUpdateOrDelete = true
        userTOUpdateOrDelete = user
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }
}