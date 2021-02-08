package com.example.testingapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private lateinit var bottomNavMenu: BottomNavigationView
    private lateinit var navController: NavController
    private var clickedOnce = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavMenu = findViewById(R.id.bottom_nav)
        navController = findNavController(R.id.fragment)
        bottomNavMenu.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        if(bottomNavMenu.selectedItemId == R.id.homeFragment)
        {
            if(clickedOnce)
                finishAffinity()
            else
            {
                Toast.makeText(this, "click again to exit", Toast.LENGTH_SHORT).show()
                clickedOnce = true
            }
        }else
            super.onBackPressed()
    }
}