package com.narsha.sundolls_ep_android.data.local.retrofit.response.questionInquiryResponse

data class QuestionInquiryResponsePost(
    val id: Long,
    val writerUsername: String,
    val writerTag: String,
    val title: String,
    val content: String,
    val createdAt: String,
    val modifiedAt: String
)