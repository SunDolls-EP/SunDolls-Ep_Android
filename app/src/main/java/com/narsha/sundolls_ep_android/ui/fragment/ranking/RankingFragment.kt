package com.narsha.sundolls_ep_android.ui.fragment.ranking

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.databinding.FragmentRankingBinding
import com.narsha.sundolls_ep_android.ui.adapter.RankingListAdapter
import com.narsha.sundolls_ep_android.ui.adapter.data.RankingData
import com.narsha.sundolls_ep_android.ui.adapter.decoration.RankingDecoraiton
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.RankingViewModel

class RankingFragment: BaseFragment<FragmentRankingBinding, RankingViewModel>(
    R.layout.fragment_ranking
) {
    private lateinit var rankingListAdapter: RankingListAdapter
    override val viewModel: RankingViewModel by viewModels()

    override fun start() {
        rankingListAdapter = RankingListAdapter()
        val rankingDecoraiton = RankingDecoraiton()

        val data = mutableListOf(
            RankingData(
                "1.",
                "최시훈",
                "1시간"
            ),RankingData(
                "2.",
                "황주완",
                "1시간"
            ),RankingData(
                "3.",
                "이혜성",
                "1시간"
            ),RankingData(
                "4.",
                "null",
                "null"
            ),RankingData(
                "5.",
                "null",
                "null"
            ),RankingData(
                "6.",
                "null",
                "null"
            ),RankingData(
                "7.",
                "null",
                "null"
            ),RankingData(
                "8.",
                "null",
                "null"
            ),RankingData(
                "9.",
                "null",
                "null"
            ),RankingData(
                "10.",
                "null",
                "null"
            ),RankingData(
                "11.",
                "null",
                "null"
            ),RankingData(
                "12.",
                "null",
                "null"
            ),RankingData(
                "13.",
                "null",
                "null"
            ),RankingData(
                "14.",
                "null",
                "null"
            ),RankingData(
                "15.",
                "null",
                "null"
            ),


        )
        with(binding){
            recyclerviewRanking.layoutManager = LinearLayoutManager(context)
            recyclerviewRanking.adapter = rankingListAdapter
            recyclerviewRanking.addItemDecoration(rankingDecoraiton)
            rankingListAdapter.submitList(data)
        }
    }
}