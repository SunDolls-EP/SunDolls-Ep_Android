package com.narsha.sundolls_ep_android.ui.viewmodel.activity

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.Intent.FLAG_ACTIVITY_NO_ANIMATION
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.narsha.sundolls_ep_android.ui.activity.Home
import com.narsha.sundolls_ep_android.ui.activity.Login

class LoginOAuthViewModel: ViewModel() {
    fun nextActivity() {
        val intent = Intent(Login.applicationContext(), Home::class.java)
        Login.applicationContext().startActivity(intent.addFlags(FLAG_ACTIVITY_NO_ANIMATION))
    }

}
