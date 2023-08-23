package com.narsha.sundolls_ep_android.data.network.retrofit.response.googleLoginResponse

import com.google.gson.annotations.SerializedName


data class Friend(
    @SerializedName("href")
    val href: String,
    @SerializedName("method")
    val method: String,
    @SerializedName("rel")
    val rel: String
)