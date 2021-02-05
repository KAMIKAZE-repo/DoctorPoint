package com.example.testingapp.searchfragment.doctorlist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R
import com.example.testingapp.searchfragment.doctordetails.DoctorDetailsActivity

class SearchRecyclerAdapter(
        private val images:ArrayList<Int>,
        private val names: ArrayList<String>,
        private val ratings: ArrayList<Pair<Float, Int>>,
        private val specs: ArrayList<String>,
        private val degrees: ArrayList<String>,
        private val places: ArrayList<String>
    ): RecyclerView.Adapter<SearchRecyclerAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image : ImageView = view.findViewById(R.id.doctorImage)
        val name : TextView = view.findViewById(R.id.doctorName)
        val rating : TextView = view.findViewById(R.id.state)
        val specialist : TextView = view.findViewById(R.id.doctorSpec)
        val degree : TextView = view.findViewById(R.id.time)
        val jobPlace : TextView = view.findViewById(R.id.type)
        init {
            val context = view.context
            view.setOnClickListener {
                Intent(context, DoctorDetailsActivity::class.java).let {
                    context.startActivity(it)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.doctor_details_card, parent, false).let{
            return ViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(images[position])
        holder.name.text = names[position]
        holder.rating.text = "${ratings[position].first}( ${ratings[position].first} Reviews"
        holder.specialist.text = specs[position]
        holder.degree.text = " - ${degrees[position]}"
        holder.jobPlace.text = places[position]
    }

    override fun getItemCount(): Int {
        return images.size
    }
}