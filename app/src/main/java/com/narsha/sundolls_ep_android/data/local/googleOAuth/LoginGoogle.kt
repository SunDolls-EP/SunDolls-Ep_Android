package com.narsha.sundolls_ep_android.data.local.googleOAuth

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.google.android.gms.tasks.Task
import com.google.api.services.people.v1.PeopleServiceScopes
import com.narsha.sundolls_ep_android.R
import com.narsha.sundolls_ep_android.data.local.retrofit.ClientRetrofit
import com.narsha.sundolls_ep_android.data.local.retrofit.response.GoogleLogin_Response.GoogleLogin_Response
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginGoogle(private val context: Context) {


    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("224818744622-c01jteud2afgr9o296c3p4h0p42hmar7.apps.googleusercontent.com")
        .requestEmail()
        .build()


    fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val idToken = account.idToken.toString()

            Log.d("GoogleSignIn", "User name: ${account.displayName}")
            Log.d("GoogleSignIn", "User email: ${account.email}")
            Log.d("GoogleSignIn", "User idToken: $idToken")
            Login(idToken)

            // 로그인 성공 처리
            // account.idToken으로 인증 정보를 가져올 수 있습니다.
        } catch (e: ApiException) {
            Log.d("상태", e.message.toString())
            // 로그인 실패 처리
        }
    }

    fun Login(idToken: String){
        ClientRetrofit.api.GoogleLogin(idToken).enqueue(object : Callback<GoogleLogin_Response>{
            override fun onResponse(
                call: Call<GoogleLogin_Response>,
                response: Response<GoogleLogin_Response>
            ) {
                if(response.isSuccessful){
                    val data = response.body()
                    Log.d("retrofit",data.toString())
                } else {
                    Log.d("retrofit", response.code().toString())
                }
            }

            override fun onFailure(call: Call<GoogleLogin_Response>, t: Throwable) {
                Log.d("retrofit",t.message.toString())
            }
        })
    }
}