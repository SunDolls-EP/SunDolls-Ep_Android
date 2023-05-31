package com.narsha.sundolls_ep_android.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.FragmentCalendarBinding
import com.narsha.sundolls_ep_android.databinding.FragmentFriendBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.CalendarViewModel
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.FriendViewModel

class CalendarFragment : Fragment() {

    private val viewModel: CalendarViewModel by lazy {
        ViewModelProvider(this)[CalendarViewModel::class.java]
    }

    lateinit var binding: FragmentCalendarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalendarBinding.inflate(inflater, container, false)
        binding.calendarViewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

}