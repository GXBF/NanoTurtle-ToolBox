package com.nanoturtle.toolbox.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "NanoTurtle的百宝箱0.0.5"
    }
    val text: LiveData<String> = _text
}