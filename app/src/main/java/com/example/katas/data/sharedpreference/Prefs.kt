package com.example.katas.data.sharedpreference

import android.content.Context

class Prefs(val context: Context) {
    val SHARED_NAME = "saveUser"
    val SHARED_EMAIL = "email"
    val storage = context.getSharedPreferences(SHARED_NAME,0)

    fun saveName(email: String){
        storage.edit().putString(SHARED_EMAIL,email).apply()
    }
    fun getName():String{
        return storage.getString(SHARED_EMAIL,"")!!

    }
    fun clearSession(){
        storage.edit().clear().apply()

    }
}