package com.narsha.sundolls_ep_android.data.local.retrofit.response.calendarInquiryResponse

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.time.LocalTime

data class CalendarInquiryResponse(
    @SerializedName("content")
    val content: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("modifiedAt")
    val modifiedAt: String,
)