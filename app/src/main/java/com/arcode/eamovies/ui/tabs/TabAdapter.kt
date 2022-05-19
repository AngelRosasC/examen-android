package com.arcode.eamovies.ui.tabs

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.arcode.eamovies.ui.popular.PopularFragment
import com.arcode.eamovies.ui.top.TopMovieFragment

class TabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TopMovieFragment()
            1 -> PopularFragment()
            else -> TopMovieFragment()
        }
    }
}