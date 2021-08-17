package com.djumabaevs.realchat

import android.app.Application
import timber.log.Timber

class RealChatApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}