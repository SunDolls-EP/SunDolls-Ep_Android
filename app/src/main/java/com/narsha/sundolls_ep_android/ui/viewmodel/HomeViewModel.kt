package com.narsha.sundolls_ep_android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel:ViewModel() {

    private val _Check_Time = MutableLiveData<Int>()

    val Check_Time: LiveData<Int>
        get() = _Check_Time

    fun Time(time: Int) {
        _Check_Time.value = time
    }

}