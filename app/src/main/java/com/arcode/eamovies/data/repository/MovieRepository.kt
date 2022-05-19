package com.arcode.eamovies.data.repository

import com.arcode.eamovies.data.network.MovieService
import com.arcode.eamovies.data.network.model.MovieModel
import com.arcode.eamovies.domain.models.Movie
import com.arcode.eamovies.domain.models.toDomain
import javax.inject.Inject

class MovieRepository @Inject constructor(private val api: MovieService) {

    suspend fun getTopRatedMoviesFromApi(): List<Movie> {
        val response: List<MovieModel> = api.getMovies()
        return response.map { it.toDomain() }
    }

    suspend fun getTopRatedMoviesFromDb(): List<Movie> {
        // TODO:  database implementation
        return emptyList()
    }

    suspend fun insertTopRatedMoviesToDb(movies: List<Movie>) {
        // TODO: database implementation
    }

    suspend fun deleteTopRatedMoviesFromDb(movie: Movie) {
        // TODO: database implementation
    }

    suspend fun deleteAllTopRatedMoviesFromDb() {
        // TODO: database implementation
    }
}

