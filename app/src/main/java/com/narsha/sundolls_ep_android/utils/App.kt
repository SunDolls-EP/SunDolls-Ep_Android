package com.narsha.sundolls_ep_android.utils

import android.app.Application
import com.narsha.sundolls_ep_android.data.model.MySharedPreferences

class App: Application() {
    companion object {
        lateinit var prefs : MySharedPreferences
    }
    /* prefs라는 이름의 MySharedPreferences 하나만 생성할 수 있도록 설정. */

    override fun onCreate() {
        prefs = MySharedPreferences(applicationContext)
        super.onCreate()
    }
}