package com.narsha.sundolls_ep_android.ui.viewmodel

import android.content.Intent
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.narsha.sundolls_ep_android.ui.activity.Home
import com.narsha.sundolls_ep_android.ui.activity.LoginOAuth

class LoginOAuthViewModel: ViewModel() {

    private val _goHome = MutableLiveData<Boolean>()

    val goHome: LiveData<Boolean>
        get() = _goHome
    fun callSignIn() {
        _goHome.value = true
    }


}