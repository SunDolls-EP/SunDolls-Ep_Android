package com.narsha.sundolls_ep_android.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.RecyclerviewItemRankingBinding

class RecyclerViewRankingAdapter(var data: MutableList<RecyclerViewRankingData>): RecyclerView.Adapter<RecyclerViewRankingAdapter.MyViewHolder>() {
    inner class MyViewHolder(private val binding: RecyclerviewItemRankingBinding): RecyclerView.ViewHolder(binding.root){
        val name = binding.userName
        val time = binding.studyTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: RecyclerviewItemRankingBinding =
            DataBindingUtil.inflate(inflater, R.layout.recyclerview_item_ranking, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = data[position].name
        holder.time.text = "${data[position].time}시간"
    }
}