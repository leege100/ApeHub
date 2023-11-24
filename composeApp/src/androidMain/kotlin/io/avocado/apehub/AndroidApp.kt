package io.avocado.apehub

import android.app.Application

class AndroidApp : Application() {
    companion object {
        private lateinit var instance: AndroidApp
        fun getInstance(): AndroidApp {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
