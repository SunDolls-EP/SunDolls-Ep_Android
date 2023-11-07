package com.narsha.sundolls_ep_android.ui.fragment.fix_user

import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.data.network.dto.oauth.LoginResponseDto
import com.narsha.sundolls_ep_android.data.network.dto.user.UserFixInformationRequestDto
import com.narsha.sundolls_ep_android.databinding.FragmentFixuserBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.UserViewModel

class FixUserFragment :
    BaseFragment<FragmentFixuserBinding, FixUserViewModel>(R.layout.fragment_fixuser) {
    override val viewModel: FixUserViewModel by viewModels()
    private val userViewModel: UserViewModel by activityViewModels()

    override fun start() {
        with(userViewModel){
            getImage(userData.value?.profileUrl ?: "")
            userData.value?.let { setEditText(it) }
        }

        with(binding){
            buttonSave.setOnClickListener {
                fixUser(name.text.toString(), school.text.toString())
            }
        }
    }

    private fun getImage(url: String) {
        Glide.with(this@FixUserFragment).load(url)
            .error(
                AppCompatResources.getDrawable(
                    requireContext(),
                    R.drawable.background_imageview_profile
                )
            )
            .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
            .into(binding.imageProfile)
    }

    private fun setEditText(loginResponseDto: LoginResponseDto) {
        with(binding) {
            name.setText(loginResponseDto.username)
            school.setText(loginResponseDto.schoolName)
        }
    }

    private fun fixUser(name: String, schoolName: String) {
        userViewModel.fixUser(UserFixInformationRequestDto(name, schoolName))
        findNavController().popBackStack()
    }
}