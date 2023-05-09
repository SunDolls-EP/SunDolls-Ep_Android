package com.narsha.sundolls_ep_android.data.local.retrofit.response

import com.google.gson.annotations.SerializedName

data class LoginGoogleResponse(
    @SerializedName("access_token") var access_token: String,
)
