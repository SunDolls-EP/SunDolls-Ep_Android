package com.narsha.sundolls_ep_android.data.local.retrofit.response.questionDeleteResponse

data class QuestionDeleteResponse(
    val id: Int,
    val writeUsername: String,
    val writerTag: String,
    val title: String,
    val content: String,
    val createdAt: String,
    val modifiedAt: String
)