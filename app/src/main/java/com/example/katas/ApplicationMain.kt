package com.example.katas

import android.app.Application
import com.example.data.sharedpreference.Prefs
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ApplicationMain: Application() {
    companion object{
         lateinit var prefs: Prefs
    }
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)


    }


}