package com.arcode.eamovies.data.database.dao

import androidx.room.*
import com.arcode.eamovies.data.database.model.LocationEntity
import com.arcode.eamovies.data.database.model.MovieEntity
import com.arcode.eamovies.data.database.model.PopularEntity
import com.arcode.eamovies.utils.constants.Constants.TABLE_NAME_LOCATION
import com.arcode.eamovies.utils.constants.Constants.TABLE_NAME_MOVIES
import com.arcode.eamovies.utils.constants.Constants.TABLE_NAME_MOVIES_POPULAR

@Dao
interface DatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopRatedMovie(movie: List<MovieEntity>)

    @Query("SELECT * FROM $TABLE_NAME_MOVIES")
    suspend fun getAllTopRatedMovies(): List<MovieEntity>

    @Delete
    suspend fun deleteTopRatedMovie(movie: MovieEntity)

    @Query("DELETE FROM $TABLE_NAME_MOVIES")
    suspend fun deleteAllTopRatedMovies()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovie(movie: List<PopularEntity>)

    @Query("SELECT * FROM $TABLE_NAME_MOVIES_POPULAR")
    suspend fun getAllPopularMovies(): List<PopularEntity>

    @Delete
    suspend fun deletePopularMovie(movie: PopularEntity)

    @Query("DELETE FROM $TABLE_NAME_MOVIES_POPULAR")
    suspend fun deleteAllPopularMovies()
}