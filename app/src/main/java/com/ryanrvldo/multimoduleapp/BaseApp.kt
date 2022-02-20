package com.ryanrvldo.multimoduleapp

import com.google.android.play.core.splitcompat.SplitCompatApplication
import timber.log.Timber

class BaseApp : SplitCompatApplication() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}