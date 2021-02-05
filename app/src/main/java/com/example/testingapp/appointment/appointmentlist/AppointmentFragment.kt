package com.example.testingapp.appointment.appointmentlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R

class AppointmentFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //data section begin//data structure will be modified
        val dates = arrayListOf("Today - 25 Dec 2020", "Tomorrow - 26 Dec 2020", "Today - 25 Dec 2020", "Tomorrow - 26 Dec 2020")
        val images = arrayListOf(R.drawable.img_placeholder1, R.drawable.img_placeholder1, R.drawable.img_placeholder1, R.drawable.img_placeholder1)
        val names = arrayListOf("Dr. Boussami Nassim", "Dr. Brycen Bradford", "Dr. Nassim Boussami", "Dr. Hatake Kakashi")
        val times = arrayListOf("09:00 AM - 10:00 AM", "02:00 PM - 03:00 PM", "09:00 AM - 10:00 AM", "02:00 PM - 03:00 PM")
        val states = arrayListOf("Accepted", "Decline", "Accepted", "in Progress")
        val types = arrayListOf("Voice Chat", "Video chat", "Messaging", "Video chat")
        //data section ended
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_appointment, container, false)
        recyclerView = view.findViewById(R.id.main_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = MainRecyclerAdapter(dates, images, names, states, types, times) as RecyclerView.Adapter<*>
        recyclerView.adapter = adapter
        return view
    }
}