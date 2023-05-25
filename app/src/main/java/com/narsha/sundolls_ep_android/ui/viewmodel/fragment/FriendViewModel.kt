package com.narsha.sundolls_ep_android.ui.viewmodel.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.narsha.sundolls_ep_android.App
import com.narsha.sundolls_ep_android.data.local.retrofit.ClientRetrofit
import com.narsha.sundolls_ep_android.data.local.retrofit.response.friendLookupResponse.FriendLookupResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FriendViewModel(): ViewModel() {

    private val _recyclerView = MutableLiveData<FriendLookupResponse>()
    val recyclerView: LiveData<FriendLookupResponse>
        get() = _recyclerView

    fun getFriend(){
        ClientRetrofit.api.friendLookup(App.prefs.access_token.toString()).enqueue(object : Callback<FriendLookupResponse>{
            override fun onResponse(
                call: Call<FriendLookupResponse>,
                response: Response<FriendLookupResponse>
            ) {
                if(response.code() == 200){
                    Log.d("retrofit",response.body().toString())
                } else {
                    Log.d("retrofit", response.code().toString())
                }
            }

            override fun onFailure(call: Call<FriendLookupResponse>, t: Throwable) {
                Log.d("retrofit",t.message.toString())
            }

        })
    }

}