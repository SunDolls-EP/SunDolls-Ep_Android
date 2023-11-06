package com.narsha.sundolls_ep_android.data.network.dto.user

data class UserFixInformationRequestDto(
    val user: UserDto,
    val request: Request
)
data class Request(
    val username: String,
    val schoolName: String
)
