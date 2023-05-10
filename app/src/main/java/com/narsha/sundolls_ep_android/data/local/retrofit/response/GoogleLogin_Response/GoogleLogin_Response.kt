package com.narsha.sundolls_ep_android.data.local.retrofit.response.GoogleLogin_Response

import com.google.gson.annotations.SerializedName

data class GoogleLogin_Response(
    @SerializedName("access-token")
    val access_token: String,
    @SerializedName("user")
    val user: User
)