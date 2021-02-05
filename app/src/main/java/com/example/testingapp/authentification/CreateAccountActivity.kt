package com.example.testingapp.authentification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.testingapp.HomeActivity
import com.example.testingapp.R

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var text : TextView
    private lateinit var name: EditText
    private lateinit var createAccountButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        text = findViewById(R.id.sign_in_button)
        name = findViewById(R.id.name_field)
        createAccountButton = findViewById(R.id.create_account_button)
        text.setOnClickListener {
            Intent(this, SignInActivity::class.java).apply {
                startActivity(this)
            }
        }

        createAccountButton.setOnClickListener {
            Intent(this, HomeActivity::class.java).apply {
                this.putExtra("USER_NAME", name.text.toString())//hardCoded
                startActivity(this)
            }
        }
    }
}