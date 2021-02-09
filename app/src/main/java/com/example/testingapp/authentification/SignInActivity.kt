package com.example.testingapp.authentification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.testingapp.HomeActivity
import com.example.testingapp.R

class SignInActivity : AppCompatActivity() {
    private lateinit var text : TextView
    private lateinit var passwordField: EditText
    private lateinit var signInButton: Button
    private lateinit var name: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        text = findViewById(R.id.create_acc)
        name = findViewById(R.id.username_field)
        signInButton = findViewById(R.id.create_account_button)
        passwordField = findViewById(R.id.password_field)
        text.setOnClickListener {
            Intent(this, CreateAccountActivity::class.java).apply {
                startActivity(this)
            }
        }
        signInButton.setOnClickListener {
            Intent(this, HomeActivity::class.java).apply {
                this.putExtra("USER_NAME", name.text.toString().split("@")[0])//hardCoded
                startActivity(this)
            }
        }
    }
}