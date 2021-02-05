package com.example.testingapp.notificationsfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R

class MainRecyclerAdapter(
    private val date: ArrayList<String>,
    private val images: ArrayList<Int>,
    private val titles: ArrayList<String>,
    private val descriptions: ArrayList<String>
): RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> (){

    class ViewHolder(view: View, images: ArrayList<Int>, titles: ArrayList<String>, descriptions: ArrayList<String>): RecyclerView.ViewHolder(view){
        var date: TextView = view.findViewById(R.id.date)
        var recyclerView: RecyclerView =view.findViewById(R.id.notification_list)
        init {
            recyclerView.layoutManager = LinearLayoutManager(view.context)
            val adapter = SubRecyclerAdapter(images, titles, descriptions) as RecyclerView.Adapter<*>
            recyclerView.adapter = adapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.main_notifications_viewer, parent, false).let{
            return ViewHolder(it, images, titles, descriptions)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date.text = date[position]
    }

    override fun getItemCount(): Int {
        return date.size
    }

}