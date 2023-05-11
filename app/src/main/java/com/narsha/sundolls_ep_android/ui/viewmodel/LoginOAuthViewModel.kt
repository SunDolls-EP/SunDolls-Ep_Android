package com.narsha.sundolls_ep_android.ui.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.tasks.Task
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.ui.activity.LoginOAuth

class LoginOAuthViewModel: ViewModel() {

    private lateinit var signInLauncher: ActivityResultLauncher<Intent>

    private val _goHome = MutableLiveData<Boolean>()
    private val _accessToken = MutableLiveData<String>()

    val goHome: LiveData<Boolean>
        get() = _goHome
    fun callSignIn() {
        _goHome.value = true
    }

    val accessToken: LiveData<String>
        get() = _accessToken
}
