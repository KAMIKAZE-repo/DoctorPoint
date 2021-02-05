package com.example.testingapp.review

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.testingapp.HomeActivity
import com.example.testingapp.R

class ReviewActivity : AppCompatActivity() {
    private lateinit var submit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)
        submit = findViewById(R.id.submit_review)
        submit.setOnClickListener {
            Toast.makeText(this, "Review submitted!", Toast.LENGTH_SHORT).show()
            Intent(this, HomeActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}