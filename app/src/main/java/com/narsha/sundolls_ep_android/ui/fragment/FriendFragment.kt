package com.narsha.sundolls_ep_android.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.databinding.FragmentFriendBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.FriendViewModel


class FriendFragment : Fragment() {

    private val viewModel: FriendViewModel by lazy {
        ViewModelProvider(this)[FriendViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentFriendBinding = FragmentFriendBinding.inflate(inflater, container, false)
        binding.ranking = viewModel
        // Inflate the layout for this fragment
        return binding.root
    }

}