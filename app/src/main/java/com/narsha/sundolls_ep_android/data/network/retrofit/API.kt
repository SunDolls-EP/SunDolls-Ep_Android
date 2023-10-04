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
    @GET("/api/rank")
    fun rankInquire(
        //Query Params
        @Header("Authorization") access: Token,
    ): Call<RankInquireResponse>

    @PATCH("/api/token")
    fun modifyUser(
        @Header("Authorization") accessToken: String,
    ): Call<ModifyUserResponse>

    @POST("/api/user/friend/{friendName}")
    fun friendRequest(
        @Header("Authorization") access: Token,
        @Path("friendName") friendName: String
    ): Call<FriendRequestResponse>

    @DELETE("/api/user/friend/{friendName}")
    fun friendDelete(
        @Header("Authorization") access: Token,             //null except
        @Path("friendName") friendName: String
    ): Call<FriendDeleteResponse>

    @PATCH("api/user/friend/{friendName}")
    fun friendAllow(
        @Header("Authorization") access: Token,
        @Path("friendName") friendName: String
    ): Call<FriendAllowResponse>


    //----------------------------------------------------------------

    @POST("api/user/study")
    fun studyTimeAdd(
        @Header("Authorization") access: Token,
    ): Call<StudyTimeAddResponse>

    @GET("api/user/study")                                  //
    fun studyTimeInquiry(
        @Header("Authorization") access: Token,
        @Query("from") from: String = "2000-01-01 00",
        @Query("to") to: String = "3000-12-31 23"
    ): Call<StudyTimeInquiryResponse>

    @GET("api/calendar")
    fun calendarInquiry(
        @Header("Authorization") access: Token,
        @Query("from") from: String = "2000-01-01 00",
        @Query("to") to: String = "3000-12-31 23"
    ): Call<CalendarInquiryResponse>

    @POST("api/calendar")
    fun calendarAdd(
        @Header("Authorization") access: Token,
    ): Call<CalendarAddResponse>

    @PUT("api/calendar")
    fun calendarModify(
        @Header("Authorization") access: Token,
    ): Call<CalendarModifyReponse>

    @GET("api/QnA/question")
    fun questionInquiry(
        @Header("Authorization") access: Token,
    ): Call<QuestionInquiryResponse>

    @POST("api/QnA/question")
    fun questionAdd(
        @Header("Authorization") access: Token,
    ): Call<QuestionAddResponse>

    @PATCH("api/QnA/question/{noticeId}")
    fun questionModify(
        @Header("Authorization") access: Token,
        @Path("noticeId") noticeId: String,
        @Body request: QuestionRequestUpdate
    ): Call<QuestionModifyResponse>

    @DELETE("api/QnA/question/{noticeId}")
    fun questionDelete(
        @Header("Authorization") access: Token,
        @Path("noticeId") noticeId: String,
    ): Call<QuestionDeleteResponse>

    @GET("api/QnA/answer/{questionNum}")                
    fun answerInquiry(
        @Header("Authorization") access: Token,
        @Path("questionNum") questionNum: String,
    ): Call<AnswerInquiryResponse>

    @POST("api/QnA/answer/{questionNum}")
    fun answerAdd(
        @Header("Authorization") access: Token,
        @Path("questionNum") questionNum: String,
        @Body request: AnswerAddRequest
    ): Call<AnswerAddResponse>

    @PUT("api/QnA/answer/{questionNum}")
    fun answerModify(
        @Header("Authorization") access: Token,
        @Path("questionNum") questionNum: String,
        @Body request: AnswerModifyRequest
    ): Call<AnswerModifyResponse>

    @GET("api/QnA/question/search")
    fun questionSearch(
        @Header("Authorization") access: Token,
        @Query("keyword") keyword: String = "3000-12-31 23"
    ): Call<QuestionSearchResponse>

    @POST("api/user/school")
    fun schoolSpecify(
        @Header("Authorization") access: Token,
        @Body request: SchoolSpecifyRequest
    ): Call<SchoolSpecifyResponse>

    @POST("api/user/username")
    fun usernameChange(
        @Header("Authorization") access: String,
        @Body request: UserNameChangeRequest
    ): Call<UserNameChangeResponse>

}