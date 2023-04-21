package com.narsha.sundolls_ep_android.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.ActivityHomeBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.HomeViewModel

class Home : AppCompatActivity() {
    private val viewModel: HomeViewModel by lazy { ViewModelProvider(this)[HomeViewModel::class.java] }
    private val binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding.circularProgressBar.setProgressWithAnimation(65f, 1500) // 65% in 1500ms

    }
}