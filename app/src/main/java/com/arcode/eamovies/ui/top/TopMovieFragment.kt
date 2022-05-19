package com.arcode.eamovies.ui.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arcode.eamovies.databinding.FragmentTopMovieBinding

class TopMovieFragment : Fragment() {
    private lateinit var binding: FragmentTopMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTopMovieBinding.inflate(inflater, container, false)
        return binding.root
    }
}