package com.narsha.sundolls_ep_android.data.local.retrofit.response.RankInquireResponse

import com.google.gson.annotations.SerializedName

data class RankInquireResponseItem(
    @SerializedName("username")
    val username: String,
    @SerializedName("study_time")
    val studyTime: String,
    @SerializedName("rank")
    val rank: String
)