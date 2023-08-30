package com.narsha.sundolls_ep_android.ui.viewmodel.activity

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.narsha.sundolls_ep_android.ui.activity.Home
import com.narsha.sundolls_ep_android.ui.activity.Login

class LoginOAuthViewModel: ViewModel() {

    private val _googleRegistration = MutableLiveData<Boolean>()
    private val _kakaoRegistration = MutableLiveData<Boolean>()
    val googleRegistration: LiveData<Boolean>
        get() = _googleRegistration
    val kakaoRegistration: LiveData<Boolean>
        get() = _kakaoRegistration
    private val _nonRegistration = MutableLiveData<Boolean>()
    val nonRegistration: LiveData<Boolean>
        get() = _nonRegistration

    fun nextActivity() {
        val intent = Intent(Login.applicationContext(), Home::class.java)
        Login.applicationContext().startActivity(intent.addFlags(FLAG_ACTIVITY_NEW_TASK))
    }

    fun nonRegistration(){
        _nonRegistration.value = true
    }

    fun googleRegistration() {
        _googleRegistration.value = true
    }

    fun kakaoRegistration(){
        _kakaoRegistration.value = true
    }

}
