package com.dlovan.sunshine.data

import android.util.Log
import java.net.URL

/**
 * this class handle the simple request for get some read data from the api URL
 * Created by dlovan on 11/18/17.
 */
class Request(private val url: String) {

    /**
     * this method run will print the list of forecast data
     */
    fun run() {
        val forecastJsonStr = URL(url).readText()
        Log.i("TAG", forecastJsonStr)
    }
}