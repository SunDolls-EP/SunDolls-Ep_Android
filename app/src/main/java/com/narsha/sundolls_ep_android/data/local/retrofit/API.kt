package com.narsha.sundolls_ep_android.data.local.retrofit

import com.narsha.sundolls_ep_android.data.local.retrofit.response.GoogleLogin_Response.GoogleLogin_Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface API {

    @GET("/api/token")
    fun GoogleLogin(
        @Header("Athorization") googleIdToken: String,
    ): Call<GoogleLogin_Response>

}