package com.example.testingapp.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(private val data: Map<String, Array<String>>, fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle){

    override fun getItemCount(): Int {
        return (data["titles"] ?: error("")).size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = OnBoardingScreenReusable()
        fragment.arguments = Bundle().apply {
            putString("TITLE", data["titles"]?.get(position))
            putString("DESCRIPTION",data["descriptions"]?.get(position))
            data["images"]?.get(position)?.let { putInt("IMAGE", it.toInt())
            putInt("DOT",position)}
        }
        return fragment
    }
}