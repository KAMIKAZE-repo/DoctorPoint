package com.example.testingapp.homefragments.homeviewadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R

class Recycler2ViewAdapter(private val titles: ArrayList<String>,
                           private val descriptions: ArrayList<String>,
                           private val prices: ArrayList<Int>)
    : RecyclerView.Adapter<Recycler2ViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var title : TextView = view.findViewById(R.id.title)
        var description :TextView = view.findViewById(R.id.description)
        var price :TextView = view.findViewById(R.id.price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.pub_cards, parent, false).let {
            return ViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = titles[position]
        holder.description.text = descriptions[position]
        holder.price.text = prices[position].toString() + " $"
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}