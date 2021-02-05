package com.example.testingapp.appointment.appointmentdetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.testingapp.R
import com.example.testingapp.review.ReviewActivity

class AppointmentDetailsActivity : AppCompatActivity() {
    private lateinit var text: TextView
    private lateinit var button : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment_details)
        text = findViewById(R.id.doctor_name)
        button = findViewById(R.id.book_appointment)
        text.text = intent.getStringExtra("DOCTOR_NAME")
        //either send a request to get data from DB or data passed from prev activity
        button.setOnClickListener {
            Intent(this, ReviewActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}