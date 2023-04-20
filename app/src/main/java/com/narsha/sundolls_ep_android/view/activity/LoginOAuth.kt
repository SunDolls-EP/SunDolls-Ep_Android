package com.narsha.sundolls_ep_android.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.viewmodel.LoginOAuthViewModel

class LoginOAuth : AppCompatActivity() {
//    private lateinit var viewModel: LoginOAuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_oauth)
//        viewModel = ViewModelProvider(this)[LoginOAuthViewModel::class.java]
    }
}