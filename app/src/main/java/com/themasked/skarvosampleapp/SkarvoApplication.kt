package com.themasked.skarvosampleapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SkarvoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}