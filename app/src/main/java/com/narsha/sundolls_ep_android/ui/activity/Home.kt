package com.narsha.sundolls_ep_android.ui.activity

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.ActivityHomeBinding
import com.narsha.sundolls_ep_android.databinding.FragmentHomeBinding
import com.narsha.sundolls_ep_android.ui.fragment.FriendFragment
import com.narsha.sundolls_ep_android.ui.fragment.HomeFragment
import com.narsha.sundolls_ep_android.ui.fragment.RankingFragment
import com.narsha.sundolls_ep_android.ui.viewmodel.activity.HomeViewModel
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.FriendViewModel
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.RankingViewModel
import kotlin.concurrent.timer

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

    private val fragmentViewModel = FriendViewModel()

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
        val rankingViewModel = RankingViewModel()
        binding.bottomNavigation.itemIconTintList = null




        val colorStateList = ColorStateList.valueOf(Color.TRANSPARENT)

        binding.bottomNavigation.itemTextColor = ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_checked),
                intArrayOf(-android.R.attr.state_checked)
            ),
            intArrayOf(
                getColor(R.color.true_color),
                getColor(R.color.false_color)
            )
        )

        binding.bottomNavigation.itemIconTintList = colorStateList
        binding.bottomNavigation.itemRippleColor = null
        binding.bottomNavigation.itemBackground = null




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
                    rankingViewModel.getRanking()
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