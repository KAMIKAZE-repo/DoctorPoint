package com.example.testingapp.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.testingapp.HomeActivity
import com.example.testingapp.R
import com.example.testingapp.authentification.AuthenticationActivity

class OnBoarding : AppCompatActivity(), OnBoardingScreenReusable.FragmentListener{
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter : ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        val data: Map<String, Array<String>> =  mapOf(
            "titles" to resources.getStringArray(R.array.onBoardingTitles),
            "descriptions" to resources.getStringArray(R.array.onBoardingDescription),
            "images" to arrayOf(//should be declared somewhere in xml
                R.drawable.img_placeholder1.toString(),
                R.drawable.img_placeholder2.toString(),
                R.drawable.img_placeholder3.toString()
            )
        )
        viewPager2 = findViewById(R.id.viewPager)
        adapter = ViewPagerAdapter(data, supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter
    }

    override fun onNextButtonClickedCallBack() {
        Intent(this, AuthenticationActivity::class.java).apply {
            startActivity(this)
        }
    }

    override fun onDotClicked(position: Int) {
        viewPager2.currentItem = position
    }
}