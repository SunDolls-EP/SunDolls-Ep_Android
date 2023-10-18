package com.narsha.sundolls_ep_android.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.narsha.sundolls_ep_android.R


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startLoading()
    }

    private fun startLoading() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed( {
            // Splash Screen이 뜨고 나서 실행될 Activity 연결
            Intent(applicationContext, LoginActivity::class.java).also {
                it.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(it)
            }
            finish()
        }, 1500)
    }
}