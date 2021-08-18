package com.djumabaevs.realchat

import android.app.Application
import timber.log.Timber

class RealChatApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}