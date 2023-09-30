package com.narsha.sundolls_ep_android.ui.viewmodel.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _timerStatus = MutableLiveData(false)
    val timerStatus: LiveData<Boolean> get() = _timerStatus

    fun onClick(){
        _timerStatus.value = _timerStatus.value != true
    }
}