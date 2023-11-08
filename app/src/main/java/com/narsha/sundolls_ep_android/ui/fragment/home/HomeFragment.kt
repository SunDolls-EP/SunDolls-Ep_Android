package com.narsha.sundolls_ep_android.ui.fragment.home

import android.content.Intent
import android.util.Log
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.databinding.FragmentHomeBinding
import com.narsha.sundolls_ep_android.service.TimerService
import com.narsha.sundolls_ep_android.ui.viewmodel.UserViewModel
import com.narsha.sundolls_ep_android.utils.App

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val viewModel: HomeViewModel by viewModels()
    val userViewModel: UserViewModel by activityViewModels()

    private var buttonTimerStatus: Boolean = false

    override fun start() {
        getUserInformation()
        with(userViewModel) {
            with(binding) {
                buttonTimer.setOnClickListener {
                    Intent(requireContext(), TimerService::class.java).apply {
                        if (buttonTimerStatus) {
                            buttonTimerStatus = false
                            action = "false"
                            buttonTimer.text = "중지"
                            requireActivity().startService(this)
                        } else {
                            buttonTimerStatus = true
                            action = "stop"
                            requireActivity().startService(this)
                            buttonTimer.text = "시작"
                        }
                    }
                }
                Log.d("UserInformation", userViewModel.userData.value.toString())
                schoolRankData.observe(this@HomeFragment) {
//                    nameSchool1.text = it[0].name
//                    nameSchool2.text = it[1].name
//                    nameSchool3.text = it[2].name
                }

                personalRankData.observe(this@HomeFragment) {
                    namePersonal1.text = it[0].username
                    namePersonal2.text = it[1].username
                    namePersonal3.text = it[2].username

                    Glide.with(this@HomeFragment).load(it[0].profileUrl)
                        .error(
                            AppCompatResources.getDrawable(
                                requireContext(),
                                R.drawable.background_imageview_profile
                            )
                        )
                        .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
                        .into(binding.imagePersonal1)
                    Glide.with(this@HomeFragment).load(it[1].profileUrl)
                        .error(
                            AppCompatResources.getDrawable(
                                requireContext(),
                                R.drawable.background_imageview_profile
                            )
                        )
                        .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
                        .into(binding.imagePersonal2)
                    Glide.with(this@HomeFragment).load(it[2].profileUrl)
                        .error(
                            AppCompatResources.getDrawable(
                                requireContext(),
                                R.drawable.background_imageview_profile
                            )
                        )
                        .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
                        .into(binding.imagePersonal3)
                }
            }
        }
        getSchoolRanking()
        getAllPersonalRanking()
    }

    private fun getSchoolRanking() {
        userViewModel.getSchoolRanking(1)
    }

    private fun getAllPersonalRanking() {
        userViewModel.getAllPersonalRanking(3, App.prefs.accessToken)
    }

    private fun getUserInformation() {
        userViewModel.getUserInformation(App.prefs.accessToken)
    }
}