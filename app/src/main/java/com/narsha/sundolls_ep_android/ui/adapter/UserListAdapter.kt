package com.narsha.sundolls_ep_android.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseListAdapter
import com.narsha.sundolls_ep_android.data.network.dto.user.UserResponseDto
import com.narsha.sundolls_ep_android.databinding.ItemNovelBinding

class UserListAdapter(private val context: Context) :
    BaseListAdapter<UserResponseDto, ItemNovelBinding>(R.layout.item_novel) {
    override fun action(data: UserResponseDto, binding: ItemNovelBinding) {
        with(binding) {
            name.text = data.username
            if (data.totalStudyTime == 0L) {
                time.text = "공부한 시간이 없습니다"
            } else if (data.totalStudyTime < 60) {
                time.text = data.totalStudyTime.toString() + "초"
            } else if (data.totalStudyTime < 3600) {
                time.text = (data.totalStudyTime / 60).toString() + "분"
            } else {
                time.text = (data.totalStudyTime / 3600).toString() + "시간"
            }

            Glide.with(context).load(data.profileUrl)
                .error(
                    AppCompatResources.getDrawable(
                        context,
                        R.drawable.background_imageview_profile
                    )
                )
                .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
                .into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
            ItemNovelBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}