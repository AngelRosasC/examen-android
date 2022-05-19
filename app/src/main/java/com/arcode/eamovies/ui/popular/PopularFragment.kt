package com.arcode.eamovies.ui.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.arcode.eamovies.databinding.FragmentPopularMovieBinding
import com.arcode.eamovies.domain.models.Movie
import com.arcode.eamovies.ui.top.TopMovieAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularFragment : Fragment(), PopularMovieViewHolder.PopularMovieAdapterListener {
    private lateinit var binding: FragmentPopularMovieBinding

    private val movieViewModel: PopularMovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPopularMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieViewModel.onCreate()

        binding.rvPopularMovie.adapter = PopularMovieAdapter(this)
        binding.rvPopularMovie.setHasFixedSize(true)
        binding.rvPopularMovie.layoutManager = GridLayoutManager(context, 2)

        movieViewModel.popularMovie.observe(viewLifecycleOwner) {
            binding.rvPopularMovie.adapter?.let { adapter ->
                if (adapter is PopularMovieAdapter) {
                    adapter.addMovieList(it)
                }
            }
        }
    }

    override fun onMovieClicked(movie: Movie) {
        TODO("Not yet implemented")
    }
}