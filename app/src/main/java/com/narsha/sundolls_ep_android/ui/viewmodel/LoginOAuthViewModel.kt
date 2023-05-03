package com.narsha.sundolls_ep_android.ui.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
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
import com.google.android.gms.tasks.Task
import com.narsha.sundolls_ep_android.ui.activity.LoginOAuth

class LoginOAuthViewModel: ViewModel() {

    private val _goHome = MutableLiveData<Boolean>()

    private val _navigateToMainActivity = MutableLiveData<Boolean>()
    val navigateToMainActivity: LiveData<Boolean>
        get() = _navigateToMainActivity

    fun signIn(context: Context) {
        var googleSignInClient: GoogleSignInClient

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(context, gso)

        var registry: ActivityResultRegistry?= null
        val signInIntent = googleSignInClient.signInIntent
        if (context is FragmentActivity) {
            registry = context.activityResultRegistry
        }
        val signInActivityResultLauncher = registry?.register(
            "key_sign_in",
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleSignInResult(task)
            }
        }
        signInActivityResultLauncher?.launch(signInIntent)
    }
    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            // Signed in successfully, show authenticated UI.
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            Log.w("LoginViewModel", "signInResult:failed code=${e.statusCode}")
        }
    }




    val goHome: LiveData<Boolean>
        get() = _goHome
    fun callSignIn() {
        _goHome.value = true
    }
}