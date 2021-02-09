package com.example.testingapp.authentification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.testingapp.HomeActivity
import com.example.testingapp.R
import org.json.JSONException
import org.json.JSONObject

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var text: TextView
    private lateinit var createAccountButton: Button

    private lateinit var username: EditText
    private lateinit var fullName: EditText
    private lateinit var country: EditText
    private lateinit var password: EditText
    private lateinit var dob: EditText
    private lateinit var matriculation: EditText
    private lateinit var specialty: EditText
    private lateinit var rib: EditText

    private lateinit var patientButton: TextView
    private lateinit var doctorButton: TextView
    private lateinit var matTextView: TextView
    private lateinit var specTextView: TextView
    private lateinit var ribTextView: TextView

    private lateinit var matImg: ImageView
    private lateinit var specImg: ImageView
    private lateinit var ribImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        createAccountButton = findViewById(R.id.create_account_button)
        initEditText()
        initTextView()
        initImgs()
        setVisibility(View.GONE)//Init
        patientButton.setOnClickListener {
            if (!patientButton.isSelected) {
                changeTextColor(patientButton, doctorButton)
                setVisibility(View.GONE)

            }
        }

        doctorButton.setOnClickListener {
            if (!doctorButton.isSelected) {
                changeTextColor(doctorButton, patientButton)
                setVisibility(View.VISIBLE)
            }
        }

        text.setOnClickListener {
            Intent(this, SignInActivity::class.java).apply {
                startActivity(this)
            }
        }

        createAccountButton.setOnClickListener {
            createAccount()
        }
    }

    private fun initEditText() {
        username = findViewById(R.id.username_field)
        fullName = findViewById(R.id.name_field)
        country = findViewById(R.id.country_field)
        password = findViewById(R.id.password_field)
        dob = findViewById(R.id.birthday_field)
        matriculation = findViewById(R.id.matriculation_field)
        specialty = findViewById(R.id.speciality_field)
        rib = findViewById(R.id.rib_field)
    }

    private fun initTextView() {
        text = findViewById(R.id.sign_in_button)
        patientButton = findViewById(R.id.patient_text_view)
        doctorButton = findViewById(R.id.doctor_text_view)
        matTextView = findViewById(R.id.mat_text_view)
        specTextView = findViewById(R.id.spec_text_view)
        ribTextView = findViewById(R.id.rib_text_view)
        patientButton.isSelected = true
        doctorButton.isSelected = false
    }

    private fun initImgs() {
        matImg = findViewById(R.id.mat_img)
        specImg = findViewById(R.id.spec_img)
        ribImg = findViewById(R.id.rib_img)
    }

    private fun changeTextColor(text1: TextView, text2: TextView) {//text1 will be selected
        text1.isSelected = true
        text2.isSelected = false
        text1.setTextColor(resources.getColor(R.color.PrimaryColor))
        text2.setTextColor(resources.getColor(R.color.SecondaryText))
        text1.setBackgroundResource(R.drawable.text_bottom_border)
        text2.setBackgroundResource(0)
    }

    private fun setVisibility(visibility: Int) {
        matImg.visibility = visibility
        specImg.visibility = visibility
        ribImg.visibility = visibility
        matTextView.visibility = visibility
        specTextView.visibility = visibility
        ribTextView.visibility = visibility
        rib.visibility = visibility
        matriculation.visibility = visibility
        specialty.visibility = visibility
    }

    private fun createAccount() {
        val requestQueue = Volley.newRequestQueue(this)
        val jsonObject = JSONObject()
        try {
            //input your API parameters
            jsonObject.put(if(doctorButton.isSelected) "doctor_username" else "patient_username", username.text.toString())
            jsonObject.put(if(doctorButton.isSelected) "doctor_username" else "patient_password", password.text.toString())
            jsonObject.put("name", fullName.text.toString())
            jsonObject.put("lastName", fullName.text.toString())
            jsonObject.put("country", country.text.toString())
            jsonObject.put("dob", dob.text.toString())
            if (patientButton.isSelected)
                jsonObject.put("cin", 14003177)
            if (doctorButton.isSelected) {
                jsonObject.put("matriculation", matriculation.text.toString().toInt())
                jsonObject.put("specialty", specialty.text.toString())
                jsonObject.put("RIB", rib.text.toString().toInt())
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        // Enter the correct url for your api service site
        val url =
            if (doctorButton.isSelected)
                "http://192.168.1.101/TeleConsulting/public/api/doctor"
            else
                "http://192.168.1.101/TeleConsulting/public/api/patient"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonObject,
            { response ->
                Log.i("TAG", "String Response : $response")
                Log.i("TAG", "In This case i'll go to homeActivity")
                Intent(this, HomeActivity::class.java).apply {
                    startActivity(this)
                }
            }
        ) {
            Log.i("TAG", "Error getting response")
            Toast.makeText(this, "something goes wrong!", Toast.LENGTH_SHORT).show()
        }
        requestQueue.add(jsonObjectRequest)
    }

}