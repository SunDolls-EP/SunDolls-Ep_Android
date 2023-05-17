package com.narsha.sundolls_ep_android.data.local.googleOAuth

import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.narsha.sundolls_ep_android.App
import com.narsha.sundolls_ep_android.data.local.retrofit.ClientRetrofit
import com.narsha.sundolls_ep_android.data.local.retrofit.response.GoogleLogin_Response.GoogleLogin_Response
import com.narsha.sundolls_ep_android.ui.activity.Login
import com.narsha.sundolls_ep_android.ui.viewmodel.LoginOAuthViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginGoogle(loginOAuth: Login) {

    private val loginOAuthViewModel = LoginOAuthViewModel()



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


    //HomeActivity 이동


    //서버 로그인(Google idToken으로 로그인함)
    fun Login(idToken: String) {
        ClientRetrofit.api.GoogleLogin(idToken).enqueue(object : Callback<GoogleLogin_Response> {
            override fun onResponse(
                call: Call<GoogleLogin_Response>,
                response: Response<GoogleLogin_Response>
            ) {
                if (response.isSuccessful) {
                    val data = response.headers().get("authorization")!!
                    App.prefs.access_token = data
                    Log.d("access_token", App.prefs.access_token.toString())
                    Log.d("User",response.body().toString())
                    loginOAuthViewModel.nextActivity()
                } else {
                    Log.d("retrofit", response.code().toString())
                }
            }

            override fun onFailure(call: Call<GoogleLogin_Response>, t: Throwable) {
                Log.d("retrofit", t.message.toString())
                Log.d("retrofit","error")

            }
        })
    }

    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("224818744622-c01jteud2afgr9o296c3p4h0p42hmar7.apps.googleusercontent.com")
        .requestEmail()
        .requestProfile()
        .build()


    val googleSignInClient: GoogleSignInClient by lazy {
        GoogleSignIn.getClient(Login.ApplicationContext(), gso)
    }

    fun Logout(){
        googleSignInClient.signOut()
            .addOnCanceledListener {

            }
    }
}