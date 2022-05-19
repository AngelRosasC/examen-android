package com.arcode.eamovies.data.network

import com.arcode.eamovies.data.network.model.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(private val api: ApiMovieService) {
    suspend fun getMovies(): List<MovieModel> = withContext(Dispatchers.IO) {
        val response = api.getTopRatedMovies()
        response.results
    }
}