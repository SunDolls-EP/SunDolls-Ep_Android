package com.narsha.sundolls_ep_android.ui.fragment.home

import android.content.Intent
import android.util.Log
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.databinding.FragmentHomeBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.UserViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, UserViewModel>(R.layout.fragment_home) {
    override val viewModel: UserViewModel by viewModels()

    override fun start() {
        with(viewModel){
            with(binding){
                schoolRankData.observe(this@HomeFragment){
                    nameSchool1.text = it[0].name
//                    nameSchool2.text = it[1].name
//                    nameSchool3.text = it[2].name
                    Log.d("학교",it.toString())
                }

                personalRankData.observe(this@HomeFragment){
                    namePersonal1.text = it[0].username
                    namePersonal2.text = it[1].username
                    namePersonal3.text = it[2].username

                    Glide.with(this@HomeFragment).load(it[0].profileUrl)
                        .error(AppCompatResources.getDrawable(requireContext(), R.drawable.background_imageview_profile))
                        .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
                        .into(binding.imageSchool1)
                    Glide.with(this@HomeFragment).load(it[1].profileUrl)
                        .error(AppCompatResources.getDrawable(requireContext(), R.drawable.background_imageview_profile))
                        .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
                        .into(binding.imageSchool2)
                    Glide.with(this@HomeFragment).load(it[2].profileUrl)
                        .error(AppCompatResources.getDrawable(requireContext(), R.drawable.background_imageview_profile))
                        .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
                        .into(binding.imageSchool3)
                    Log.d("사람",it.toString())
                }
            }
        }
        getSchoolRanking()
        getAllPersonalRanking()
    }

    private fun getSchoolRanking() {
        viewModel.getSchoolRanking(1)
    }

    private fun getAllPersonalRanking() {
        viewModel.getAllPersonalRanking(3)
    }

    private fun setImg(){

    }

    private fun timer() {
        var timerStatus = false
        binding.buttonTimer.setOnClickListener {
            timerStatus = if (timerStatus) {
                binding.buttonTimer.text = "시작"
                Log.d("타이머", "멈춤")
                serviceStop()
                false
            } else {
                binding.buttonTimer.text = "중지"
                Log.d("타이머", "시작")
                serviceStart()
                true
            }
        }

    }


    private fun serviceStart() {
        Intent(context, TimerService::class.java).also { intent ->
            activity?.startService(intent)
        }
    }

    private fun serviceStop() {
        Intent(context, TimerService::class.java).also { intent ->
            activity?.stopService(intent)
        }
    }
}