package com.example.testingapp.notificationsfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R

class NotificationsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //data section begin
        val dates = arrayListOf("Monday - 9 June 2020", "Monday - 9 June 2020", "Monday - 9 June 2020")
        val images = arrayListOf(
            android.R.drawable.ic_popup_reminder,
            android.R.drawable.ic_popup_reminder,
            android.R.drawable.ic_popup_reminder,
            android.R.drawable.ic_popup_reminder
        )
        val titles = arrayListOf(
            "Appointment Alarm",
            "Appointment Alarm",
            "Appointment Alarm",
            "Appointment Alarm"
        )
        val descriptions = arrayListOf(
            "your appointement will be start after 15 minutes. Stay with app and take care",
            "your appointement will be start after 15 minutes. Stay with app and take care",
            "your appointement will be start after 15 minutes. Stay with app and take care",
            "your appointement will be start after 15 minutes. Stay with app and take care"
        )
        //data section ended
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_notifications, container, false)
        recyclerView = view.findViewById(R.id.notifications_viewer)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        val adapter = MainRecyclerAdapter(dates, images, titles, descriptions) as RecyclerView.Adapter<*>
        recyclerView.adapter = adapter
        return view
    }
}