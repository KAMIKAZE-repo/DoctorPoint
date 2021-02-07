package com.example.testingapp.searchfragment.doctordetails

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R
import com.example.testingapp.appointment.bookappointment.BookAppointmentActivity

class DoctorDetailsActivity : AppCompatActivity() {
    private lateinit var monthSelector: Spinner
    private lateinit var daysSelector: RecyclerView
    private lateinit var bookButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_details)
        val months = resources.getStringArray(R.array.months)
        monthSelector = findViewById(R.id.month_list)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, months)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        monthSelector.adapter = adapter

        val data = arrayListOf(//TODO("implement time paring function")
            "MON" to 10,
            "TUE" to 11,
            "WEN" to 12,
            "THE" to 13,
            "FRI" to 14,
            "SAT" to 15
        )
        daysSelector  =findViewById(R.id.days_list)
        daysSelector.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val daysRecyclerAdapter = DaysRecyclerAdapter(data) as RecyclerView.Adapter<*>
        daysSelector.adapter = daysRecyclerAdapter

        bookButton = findViewById(R.id.book_appointment)
        bookButton.setOnClickListener {
            Intent(this, BookAppointmentActivity::class.java).let {
                it.putExtra("DATE", "10/2/2021")//TODO("pass date picked")
                it.putExtra("DOCTOR_NAME", "Dr.Mahmoud Nik")//to be changed
                startActivity(it)
            }
        }
    }
}
