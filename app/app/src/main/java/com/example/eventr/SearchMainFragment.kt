package com.example.eventr

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.beust.klaxon.Klaxon

class SearchMainFragment : Fragment() {

    var eventList = listOf<Event>()
    lateinit var adapter: EventAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var queue: RequestQueue
    private val viewModel: SearchMainViewModel by activityViewModels()
    lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchView = view.findViewById(R.id.search_view)
        layoutManager = LinearLayoutManager(activity)
        recyclerView = view.findViewById(R.id.recyclerView)
        queue = Volley.newRequestQueue(activity)
        getEventInfo()

        adapter = EventAdapter(eventList) { event ->

            viewModel.event = event

            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<EventPageFragment>(R.id.nav_host_fragment)
                addToBackStack(null)
            }

        }

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter



        (activity as MainActivity).hideNavBar()
    }

    private fun getEventInfo() {
        val queue = Volley.newRequestQueue(activity)
        val url = "https://ul4zoh2n.api.sanity.io/v2021-10-21/data/query/production?query=*%5B_type%20%3D%3D%20%27event%27%5D%20%7C%20order(startDateAndTime%20asc)%7B%0A%20%20_id%2C%0A%20%20hosts%5B%5D-%3E%7B%0A%20%20%20%20email%2C%0A%20%20%20%20name%0A%20%20%7D%2C%0A%20%20speakers%5B%5D-%3E%7B%0A%20%20%20%20name%2C%0A%20%20%20%20organization%0A%20%20%7D%2C%0A%20%20%20%20startDateAndTime%2C%0A%20%20%20%20endDateAndTime%2C%0A%20%20%20%20_createdAt%2C%0A%20%20%20%20title%2C%0A%20%20%20%20description%2C%0A%20%20%20%20picture%7B%0A%20%20%20%20%20%20asset-%3E%20%7B%0A%20%20%20%20%20%20%20url%0A%20%20%20%20%20%20%7D%0A%20%20%20%20%7D%2C%0A%20%20%20%20price%2C%0A%20%20%20%20location%5B%5D-%3E%7B%0A%20%20%20%20venue%2C%0A%20%20%20%20address%2C%0A%20%20%20%20city%0A%20%20%20%7D%2C%0A%7D"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { json ->
                var event = Klaxon().parse<Events>(json)
                eventList = event?.result ?: listOf()
                adapter.updateData(eventList)


            }, {
            })

        queue.add(stringRequest)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as MainActivity).showNavBar()
    }
}