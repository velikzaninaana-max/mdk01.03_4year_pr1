package com.example.pr1.data

import android.content.Context

class SharedPrefManager(private val context: Context) {
    companion object{
        private val SHARED_PREFS = "preferences"
        private val SHARED_TOKEN = "access_token"
    }
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

    fun saveTokenToSharedPrefs(token: String){
        sharedPreferences.edit().putString(SHARED_TOKEN, token).apply()
    }
    fun readTokenToSharedPrefs(): String? {
        return sharedPreferences.getString(SHARED_TOKEN, null)
    }
}