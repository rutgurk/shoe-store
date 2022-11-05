package com.udacity.shoestore.screens.login

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.BR
import com.udacity.shoestore.utils.Utils

class LoginViewModel : ViewModel(), Observable {

    private val _username = MutableLiveData<String>()

    var username: String
        @Bindable get() {
            return _username.value ?: ""
        }
        set(value) {
            if (_username.value != value) {
                _username.value = value
                callbacks.notifyCallbacks(this, BR.username, null)
            }
        }

    val isValidUsername: Boolean
        @Bindable get() = Utils.isValidEmail(username)

    fun resetError() {

    }

    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }

}