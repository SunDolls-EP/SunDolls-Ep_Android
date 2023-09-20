package com.narsha.sundolls_ep_android.ui.activity

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.ActivityHomeBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.activity.HomeViewModel


class Home : AppCompatActivity() {

    private val viewModel: HomeViewModel by lazy { ViewModelProvider(this)[HomeViewModel::class.java] }
    val binding: ActivityHomeBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_home
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.home = viewModel
        binding.lifecycleOwner = this

        binding.bnv.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.novel -> {

                }

                R.id.home -> {
                    replaceFragment(friendFragment)
                    fragmentViewModel.getFriend()
                }

                R.id.home ->{

                }
                
                R.id.home ->{
                    replaceFragment(homeFragment)
                }

                R.id.menu -> {

                }
            }
            true
        }

        binding.bnv.selectedItemId = R.id.home
    }

    override fun onResume() {
        super.onResume()
    }
}