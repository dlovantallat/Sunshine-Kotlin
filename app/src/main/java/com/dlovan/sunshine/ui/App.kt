package com.dlovan.sunshine.ui

import android.app.Application
import com.dlovan.sunshine.extensions.DelegatesExt
import com.facebook.stetho.Stetho

/**
 * Application Singleton
 * Created by dlovan on 1/30/18.
 */

class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        //this is to show the database in the google chrome
        Stetho.initializeWithDefaults(instance)
    }
}