package com.narsha.sundolls_ep_android.data.local.retrofit.response.studyTimeAddResponse

import com.google.gson.annotations.SerializedName

data class StudyTimeAddResponse(
    @SerializedName("startAt")
    val startAt: String,
    @SerializedName("endAt")
    val endAt: String,
)