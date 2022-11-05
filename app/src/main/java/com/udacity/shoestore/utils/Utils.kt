package com.udacity.shoestore.utils

import android.app.Activity
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager

object Utils {

    fun isValidEmail(emailAdress: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(emailAdress).matches()
}