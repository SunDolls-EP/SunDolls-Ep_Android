package com.narsha.sundolls_ep_android.data.network.retrofit

import com.narsha.sundolls_ep_android.data.network.dto.oauth.LoginResponseDto
import com.narsha.sundolls_ep_android.data.network.dto.oauth.RefreshResponseDto
import com.narsha.sundolls_ep_android.data.network.dto.rank.PeopleRankResponseDto
import com.narsha.sundolls_ep_android.data.network.dto.rank.SchoolRankResponseDto
import com.narsha.sundolls_ep_android.data.network.dto.user.FriendResponseDto
import com.narsha.sundolls_ep_android.data.network.dto.user.UserDto
import com.narsha.sundolls_ep_android.data.network.dto.user.UserFixInformationRequestDto
import com.narsha.sundolls_ep_android.data.network.dto.user.UserGetStudyRequestDto
import com.narsha.sundolls_ep_android.data.network.dto.user.UserResponseDto
import com.narsha.sundolls_ep_android.data.network.dto.user.UserSetStudyRequestDto
import com.narsha.sundolls_ep_android.data.network.dto.user.UserStudyInfoRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    //Auth-Controller
    @GET("api/auth/login/oauth2/{provider}")
    suspend fun login(
        @Path("provider") provider: String,
        @Header("Authorization") token: String
    ): LoginResponseDto

    @GET("api/auth/login/refresh")
    suspend fun refreshToken(
        @Header("Authorization") token: String
    ): RefreshResponseDto

    //Rank-Controller
    @GET("api/rank")
    suspend fun getAllPersonalRanking(
        @Header("Authorization") token: String,
        @Query("limit") limit: Int
    ): List<PeopleRankResponseDto>

    @GET("api/rank/school/{schoolName}")
    suspend fun getSchoolPersonalRanking(
        @Query("limit") limit: Int,
        @Path(value = "schoolName") schoolName: String
    ): List<PeopleRankResponseDto>

    @GET("api/rank/school/all")
    suspend fun getSchoolRanking(
        @Query("limit") limit: Int
    ): List<SchoolRankResponseDto>


    //User-Controller
    @PUT("api/user")
    suspend fun fixUserInformation(
        @Body userFixInformationRequestDto: UserFixInformationRequestDto
    ): UserResponseDto

    @GET("api/user/study")
    suspend fun getUserStudy(
        @Query("user") user: UserGetStudyRequestDto
    ): List<UserStudyInfoRequest>

    @POST("api/user/study")
    suspend fun setUserStudy(
        @Body userSetStudyRequestDto: UserSetStudyRequestDto
    )

    @POST("api/user/friend/{username}/{tag}")
    suspend fun setUserAddFriend(
        @Path("username") username: String,
        @Path("tag") tag: String,
        @Body userDto: UserDto
    ): UserResponseDto

    @DELETE("api/user/friend/{username}/{tag}")
    suspend fun deleteUserFriend(
        @Path("username") username: String,
        @Path("tag") tag: String,
        @Body userDto: UserDto
    ): FriendResponseDto

    @PATCH("api/user/friend/{username}/{tag}")
    suspend fun acceptUserFriend(
        @Path("username") username: String,
        @Path("tag") tag: String,
        @Body userDto: UserDto
    ): FriendResponseDto

    @GET("api/user/{username}")
    suspend fun findUser(
        @Header("Authorization") authorization: String,
        @Path("username") username: String
    ): List<UserResponseDto>

    @GET("api/user/{username}/{tag}")
    suspend fun findUser(
        @Header("Authorization") authorization: String,
        @Path("username") username: String,
        @Path("tag") tag: String
    ): UserResponseDto

    @GET("api/user/random/list")
    suspend fun getRandomUserList(
        @Header("Authorization") authorization: String,
        @Query("limit") limit: Int
    ): List<UserResponseDto>

    @GET("api/user/friend")
    suspend fun getUserFriendList(
        @Query("user") user: UserDto
    ): List<FriendResponseDto>

    @GET("/api/user/self")
    suspend fun getUserInformation(
        @Header("Authorization") authorization: String
    ): LoginResponseDto

}