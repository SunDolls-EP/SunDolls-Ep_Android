package com.narsha.sundolls_ep_android.ui.activity

import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseActivity
import com.narsha.sundolls_ep_android.databinding.ActivityHomeBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.activity.HomeViewModel


class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(R.layout.activity_home) {
    override val viewModel: HomeViewModel by viewModels()

    override fun start() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.findNavController()
        binding.bnv.setupWithNavController(navController)
    }
}