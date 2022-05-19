package com.arcode.eamovies.data.repository

import com.arcode.eamovies.data.database.DatabaseDao
import com.arcode.eamovies.data.database.model.toDatabase
import com.arcode.eamovies.data.database.model.toDatabasePopular
import com.arcode.eamovies.data.network.MovieService
import com.arcode.eamovies.data.network.model.MovieModel
import com.arcode.eamovies.domain.models.Movie
import com.arcode.eamovies.domain.models.toDomain
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api: MovieService,
    private val dao: DatabaseDao,
) {

    suspend fun getTopRatedMoviesFromApi(): List<Movie> {
        val response: List<MovieModel> = api.getMovies()
        return response.map { it.toDomain() }
    }

    suspend fun getTopRatedMoviesFromDb(): List<Movie> {
        return dao.getAllTopRatedMovies().map { it.toDomain() }
    }

    fun insertTopRatedMoviesToDb(movies: List<Movie>) {
        dao.insertTopRatedMovie(movies.map { it.toDatabase() })
    }

    suspend fun deleteTopRatedMoviesFromDb(movie: Movie) {
        dao.deleteTopRatedMovie(movie.toDatabase())
    }

    suspend fun deleteAllTopRatedMoviesFromDb() {
        dao.deleteAllTopRatedMovies()
    }


    suspend fun getPopularMoviesFromApi(): List<Movie> {
        val response: List<MovieModel> = api.getPopularMovie()
        return response.map { it.toDomain() }
    }

    suspend fun getPopularMoviesFromDb(): List<Movie> {
        return dao.getAllPopularMovies().map { it.toDomain() }
    }

    suspend fun insertPopularMoviesToDb(movies: List<Movie>) {
        dao.insertPopularMovie(movies.map { it.toDatabasePopular() })
    }

    suspend fun deletePopularMoviesFromDb(movie: Movie) {
        dao.deletePopularMovie(movie.toDatabasePopular())
    }

    suspend fun deleteAllPopularMoviesFromDb() {
        dao.deleteAllPopularMovies()
    }
}

