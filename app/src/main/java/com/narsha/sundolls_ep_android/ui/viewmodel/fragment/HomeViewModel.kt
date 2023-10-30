package com.narsha.sundolls_ep_android.ui.viewmodel.fragment

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.narsha.sundolls_ep_android.base.BaseViewModel

class HomeViewModel : BaseViewModel() {
    private val _timerStatus = MutableLiveData(false)
    val timerStatus: LiveData<Boolean> get() = _timerStatus

    fun onClick(view: View){
        Log.d("상태","클릭")
        _timerStatus.value = _timerStatus.value != true
    }
}