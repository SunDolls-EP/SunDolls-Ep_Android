package com.narsha.sundolls_ep_android.ui.fragment.menu

import android.content.Intent
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.viewModels
import com.narsha.sundolls_ep_android.utils.App
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.databinding.FragmentMenuBinding
import com.narsha.sundolls_ep_android.ui.activity.LoginActivity
import com.narsha.sundolls_ep_android.ui.viewmodel.fragment.UserViewModel

class MenuFragment : BaseFragment<FragmentMenuBinding, UserViewModel>(
    R.layout.fragment_menu
) {
    override val viewModel: UserViewModel by viewModels()
    override fun start() {
        with(binding) {
            name.text = App.prefs.name
            school.text = App.prefs.school


            buttonAccountFix.setOnClickListener {}
            buttonLogout.setOnClickListener {
                logout()
            }
        }
    }

    private fun logout(){
        App.prefs.deleteUserInformation()
        Intent(context, LoginActivity::class.java).also {
            finishAffinity(requireActivity())
            startActivity(it)
        }
    }
}