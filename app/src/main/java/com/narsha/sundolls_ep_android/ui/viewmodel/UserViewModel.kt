package com.narsha.sundolls_ep_android.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.narsha.sundolls_ep_android.base.BaseViewModel
import com.narsha.sundolls_ep_android.data.network.dto.oauth.LoginResponseDto
import com.narsha.sundolls_ep_android.data.network.dto.rank.PeopleRankResponseDto
import com.narsha.sundolls_ep_android.data.network.dto.rank.SchoolRankResponseDto
import com.narsha.sundolls_ep_android.data.network.dto.user.UserFixInformationRequestDto
import com.narsha.sundolls_ep_android.data.network.dto.user.UserResponseDto
import com.narsha.sundolls_ep_android.data.network.retrofit.ClientRetrofit.api
import com.narsha.sundolls_ep_android.utils.App
import kotlinx.coroutines.launch

class UserViewModel : BaseViewModel() {
    private val _schoolRankData = MutableLiveData<List<SchoolRankResponseDto>>()
    val schoolRankData: LiveData<List<SchoolRankResponseDto>> = _schoolRankData

    private val _personalRankData = MutableLiveData<List<PeopleRankResponseDto>>()
    val personalRankData: LiveData<List<PeopleRankResponseDto>> = _personalRankData

    private val _friendDataList = MutableLiveData<List<UserResponseDto>>()
    val friendDataList: LiveData<List<UserResponseDto>> = _friendDataList

    private val _friendData = MutableLiveData<UserResponseDto>()
    val friendData: LiveData<UserResponseDto> = _friendData

    private val _userData = MutableLiveData<LoginResponseDto>()
    val userData: LiveData<LoginResponseDto> = _userData

    private val _userRanking = MutableLiveData<List<PeopleRankResponseDto>>()
    val userRanking: LiveData<List<PeopleRankResponseDto>> = _userRanking
    //    private val _
    fun getSchoolRanking(limit: Int) = viewModelScope.launch {
        kotlin.runCatching {
            api.getSchoolRanking(limit)
        }.onSuccess {
            _schoolRankData.value = it
            Log.d("getSchoolRanking - 성공", it.toString())
        }.onFailure { e ->
            Log.d("getSchoolRanking - 애러", e.message.toString())
        }
    }

    fun getAllPersonalRanking(limit: Int, token: String) = viewModelScope.launch {
        kotlin.runCatching {
            api.getAllPersonalRanking(token, limit)
        }.onSuccess {
            _personalRankData.value = it
            Log.d("getAllPersonalRanking - 성공", it.toString())
        }.onFailure { e ->
            Log.d("getAllPersonalRanking - 애러", e.toString())
        }
    }

    fun findUser(username: String, tag: String) = viewModelScope.launch {
        if (tag == "") {
            kotlin.runCatching {
                api.findUser(username = username, authorization = App.prefs.accessToken)
            }.onSuccess {
                _friendDataList.value = it
                Log.d("findUser - 성공", it.toString())
            }.onFailure { e ->
                Log.d("findUser - 애러", e.message.toString())
            }
        } else {
            kotlin.runCatching {
                api.findUser(username = username, tag = tag, authorization = App.prefs.accessToken)
            }.onSuccess {
                _friendData.value = it
                Log.d("findUser - 성공", it.toString())
            }.onFailure { e ->
                Log.d("findUser - 애러", e.message.toString())
            }
        }
    }

    fun login(provider: String, token: String) = viewModelScope.launch {
        kotlin.runCatching {
            api.login(provider, token)
        }.onSuccess {
            _userData.value = it
            Log.d("login - 성공", it.toString())
        }.onFailure { e ->
            Log.d("login - 애러", e.message.toString())
        }
    }

    fun getUserInformation(token: String) = viewModelScope.launch {
        kotlin.runCatching {
            api.getUserInformation(token)
        }.onSuccess {
            _userData.value = it
            Log.d("getUserInformation - 성공", it.toString())
        }.onFailure { e ->
            Log.d("getUserInformation - 애러", e.message.toString())
        }
    }

    fun fixUser(userFixInformationRequestDto: UserFixInformationRequestDto) =
        viewModelScope.launch {
            kotlin.runCatching {
                api.fixUserInformation(userFixInformationRequestDto)
            }.onSuccess {
                _userData.value = LoginResponseDto(
                    it.username,
                    it.tag,
                    it.schoolName,
                    it.totalStudyTime,
                    it.profileUrl,
                    it.createdAt,
                    it.modifiedAt
                )
                Log.d("fixUser - 성공", it.toString())
            }.onFailure { e ->
                Log.d("fixUser - 애러", e.message.toString())
            }
        }

    fun getUserRandom(limit: Int) = viewModelScope.launch {
        kotlin.runCatching {
            api.getRandomUserList(limit = limit, authorization = App.prefs.accessToken)
        }.onSuccess {
            _friendDataList.value = it
            Log.d("getUserRandom - 성공", it.toString())
        }.onFailure { e ->
            Log.d("getUserRandom - 애러", e.message.toString())
        }
    }
}