package com.arcode.eamovies.ui.top

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.arcode.eamovies.BuildConfig.IMAGE_URL
import com.arcode.eamovies.databinding.ListItemTopMovieBinding
import com.arcode.eamovies.domain.models.Movie
import com.bumptech.glide.Glide

class TopMovieViewHolder(
    private val binding: ListItemTopMovieBinding,
    private val listener: TopMovieAdapterListener,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movies: List<Movie>) {
        val movie = movies[absoluteAdapterPosition]
        with(binding) {
            tvTitle.text = movie.title
            val path = IMAGE_URL + movie.posterPath
            Glide.with(binding.root.context).load(path).into(ivPoster)
            root.setOnClickListener { listener.onMovieClicked(movie) }
        }
    }

    interface TopMovieAdapterListener {
        fun onMovieClicked(movie: Movie)
    }

}