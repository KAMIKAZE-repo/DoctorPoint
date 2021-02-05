package com.example.testingapp.appointment.bookappointment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.testingapp.HomeActivity
import com.example.testingapp.R
import com.example.testingapp.appointment.bookappointment.appointmentconfigurations.AppointmentConfiguration
import com.example.testingapp.appointment.bookappointment.patientdetails.PatientDetailsFragment
import com.example.testingapp.appointment.bookappointment.payment.PaymentFragment

class BookAppointmentActivity : AppCompatActivity(){
    private lateinit var viewPager: ViewPager2
    private lateinit var frags: ArrayList<Fragment>
    private lateinit var nextButton: Button
    private lateinit var popUpWindow: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment_fragment_holer)
        viewPager = findViewById(R.id.viewPager)
        popUpWindow = findViewById(R.id.complete_window)
        nextButton = findViewById(R.id.next)
        viewPager.isUserInputEnabled = false
        frags = arrayListOf<Fragment>(AppointmentConfiguration(), PatientDetailsFragment(), PaymentFragment())
        val adapter = ViewPager(frags, supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        nextButton.setOnClickListener {
            if(viewPager.currentItem + 1 < frags.lastIndex){
                nextButton.text = "Continue"
                viewPager.currentItem ++
            }else if(viewPager.currentItem + 1 == frags.lastIndex){
                nextButton.text = "Payment now"
                viewPager.currentItem ++
            }else{
                popUpWindow.visibility = View.VISIBLE
            }
        }
    }
    //TODO("set the communication with fragments")

    override fun onBackPressed() {
        if(popUpWindow.visibility == View.VISIBLE){//that's mean we are at the last frag
            popUpWindow.visibility = View.INVISIBLE//To be discussed
        }else if(viewPager.currentItem != 0) {
             viewPager.currentItem --
             nextButton.text = "Continue"
        }else{
            super.onBackPressed()
        }
    }

    fun onclick1(view: View){
        //TODO("send request to add appointment in DB")
        startActivity(Intent(this, HomeActivity::class.java))
    }
}