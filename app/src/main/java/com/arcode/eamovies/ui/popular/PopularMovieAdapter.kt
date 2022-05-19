package com.arcode.eamovies.ui.popular

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arcode.eamovies.databinding.ListItemPopularMovieBinding
import com.arcode.eamovies.domain.models.Movie

class PopularMovieAdapter(private val listener: PopularMovieViewHolder.PopularMovieAdapterListener) :
    RecyclerView.Adapter<PopularMovieViewHolder>() {

    private var movies: List<Movie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        val binding =
            ListItemPopularMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularMovieViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) = holder.bind(movies)

    override fun getItemCount(): Int = movies.size

    @SuppressLint("NotifyDataSetChanged")
    fun addMovieList(movieList: List<Movie>) {
        movies = movieList
        notifyDataSetChanged()
    }
}