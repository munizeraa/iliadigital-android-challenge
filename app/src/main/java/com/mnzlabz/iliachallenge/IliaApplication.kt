package com.mnzlabz.iliachallenge

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class IliaApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}