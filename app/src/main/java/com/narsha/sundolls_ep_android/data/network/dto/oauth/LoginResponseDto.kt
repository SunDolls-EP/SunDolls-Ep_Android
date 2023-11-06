package com.narsha.sundolls_ep_android.data.network.dto.oauth


data class LoginResponseDto(
    val username: String,
    val tag: String,
    val schoolName: String,
    val totalStudyTime: Long,
    val profileUrl: String,
    val createdAt: String,
    val modifiedAt: String,
)