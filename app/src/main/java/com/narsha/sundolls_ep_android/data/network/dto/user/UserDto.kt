package com.narsha.sundolls_ep_android.data.network.dto.user

data class UserDto(
    val createdAt: String,
    val email: String,
    val id: String,
    val modifiedAt: String,
    val password: String,
    val profileUrl: String,
    val schoolName: String,
    val tag: String,
    val totalStudyTime: Int,
    val username: String
)