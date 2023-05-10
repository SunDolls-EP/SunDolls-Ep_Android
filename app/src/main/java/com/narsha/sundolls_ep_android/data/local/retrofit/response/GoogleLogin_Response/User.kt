package com.narsha.sundolls_ep_android.data.local.retrofit.response.GoogleLogin_Response

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("password")
    val password: String?,
    @SerializedName("schoolName")
    val schoolName: String?,
    @SerializedName("username")
    val username: String
)