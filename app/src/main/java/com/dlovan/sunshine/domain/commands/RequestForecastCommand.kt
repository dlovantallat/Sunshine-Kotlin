package com.dlovan.sunshine.domain.commands

import com.dlovan.sunshine.data.ForecastRequest
import com.dlovan.sunshine.domain.mappers.ForecastDataMapper
import com.dlovan.sunshine.domain.model.ForecastList

/**
 * the Request class
 * Created by dlovan on 1/6/18.
 */

class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}