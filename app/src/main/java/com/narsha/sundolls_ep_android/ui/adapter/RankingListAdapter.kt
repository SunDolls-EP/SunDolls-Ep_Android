package com.narsha.sundolls_ep_android.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseListAdapter
import com.narsha.sundolls_ep_android.databinding.ItemRankingBinding
import com.narsha.sundolls_ep_android.ui.adapter.data.RankingData


class RankingListAdapter: BaseListAdapter<RankingData, ItemRankingBinding>(R.layout.item_ranking) {
    override fun action(data: RankingData, binding: ItemRankingBinding) {
        with(binding){
            name.text = data.name
            time.text = data.time
            ranking.text = data.ranking
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(ItemRankingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

}