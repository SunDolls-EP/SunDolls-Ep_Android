package com.narsha.sundolls_ep_android.ui.viewmodel.fragment

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.narsha.sundolls_ep_android.App
import com.narsha.sundolls_ep_android.databinding.ActivityHomeBinding
import com.narsha.sundolls_ep_android.databinding.FragmentHomeBinding
import com.narsha.sundolls_ep_android.ui.adapter.RecyclerViewTodoData
import com.narsha.sundolls_ep_android.ui.fragment.HomeFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.timer

class HomeViewModel : ViewModel() {

    private val _onclickDrawerLayout = MutableLiveData<Boolean>()

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable


    val onclickDrawerLayout: LiveData<Boolean>
        get() = _onclickDrawerLayout

    private val _timer = MutableLiveData<Long>()
    val timer: LiveData<Long>
        get() = _timer

    private val _timerState = MutableLiveData<Boolean>()
    val timerState: LiveData<Boolean>
        get() = _timerState

    private val _timerSkip = MutableLiveData<Boolean>()
    val timerSkip: LiveData<Boolean>
        get() = _timerSkip

    private val _onclickAddTODO = MutableLiveData<Boolean>()
    val onclickAddTODO: LiveData<Boolean>
        get() = _onclickAddTODO

    private val _todoListData = MutableLiveData<ArrayList<RecyclerViewTodoData>>()
    val todoListData: LiveData<ArrayList<RecyclerViewTodoData>>
        get() = _todoListData

    init {
        handler = Handler(Looper.getMainLooper())
        runnable = object : Runnable {
            override fun run() {
                updateTimer()
                handler.postDelayed(this, 1000) // 1초마다 실행
            }
        }
    }

    fun onclickDrawerLayout() {
        _onclickDrawerLayout.value = true
    }

    fun timerStatus(){
        if(_timerState.value != false){
            _timerState.value = false
            Log.d("버튼 정보",_timerState.value.toString())
            handler.removeCallbacks(runnable)
        } else {
            Log.d("버튼 정보",_timerState.value.toString())
            handler.postDelayed(runnable, 1000) // 1초마다 실행
            _timerState.value = true
        }
    }

    fun skip(){
        _timerSkip.value = true
        _timerState.value = false
        handler.removeCallbacks(runnable)
        App.prefs.time = 0
        _timer.value = App.prefs.time
    }

    fun addTODO(){
        _onclickAddTODO.value = true
    }

    fun onclickDrawerOpen(binding: FragmentHomeBinding) {
        if (binding.DrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            binding.DrawerLayout.closeDrawer(Gravity.LEFT)
        } else {
            binding.DrawerLayout.openDrawer(Gravity.LEFT)
        }
    }

    private fun updateTimer() {
        App.prefs.time++
        _timer.value = App.prefs.time
    }
}