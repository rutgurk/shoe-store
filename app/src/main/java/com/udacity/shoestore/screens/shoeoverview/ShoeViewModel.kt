package com.udacity.shoestore.screens.shoeoverview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    val shoeName = MutableLiveData<String>("")
    val shoeSize = MutableLiveData<String>("")
    val shoeCompany = MutableLiveData<String>("")
    val shoeDescription = MutableLiveData<String>("")

    val DEFAULT_MINIMUM_SHOESIZE: Double = 0.00

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val list = mutableListOf<Shoe>()

    fun createShoeFromInput() {
        addShoe(Shoe(formatValue(shoeName.value.toString()),formatShoeSize(shoeSize.value), formatValue(shoeCompany.value.toString()), formatValue(shoeDescription.value.toString())))
        clearInputValues()
    }

    private fun formatShoeSize(text: String?): Double {
        return if (text.isNullOrBlank()) DEFAULT_MINIMUM_SHOESIZE else text.toDouble()

    }

    private fun formatValue(text: String): String {
        return if (text.isNullOrBlank()) "" else text.trim()
    }

    private fun clearInputValues() {
        shoeName.value = ""
        shoeSize.value = ""
        shoeCompany.value = ""
        shoeDescription.value = ""
    }

    private fun addShoe(newShoe: Shoe) {
        list.add(newShoe)
        _shoeList.value = list
    }

}