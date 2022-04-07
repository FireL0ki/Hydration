package com.example.hydration

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// job of this class-- user wants to view tab #0, which fragment should be shown to the user
// adapt the information-- connect the tabs to the the correct fragment behind the scenes / make association
class WaterViewPagerAdapter(activity: FragmentActivity, private val days: Array<String>):
    FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        // to return how many tabs
        return days.size
    }

    override fun createFragment(position: Int): Fragment {
        // to return the correct fragment based on its position
        val day = days[position]
        return HydrationFragment.newInstance(day)
    }

}