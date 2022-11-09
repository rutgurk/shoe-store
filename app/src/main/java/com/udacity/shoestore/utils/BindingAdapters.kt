package com.udacity.shoestore.utils

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("errorText")
fun bindErrorText(view: TextInputLayout, errorText: String?) {
    if (errorText.isNullOrBlank()) {
        view.error = null
    } else {
        view.error = errorText
    }
}