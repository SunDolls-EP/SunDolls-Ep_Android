package com.narsha.sundolls_ep_android.ui.fragment.ranking

import androidx.fragment.app.viewModels
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.databinding.FragmentRankingBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.RankingViewModel

class RankingFragment: BaseFragment<FragmentRankingBinding, RankingViewModel>(
    R.layout.fragment_ranking
) {
    override val viewModel: RankingViewModel by viewModels()

    override fun start() {

    }
}