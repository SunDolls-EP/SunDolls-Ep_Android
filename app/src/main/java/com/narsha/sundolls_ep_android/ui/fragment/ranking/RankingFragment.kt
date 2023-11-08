package com.narsha.sundolls_ep_android.ui.fragment.ranking

import android.util.Log
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.databinding.FragmentRankingBinding
import com.narsha.sundolls_ep_android.ui.adapter.RankingListAdapter
import com.narsha.sundolls_ep_android.ui.adapter.decoration.RankingDecoraiton
import com.narsha.sundolls_ep_android.ui.viewmodel.UserViewModel
import com.narsha.sundolls_ep_android.utils.App

class RankingFragment: BaseFragment<FragmentRankingBinding, RankingViewModel>(
    R.layout.fragment_ranking
) {
    private val rankingListAdapter = RankingListAdapter()
    override val viewModel: RankingViewModel by viewModels()
    val userViewModel: UserViewModel by activityViewModels()

    override fun start() {

        userViewModel.getAllPersonalRanking(3, App.prefs.accessToken)
        Log.d("UserInformation",userViewModel.userData.value.toString())
        val rankingDecoraiton = RankingDecoraiton()


        with(binding){
            recyclerviewRanking.layoutManager = LinearLayoutManager(context)
            recyclerviewRanking.adapter = rankingListAdapter
            recyclerviewRanking.addItemDecoration(rankingDecoraiton)

            userViewModel.personalRankData.observe(this@RankingFragment){
                Glide.with(this@RankingFragment).load(it[0].profileUrl)
                    .error(AppCompatResources.getDrawable(requireContext(), R.drawable.background_imageview_profile))
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
                    .into(binding.image1)
                Glide.with(this@RankingFragment).load(it[1].profileUrl)
                    .error(AppCompatResources.getDrawable(requireContext(), R.drawable.background_imageview_profile))
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
                    .into(binding.image2)
                Glide.with(this@RankingFragment).load(it[2].profileUrl)
                    .error(AppCompatResources.getDrawable(requireContext(), R.drawable.background_imageview_profile))
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
                    .into(binding.image3)
//awz
                text1.text = it[0].username
                text2.text = it[1].username
                text3.text = it[2].username
            }
        }
    }
}