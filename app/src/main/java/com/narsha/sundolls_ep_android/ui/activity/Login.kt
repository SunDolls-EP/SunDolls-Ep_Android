package com.narsha.sundolls_ep_android.ui.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.data.local.googleOAuth.LoginGoogle
import com.narsha.sundolls_ep_android.databinding.ActivityLoginOauthBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.LoginOAuthViewModel

class Login : AppCompatActivity() {

    companion object{
        lateinit var instance: Login
        fun ApplicationContext() : Context {
            return instance.applicationContext
        }
    }
    init{
        instance = this
    }
    private val viewModel: LoginOAuthViewModel by lazy { ViewModelProvider(this)[LoginOAuthViewModel::class.java] }
    private val binding: ActivityLoginOauthBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_login_oauth
        )
    }

    private val loginGoogle = LoginGoogle(this)
    private val loginOAuthViewModel = LoginOAuthViewModel()



    private val signInResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                LoginGoogle().handleSignInResult(task)
                finish()
            } else {
                Log.d("애러", result.toString())
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.login = viewModel
        binding.lifecycleOwner = this

        viewModel.registration.observe(this) {
            val signInIntent = loginGoogle.googleSignInClient.signInIntent
            signInResultLauncher.launch(signInIntent)
        }

        viewModel.non_registration.observe(this){
            loginOAuthViewModel.nextActivity()
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

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