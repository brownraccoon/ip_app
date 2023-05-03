package com.br.ipapp

import android.app.Application
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class IpApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setUpTimberLogging()
    }

    private fun setUpTimberLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}
