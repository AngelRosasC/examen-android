package com.arcode.eamovies.domain.models

import com.arcode.eamovies.data.database.model.MovieEntity
import com.arcode.eamovies.data.network.model.MovieModel

data class Movie(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val movieId: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int,
)

fun MovieModel.toDomain() = Movie(
    adult = adult,
    backdropPath = backdropPath,
    genreIds = genreIds,
    movieId = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun MovieEntity.toDomain() = Movie(
    adult = adult,
    backdropPath = backdropPath,
    genreIds = genreIds,
    movieId = id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)