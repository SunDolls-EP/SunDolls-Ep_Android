package com.narsha.sundolls_ep_android.data.network.retrofit

import android.util.Log
import com.narsha.sundolls_ep_android.utils.App
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        val original = request()
        if (original.header("Authorization") != null) {
            App.prefs.accessToken = original.header("Authorization").toString()
            Log.d("헤더", App.prefs.accessToken)
        }
        return proceed(original)
    }
}