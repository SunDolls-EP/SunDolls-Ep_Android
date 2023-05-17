package com.narsha.sundolls_ep_android.ui.viewmodel

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.narsha.sundolls_ep_android.ui.activity.Home
import com.narsha.sundolls_ep_android.ui.activity.Login

class LoginOAuthViewModel: ViewModel() {

    private lateinit var signInLauncher: ActivityResultLauncher<Intent>

    private val _registration = MutableLiveData<Boolean>()
    private val _non_registration = MutableLiveData<Boolean>()

    fun nextActivity() {
        val intent = Intent(Login.ApplicationContext(), Home::class.java)
        Login.ApplicationContext().startActivity(intent.addFlags(FLAG_ACTIVITY_NEW_TASK))
    }

    val registration: LiveData<Boolean>
        get() = _registration

    val non_registration: LiveData<Boolean>
        get() = _non_registration

    fun non_registration(){
        _non_registration.value = true
    }

    fun registration() {
        _registration.value = true
    }





}
