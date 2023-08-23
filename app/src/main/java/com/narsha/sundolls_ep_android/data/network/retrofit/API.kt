package com.narsha.sundolls_ep_android.data.network.retrofit

import com.narsha.sundolls_ep_android.data.network.retrofit.response.friendLookupResponse.FriendLookupResponse
import com.narsha.sundolls_ep_android.data.network.retrofit.response.googleLoginResponse.GoogleLoginResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface API {

    @GET("/api/token")
    fun GoogleLogin(
        @Header("Authorization") googleIdToken: String,
    ): Call<GoogleLoginResponse>

    @GET("/api/user/friend")
    fun friendLookup(
        @Header("Authorization") googleIdToken: String,
    ): Call<FriendLookupResponse>


}