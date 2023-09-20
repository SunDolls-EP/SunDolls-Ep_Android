package com.narsha.sundolls_ep_android.data.local.retrofit.response.friendDeleteResponse

import com.google.gson.annotations.SerializedName

data class FriendDeleteResponseItem (
    @SerializedName("username")
    val username: String,
    @SerializedName("schoolName")
    val schoolName: String,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("modifiedAt")
    val modifiedAt: String?,
    @SerializedName("acceptedAt")
    val accepted: Boolean,
    @SerializedName("links")
    val links: Any
)