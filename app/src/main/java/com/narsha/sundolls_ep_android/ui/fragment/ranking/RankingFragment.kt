package com.narsha.sundolls_ep_android.ui.fragment.ranking

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.databinding.FragmentRankingBinding
import com.narsha.sundolls_ep_android.ui.adapter.RankingListAdapter
import com.narsha.sundolls_ep_android.ui.adapter.decoration.RankingDecoraiton
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.RankingViewModel

class RankingFragment: BaseFragment<FragmentRankingBinding, RankingViewModel>(
    R.layout.fragment_ranking
) {
    private val rankingListAdapter = RankingListAdapter()
    override val viewModel: RankingViewModel by viewModels()

    override fun start() {
        val rankingDecoraiton = RankingDecoraiton()
        with(binding){
            recyclerviewRanking.layoutManager = LinearLayoutManager(context)
            recyclerviewRanking.adapter = rankingListAdapter
            recyclerviewRanking.addItemDecoration(rankingDecoraiton)
//            rankingListAdapter.submitList()
        }
    }
}