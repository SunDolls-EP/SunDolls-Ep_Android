package com.narsha.sundolls_ep_android.data.network.retrofit

import com.narsha.sundolls_ep_android.data.network.retrofit.response.login_response.LoginResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface API {
    @GET("/login/oauth2/authorize/google")
    fun googleLogin(
        @Header("Authorization") googleIdToken: String
    ): Call<LoginResponse>

    @GET("/login/oauth2/authorize/kakao")
    fun kakaoLogin(
        @Header("Authorization") kakaoAccessToken: String,
    ): Call<LoginResponse>
}