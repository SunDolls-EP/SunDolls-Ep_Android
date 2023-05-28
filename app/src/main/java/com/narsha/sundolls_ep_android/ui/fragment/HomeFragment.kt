package com.narsha.sundolls_ep_android.ui.fragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.narsha.sundolls_ep_android.App
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

    private val handler = Handler(Looper.getMainLooper())
    private var timer: Timer? = null
    private var timerTask: TimerTask? = null

    private var timeSeconds = 0L

    private var timeStatus = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        UITimer()
        Log.d("라이프","onCreateView")
        timeSeconds = App.prefs.time


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
        UITimer()

        Log.d("라이프","onViewCreated")

        viewModel.onclickDrawerLayout.observe(viewLifecycleOwner) {
            viewModel.onclickDrawerOpen(binding)
        }

        viewModel.timerState.observe(viewLifecycleOwner){
            if(!timeStatus){
                startTimer()
                Log.d("상태",timeStatus.toString())
                timeStatus = true
            } else {
                stopTimer()
                Log.d("상태",timeStatus.toString())
                timeStatus = false
            }
        }

        viewModel.timerSkip.observe(viewLifecycleOwner){
            skipTimer()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        App.prefs.time = timeSeconds
        Log.d("라이프","onDestroyView")
    }

    private fun startTimer(){
        timer = Timer()
        timerTask = object :TimerTask(){
            override fun run() {
                timeSeconds++
                handler.post { updateTimerText() }
            }
        }
        timer?.scheduleAtFixedRate(timerTask, 1000, 1000)
    }

    private fun stopTimer() {
        App.prefs.time = timeSeconds
        timer?.cancel()
        timer?.purge()
        timer = null
        timerTask = null
        handler.post { updateTimerText() }
    }

    private fun skipTimer() {
        timer?.cancel()
        timer?.purge()
        timer = null
        timerTask = null
        timeSeconds = 0
        App.prefs.time = 0
        handler.post { updateTimerText() }
    }


    private fun UITimer(){
        timerTask = object : TimerTask(){
            override fun run() {
                handler.post { updateTimerText() }
            }
        }
    }

    private fun updateTimerText() {
        val minutes = timeSeconds / 60
        val seconds = timeSeconds % 60
        binding.TargetTime.text = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds)
    }


}