package com.narsha.sundolls_ep_android.data.network.oauth.kakao

import android.util.Log
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.narsha.sundolls_ep_android.App
import com.narsha.sundolls_ep_android.data.network.retrofit.ClientRetrofit
import com.narsha.sundolls_ep_android.data.network.retrofit.response.login_response.LoginResponse
import com.narsha.sundolls_ep_android.ui.activity.LoginActivity
import com.narsha.sundolls_ep_android.ui.viewmodel.activity.LoginOAuthViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class KakaoLogin {
    private val context = LoginActivity.instance
    private val loginOAuthViewModel = LoginOAuthViewModel()


    fun kakaoAccessToken() {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.e("카카오", "카카오계정으로 로그인 실패", error)
            } else if (token != null) {
                val kakaoAccessToken = token.accessToken
                Log.i("카카오", "카카오계정으로 로그인 성공 ${token.accessToken}")
                kakaoLogin(kakaoAccessToken)
            }
        }

        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                if (error != null) {
                    Log.e("카카오", "카카오톡으로 로그인 실패", error)

                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        return@loginWithKakaoTalk
                    }

                    UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
                } else if (token != null) {
                    val kakaoAccessToken = token.accessToken
                    Log.i("카카오", "카카오톡으로 로그인 성공 ${token.accessToken}")
                    kakaoLogin(kakaoAccessToken)
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
        }
    }

    private fun kakaoLogin(token: String) {
        ClientRetrofit.api.kakaoLogin(token).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if(response.code() == 200){
                    val data = response.body()
                    App.prefs.accessToken = response.headers()["authorization"]!!
                    App.prefs.name = data?.username?:""
                    App.prefs.school = data?.schoolName?:""
                    Log.d("retrofit", App.prefs.accessToken)
                    Log.d("retrofit",response.body().toString())
                    loginOAuthViewModel.nextActivity()
                } else {
                    Log.d("retrofit",response.code().toString())
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("retrofit",t.message.toString())
            }

        })
    }

}