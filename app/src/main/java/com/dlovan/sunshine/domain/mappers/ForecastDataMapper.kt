package com.dlovan.sunshine.domain.mappers

import com.dlovan.sunshine.data.server.Forecast
import com.dlovan.sunshine.data.server.ForecastResult
import com.dlovan.sunshine.domain.model.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit
import com.dlovan.sunshine.domain.model.Forecast as ModelForecast

/**
 * like utils class
 * Created by dlovan on 1/6/18.
 */

class ForecastDataMapper {

    fun convertFromDataModel(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }


    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(dt, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"
}