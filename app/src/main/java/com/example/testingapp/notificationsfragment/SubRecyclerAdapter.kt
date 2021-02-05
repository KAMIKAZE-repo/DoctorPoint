package com.example.testingapp.notificationsfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R

class SubRecyclerAdapter(
    private val images: ArrayList<Int>,
    private val titles: ArrayList<String>,
    private val descriptions: ArrayList<String>
) : RecyclerView.Adapter<SubRecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        var image : ImageView = view.findViewById(R.id.not_icon)
        var title : TextView = view.findViewById(R.id.not_title)
        var description : TextView = view.findViewById(R.id.not_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.notification_detail, parent, false).let {
            return ViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(images[position])
        holder.title.text = titles[position]
        holder.description.text = descriptions[position]
    }

    override fun getItemCount(): Int {
        return images.size
    }
}