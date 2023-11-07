package com.narsha.sundolls_ep_android.ui.fragment.novel

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.base.BaseFragment
import com.narsha.sundolls_ep_android.databinding.FragmentNovelBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.UserViewModel

class NovelFragment: BaseFragment<FragmentNovelBinding, NovelViewModel>(
    R.layout.fragment_novel
) {
    override val viewModel: NovelViewModel by viewModels()
    val userViewModel: UserViewModel by activityViewModels()
    override fun start() {
        Log.d("UserInformation",userViewModel.userData.value.toString())
        with(binding){
            buttonFind.setOnClickListener {
                findUser(name.text.toString())
            }
        }
    }

    private fun findUser(name: String){
        if(extractAndCheckPattern(name)){
            val userName = name.substring(0, name.length - 5)
            val tag = name.substring(name.length - 4)
            userViewModel.findUser(userName, tag)
        } else {
            userViewModel.findUser(name, "")
        }
    }

    private fun extractAndCheckPattern(input: String): Boolean {
        val pattern = Regex("#\\d{4}$") // # 다음에 4자리 숫자가 오는 패턴을 정의합니다.

        val matchResult = pattern.find(input)

        // 패턴이 발견되었고, 발견된 부분이 문자열의 끝과 일치하는 경우 true를 반환합니다.
        return matchResult != null && matchResult.value == input
    }
}