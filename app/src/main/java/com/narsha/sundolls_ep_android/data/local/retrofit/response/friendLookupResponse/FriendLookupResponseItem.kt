package com.narsha.sundolls_ep_android.data.local.retrofit.response.friendLookupResponse

import com.google.gson.annotations.SerializedName

data class FriendLookupResponseItem(
    @SerializedName("accepted")
    val accepted: Boolean,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("modifiedAt")
    val modifiedAt: String,
    @SerializedName("schoolName")
    val schoolName: String,
    @SerializedName("username")
    val username: String
)