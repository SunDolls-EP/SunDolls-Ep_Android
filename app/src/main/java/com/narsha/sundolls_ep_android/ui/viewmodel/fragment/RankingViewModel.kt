package com.narsha.sundolls_ep_android.ui.viewmodel.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.narsha.sundolls_ep_android.ui.adapter.RecyclerViewRankingData

class RankingViewModel:ViewModel() {

    private val _recyclerView = MutableLiveData<MutableList<RecyclerViewRankingData>>()
    val recyclerView: LiveData<MutableList<RecyclerViewRankingData>>
        get() = _recyclerView

    fun getRanking(){
        _recyclerView.value?.add(RecyclerViewRankingData("황주완",523))
        Log.d("상태",_recyclerView.value.toString())
        Log.d("상태",RecyclerViewRankingData("황주완",523).toString())
    }

}