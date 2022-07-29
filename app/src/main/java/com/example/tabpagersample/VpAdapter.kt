package com.example.tabpagersample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class VpAdapter(fa: FragmentActivity, private val list: List<Fragment>) : FragmentStateAdapter(fa) {

    // how many fragments to keep
    override fun getItemCount(): Int {
        return list.size
    }

    // decides which fragment to show
    override fun createFragment(position: Int): Fragment {
        return list[position]
    }

}