package com.narsha.sundolls_ep_android.ui.activity

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.ActivityHomeBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.HomeViewModel

class Home : AppCompatActivity() {

    companion object{
        lateinit var instance: Home
        fun ApplicationContext() : Context {
            return instance.applicationContext
        }
    }
    init{
        instance = this
    }

    private val viewModel: HomeViewModel by lazy { ViewModelProvider(this)[HomeViewModel::class.java] }
    private val binding by lazy { DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.home = viewModel
        binding.lifecycleOwner = this

//        viewModel.Check_Time.observe(this){
//
//        }
    }
}