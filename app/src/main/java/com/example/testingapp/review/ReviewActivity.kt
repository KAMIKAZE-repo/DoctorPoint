package com.example.testingapp.review

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.testingapp.HomeActivity
import com.example.testingapp.R

class ReviewActivity : AppCompatActivity() {
    private lateinit var submit: Button
    private lateinit var askReviewTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)
        submit = findViewById(R.id.submit_review)
        askReviewTextView = findViewById(R.id.textView2)
        askReviewTextView.text = getString(R.string.ask_review, intent.getStringExtra("DOCTOR_NAME"))
        submit.setOnClickListener {
            Toast.makeText(this, "Review submitted!", Toast.LENGTH_SHORT).show()
            Intent(this, HomeActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}