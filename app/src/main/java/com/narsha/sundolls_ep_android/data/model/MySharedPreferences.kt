package com.narsha.sundolls_ep_android.data.model

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(context: Context) {
    companion object{
        const val PREFS_FILENAME = "prefs"
        const val PREF_KEY_ACCESSTOKEN = "PREF_KEY_ACCESSTOKEN"
    }

    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)
    var accessToken: String
        get() = prefs.getString(PREF_KEY_ACCESSTOKEN, "").toString()
        set(value) = prefs.edit().putString(PREF_KEY_ACCESSTOKEN, value).apply()



    fun deleteUserInformation() {
        prefs.edit().remove(PREF_KEY_ACCESSTOKEN).apply()
    }

}