package com.example.testingapp.appointment.bookappointment.appointmentconfigurations

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R
import com.example.testingapp.appointment.bookappointment.BookAppointmentActivity
import com.example.testingapp.onboarding.OnBoardingScreenReusable

class AppointmentConfiguration : Fragment() {
    private lateinit var morningButton: ConstraintLayout
    private lateinit var eveningButton: ConstraintLayout

    private lateinit var callChoice: ConstraintLayout
    private lateinit var messagingChoice: ConstraintLayout
    private lateinit var vidCallChoice: ConstraintLayout

    private lateinit var timeGrid: RecyclerView
    private lateinit var adapter1 : RecyclerView.Adapter<*>
    private lateinit var adapter2 : RecyclerView.Adapter<*>

    private lateinit var callTitle: TextView
    private lateinit var callDescription: TextView
    private lateinit var messageTitle: TextView
    private lateinit var messageDescription: TextView
    private lateinit var vidTitle: TextView
    private lateinit var vidDescription: TextView
    private lateinit var vidPrice: TextView
    private lateinit var messagePrice: TextView
    private lateinit var callPrice: TextView

    private lateinit var myView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
         myView = inflater.inflate(R.layout.fragment_testing, container, false)
        val data1 = arrayListOf("09:00 AM", "09:30 AM", "10:30 AM", "11:15 AM", "09:00 AM", "09:30 AM", "10:30 AM", "11:15 AM")
        val data2 = arrayListOf("02:00 PM", "03:00 PM", "03:30 PM", "04:30 PM", "02:00 PM", "03:00 PM", "03:30 PM", "04:30 PM")

        initComponents()
        timeGrid = myView.findViewById(R.id.time_list_viewer)
        timeGrid.layoutManager = GridLayoutManager(myView.context, 4, GridLayoutManager.VERTICAL, false)
        adapter1 = WorkingTimeRecyclerAdapter(data1)
        adapter2 = WorkingTimeRecyclerAdapter(data2)
        timeGrid.adapter = adapter1//init
        buttonClick()
        return myView
    }


    private fun initComponents() {
        morningButton = myView.findViewById(R.id.morning_button)
        eveningButton = myView.findViewById(R.id.evening_button)

        callChoice = myView.findViewById(R.id.call_button)
        messagingChoice = myView.findViewById(R.id.messaging_button)
        vidCallChoice = myView.findViewById(R.id.vid_call_button)

        callChoice.isSelected = true
        messagingChoice.isSelected = false
        vidCallChoice.isSelected = false

        morningButton.isSelected = true
        eveningButton.isSelected = false

        callTitle = myView.findViewById(R.id.voice_call_title)
        callDescription = myView.findViewById(R.id.voice_call_description)
        messageTitle = myView.findViewById(R.id.messaging_title)
        messageDescription = myView.findViewById(R.id.messaging_description)
        vidTitle = myView.findViewById(R.id.video_call_title)
        vidDescription = myView.findViewById(R.id.video_call_description)

        callPrice = myView.findViewById(R.id.call_price)
        messagePrice = myView.findViewById(R.id.message_price)
        vidPrice = myView.findViewById(R.id.vid_price)
    }

    private fun buttonClick(){
        timePeriodSelect(morningButton, adapter1)
        timePeriodSelect(eveningButton, adapter2)
        choiceSelect(callChoice, b1 = true, b2 = false, b3 = false)
        choiceSelect(messagingChoice,b1 = false,b2 = true, b3 = false)
        choiceSelect(vidCallChoice, b1  = false,b2 = false,b3 = true)
    }
    private fun choiceSelect(button: View, b1: Boolean, b2: Boolean, b3: Boolean){
        button.setOnClickListener {
            callChoice.isSelected = b1
            messagingChoice.isSelected = b2
            vidCallChoice.isSelected = b3
            if (b1) {
                changeTextsColors(
                    callTitle, callDescription, callPrice,
                    messageTitle, messageDescription, messagePrice,
                    vidTitle, vidDescription, vidPrice
                )
            } else if (b2) {
                changeTextsColors(
                    messageTitle, messageDescription, messagePrice,
                    callTitle, callDescription, callPrice,
                    vidTitle, vidDescription, vidPrice
                )
            } else if (b3) {
                changeTextsColors(
                    vidTitle, vidDescription, vidPrice,
                    messageTitle, messageDescription, messagePrice,
                    callTitle, callDescription, callPrice
                )
            }
        }
    }
    private fun timePeriodSelect(button: View, adapter: RecyclerView.Adapter<*>){
        button.setOnClickListener {
            morningButton.isSelected = !morningButton.isSelected
            eveningButton.isSelected = !eveningButton.isSelected
            timeGrid.adapter = adapter
        }
    }
    private fun changeTextColor(title: TextView, description: TextView,price: TextView, color: Int, color2: Int){
        title.setTextColor(color)
        description.setTextColor(color)
        price.setTextColor(color2)
    }
    private fun changeTextsColors(text1Title: TextView,text1Description: TextView,price1: TextView,
                                  text2Title: TextView,text2Description: TextView,price2: TextView,
                                  text3Title: TextView,text3Description: TextView,price3: TextView
    ){//text1 will be set to white
        changeTextColor(text1Title, text1Description, price1, Color.WHITE, Color.WHITE)
        changeTextColor(text2Title, text2Description, price2, resources.getColor(R.color.PrimaryText), resources.getColor(R.color.PrimaryColor))
        changeTextColor(text3Title, text3Description, price3, resources.getColor(R.color.PrimaryText), resources.getColor(R.color.PrimaryColor))
    }
}