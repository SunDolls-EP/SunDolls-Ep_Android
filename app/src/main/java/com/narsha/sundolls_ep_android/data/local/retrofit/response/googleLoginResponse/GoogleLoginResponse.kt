package com.narsha.sundolls_ep_android.data.local.retrofit.response.googleLoginResponse

import com.google.gson.annotations.SerializedName

data class GoogleLoginResponse(
    @SerializedName("username")
    val username: String,
    @SerializedName("schoolName")
    val schoolName: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("modifiedAt")
    val modifiedAt: String
)