package com.arcode.eamovies.domain

import com.arcode.eamovies.data.repository.MovieRepository
import com.arcode.eamovies.domain.models.Movie
import javax.inject.Inject

class GetTopRatedMoviesUseCase @Inject constructor(private val moviesRepository: MovieRepository) {
    suspend operator fun invoke(): List<Movie> {
        val movies = moviesRepository.getTopRatedMoviesFromApi()

        return if (movies.isNotEmpty()) {
            moviesRepository.deleteAllTopRatedMoviesFromDb()
            moviesRepository.insertTopRatedMoviesToDb(movies)
            movies
        } else {
            moviesRepository.getTopRatedMoviesFromDb()
        }
    }
}