package com.dlovan.sunshine.ui

import android.app.Application
import com.dlovan.sunshine.ui.utils.DelegatesExt

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
    }
}