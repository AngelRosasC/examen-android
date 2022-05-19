package com.arcode.eamovies.ui.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arcode.eamovies.databinding.FragmentTabMovieBinding

class TabFragment : Fragment() {
    private lateinit var binding: FragmentTabMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTabMovieBinding.inflate(inflater, container, false)
        return binding.root
    }
}