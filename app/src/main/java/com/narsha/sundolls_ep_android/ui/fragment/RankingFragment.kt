package com.narsha.sundolls_ep_android.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.narsha.sundolls_ep_android.databinding.FragmentRankingBinding
import com.narsha.sundolls_ep_android.ui.adapter.RecyclerViewRankingAdapter
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.RankingViewModel

class RankingFragment : Fragment() {

    lateinit var binding: FragmentRankingBinding

    private val viewModel: RankingViewModel by lazy {
        ViewModelProvider(this)[RankingViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRankingBinding.inflate(inflater, container, false)
        binding.ranking = viewModel

        binding.lifecycleOwner = this
        binding.recyclerRankingList.layoutManager = LinearLayoutManager(context)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.recyclerView.observe(viewLifecycleOwner, Observer{
            var newAdapter = RecyclerViewRankingAdapter(it)
            binding.recyclerRankingList.adapter = newAdapter
            Log.d("상태",it.toString())
            Log.d("상태","ㅎㅇ")
        })
    }

}