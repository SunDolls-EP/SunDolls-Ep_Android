package com.narsha.sundolls_ep_android.data.local.retrofit.response.GoogleLogin_Response

import com.google.gson.annotations.SerializedName

data class GoogleLogin_Response(
    @SerializedName("access-token")
    val access_token: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("links")
    val links: List<friend>,
    @SerializedName("school")
    val school: String,
    @SerializedName("username")
    val username: String
)