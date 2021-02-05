package com.example.testingapp.appointment.appointmentlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R

class MainRecyclerAdapter(
    private val dates: ArrayList<String>,
    private val images: ArrayList<Int>,
    private val names : ArrayList<String>,
    private val states : ArrayList<String>,
    private val types : ArrayList<String>,
    private val times : ArrayList<String>
): RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>(){

    class ViewHolder(
        view: View,
        images: ArrayList<Int>,
        names: ArrayList<String>,
        states: ArrayList<String>,
        types: ArrayList<String>,
        times: ArrayList<String>
    ) : RecyclerView.ViewHolder(view){
        val date: TextView = view.findViewById(R.id.day)
        private val recyclerView: RecyclerView = view.findViewById(R.id.appointment_list)
        init {
            recyclerView.layoutManager = LinearLayoutManager(view.context)
            val adapter = SubAppointmentAdapter(images, names, states, types, times) as RecyclerView.Adapter<*>
            recyclerView.adapter = adapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.sub_appointment_layout, parent, false).let {
            return ViewHolder(it, images, names, states, types, times)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date.text = dates[position]
    }

    override fun getItemCount(): Int {
        return dates.size
    }
}