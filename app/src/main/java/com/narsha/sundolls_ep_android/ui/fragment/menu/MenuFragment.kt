package com.narsha.sundolls_ep_android.ui.fragment.menu

import android.content.Intent
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.narsha.sundolls_ep_android.utils.App
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.databinding.FragmentMenuBinding
import com.narsha.sundolls_ep_android.ui.activity.LoginActivity
import com.narsha.sundolls_ep_android.ui.viewmodel.UserViewModel

class MenuFragment : BaseFragment<FragmentMenuBinding, MenuViewModel>(
    R.layout.fragment_menu
) {
    override val viewModel: MenuViewModel by viewModels()
    val userViewModel: UserViewModel by activityViewModels()
    override fun start() {
        val userData = userViewModel.userData.value!!

        with(binding) {
            name.text = userData.username
            school.text = userData.schoolName
            time.text = if (userData.totalStudyTime == 0L) {
                "공부한 시간이 없습니다"
            } else if ((userData.totalStudyTime) < 60) {
                userData.totalStudyTime.toString() + "초"
            } else if ((userData.totalStudyTime) < 3600) {
                ((userData.totalStudyTime/60)).toString() + "분"
            } else {
                ((userData.totalStudyTime/3600)).toString() + "시간"
            }
            buttonLogout.setOnClickListener { logout() }
            buttonAccountFix.setOnClickListener { goFixUserFragment() }
        }

        Glide.with(this).load(userData.profileUrl)
            .error(
                AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.background_imageview_profile
                )
            )
            .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
            .into(binding.imageView6)
    }

    private fun logout() {
        App.prefs.deleteUserInformation()
        Intent(context, LoginActivity::class.java).also {
            finishAffinity(requireActivity())
            startActivity(it)
        }
    }

    private fun goFixUserFragment() {
        findNavController().navigate(R.id.action_menuFragment_to_fixUserFragment)
    }
}