package com.example.eventr

import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class EventAdapter(var dataSet: List<Event>, val callback: (Event) -> Unit): RecyclerView.Adapter<EventAdapter.DataViewHolder>() {

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

        var cityText = ""
        for (location in content.location) {
            cityText += "${location.city[0]}"
        }

        var hostText = ""
        for (host in content.hosts) {
            hostText += "${host.name}"
        }

        var speakerText = ""
        /*for (speaker in content.speakers) {
            speakerText += "${speaker.name}\n"
        }*/

        Glide.with(holder.itemView).load(content.picture.asset.url).into(holder.eventImage)
        holder.eventTitle.text = content.title
        holder.eventCity.text = "Sted: $cityText"
        holder.eventDate.text = "Dato: ${content.startDateAndTime}"
        holder.eventHost.text = "Arrangør: $hostText"
        holder.readMore.setOnClickListener {
            callback(content)
        }

    }


    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun updateData(list: List<Event>) {
        dataSet = list
        notifyDataSetChanged()
    }
}
