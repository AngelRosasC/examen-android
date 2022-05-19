package com.arcode.eamovies.ui.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.arcode.eamovies.databinding.FragmentTabMovieBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabFragment : Fragment() {
    private lateinit var binding: FragmentTabMovieBinding
    private lateinit var tabAdapter: TabAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTabMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tabAdapter = TabAdapter(this)
        viewPager = binding.viewPagerMovies
        viewPager.adapter = tabAdapter

        TabLayoutMediator(binding.tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Top Rated"
                1 -> tab.text = "Popular"
            }
        }.attach()
    }
}