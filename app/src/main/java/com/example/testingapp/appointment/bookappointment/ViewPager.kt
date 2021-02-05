package com.example.testingapp.appointment.bookappointment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager(private val pages: ArrayList<Fragment> ,fm: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int = pages.size

    override fun createFragment(position: Int): Fragment {
        return pages[position]
    }
}