package com.narsha.sundolls_ep_android.ui.viewmodel

import android.util.Log
import android.view.Gravity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.narsha.sundolls_ep_android.databinding.ActivityHomeBinding

class HomeViewModel:ViewModel() {


    private val _Check_Time = MutableLiveData<Int>()

    private val _onclickDrawerLayout = MutableLiveData<Boolean>()
    val onclickDrawerLayout: LiveData<Boolean>
        get() = _onclickDrawerLayout

    val Check_Time: LiveData<Int>
        get() = _Check_Time

    fun Time(time: Int) {
        _Check_Time.value = time
    }


    fun OnclickDrawerLayout(){
        _onclickDrawerLayout.value = true
    }
    fun OnclickDrawerOpen(binding: ActivityHomeBinding){
        if (!binding.DrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            binding.DrawerLayout.openDrawer(Gravity.LEFT)
        } else {
            binding.DrawerLayout.closeDrawer(Gravity.LEFT)
        }
    }
}