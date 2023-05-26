package com.narsha.sundolls_ep_android.ui.viewmodel.fragment

import android.view.Gravity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.narsha.sundolls_ep_android.databinding.ActivityHomeBinding
import com.narsha.sundolls_ep_android.databinding.FragmentHomeBinding
import com.narsha.sundolls_ep_android.ui.fragment.HomeFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.timer

class HomeViewModel : ViewModel() {


    private val _onclickDrawerLayout = MutableLiveData<Boolean>()
    val onclickDrawerLayout: LiveData<Boolean>
        get() = _onclickDrawerLayout

    private val _Timer = MutableLiveData<Long>()
    val Timer: LiveData<Long>
        get() = Timer

    private val _timerState = MutableLiveData<Boolean>()
    val timerState: LiveData<Boolean>
        get() = _timerState

    private val _timerSkip = MutableLiveData<Boolean>()
    val timerSkip: LiveData<Boolean>
        get() = _timerSkip



    fun onclickDrawerLayout() {
        _onclickDrawerLayout.value = true
    }

    fun timer(){
        _timerState.value = true
    }

    fun skip(){
        _timerSkip.value = true
    }



    fun onclickDrawerOpen(binding: FragmentHomeBinding) {
        if (binding.DrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            binding.DrawerLayout.closeDrawer(Gravity.LEFT)
        } else {
            binding.DrawerLayout.openDrawer(Gravity.LEFT)
        }
    }
}