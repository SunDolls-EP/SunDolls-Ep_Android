package com.narsha.sundolls_ep_android.data.model

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(context: Context) {
    companion object{
        const val PREFS_FILENAME = "prefs"
        const val PREF_KEY_ACCESSTOKEN = "accessToken"
        const val PREF_KEY_TIME = "time"
    }

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)
    var accessToken: String?
        get() = prefs.getString(PREF_KEY_ACCESSTOKEN, "")
        set(value) = prefs.edit().putString(PREF_KEY_ACCESSTOKEN, value).apply()

    var time: Long
        get() = prefs.getLong(PREF_KEY_TIME,0L)
        set(value) = prefs.edit().putLong(PREF_KEY_TIME, value).apply()


}