package com.narsha.sundolls_ep_android.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.ActivityLoginOauthBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.LoginOAuthViewModel

class LoginOAuth : AppCompatActivity() {
    private val viewModel: LoginOAuthViewModel by lazy { ViewModelProvider(this)[LoginOAuthViewModel::class.java] }
    private val binding by lazy { DataBindingUtil.setContentView<ActivityLoginOauthBinding>(this, R.layout.activity_login_oauth) }

    companion object {
        private lateinit var instance: LoginOAuth

        fun getInstance(): LoginOAuth {
            return instance
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.login = viewModel
        binding.lifecycleOwner = this
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        viewModel.goHome.observe(this) {
            startActivity(Intent(this, Home::class.java))
            finish()
        }
    }

    override fun onPause() {
        super.onPause()

    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}