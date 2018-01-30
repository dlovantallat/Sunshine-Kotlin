package com.dlovan.sunshine.data.server

import com.google.gson.Gson
import java.net.URL

/**
 * this class handle the simple request for get some read data from the api URL
 * Created by dlovan on 11/18/17.
 */
class ForecastRequest(private val zipCode: Long) {

    companion object {
        private val APP_ID = "2a486e1c13c859a58987ddcc74979016"
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${URL}&APPID=${APP_ID}&q="
    }

    /**
     * this function will return the list of forecast data
     */
    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}