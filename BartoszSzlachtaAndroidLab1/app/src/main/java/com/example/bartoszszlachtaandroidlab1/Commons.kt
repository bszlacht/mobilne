package com.example.bartoszszlachtaandroidlab1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class User() : ViewModel() {
    var firstName = MutableLiveData<String>()
    var lastName = MutableLiveData<String>()
}