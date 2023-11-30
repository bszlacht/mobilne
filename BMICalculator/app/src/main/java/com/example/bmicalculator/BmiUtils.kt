package com.example.bmicalculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiUtils() : ViewModel() {
    var weight = MutableLiveData<String>()
    var height = MutableLiveData<String>()
}
