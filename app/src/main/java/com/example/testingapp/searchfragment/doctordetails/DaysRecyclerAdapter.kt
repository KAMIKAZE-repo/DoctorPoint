package com.example.testingapp.searchfragment.doctordetails

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R

class DaysRecyclerAdapter(
    private val data: ArrayList<Pair<String, Int>>// data format [Pair("MON" to 10), Pair("Tue" to 11), ...], size == nbr of days
) : RecyclerView.Adapter<DaysRecyclerAdapter.ViewHolder>() {
    var selectedPosition = 0

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var day : TextView = view.findViewById(R.id.day)
        var nbr : TextView = view.findViewById(R.id.nbr)
        var layout: ConstraintLayout = view.findViewById(R.id.day_card_layout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.day_card, parent, false).let {
            return ViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.day.text = data[position].first
        holder.nbr.text = data[position].second.toString()
        if(selectedPosition == position)
        {
            holder.layout.setBackgroundColor(holder.itemView.resources.getColor(R.color.PrimaryColor))
            holder.day.setTextColor(Color.WHITE)
            holder.nbr.setTextColor(Color.WHITE)
        }
        else
        {
            holder.layout.setBackgroundColor(Color.WHITE)
            holder.day.setTextColor(holder.itemView.resources.getColor(R.color.PrimaryText))
            holder.nbr.setTextColor(holder.itemView.resources.getColor(R.color.PrimaryText))
        }

        holder.itemView.setOnClickListener {
            if (selectedPosition >= 0)
                notifyItemChanged(selectedPosition);
            selectedPosition = holder.adapterPosition;
            notifyItemChanged(selectedPosition);
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }
}