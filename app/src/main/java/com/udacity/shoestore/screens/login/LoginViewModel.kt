package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.utils.Utils

class LoginViewModel : ViewModel() {

    val username = MutableLiveData<String>()

    private val _usernameError = MutableLiveData<String>()
    val usernameError: LiveData<String>
        get() = _usernameError

    val isValidUsername: Boolean = Utils.isValidEmail(username.value ?: "")

    fun clearUsernameError() {
        _usernameError.value = ""
    }

    fun validateUsername() {
        if (!isValidUsername) {
            _usernameError.value = "Please enter a valid e-mail address"
        }
    }
}