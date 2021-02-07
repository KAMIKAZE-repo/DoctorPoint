package com.example.testingapp.searchfragment.doctordetails

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapp.R
import com.example.testingapp.appointment.bookappointment.BookAppointmentActivity
import java.util.*

class DoctorDetailsActivity : AppCompatActivity(), DaysRecyclerAdapter.ClickListner{
    private lateinit var monthSelector: Spinner
    private lateinit var daysSelector: RecyclerView
    private lateinit var bookButton: Button
    private val dates = arrayListOf("MON", "TUE", "WEN", "THE", "FRI")
    private lateinit var datePicked : String
    private lateinit var data : ArrayList<Pair<String, Pair<String, Int>>>
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_details)
        val months = resources.getStringArray(R.array.months)
        monthSelector = findViewById(R.id.month_list)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, months)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        monthSelector.adapter = adapter
        data = datesGenerator()
        datePicked = data[0].first
        daysSelector  =findViewById(R.id.days_list)
        daysSelector.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val daysRecyclerAdapter = DaysRecyclerAdapter(data, this) as RecyclerView.Adapter<*>
        daysSelector.adapter = daysRecyclerAdapter
        bookButton = findViewById(R.id.book_appointment)
        bookButton.setOnClickListener {
            Intent(this, BookAppointmentActivity::class.java).let {
                it.putExtra("DATE", datePicked)
                it.putExtra("DOCTOR_NAME", "Dr.Mahmoud Nik")//to be changed
                startActivity(it)
            }
        }
    }


    private fun datesGenerator():ArrayList<Pair<String, Pair<String, Int>>>{
        val result = arrayListOf<Pair<String, Pair<String, Int>>>()
        val dt = Date()
        val c = Calendar.getInstance()
        c.time = dt//date of today
        val today = c.get(Calendar.DAY_OF_WEEK)
        val i = if(today == 1){
            c.add(Calendar.DATE, 1)
            2
        }else{
            today
        }
        for(day in i until 7)
        {
            val dayOFDay = if(c.get(Calendar.DAY_OF_MONTH) < 10) "0${c.get(Calendar.DAY_OF_MONTH)}" else "${c.get(Calendar.DAY_OF_MONTH)}"
            val month = if(c.get(Calendar.MONTH) < 10) "0${c.get(Calendar.MONTH)+1}" else "${c.get(Calendar.MONTH)+1}"
            val year = c.get(Calendar.YEAR)
            result.add(
                "$dayOFDay/$month/$year" to (dates[day-2] to c.get(Calendar.DAY_OF_MONTH))
            )
            c.add(Calendar.DATE, 1)
        }
        Log.i("TAG", result.toString())
        return result
    }

    override fun onItemClicked(pos: Int) {
        datePicked = data[pos].first
        Log.i("TAG", "dataPicked: ${data[pos].first}")
    }
}
