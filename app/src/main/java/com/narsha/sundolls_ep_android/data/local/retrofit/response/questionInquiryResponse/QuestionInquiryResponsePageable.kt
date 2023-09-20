package com.narsha.sundolls_ep_android.data.local.retrofit.response.questionInquiryResponse

data class QuestionInquiryResponsePageable(
    val sort: QuestionInquiryResponseSort,
    val offset: Int,
    val pageNumber: Int,
    val pageSize: Int,
    val paged: Boolean,
    val unpaged: Boolean
)