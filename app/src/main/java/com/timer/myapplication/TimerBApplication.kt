package com.timer.myapplication

import android.app.Application
import io.realm.Realm

class TimerBApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}