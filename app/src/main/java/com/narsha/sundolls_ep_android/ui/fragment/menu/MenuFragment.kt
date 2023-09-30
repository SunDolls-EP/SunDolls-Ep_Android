package com.narsha.sundolls_ep_android.ui.fragment.menu

import androidx.fragment.app.viewModels
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.databinding.FragmentMenuBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.MenuViewModel

class MenuFragment: BaseFragment<FragmentMenuBinding, MenuViewModel>(
    R.layout.fragment_menu
) {
    override val viewModel: MenuViewModel by viewModels()
    override fun start() {

    }
}