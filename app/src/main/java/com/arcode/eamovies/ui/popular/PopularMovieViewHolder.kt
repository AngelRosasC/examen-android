package com.arcode.eamovies.ui.popular

import androidx.recyclerview.widget.RecyclerView
import com.arcode.eamovies.BuildConfig.IMAGE_URL
import com.arcode.eamovies.databinding.ListItemPopularMovieBinding
import com.arcode.eamovies.databinding.ListItemTopMovieBinding
import com.arcode.eamovies.domain.models.Movie
import com.bumptech.glide.Glide

class PopularMovieViewHolder(
    private val binding: ListItemPopularMovieBinding,
    private val listener: PopularMovieAdapterListener,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movies: List<Movie>) {
        val movie = movies[absoluteAdapterPosition]
        with(binding) {
            tvPopularTitle.text = movie.title
            val path = IMAGE_URL + movie.posterPath
            Glide.with(binding.root.context).load(path).into(ivPopularPoster)
            root.setOnClickListener { listener.onMovieClicked(movie) }
        }
    }

    interface PopularMovieAdapterListener {
        fun onMovieClicked(movie: Movie)
    }

}