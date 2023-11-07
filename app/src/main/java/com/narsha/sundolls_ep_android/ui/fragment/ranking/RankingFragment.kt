package com.narsha.sundolls_ep_android.ui.fragment.ranking

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.databinding.FragmentRankingBinding
import com.narsha.sundolls_ep_android.ui.adapter.RankingListAdapter
import com.narsha.sundolls_ep_android.ui.adapter.decoration.RankingDecoraiton
import com.narsha.sundolls_ep_android.ui.viewmodel.UserViewModel

class RankingFragment: BaseFragment<FragmentRankingBinding, RankingViewModel>(
    R.layout.fragment_ranking
) {
    private val rankingListAdapter = RankingListAdapter()
    override val viewModel: RankingViewModel by viewModels()
    val userViewModel: UserViewModel by activityViewModels()

    override fun start() {
        Log.d("UserInformation",userViewModel.userData.value.toString())
        val rankingDecoraiton = RankingDecoraiton()
        with(binding){
            recyclerviewRanking.layoutManager = LinearLayoutManager(context)
            recyclerviewRanking.adapter = rankingListAdapter
            recyclerviewRanking.addItemDecoration(rankingDecoraiton)
//            rankingListAdapter.submitList()
        }
    }
}