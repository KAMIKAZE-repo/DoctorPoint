package com.example.testingapp.appointment.appointmentlist

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R
import com.example.testingapp.appointment.appointmentdetails.AppointmentDetailsActivity
import com.google.android.material.snackbar.Snackbar

class SubAppointmentAdapter(
    private val images: ArrayList<Int>,
    private val names : ArrayList<String>,
    private val states : ArrayList<String>,
    private val types : ArrayList<String>,
    private val times : ArrayList<String>
): RecyclerView.Adapter<SubAppointmentAdapter.ViewHolder>() {



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private var context: Context = view.context
        var doctorName : TextView = view.findViewById(R.id.doctorName)
        var type : TextView = view.findViewById(R.id.type)
        var state : TextView = view.findViewById(R.id.state)
        var time : TextView = view.findViewById(R.id.time)
        var image : ImageView = view.findViewById(R.id.doctorImage)
        init {//send doctor details to see appointment details
            view.setOnClickListener {
                Intent(context, AppointmentDetailsActivity::class.java).let {
                    it.putExtra("DOCTOR_NAME", doctorName.text.toString())
                    context.startActivity(it)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       LayoutInflater.from(parent.context).inflate(R.layout.appointment_card, parent, false).let {
           return ViewHolder(it)
       }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(images[position])
        holder.doctorName.text = names[position]
        holder.state.text = " - " + states[position]
        holder.state.setTextColor(when(states[position]){
            "Accepted" -> Color.GREEN
            "in Progress" -> Color.BLUE
            "Decline" -> Color.RED
            else -> Color.BLACK
        })
        holder.type.text = types[position]
        holder.time.text = times[position]
    }

    override fun getItemCount(): Int {
        return images.size
    }
}