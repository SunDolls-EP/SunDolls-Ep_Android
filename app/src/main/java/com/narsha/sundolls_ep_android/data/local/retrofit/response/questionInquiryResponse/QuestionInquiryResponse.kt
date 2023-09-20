package com.narsha.sundolls_ep_android.data.local.retrofit.response.questionInquiryResponse

import com.google.gson.annotations.SerializedName

data class QuestionInquiryResponse(
    val content: List<QuestionInquiryResponsePost>,
    val pageable: QuestionInquiryResponsePageable,
    val last: Boolean,
    val totalElements: Int,
    val totalPages: Int,
    val size: Int,
    val number: Int,
    val sort: QuestionInquiryResponseSort,
    val first: Boolean,
    val numberOfElements: Int,
    val empty: Boolean
)






