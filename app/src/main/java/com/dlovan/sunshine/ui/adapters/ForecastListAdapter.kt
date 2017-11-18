package com.dlovan.sunshine.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * the Adapter for list of 7 days forecast
 *
 * Created by dlovan on 11/18/17.
 */

class ForecastListAdapter(private val items: List<String>) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder = ViewHolder(TextView(parent.context))

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}