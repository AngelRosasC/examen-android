package com.arcode.eamovies.domain

import com.arcode.eamovies.data.repository.MovieRepository
import com.arcode.eamovies.domain.models.Movie
import javax.inject.Inject

class GetPopularMovie @Inject constructor(private val moviesRepository: MovieRepository) {
    suspend operator fun invoke(): List<Movie> {
        val movies = moviesRepository.getPopularMoviesFromApi()

        return if (movies.isNotEmpty()) {
            moviesRepository.deleteAllPopularMoviesFromDb()
            moviesRepository.insertPopularMoviesToDb(movies)
            movies
        } else {
            moviesRepository.getPopularMoviesFromDb()
        }
    }
}