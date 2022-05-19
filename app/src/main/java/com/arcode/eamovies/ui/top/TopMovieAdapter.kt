package com.arcode.eamovies.ui.top

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arcode.eamovies.databinding.ListItemTopMovieBinding
import com.arcode.eamovies.domain.models.Movie

class TopMovieAdapter(private val listener: TopMovieViewHolder.TopMovieAdapterListener) :
    RecyclerView.Adapter<TopMovieViewHolder>() {

    private var movies: List<Movie> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMovieViewHolder {
        val binding =
            ListItemTopMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopMovieViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: TopMovieViewHolder, position: Int) = holder.bind(movies)

    override fun getItemCount(): Int = movies.size

    @SuppressLint("NotifyDataSetChanged")
    fun addMovieList(movieList: List<Movie>) {
        movies = movieList
        notifyDataSetChanged()
    }
}