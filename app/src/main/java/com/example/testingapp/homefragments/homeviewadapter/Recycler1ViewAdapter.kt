package com.example.testingapp.homefragments.homeviewadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R

class Recycler1ViewAdapter(private val images: ArrayList<Int>,
                           private val titles: ArrayList<String>,
                           private val nbr: ArrayList<Int>,
                           private val backgrounds: ArrayList<Int>)
    : RecyclerView.Adapter<Recycler1ViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var image : ImageView = view.findViewById(R.id.specialist_icon)
        var title : TextView = view.findViewById(R.id.specialist_title)
        var nbrDoctors :TextView = view.findViewById(R.id.nbr_docotr)
        var layout: ConstraintLayout = view.findViewById(R.id.container)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.specialist_card, parent, false).let {
            return ViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(images[position])
        holder.title.text = titles[position]
        holder.nbrDoctors.text = nbr[position].toString() + " Doctors"
        holder.layout.setBackgroundColor(backgrounds[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}