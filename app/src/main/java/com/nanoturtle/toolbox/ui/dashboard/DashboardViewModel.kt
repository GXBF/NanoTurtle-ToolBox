package com.nanoturtle.toolbox.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "由于这段删了会死，所以我不删了😭"
    }
    val text: LiveData<String> = _text
}