package com.narsha.sundolls_ep_android.data.network.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClientRetrofit {
    private const val baseURL = "http://dgswhs.gabia.io/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(HeaderInterceptor())
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api: API = retrofit.create(API::class.java)
}