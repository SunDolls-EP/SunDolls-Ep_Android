package com.narsha.sundolls_ep_android.data.local.retrofit

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        // 원하는 헤더 값을 가져옵니다.
        val headerValue = "YourHeaderValue"

        // 가져온 헤더 값을 추가한 새로운 Request 객체를 생성합니다.
        val modifiedRequest = originalRequest.newBuilder()
            .header("authorization", headerValue)
            .build()

        return chain.proceed(modifiedRequest)
    }
}