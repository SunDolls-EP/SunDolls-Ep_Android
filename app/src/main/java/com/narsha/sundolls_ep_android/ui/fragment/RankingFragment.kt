package com.narsha.sundolls_ep_android.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.FragmentRankingBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.RankingViewModel

class RankingFragment : Fragment() {

    private val viewModel: RankingViewModel by lazy {
        ViewModelProvider(this)[RankingViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentRankingBinding = FragmentRankingBinding.inflate(inflater, container, false)
        binding.ranking = viewModel
        // Inflate the layout for this fragment
        return binding.root
    }

}