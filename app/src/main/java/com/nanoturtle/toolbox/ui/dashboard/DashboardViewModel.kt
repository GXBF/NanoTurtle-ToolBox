package com.nanoturtle.toolbox.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "这里可以打开小天才隐藏的Activity。但是只有少部分可以免root打开，其他均需root。建议您root完再使用本功能！"
    }
    val text: LiveData<String> = _text
}