package com.narsha.sundolls_ep_android.ui.fragment.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.narsha.sundolls_ep_android.databinding.FragmentHomeBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.HomeViewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.home = viewModel

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
        return binding.root
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