package com.narsha.sundolls_ep_android.data.network.dto.user

data class FriendResponseDto(
    val accepted: Boolean,
    val createdAt: String,
    val modifiedAt: String,
    val profileUrl: String,
    val schoolName: String,
    val tag: String,
    val totalStudyTime: Int,
    val username: String
)