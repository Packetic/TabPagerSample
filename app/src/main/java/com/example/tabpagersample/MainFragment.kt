package com.example.tabpagersample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.tabpagersample.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator

// this fragment replaces MainActivity
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    // activities we switch
    private val fList = listOf(
        FitstFragment.newInstance(),
        SecondFragment.newInstance()
    )

    // when we use TabLayoutMediator, we need to rename tabs
    // so this list contains new names of those tabs
    private val tList = listOf(
        "First",
        "Second"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabPagerInit()
    }

    private fun tabPagerInit() = with(binding) {
        val adapter = VpAdapter(activity as FragmentActivity, fList)
        vp.adapter = adapter
        // creates a bridge between TabLayout and ViewPager
        TabLayoutMediator(tabLayout, vp) {
            // looks weird but we need it just to set names of tabs
            tab, pos -> tab.text = tList[pos]
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}