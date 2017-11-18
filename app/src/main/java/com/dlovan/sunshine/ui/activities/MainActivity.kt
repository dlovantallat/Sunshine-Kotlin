package com.dlovan.sunshine.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.dlovan.sunshine.R
import com.dlovan.sunshine.data.Request
import com.dlovan.sunshine.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

/**
 * this is the main Activity that will show the list of 7 days forecast of Erbil City
 *
 * Created by dlovan on 11/18/17.
 */
class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERIZATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup the recyclerView and Adapter to show forecast list
        val forecastList = find<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)

        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?" +
                "APPID=2a486e1c13c859a58987ddcc74979016&q=erbil&mode=json&units=metric&cnt=7"

        //this method will let to return to main thread by calling the uiThread
        doAsync {
            Request(url).run()
            uiThread { longToast("Request performed") }
        }
    }
}