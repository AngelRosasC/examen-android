package com.arcode.eamovies.ui.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arcode.eamovies.databinding.FragmentPopularMovieBinding

class PopularFragment : Fragment() {
    private lateinit var binding: FragmentPopularMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPopularMovieBinding.inflate(inflater, container, false)
        return binding.root
    }
}