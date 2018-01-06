package com.dlovan.sunshine.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.dlovan.sunshine.R
import com.dlovan.sunshine.domain.commands.RequestForecastCommand
import com.dlovan.sunshine.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

/**
 * this is the main Activity that will show the list of 7 days forecast of Erbil City
 *
 * Created by dlovan on 11/18/17.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup the recyclerView and Adapter to show forecast list
        val forecastList = find<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        //this method will let to return to main thread by calling the uiThread
        doAsync {
            val result = RequestForecastCommand("erbil").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result)
            }
        }
    }
}