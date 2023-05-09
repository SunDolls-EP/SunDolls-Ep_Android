package com.narsha.sundolls_ep_android.data.local.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ClientRetrofit {
    const val baseURL = "http://"

    const val googleBaseURL = "https://www.googleapis.com"

    val googleRetrofit = Retrofit.Builder()
        .baseUrl(googleBaseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val googleApi: GoogleAPI = googleRetrofit.create(GoogleAPI::class.java)

    val retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api: API = retrofit.create(API::class.java)
}