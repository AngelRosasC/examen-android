package com.arcode.eamovies.data.network

import com.arcode.eamovies.BuildConfig.POPULAR
import com.arcode.eamovies.BuildConfig.TOP_RATED
import com.arcode.eamovies.data.network.model.MovieResponse
import retrofit2.http.GET

interface ApiMovieService {
    @GET(TOP_RATED)
    suspend fun getTopRatedMovies(): MovieResponse

    @GET(POPULAR)
    suspend fun getPopularMovies(): MovieResponse
}