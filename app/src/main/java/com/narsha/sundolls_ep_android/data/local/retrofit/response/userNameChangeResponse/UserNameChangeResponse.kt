package com.narsha.sundolls_ep_android.data.local.retrofit.response.userNameChangeResponse

import com.narsha.sundolls_ep_android.data.local.retrofit.response.schoolSpecifyResponse.SchoolSpecifyAnswers
import com.narsha.sundolls_ep_android.data.local.retrofit.response.schoolSpecifyResponse.SchoolSpecifyLink

data class UserNameChangeResponse(
    val user: String,
    val email: String,
    val school: String,
    val links: List<UserNameChangeReponseLink>
)