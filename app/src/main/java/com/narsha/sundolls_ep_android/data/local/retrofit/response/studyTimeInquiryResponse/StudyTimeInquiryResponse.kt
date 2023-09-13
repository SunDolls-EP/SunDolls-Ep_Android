package com.narsha.sundolls_ep_android.data.local.retrofit.response.studyTimeInquiryResponse

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.time.LocalTime

data class StudyTimeInquiryResponse(
    @SerializedName("startAt")
    val startAt: LocalDateTime,
    @SerializedName("endAt")
    val endAt: LocalDateTime,
    @SerializedName("totalTime")
    val totalTime: LocalTime,

    )