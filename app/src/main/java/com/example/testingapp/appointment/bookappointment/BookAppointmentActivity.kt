package com.example.testingapp.appointment.bookappointment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.testingapp.HomeActivity
import com.example.testingapp.R
import com.example.testingapp.appointment.bookappointment.appointmentconfigurations.AppointmentConfiguration
import com.example.testingapp.appointment.bookappointment.patientdetails.PatientDetailsFragment
import com.example.testingapp.appointment.bookappointment.payment.PaymentFragment
import kotlinx.android.synthetic.main.appointment_card.*
import java.lang.reflect.Method
import java.nio.charset.Charset

class BookAppointmentActivity : AppCompatActivity(), AppointmentConfiguration.FragmentListener{
    private lateinit var viewPager: ViewPager2
    private lateinit var frags: ArrayList<Fragment>
    private lateinit var nextButton: Button
    private lateinit var popUpWindow: ConstraintLayout
    private lateinit var consultTypeImage: ImageView
    private lateinit var completedMsg: TextView
    private var doctorName = ""
    private var consultDate = ""
    private var consultTime = ""
    private var consultType = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment_fragment_holer)
        viewPager = findViewById(R.id.viewPager)
        popUpWindow = findViewById(R.id.complete_window)
        nextButton = findViewById(R.id.next)
        consultTypeImage = findViewById(R.id.conuslt_type)
        completedMsg = findViewById(R.id.completed_msg)
        viewPager.isUserInputEnabled = false
        frags = arrayListOf(AppointmentConfiguration(), PatientDetailsFragment(), PaymentFragment())
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
                //partie graphique
                consultTypeImage.setImageResource(
                    when(consultType){
                        "0" -> R.drawable.ic_phone_colored
                        "1" -> R.drawable.ic_message
                        "2" -> R.drawable.ic_videocam
                        else -> R.drawable.img_placeholder1//or error image
                    }
                )
                completedMsg.text = getString(R.string.complete_message, doctorName, when(consultType){
                    "0" -> "Voice call"
                    "1" -> "Message"
                    "2" -> "Video call"
                    else -> "Contact"
                })
                //partie graphique ends here
                popUpWindow.visibility = View.VISIBLE
            }
        }

        doctorName = intent.getStringExtra("DOCTOR_NAME").toString()
        consultDate = intent.getStringExtra("DATE").toString()

    }

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
        //sending request
        postVolley()
        //ends here
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun onTimeClicked(time: String) {
        Log.i("TAG", "time position: $time")
        consultTime = time
    }

    override fun onTypeClicked(type: Int) {
        Log.i("TAG", "type: $type")//register consult type
        consultType = type.toString()
    }

    fun postVolley() {
        val queue = Volley.newRequestQueue(this)
        val url = "http://localhost:3000/api/PostTest"

        val requestBody = "doctorName=$doctorName&date=$consultDate%$consultTime&type=$consultType"
        val stringReq : StringRequest =
            object : StringRequest(
                Method.POST, url,
                Response.Listener { response ->
                    // response
                    var strResp = response.toString()
                    Log.d("TAG", strResp)
                },
                Response.ErrorListener { error ->
                    Log.d("TAG", "error => $error")
                }
            ){
                override fun getBody(): ByteArray {
                    return requestBody.toByteArray(Charset.defaultCharset())
                }
            }
        queue.add(stringReq)
    }
}