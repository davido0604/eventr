package com.example.eventr

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class EventPageFragment : Fragment() {

    private val viewModel: SearchMainViewModel by activityViewModels()

    lateinit var scrollView: ScrollView

    lateinit var eventImage: ImageView
    lateinit var eventTitle: TextView
    lateinit var eventCity: TextView
    lateinit var eventDate: TextView
    lateinit var eventAddress: TextView
    lateinit var eventPrice: TextView
    lateinit var eventHost: TextView
    lateinit var eventSpeaker: TextView
    lateinit var eventDescription: TextView
    lateinit var eventSignUpBtn: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event_page, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scrollView = view.findViewById(R.id.event_page_scrollView)

        eventImage = view.findViewById(R.id.event_image)
        eventTitle = view.findViewById(R.id.event_title)
        eventCity = view.findViewById(R.id.event_page_city)
        eventDate = view.findViewById(R.id.event_page_date)
        eventAddress = view.findViewById(R.id.event_page_address)
        eventPrice = view.findViewById(R.id.event_page_price)
        eventHost = view.findViewById(R.id.event_page_host)
        eventSpeaker = view.findViewById(R.id.event_page_speaker)
        eventDescription = view.findViewById(R.id.event_page_description)
        eventSignUpBtn = view.findViewById(R.id.sign_up_btn)

        var cityText = ""
        for (location in viewModel.event.location) {
            cityText += "${location.city[0]}"
        }

        var addressText = ""
        for (location in viewModel.event.location) {
            addressText += "${location.address}"
        }

        var hostText = ""
        for (host in viewModel.event.hosts) {
            hostText += "${host.name}"
        }

        Glide
            .with(this)
            .load(viewModel.event.picture.asset.url)
            .into(eventImage)

        eventTitle.text = viewModel.event.title
        eventCity.text = "Sted: $cityText"
        eventDate.text = "Dato: ${viewModel.event.startDateAndTime}"
        eventAddress.text = "Adresse: $addressText"
        eventPrice.text = "Pris: ${viewModel.event.price.toString()}kr"
        eventHost.text = "Arrangør: $hostText"
        eventSpeaker.text = "Tallere: må fikses"
        eventDescription.text = "Beskrivelse: ${viewModel.event.description}"
        eventSignUpBtn.setOnClickListener {
            
        }



    }


}