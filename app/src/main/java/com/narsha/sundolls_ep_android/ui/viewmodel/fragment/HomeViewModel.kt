package com.narsha.sundolls_ep_android.ui.viewmodel.fragment

import android.view.Gravity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.narsha.sundolls_ep_android.databinding.ActivityHomeBinding
import com.narsha.sundolls_ep_android.databinding.FragmentHomeBinding
import com.narsha.sundolls_ep_android.ui.fragment.HomeFragment

class HomeViewModel : ViewModel() {


    private val _onclickDrawerLayout = MutableLiveData<Boolean>()
    val onclickDrawerLayout: LiveData<Boolean>
        get() = _onclickDrawerLayout



    fun OnclickDrawerLayout() {
        _onclickDrawerLayout.value = true
    }



    fun OnclickDrawerOpen(binding: FragmentHomeBinding) {
        if (!binding.DrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            binding.DrawerLayout.openDrawer(Gravity.LEFT)
        } else {
            binding.DrawerLayout.closeDrawer(Gravity.LEFT)
        }
    }
}