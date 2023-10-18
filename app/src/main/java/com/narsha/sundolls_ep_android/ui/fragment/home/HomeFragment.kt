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
        viewModel.timerStatus.observe(viewLifecycleOwner){
            if(it) {
                Log.d("상태",it.toString())
                serviceStart()
            } else {
                Log.d("상태",it.toString())
                serviceStop()
            }
        }
        serviceStart()
    }

    private fun serviceStart() {
        Intent(context, TimerService::class.java).also {
            activity?.startService(it)
        }
    }

    private fun serviceStop(){
        Intent(context, TimerService::class.java).also {
            activity?.stopService(it)
        }
    }
}