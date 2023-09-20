package com.narsha.sundolls_ep_android.data.local.retrofit.response.questionModifyResponse

data class QuestionModifyResponse(
    val id: Int,
    val writeUsername: String,
    val writerTag: String,
    val content: String,
    val createdAt: String,
    val modifiedAt: String
)