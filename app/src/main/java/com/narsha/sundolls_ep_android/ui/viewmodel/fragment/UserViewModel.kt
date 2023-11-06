package com.narsha.sundolls_ep_android.ui.viewmodel.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.narsha.sundolls_ep_android.base.BaseViewModel
import com.narsha.sundolls_ep_android.data.network.dto.rank.PeopleRankResponseDto
import com.narsha.sundolls_ep_android.data.network.dto.rank.SchoolRankResponseDto
import com.narsha.sundolls_ep_android.data.network.dto.user.UserResponseDto
import com.narsha.sundolls_ep_android.data.network.retrofit.ClientRetrofit.api
import kotlinx.coroutines.launch

class UserViewModel : BaseViewModel() {
    private val _schoolRankData = MutableLiveData<List<SchoolRankResponseDto>>()
    val schoolRankData: LiveData<List<SchoolRankResponseDto>> = _schoolRankData

    private val _personalRankData = MutableLiveData<List<PeopleRankResponseDto>>()
    val personalRankData: LiveData<List<PeopleRankResponseDto>> = _personalRankData

    private val _userDataList = MutableLiveData<List<UserResponseDto>>()
    val userDataList: LiveData<List<UserResponseDto>> = _userDataList

    private val _userData = MutableLiveData<UserResponseDto>()
    val userData: LiveData<UserResponseDto> = _userData

    //    private val _
    fun getSchoolRanking(limit: Int) = viewModelScope.launch {
        kotlin.runCatching {
            api.getSchoolRanking(limit)
        }.onSuccess {
            _schoolRankData.value = it
        }.onFailure { e ->
            Log.d("애러", e.message.toString())
        }
    }

    fun getAllPersonalRanking(limit: Int) = viewModelScope.launch {
        kotlin.runCatching {
            api.getAllPersonalRanking(limit)
        }.onSuccess {
            _personalRankData.value = it
        }.onFailure { e ->
            Log.d("애러", e.toString())
        }
    }

    fun findUser(username: String, tag: String) = viewModelScope.launch {
        if (tag == "") {
            kotlin.runCatching {
                api.findUser(username)
            }.onSuccess {
                _userDataList.value = it
            }.onFailure { e ->
                Log.d("애러",e.message.toString())
            }
        } else {
            kotlin.runCatching {
                api.findUser(username, tag)
            }.onSuccess {
                _userData.value = it
            }.onFailure { e ->
                Log.d("애러",e.message.toString())
            }
        }

    }
}