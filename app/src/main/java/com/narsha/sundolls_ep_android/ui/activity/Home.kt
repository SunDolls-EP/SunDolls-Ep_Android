package com.narsha.sundolls_ep_android.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.ActivityHomeBinding
import com.narsha.sundolls_ep_android.ui.fragment.FriendFragment
import com.narsha.sundolls_ep_android.ui.fragment.HomeFragment
import com.narsha.sundolls_ep_android.ui.fragment.RankingFragment
import com.narsha.sundolls_ep_android.ui.viewmodel.activity.HomeViewModel

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
        homeViewModel = HomeViewModel()

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.novel -> {
                    replaceFragment(friendFragment)
                    //친구 불러오기
                    fragmentViewModel.getFriend()
                }
                R.id.home ->{
                    replaceFragment(homeFragment)
                }
                R.id.ranking -> {
                    replaceFragment(rankingFragment)
                }
            }
            true
        }

        binding.bottomNavigation.selectedItemId = R.id.home
    }

    override fun onResume() {
        super.onResume()
    }

    private fun replaceFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
    }


}