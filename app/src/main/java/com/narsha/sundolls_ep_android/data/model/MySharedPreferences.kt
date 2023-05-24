package com.narsha.sundolls_ep_android.data.model

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(context: Context) {
    companion object{
        const val PREFS_FILENAME = "prefs"
        const val PREF_KEY_MY_EDITTEXT = "myEditText"
    }

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)
    var access_token: String?
        get() = prefs.getString(PREF_KEY_MY_EDITTEXT, "")
        set(value) = prefs.edit().putString(PREF_KEY_MY_EDITTEXT, value).apply()


}