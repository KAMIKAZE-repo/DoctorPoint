package com.example.testingapp.searchfragment.doctorlist

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R

class CategoriesRecyclerAdapter(private val categories: ArrayList<String>) : RecyclerView.Adapter<CategoriesRecyclerAdapter.ViewHolder>() {

    private var selectedPosition = 0

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        var categorize : TextView = view.findViewById(R.id.categorie)
        var layout: ConstraintLayout = view.findViewById(R.id.categorie_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.categorie_card, parent, false).let{
            return ViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.categorize.text = categories[position]
        if(selectedPosition == position)
        {
            holder.layout.setBackgroundColor(holder.itemView.resources.getColor(R.color.PrimaryColor))
            holder.categorize.setTextColor(Color.WHITE)
        }
        else
        {
            holder.layout.setBackgroundColor(Color.WHITE)
            holder.categorize.setTextColor(holder.itemView.resources.getColor(R.color.PrimaryText))
        }

        holder.itemView.setOnClickListener {
            if (selectedPosition >= 0)
                notifyItemChanged(selectedPosition);
            selectedPosition = holder.adapterPosition;
            notifyItemChanged(selectedPosition);
        }

    }

    override fun getItemCount(): Int = categories.size
}