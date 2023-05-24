package com.narsha.sundolls_ep_android.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.RecyclerviewItemTodoBinding

class RecyclerViewTodoAdapter(var data: ArrayList<RecyclerViewTodoData>): RecyclerView.Adapter<RecyclerViewTodoAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val binding: RecyclerviewItemTodoBinding): RecyclerView.ViewHolder(binding.root){
        val text = binding.todoText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: RecyclerviewItemTodoBinding =
            DataBindingUtil.inflate(inflater, R.layout.recyclerview_item_todo, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.text.text = data[position].text
        Log.d("상태",data.toString())
    }
}