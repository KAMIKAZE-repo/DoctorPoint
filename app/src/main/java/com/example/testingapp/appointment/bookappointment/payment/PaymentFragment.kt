package com.example.testingapp.appointment.bookappointment.payment

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.testingapp.R
import java.util.*

class PaymentFragment : Fragment() {
    private lateinit var name: EditText
    private lateinit var number: EditText
    private lateinit var date: EditText
    private lateinit var cvv: EditText

    private lateinit var cardNumber: TextView
    private lateinit var cardDate: TextView
    private lateinit var cardCVV: TextView

    private lateinit var myView: View

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        myView = inflater.inflate(R.layout.fragment_payment, container, false)
        initViews()
        number.doOnTextChanged { text, _, _, _ ->
            cardNumber.text = text
        }
        cvv.doOnTextChanged { text, _, _, _ ->
            cardCVV.text = text
        }

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        date.setOnClickListener {
            val dpd = DatePickerDialog(myView.context, { _, year, monthOfYear, dayOfMonth ->
                var fixedMonth = if (monthOfYear < 10) "0${monthOfYear+1}" else "${monthOfYear+1}"
                date.setText("$dayOfMonth-$fixedMonth-$year")
                cardDate.text = "$dayOfMonth-$fixedMonth-$year"
            }, year, month, day)
            dpd.show()
        }
        return myView
    }

    private fun initViews() {
        name = myView.findViewById(R.id.full_name)
        number = myView.findViewById(R.id.card_number)
        date = myView.findViewById(R.id.date)
        cvv = myView.findViewById(R.id.cvv_number)
        cardNumber = myView.findViewById(R.id.card_number_viewer)
        cardDate = myView.findViewById(R.id.card_date_viewer)
        cardCVV = myView.findViewById(R.id.card_cvv_viewer)
    }
}