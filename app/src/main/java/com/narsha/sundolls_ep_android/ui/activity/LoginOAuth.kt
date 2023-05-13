package com.narsha.sundolls_ep_android.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.data.local.googleOAuth.LoginGoogle
import com.narsha.sundolls_ep_android.databinding.ActivityLoginOauthBinding
import com.narsha.sundolls_ep_android.ui.viewmodel.LoginOAuthViewModel

class LoginOAuth : AppCompatActivity() {

    private val viewModel: LoginOAuthViewModel by lazy { ViewModelProvider(this)[LoginOAuthViewModel::class.java] }
    private val binding: ActivityLoginOauthBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_login_oauth
        )
    }

    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("224818744622-c01jteud2afgr9o296c3p4h0p42hmar7.apps.googleusercontent.com")
        .requestEmail()
        .requestProfile()
        .build()


    val googleSignInClient: GoogleSignInClient by lazy {
        GoogleSignIn.getClient(this, gso)
    }




    private val signInResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                LoginGoogle(this).handleSignInResult(task)
            } else {
                Log.d("애러", result.toString())
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.login = viewModel
        binding.lifecycleOwner = this



        viewModel.goHome.observe(this) {
            val signInIntent = googleSignInClient.signInIntent
            signInResultLauncher.launch(signInIntent)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }


}