package com.example.testingapp.appointment.bookappointment.appointmentconfigurations

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R


class WorkingTimeRecyclerAdapter(
    private val data: ArrayList<String>,
    private val myClickListener: MyClickListener?
): RecyclerView.Adapter<WorkingTimeRecyclerAdapter.ViewHolder>() {

    private var selectedPosition = 0
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val time : TextView = view.findViewById(R.id.time_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.time_card_view, parent, false).let {
            return ViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.time.text = data[position]
        if (selectedPosition == position){
            holder.itemView.isSelected = true
            holder.time.setTextColor(Color.WHITE)
        }else{
            holder.itemView.isSelected = false
            holder.time.setTextColor(holder.itemView.resources.getColor(R.color.PrimaryText))
        }

        holder.itemView.setOnClickListener {
            if (selectedPosition >= 0)
                notifyItemChanged(selectedPosition);
            selectedPosition = holder.adapterPosition;
            myClickListener!!.onItemClicked(data[selectedPosition])
            notifyItemChanged(selectedPosition);
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface MyClickListener {
        fun onItemClicked(time: String)
    }
}