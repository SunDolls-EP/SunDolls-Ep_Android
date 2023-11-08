package com.narsha.sundolls_ep_android.data.network.retrofit

import android.util.Log
import com.narsha.sundolls_ep_android.utils.App
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        val original = chain.request()
        val response = chain.proceed(original)
        if (response.header("Authorization") != null) {
            App.prefs.accessToken = response.header("Authorization").toString()
        }
//        request().newBuilder()
//            .addHeader("Authorization", App.prefs.accessToken)
//            .build()
        response
    }
}