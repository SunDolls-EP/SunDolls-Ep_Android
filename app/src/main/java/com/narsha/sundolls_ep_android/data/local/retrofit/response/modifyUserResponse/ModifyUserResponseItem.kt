package com.narsha.sundolls_ep_android.data.local.retrofit.response.modifyUserResponse

import com.google.gson.annotations.SerializedName

data class ModifyUserResponseItem(
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("school")
    val school: String,
    @SerializedName("modifiedAt")
    val modifiedAt: String

)