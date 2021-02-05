package com.example.testingapp.homefragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R
import com.example.testingapp.homefragments.homeviewadapter.Recycler1ViewAdapter
import com.example.testingapp.homefragments.homeviewadapter.Recycler2ViewAdapter
import com.example.testingapp.homefragments.homeviewadapter.Recycler3ViewAdapter
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var recyclerView3: RecyclerView
    private lateinit var myView : View
    private lateinit var userName : TextView

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //data to pass//TODO("move those data to array.xml")
        val images  = arrayListOf(R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img2)
        val titles  = arrayListOf("Cardio Specialist", "Heart\nIssue", "Dental\nCare", "Physical Therapy", "Mental Therapy")
        val nbrDoctors  = arrayListOf(27, 45, 27, 45, 13)
        val backgrounds  = arrayListOf(
            resources.getColor(R.color.PrimaryColor, activity?.theme),
            resources.getColor(R.color.color2, activity?.theme),
            resources.getColor(R.color.color3, activity?.theme),
            resources.getColor(R.color.color4, activity?.theme),
            resources.getColor(R.color.color2, activity?.theme)
        )

        val titles2 = arrayListOf("Cardio Issues?", "Dental Issues?")
        val descriptions = arrayListOf(
            "For cardio patient here can easily contact with doctors. Can chat & live Chat",
            "For dental patient here can easily contact with doctors. Can chat & live Chat"
        )
        val prices = arrayListOf(100, 120)

        val imagesDoctors = arrayListOf(
            R.drawable.img_placeholder1,
            R.drawable.img_placeholder1,
            R.drawable.img_placeholder1,
            R.drawable.img_placeholder1,
            R.drawable.img_placeholder1
        )
        val names = arrayListOf("Mahmoud N", "Daniela M", "Boussami N", "Nassim B", "Mahmoud N")
        val specialists = arrayListOf("Heart Sergon", "Cardio Sergon", "Dental Sergon", "Cardio Sergon", "Heart Sergon")

        //data section ends here
        // Inflate the layout for this fragment
        myView =  inflater.inflate(R.layout.fragment_home, container, false)
        userName  =myView.findViewById(R.id.user_name)
        userName.text = arguments?.getString("USER_NAME")?:"User Name 2"//just for now
        val adapter = Recycler1ViewAdapter(images, titles, nbrDoctors, backgrounds) as RecyclerView.Adapter<*>
        recyclerView = initRecyclerView(R.id.recyclerView, adapter)

        val adapter2 = Recycler2ViewAdapter(titles2, descriptions, prices) as RecyclerView.Adapter<*>
        recyclerView2 = initRecyclerView(R.id.recyclerView2, adapter2)

        val adapter3 = Recycler3ViewAdapter(imagesDoctors, names, specialists) as RecyclerView.Adapter<*>
        recyclerView3 = initRecyclerView(R.id.recyclerView3, adapter3)

        return myView
    }
    private fun initRecyclerView(id: Int, adapter : RecyclerView.Adapter<*>): RecyclerView {
        val recyclerView = myView.findViewById<RecyclerView>(id)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
        return recyclerView
    }
}