package com.narsha.sundolls_ep_android.ui.viewmodel.activity

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import com.narsha.sundolls_ep_android.base.BaseViewModel
import com.narsha.sundolls_ep_android.ui.activity.HomeActivity
import com.narsha.sundolls_ep_android.ui.activity.LoginActivity

class LoginOAuthViewModel: BaseViewModel() {
    fun nextActivity() {
        val intent = Intent(LoginActivity.applicationContext(), HomeActivity::class.java)
        LoginActivity.applicationContext().startActivity(intent.addFlags(FLAG_ACTIVITY_NEW_TASK))
    }

}
