package com.narsha.sundolls_ep_android.data.local.googleOAuth

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.narsha.sundolls_ep_android.App
import com.narsha.sundolls_ep_android.data.local.retrofit.ClientRetrofit
import com.narsha.sundolls_ep_android.data.local.retrofit.response.GoogleLogin_Response.GoogleLogin_Response
import com.narsha.sundolls_ep_android.ui.activity.Home
import com.narsha.sundolls_ep_android.ui.activity.LoginOAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginGoogle(private val context: Context) {

    private val loginOAuth = LoginOAuth()


    fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val idToken = account.idToken.toString()

            Log.d("GoogleSignIn", "User name: ${account.displayName}")
            Log.d("GoogleSignIn", "User email: ${account.email}")
            Log.d("GoogleSignIn", "User idToken: $idToken")
            Login(idToken)

        } catch (e: ApiException) {
            Log.d("상태", e.message.toString())
        }
    }


    fun nextActivity() {
        val intent = Intent(context, Home::class.java)
        context.startActivity(intent)
    }


    fun Login(idToken: String) {
        ClientRetrofit.api.GoogleLogin(idToken).enqueue(object : Callback<GoogleLogin_Response> {
            override fun onResponse(
                call: Call<GoogleLogin_Response>,
                response: Response<GoogleLogin_Response>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("retrofit", data.toString())
                    App.prefs.access_token = data?.access_token
                    Log.d("access_token", App.prefs.access_token.toString())
                    nextActivity()
                } else {
                    Log.d("retrofit", response.code().toString())
                }
            }

            override fun onFailure(call: Call<GoogleLogin_Response>, t: Throwable) {
                Log.d("retrofit", t.message.toString())
            }
        })
    }

    fun Logout(){
        loginOAuth.googleSignInClient.signOut()
            .addOnCanceledListener {

            }
    }
}