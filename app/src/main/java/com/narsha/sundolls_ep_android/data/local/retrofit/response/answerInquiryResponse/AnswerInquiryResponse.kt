package com.narsha.sundolls_ep_android.data.local.retrofit.response.answerInquiryResponse

import com.narsha.sundolls_ep_android.data.local.retrofit.response.userNameChangeResponse.UserNameChangeReponseLink

data class AnswerInquiryResponse(
    val answerId: String,
    val content: String,
    val createdAt: String,
    val links: List<AnswerInquiryLink>
)