package com.narsha.sundolls_ep_android.data.network.oauth.google

import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.narsha.sundolls_ep_android.App
import com.narsha.sundolls_ep_android.data.network.retrofit.ClientRetrofit
import com.narsha.sundolls_ep_android.data.network.retrofit.response.login_response.LoginResponse
import com.narsha.sundolls_ep_android.ui.activity.LoginActivity
import com.narsha.sundolls_ep_android.ui.viewmodel.activity.LoginOAuthViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginGoogle() {

    private val loginOAuthViewModel = LoginOAuthViewModel()

    fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val idToken = account.idToken.toString()

            Log.d("GoogleSignIn", "User name: ${account.displayName}")
            Log.d("GoogleSignIn", "User email: ${account.email}")
            Log.d("GoogleSignIn", "User idToken: $idToken")
            googleLogin(idToken)

        } catch (e: ApiException) {
            Log.d("상태", e.message.toString())
        }
    }


    //HomeActivity 이동


    //서버 로그인(Google idToken으로 로그인함)
    private fun googleLogin(idToken: String) {
        ClientRetrofit.api.googleLogin(idToken).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    App.prefs.accessToken = response.headers()["authorization"]!!
                    App.prefs.name = data?.username?:""
                    App.prefs.school = data?.schoolName?:""
                    Log.d("retrofit", App.prefs.accessToken)
                    Log.d("retrofit",response.body().toString())
                    loginOAuthViewModel.nextActivity()
                } else {
                    Log.d("retrofit", response.code().toString())
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("retrofit", t.message.toString())
            }
        })
    }

    private val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("224818744622-c01jteud2afgr9o296c3p4h0p42hmar7.apps.googleusercontent.com")
        .requestEmail()
        .requestProfile()
        .build()


    val googleSignInClient: GoogleSignInClient by lazy {
        GoogleSignIn.getClient(LoginActivity.applicationContext(), gso)
    }

    fun Logout(){
        googleSignInClient.signOut()
            .addOnCanceledListener {

            }
    }
}