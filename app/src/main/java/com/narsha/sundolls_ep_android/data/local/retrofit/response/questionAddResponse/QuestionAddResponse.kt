package com.narsha.sundolls_ep_android.data.local.retrofit.response.questionAddResponse

data class QuestionAddResponse(
    val id: Int,
    val writerUsername: String,
    val writerTag: String,
    val title: String,
    val content: String,
    val modifiedAt: String
)