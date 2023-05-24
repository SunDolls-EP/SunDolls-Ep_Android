package com.narsha.sundolls_ep_android.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.data.local.retrofit.response.friendLookupResponse.FriendLookupResponse
import com.narsha.sundolls_ep_android.databinding.RecyclerviewItemFriendBinding
import com.narsha.sundolls_ep_android.databinding.RecyclerviewItemTodoBinding

class RecyclerViewFriendAdapter(var data: FriendLookupResponse): RecyclerView.Adapter<RecyclerViewFriendAdapter.MyViewHolder>() {
    inner class MyViewHolder(private val binding: RecyclerviewItemFriendBinding): RecyclerView.ViewHolder(binding.root){
        val name = binding.friendName
        val img = binding.friendImg
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: RecyclerviewItemFriendBinding =
            DataBindingUtil.inflate(inflater, R.layout.recyclerview_item_friend, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = data[position].username
    }
}