package com.narsha.sundolls_ep_android.ui.fragment.novel

import androidx.fragment.app.viewModels
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.databinding.FragmentNovelBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.UserViewModel

class NovelFragment: BaseFragment<FragmentNovelBinding, UserViewModel>(
    R.layout.fragment_novel
) {
    override val viewModel: UserViewModel by viewModels()
    override fun start() {
        with(binding){

        }
    }
}