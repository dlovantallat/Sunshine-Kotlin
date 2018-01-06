package com.dlovan.sunshine.domain.model

/**
 * the data class
 * Created by dlovan on 1/6/18.
 */
data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>)

data class Forecast(val date: String, val description: String, val high: Int, val low: Int)