package com.narsha.sundolls_ep_android.ui.fragment.home

import android.content.Intent
import android.util.Log
import androidx.fragment.app.viewModels
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.databinding.FragmentHomeBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val viewModel: HomeViewModel by viewModels()

    override fun start() {
        var timerStatus = false
        binding.buttonTimer.setOnClickListener {
            timerStatus = if (timerStatus) {
                binding.buttonTimer.setImageResource(R.drawable.ic_start)
                Log.d("타이머", "멈춤")
                serviceStop()
                false
            } else {
                binding.buttonTimer.setImageResource(R.drawable.ic_stop)
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