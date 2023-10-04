package com.narsha.sundolls_ep_android.ui.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.kakao.sdk.common.KakaoSdk
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.data.network.oauth.google.LoginGoogle
import com.narsha.sundolls_ep_android.data.network.oauth.kakao.KakaoLogin
import com.narsha.sundolls_ep_android.databinding.ActivityLoginOauthBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.activity.LoginOAuthViewModel

class LoginActivity : AppCompatActivity() {

    companion object {
        lateinit var instance: LoginActivity
        fun applicationContext(): Context {
            return instance.applicationContext
        }
    }

    init {
        instance = this
    }

    private val viewModel: LoginOAuthViewModel by lazy { ViewModelProvider(this)[LoginOAuthViewModel::class.java] }
    private val binding: ActivityLoginOauthBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_login_oauth
        )
    }

    private val loginGoogle = LoginGoogle()
    private val loginOAuthViewModel = LoginOAuthViewModel()
    private val kakaoLogin = KakaoLogin()


    private val signInResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                LoginGoogle().handleSignInResult(task)
            } else {
                Log.d("애러", result.toString())
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.login = viewModel
        binding.lifecycleOwner = this

        //kakaoSdk 초기화
        KakaoSdk.init(this, getString(R.string.kakao_reactive_app_key))

        with(binding) {
            GoogleLoginButton.setOnClickListener {
                val signInIntent = loginGoogle.googleSignInClient.signInIntent
                signInResultLauncher.launch(signInIntent)
            }
            KakaoLoginButton.setOnClickListener { kakaoLogin.kakaoAccessToken() }
        }
    }
}