package com.ubaya.uts160421066.view

import android.content.Context
import android.content.SharedPreferences

class SharedPrefManager(context: Context) {

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences("MY_APP_PREF", Context.MODE_PRIVATE)

    fun saveLoginStatus(isLoggedIn: Boolean) {
        val editor = sharedPref.edit()
        editor.putBoolean("IS_LOGGED_IN", isLoggedIn)
        editor.apply()
    }

    fun getLoginStatus(): Boolean {
        return sharedPref.getBoolean("IS_LOGGED_IN", false)
    }
}
