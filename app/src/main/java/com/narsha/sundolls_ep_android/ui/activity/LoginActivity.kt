package com.narsha.sundolls_ep_android.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.ActivityLoginOauthBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.UserViewModel
import com.narsha.sundolls_ep_android.utils.OnSingleClickListener

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginOauthBinding by lazy {
        ActivityLoginOauthBinding.inflate(layoutInflater)
    }
    companion object {
        lateinit var instance: LoginActivity
        fun applicationContext(): Context {
            return instance.applicationContext
        }
    }

    init {
        instance = this
    }

    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        KakaoSdk.init(this, getString(R.string.kakao_reactive_app_key))

        val signInResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                    handleSignInResult(task)
                } else {
                    Log.d("애러", result.toString())
                }
            }

        with(binding) {
            GoogleLoginButton.setOnClickListener(OnSingleClickListener {
                googleLogin(
                    signInResultLauncher
                )
            })

            KakaoLoginButton.setOnClickListener(OnSingleClickListener { kakaoLogin() })
        }

        with(viewModel) {
            userData.observe(this@LoginActivity) {
                Intent(this@LoginActivity, HomeActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
        }
    }

    private fun googleLogin(signInResultLauncher: ActivityResultLauncher<Intent>) {

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("224818744622-c01jteud2afgr9o296c3p4h0p42hmar7.apps.googleusercontent.com")
            .requestEmail()
            .requestProfile()
            .build()

        val googleSignInClient: GoogleSignInClient by lazy {
            GoogleSignIn.getClient(applicationContext(), gso)
        }

        val signInIntent = googleSignInClient.signInIntent

        signInResultLauncher.launch(signInIntent)
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val idToken = account.idToken.toString()
            Log.d("토큰",idToken)
            viewModel.login("google", idToken)
        } catch (e: ApiException) {
            Log.d("상태", e.message.toString())
        }
    }

    private fun kakaoLogin() {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.e("카카오", "카카오계정으로 로그인 실패", error)
            } else if (token != null) {
                val kakaoAccessToken = token.idToken ?: ""
                Log.i("카카오", "카카오계정으로 로그인 성공 $kakaoAccessToken")
                viewModel.login("kakao", kakaoAccessToken)
            }
        }

        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
            UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                if (error != null) {
                    Log.e("카카오", "카카오톡으로 로그인 실패", error)

                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        return@loginWithKakaoTalk
                    }

                    UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
                } else if (token != null) {
                    val kakaoAccessToken = token.accessToken
                    Log.i("카카오", "카카오톡으로 로그인 성공 ${token.accessToken}")
                    viewModel.login("kakao", kakaoAccessToken)
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
        }
    }

}