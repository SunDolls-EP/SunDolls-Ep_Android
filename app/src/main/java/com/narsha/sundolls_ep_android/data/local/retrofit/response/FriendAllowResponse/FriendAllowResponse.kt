package com.narsha.sundolls_ep_android.data.local.retrofit.response.FriendAllowResponse

import com.google.gson.annotations.SerializedName

data class FriendAllowResponse(
    @SerializedName("userName")
    val userName: String,
    @SerializedName("schoolName")
    val schoolName: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("modifiedAt")
    val modifiedAt: String,
    @SerializedName("username")
    val accepted: Boolean
)