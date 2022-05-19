package com.arcode.eamovies.ui.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.arcode.eamovies.databinding.FragmentTopMovieBinding
import com.arcode.eamovies.domain.models.Movie
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopMovieFragment : Fragment(), TopMovieViewHolder.TopMovieAdapterListener {
    private lateinit var binding: FragmentTopMovieBinding

    private val movieViewModel: TopMovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTopMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieViewModel.onCreate()

        binding.rvTopMovie.adapter = TopMovieAdapter(this)
        binding.rvTopMovie.setHasFixedSize(true)
        binding.rvTopMovie.layoutManager = GridLayoutManager(context, 2)

        movieViewModel.topRatedMovies.observe(viewLifecycleOwner) {
            binding.rvTopMovie.adapter?.let { adapter ->
                if (adapter is TopMovieAdapter) {
                    adapter.addMovieList(it)
                }
            }
        }
    }

    override fun onMovieClicked(movie: Movie) {

    }
}