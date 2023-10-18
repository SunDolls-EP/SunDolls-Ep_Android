package com.narsha.sundolls_ep_android.data.network.retrofit

import android.media.session.MediaSession.Token
import com.narsha.sundolls_ep_android.data.local.retrofit.response.FriendAllowResponse.FriendAllowResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.RankInquireResponse.RankInquireResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.answerAddResponse.AnswerAddResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.answerAddResponse.AnswerAddRequest
import com.narsha.sundolls_ep_android.data.local.retrofit.response.answerInquiryResponse.AnswerInquiryResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.CalendarModifyResponse.CalendarModifyReponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.answerModifyResponse.AnswerModifyRequest
import com.narsha.sundolls_ep_android.data.local.retrofit.response.answerModifyResponse.AnswerModifyResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.calendarAddResponse.CalendarAddResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.calendarInquiryResponse.CalendarInquiryResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.friendRequestResponse.FriendRequestResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.friendDeleteResponse.FriendDeleteResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.modifyUserResponse.ModifyUserResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.quesionSearchResponse.QuestionSearchResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.questionAddResponse.QuestionAddResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.questionDeleteResponse.QuestionDeleteResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.questionInquiryResponse.QuestionInquiryResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.questionInquiryResponse.QuestionInquiryResponsePageable
import com.narsha.sundolls_ep_android.data.local.retrofit.response.questionModifyResponse.QuestionModifyResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.questionModifyResponse.QuestionRequestUpdate
import com.narsha.sundolls_ep_android.data.local.retrofit.response.schoolSpecifyResponse.SchoolSpecifyRequest
import com.narsha.sundolls_ep_android.data.local.retrofit.response.schoolSpecifyResponse.SchoolSpecifyResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.studyTimeAddResponse.StudyTimeAddResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.studyTimeInquiryResponse.StudyTimeInquiryResponse
import com.narsha.sundolls_ep_android.data.local.retrofit.response.userNameChangeResponse.UserNameChangeRequest
import com.narsha.sundolls_ep_android.data.local.retrofit.response.userNameChangeResponse.UserNameChangeResponse
import com.narsha.sundolls_ep_android.data.network.retrofit.response.friendLookupResponse.FriendLookupResponse
import com.narsha.sundolls_ep_android.data.network.retrofit.response.login_response.LoginResponse
import retrofit2.Call
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

    @GET("/login/oauth2/authorize/google")
    fun googleLogin(
        @Header("Authorization") googleIdToken: String,
    ): Call<LoginResponse>

    @GET("/login/oauth2/authorize/kakao")
    fun kakaoLogin(
        @Header("Authorization") kakaoAccessToken: String,
    ): Call<LoginResponse>

    @GET("/api/user/friend")
    fun friendLookup(
        @Header("Authorization") googleIdToken: String,
    ): Call<FriendLookupResponse>


    //--------------------------------->
    @PUT("/api/user")
    fun friendModify(
        @Header("Authorization") token: String
    )

    @GET("/api/user/study")
    fun checkStudyRecord(
        @Header("Authorization") token: String,
        @Query("from") from: String = "2000-01-01 00",
        @Query("to") to: String = "2000-12-31 23"
    )

    @POST("/api/user/study")
    fun submitStudyRecord(
        @Header("Authorization") token: String,
    )

    @POST("/api/user/friend/{username}/{tag}")
    fun requestFriend(
        @Header("Authorization") token: String,
        @Path("username") username: String,
        @Path("tag") tag: String,
    )

    @DELETE("/api/user/friend/{username}/{tag}")
    fun deleteFriend(
        @Header("Authorization") token: String,
        @Path("username") username: String,
        @Path("tag") tag: String,
    )

    @PATCH("/api/user/friend/{username}/{tag}")
    fun patchFriend(
        @Header("Authorization") token: String,
        @Path("username") username: String,
        @Path("tag") tag: String,
    )

    @GET("/api/user/{username}")
    fun searchFriendByUsername(
        @Path("username") username: String
    )

    @GET("/api/user/{username}/{tag}")
    fun searchFriendByUsernameTag(
        @Path("username") username: String,
        @Path("tag") tag: String
    )

    @GET("/api/user/friend")
    fun checkFriendList(
        @Header("Authorization") token: String
    )

    @GET("/api/calendar")
    fun checkCalendar(
        @Header("Authorization") token: String,
        @Query("from") from: String = "2000-01-01 00",
        @Query("to") to: String = "2000-12-31 23"
    )

    @PUT("/api/calendar")
    fun modifyCalendar(
        @Header("Authorization") token: String,
    )

    @POST("/api/calendar")
    fun addCalendar(
        @Header("Authorization") token: String,
    )

    @GET("/api/QnA/question/{questionId}")
    fun searchQuestion(
        @Path("questionId") questionId: Long,
    )

    @PUT("/api/QnA/question/{questionId}")
    fun modifyQuestion(
        @Header("Authorization") token: String,
        @Path("questionId") questionId: Long,
    )

    @DELETE("/api/QnA/question/{questionId}")
    fun deleteQuestion(
        @Header("Authorization") token: String,
        @Path("questionId") questionId: Long,
    )

    @POST("/api/QnA/question")
    fun postQuestion(
        @Header("Authorization") token: String,
    )

    @GET("/api/QnA/question/list")
    fun checkQuestion(
//        @Query("pageable") pageable:      //Description
        @Query("title-keyword") titleKeyword:String?,
        @Query("content-keyword") contentKeyword:String?,
        @Query("writer-name") writerName:String?,
        @Query("writer-tag") writerTag:String?,
        @Query("from") from:String,
        @Query("to") to:String,
        //?
        )

    @PUT("/api/QnA/answer/{answerId}")
    fun modifyAnswer(
        @Header("Authorization") token: String,
        @Path("answerId") answerId: Long,
    )

    @DELETE("/api/QnA/answer/{answerId}")
    fun deleteAnswer(
        @Header("Authorization") token: String,
        @Path("answerId") answerId: Long,
    )

    @GET("/api/QnA/answer/{questionId}")
    fun checkAnswer(
        @Path("questionId") questionId: Long,
//        @Query("pageable") pageable: Pageable = Pagerable(0,1,Sort(listOf("string"))) //description
    )

    @POST("/api/QnA/answer/{questionId}")
    fun addAnswer(
        @Header("Authorization") token: String,
        @Path("questionId") questionId: Long,
    )

    @GET("/school/{schoolName}")
    fun checkStudentRank(
        @Path("schoolName") schoolName: String
    )

    @GET("/school/all")
    fun checkSchoolRank()

    @GET("/")
    fun checkRank()



}