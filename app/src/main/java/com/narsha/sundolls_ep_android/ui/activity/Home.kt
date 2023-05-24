package com.narsha.sundolls_ep_android.ui.activity

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_LOCKED_CLOSED
import androidx.lifecycle.ViewModelProvider
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.ActivityHomeBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.HomeViewModel

class Home : AppCompatActivity() {

    companion object {
        lateinit var instance: Home
        fun ApplicationContext(): Context {
            return instance.applicationContext
        }
    }

    init {
        instance = this
    }

    private val transaction = supportFragmentManager.beginTransaction()
    private val fragmentManager: FragmentManager = supportFragmentManager


    private val friendFragment = FriendFragment()
    private val homeFragment = HomeFragment()
    private val rankingFragment = RankingFragment()


    private val viewModel: HomeViewModel by lazy { ViewModelProvider(this)[HomeViewModel::class.java] }
    val binding: ActivityHomeBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_home
        )
    }


    private lateinit var homeViewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.homeViewModel = viewModel
        binding.lifecycleOwner = this
        binding.DrawerLayout.setDrawerLockMode(LOCK_MODE_LOCKED_CLOSED)
        homeViewModel = HomeViewModel()

        viewModel.onclickDrawerLayout.observe(this) {
            homeViewModel.OnclickDrawerOpen(binding)
        }

    }


}