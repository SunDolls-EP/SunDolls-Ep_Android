package com.narsha.sundolls_ep_android.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.FragmentCalendarBinding
import com.narsha.sundolls_ep_android.databinding.FragmentFriendBinding
import com.narsha.sundolls_ep_android.databinding.FragmentSettingBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.CalendarViewModel
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.SettingViewModel


class SettingFragment : Fragment() {

    private val viewModel: SettingViewModel by lazy {
        ViewModelProvider(this)[SettingViewModel::class.java]
    }

    lateinit var binding: FragmentSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSettingBinding.inflate(inflater, container, false)
        binding.settingViewModel = viewModel
        binding.lifecycleOwner = this


        return binding.root
    }

}