package com.kevin.kevinsquizapp

import android.app.Application
import timber.log.Timber

class KevinsQuizAppL : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree());
        }
    }
}