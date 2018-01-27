package com.dlovan.sunshine.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.dlovan.sunshine.domain.model.ForecastList

/**
 * the Adapter for list of 7 days forecast
 *
 * Created by dlovan on 11/18/17.
 */

class ForecastListAdapter(private val weekForecast: ForecastList) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder = ViewHolder(TextView(parent.context))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int = weekForecast.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}