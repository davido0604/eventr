package com.example.eventr

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(var dataSet: List<Event>, val callback: (Coin) -> Unit): RecyclerView.Adapter<EventAdapter.DataViewHolder>() {

    inner class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val eventImage: ImageView
        val eventTitle: TextView
        val eventCity: TextView
        val eventDate: TextView
        val eventHost: TextView
        val readMore: Button

        init {
            eventImage = view.findViewById(R.id.cell_picture)
            eventTitle = view.findViewById(R.id.cell_title)
            eventCity = view.findViewById(R.id.cell_city)
            eventDate = view.findViewById(R.id.cell_date)
            eventHost = view.findViewById(R.id.cell_host)
            readMore = view.findViewById(R.id.cell_readmore)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_cell, parent, false)

        return DataViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val content = dataSet[position]

    }


    override fun getItemCount(): Int {
        return dataSet.size
    }

}
