package com.example.testingapp.appointment.appointmentdetails

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.testingapp.R
import com.example.testingapp.review.ReviewActivity
import com.example.testingapp.room.VideoCallActivity

class AppointmentDetailsActivity : AppCompatActivity() {
    private lateinit var text: TextView
    private lateinit var button : Button
    private lateinit var voiceCallLogo: ImageView
    private lateinit var videoCallLogo: ImageView
    private lateinit var messageCallLogo: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment_details)
        text = findViewById(R.id.doctor_name)
        button = findViewById(R.id.book_appointment)
        voiceCallLogo = findViewById(R.id.phoneLogo)
        videoCallLogo = findViewById(R.id.videoLogo)
        messageCallLogo = findViewById(R.id.messageLogo)
        text.text = intent.getStringExtra("DOCTOR_NAME")
        //either send a request to get data from DB or data passed from prev activity
        //after getting Data - test on Type
        when("1"/*intent.getStringExtra("TYPE")*/){
            "0" -> voiceCallLogo.setImageResource(R.drawable.ic_call_white)
            "1" -> messageCallLogo.setImageResource(R.drawable.ic_message_white)
            "2" -> {
                voiceCallLogo.setImageResource(R.drawable.ic_call_white)
                messageCallLogo.setImageResource(R.drawable.ic_message_white)
                videoCallLogo.setImageResource(R.drawable.ic_videocam_white)
            }
        }

        button.setOnClickListener {
            //test about type of consult
            //if(type == "")
            Intent(this, VideoCallActivity::class.java).apply {
                // this.putExtra("DOCTOR_NAME",text.text.toString())
                startActivity(this)
            }
        }
    }
}