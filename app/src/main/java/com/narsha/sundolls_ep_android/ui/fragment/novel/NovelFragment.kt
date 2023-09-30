package com.narsha.sundolls_ep_android.ui.fragment.novel

import androidx.fragment.app.viewModels
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.databinding.FragmentNovelBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.NovelViewModel

class NovelFragment: BaseFragment<FragmentNovelBinding, NovelViewModel>(
    R.layout.fragment_novel
) {
    override val viewModel: NovelViewModel by viewModels()
    override fun start() {

    }
}