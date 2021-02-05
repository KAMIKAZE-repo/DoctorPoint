package com.example.testingapp.authentification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.testingapp.R

class AuthenticationActivity : AppCompatActivity() {
    private lateinit var signInButton : Button
    private lateinit var newAccountButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentification)
        signInButton = findViewById(R.id.create_account_button)
        newAccountButton = findViewById(R.id.create)
        signInButton.setOnClickListener {
            Intent(this, SignInActivity::class.java).apply {
                startActivity(this)
            }
        }

        newAccountButton.setOnClickListener {
            Intent(this, CreateAccountActivity::class.java).apply {
                startActivity(this)
            }
        }

    }
}