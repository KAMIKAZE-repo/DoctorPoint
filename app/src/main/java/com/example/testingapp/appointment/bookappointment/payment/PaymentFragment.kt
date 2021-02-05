package com.example.testingapp.appointment.bookappointment.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.testingapp.R

class PaymentFragment : Fragment() {
    private lateinit var name: EditText
    private lateinit var number: EditText
    private lateinit var date: EditText
    private lateinit var cvv: EditText

    private lateinit var cardNumber: TextView
    private lateinit var cardDate: TextView
    private lateinit var cardCVV: TextView

    private lateinit var myView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        myView =  inflater.inflate(R.layout.fragment_payment, container, false)
        initViews()
        number.doOnTextChanged { text, _, _, _ ->
            cardNumber.text = text
        }
        date.doOnTextChanged{ text, _, _, _ ->
            cardDate.text = text
        }
        cvv.doOnTextChanged { text, _, _, _ ->
            cardCVV.text = text
        }
        return myView
    }

    private fun initViews(){
        name = myView.findViewById(R.id.full_name)
        number = myView.findViewById(R.id.card_number)
        date = myView.findViewById(R.id.date)
        cvv = myView.findViewById(R.id.cvv_number)
        cardNumber = myView.findViewById(R.id.card_number_viewer)
        cardDate = myView.findViewById(R.id.card_date_viewer)
        cardCVV = myView.findViewById(R.id.card_cvv_viewer)
    }
}