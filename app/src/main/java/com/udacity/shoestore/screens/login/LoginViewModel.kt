package com.udacity.shoestore.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.utils.Utils

class LoginViewModel : ViewModel() {

    val username = MutableLiveData<String>()

    private val _showError = MutableLiveData(false)
    val showError: LiveData<Boolean>
        get() = _showError

    private fun isValidEmail(): Boolean = Utils.isValidEmail(username.value ?: "")

    fun clearUsernameError() {
        if (_showError.value == true) _showError.value = false
    }

    fun isValidUsername(): Boolean {
        val isValidUsername = isValidEmail()
        _showError.value = !isValidUsername
        return isValidUsername
    }
}