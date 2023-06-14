package com.narsha.sundolls_ep_android.ui.fragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.narsha.sundolls_ep_android.App
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.FragmentHomeBinding
import com.narsha.sundolls_ep_android.databinding.NavigationBeaderBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.HomeViewModel
import java.util.Locale
import java.util.Timer
import java.util.TimerTask

class HomeFragment : Fragment() {

    companion object{
        lateinit var instance: HomeFragment
        fun ApplicationContext() : Context {
            return instance.requireContext()
        }
    }
    init{
        instance = this
    }

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    lateinit var binding: FragmentHomeBinding
    lateinit var recyclerViewBinding: NavigationBeaderBinding

    private var timerStatus: Boolean = false




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Log.d("라이프","onCreateView")


        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.home = viewModel



        recyclerViewBinding = NavigationBeaderBinding.inflate(inflater, container, false)
        binding.DrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        recyclerViewBinding.lifecycleOwner = this
        recyclerViewBinding.recyclerTODO.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Log.d("라이프","onViewCreated")

        binding.DrawerLayout.closeDrawer(Gravity.LEFT)
        viewModel.onclickDrawerLayout.observe(viewLifecycleOwner) {
            viewModel.onclickDrawerOpen(binding)
        }

        viewModel.timer.observe(viewLifecycleOwner){
            Log.d("시간",it.toString())
            val minute = String.format("%02d", it / 60)
            val second = String.format("%02d", it % 60)
            binding.TargetTime.text = "$minute:$second"
            App.prefs.time = it
        }

        viewModel.timerState.observe(viewLifecycleOwner){
            //Start, STOP
            if(it){
                binding.iconStopNplay.setImageResource(R.drawable.icon_stop)
                binding.textStopNplay.text = "STOP"
            } else {
                binding.iconStopNplay.setImageResource(R.drawable.icon_play)
                binding.textStopNplay.text = "START"
            }
        }

        viewModel.timerSkip.observe(viewLifecycleOwner){
            //Skip
            timerStatus = false
        }

        viewModel.onclickAddTODO.observe(viewLifecycleOwner){

        }

        viewModel.todoListData.observe(viewLifecycleOwner){

        }

    }

    override fun onResume() {
        binding.DrawerLayout.closeDrawer(Gravity.LEFT)
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.DrawerLayout.closeDrawer(Gravity.LEFT)
        Log.d("라이프","onDestroyView")
    }



}