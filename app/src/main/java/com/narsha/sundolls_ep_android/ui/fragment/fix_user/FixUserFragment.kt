package com.narsha.sundolls_ep_android.ui.fragment.fix_user

import androidx.fragment.app.viewModels
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.databinding.FragmentFixuserBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.UserViewModel

class FixUserFragment: BaseFragment<FragmentFixuserBinding, UserViewModel>(R.layout.fragment_fixuser) {
    override val viewModel: UserViewModel by viewModels()

    override fun start() {
        
    }
}