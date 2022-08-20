package com.nirwashh.android.livedatasimpleexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nirwashh.android.livedatasimpleexample.model.User
import com.nirwashh.android.livedatasimpleexample.model.UserData

class UserViewModel() : ViewModel() {
    private val users: MutableLiveData<List<User>> = MutableLiveData()

    init {
        users.value = UserData.getUsers()
    }

    fun getListUsers() = users

    fun updateUserList() {
        users.value = UserData.getAnotherUsers()
    }
}