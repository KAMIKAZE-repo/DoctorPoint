package com.example.testingapp.searchfragment.doctorlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R

class SearchFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        val images = arrayListOf(
            R.drawable.img_placeholder1,
            R.drawable.img_placeholder1,
            R.drawable.img_placeholder1,
            R.drawable.img_placeholder1,
            R.drawable.img_placeholder1,
            R.drawable.img_placeholder1,
            R.drawable.img_placeholder1,
            R.drawable.img_placeholder1
        )
        val names = arrayListOf(
            "Dr. Mahmud Nik Hasan",
            "Dr. Mahmud Nik Hasan",
            "Dr. Mahmud Nik Hasan",
            "Dr. Mahmud Nik Hasan",
            "Dr. Mahmud Nik Hasan",
            "Dr. Mahmud Nik Hasan",
            "Dr. Mahmud Nik Hasan",
            "Dr. Mahmud Nik Hasan"
        )
        val reviews = arrayListOf(
            Pair(4.9f,37),
            Pair(4.9f,37),
            Pair(4.9f,37),
            Pair(4.9f,37),
            Pair(4.9f,37),
            Pair(4.9f,37),
            Pair(4.9f,37),
            Pair(4.9f,37)
        )
        val specialists = arrayListOf(
            "Cardiologist",
            "Cardiologist",
            "Cardiologist",
            "Cardiologist",
            "Cardiologist",
            "Cardiologist",
            "Cardiologist",
            "Cardiologist"
        )
        val degrees = arrayListOf(
            "Dhaka medical college",
            "Dhaka medical college",
            "Dhaka medical college",
            "Dhaka medical college",
            "Dhaka medical college",
            "Dhaka medical college",
            "Dhaka medical college",
            "Dhaka medical college"
        )
        val places = arrayListOf(
            "Hospital",
            "Hospital",
            "Hospital",
            "Hospital",
            "Hospital",
            "Hospital",
            "Hospital",
            "Hospital"
        )
        val categories = arrayListOf("All", "Cardio", "Dentist", "Phsyco therapy")
        val view =  inflater.inflate(R.layout.fragment_search, container, false)

        recyclerView = view.findViewById(R.id.doctorFound)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = SearchRecyclerAdapter(images, names, reviews, specialists, degrees, places) as RecyclerView.Adapter<*>
        recyclerView.adapter = adapter

        recyclerView2 = view.findViewById(R.id.categories)
        recyclerView2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter2 = CategoriesRecyclerAdapter(categories) as RecyclerView.Adapter<*>
        recyclerView2.adapter = adapter2

        return view
    }
}