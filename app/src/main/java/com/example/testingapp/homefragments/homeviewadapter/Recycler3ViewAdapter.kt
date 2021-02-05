package com.example.testingapp.homefragments.homeviewadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R

class Recycler3ViewAdapter(private val images: ArrayList<Int>,
                           private val names: ArrayList<String>,
                           private val specialists: ArrayList<String>)
    : RecyclerView.Adapter<Recycler3ViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var image : ImageView = view.findViewById(R.id.image)
        var name : TextView = view.findViewById(R.id.name)
        var specialist : TextView = view.findViewById(R.id.specialist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.doctor_card, parent, false).let {
            return ViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(images[position])
        holder.name.text = "Dr. " + names[position]
        holder.specialist.text = specialists[position]
    }

    override fun getItemCount(): Int {
        return images.size
    }
}